package com.assemblyai.api;

import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.resources.realtime.types.AudioData;
import com.assemblyai.api.resources.realtime.types.FinalTranscript;
import com.assemblyai.api.resources.realtime.types.PartialTranscript;
import com.assemblyai.api.resources.realtime.types.RealtimeError;
import com.assemblyai.api.resources.realtime.types.RealtimeMessage;
import com.assemblyai.api.resources.realtime.types.RealtimeTranscript;
import com.assemblyai.api.resources.realtime.types.SessionBegins;
import com.assemblyai.api.resources.realtime.types.SessionTerminated;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RealtimeTranscriber implements AutoCloseable {

    private static final String BASE_URL = "wss://api.assemblyai.com";
    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder().build();
    private final String apiKey;
    private final int sampleRate;
    private final Optional<List<String>> wordBoost;
    private final Consumer<SessionBegins> onSessionStart;
    private final Consumer<PartialTranscript> onPartialTranscript;
    private final Consumer<FinalTranscript> onFinalTranscript;
    private final Consumer<RealtimeTranscript> onTranscript;
    private final Consumer<Throwable> onError;
    private final RealtimeMessageVisitor realtimeMessageVisitor;
    private WebSocket webSocket;

    private RealtimeTranscriber(
            String apiKey,
            int sampleRate,
            Optional<List<String>> wordBoost,
            Consumer<SessionBegins> onSessionStart,
            Consumer<PartialTranscript> onPartialTranscript,
            Consumer<FinalTranscript> onFinalTranscript,
            Consumer<RealtimeTranscript> onTranscript,
            Consumer<Throwable> onError) {
        this.apiKey = apiKey;
        this.sampleRate = sampleRate;
        this.onSessionStart = onSessionStart;
        this.onPartialTranscript = onPartialTranscript;
        this.onFinalTranscript = onFinalTranscript;
        this.onTranscript = onTranscript;
        this.wordBoost = wordBoost;
        this.onError = onError;
        this.realtimeMessageVisitor = new RealtimeMessageVisitor();
    }

    /**
     * Establishes connection with the websocket. Defaults to a 10s timeout.
     */
    public void connect() {
        String url = BASE_URL + "/v2/realtime/ws?sample_rate=" + sampleRate;
        if (wordBoost.isPresent() && !wordBoost.get().isEmpty()) {
            try {
                url += "&word_boost=" + ObjectMappers.JSON_MAPPER.writeValueAsString(wordBoost.get());
            } catch (IOException e) {
                throw new RuntimeException("Failed to serialize word boosts");
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", apiKey)
                .build();
        this.webSocket = OK_HTTP_CLIENT.newWebSocket(request, new Listener());
    }

    /**
     * Stream binary audio data
     * @param data byte array audio data
     */
    public void sendAudio(byte[] data) {
        String encoded = new String(Base64.getEncoder().encode(data), StandardCharsets.UTF_8);
        sendAudio(encoded);
    }

    /**
     * Stream base64 encoded audio data
     * @param data base64 audio data string
     */
    public void sendAudio(String data) {
        try {
            AudioData audioData = AudioData.builder().audioData(data).build();
            this.webSocket.send(ObjectMappers.JSON_MAPPER.writeValueAsString(audioData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Closes the websocket connection.
     */
    @Override
    public void close() {
        boolean closed = this.webSocket.close(1000, "Shutting down");
        if (!closed) {
            this.webSocket.cancel();
        }
    }

    public static RealtimeTranscriber.Builder builder() {
        return new RealtimeTranscriber.Builder();
    }

    public static final class Builder {
        private static final int DEFAULT_SAMPLE_RATE = 16_000;
        private String apiKey;
        private Integer sampleRate;
        private List<String> wordBoost;
        private Consumer<SessionBegins> onSessionStart = _unused -> {};
        private Consumer<PartialTranscript> onPartialTranscript = _unused -> {};
        private Consumer<FinalTranscript> onFinalTranscript = _unused -> {};
        private Consumer<RealtimeTranscript> onTranscript = _unused -> {};
        private Consumer<Throwable> onError;

        /**
         * Sets api key
         * @param apiKey The AssemblyAI API Key
         * @return this
         */
        public RealtimeTranscriber.Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /**
         * Sets sample rate
         * @param sampleRate The audio sample rate. Defaults to 16_000
         * @return this
         */
        public RealtimeTranscriber.Builder sampleRate(int sampleRate) {
            this.sampleRate = sampleRate;
            return this;
        }

        /**
         * Sets word boost
         * @param wordBoost An array of words to boost
         * @return this
         */
        public RealtimeTranscriber.Builder wordBoost(List<String> wordBoost) {
            this.wordBoost = wordBoost;
            return this;
        }

        /**
         * Sets onSessionStart
         * @param onSessionStart an event handler for the start event. Defaults to a noop.
         * @return this
         */
        public RealtimeTranscriber.Builder onSessionStart(Consumer<SessionBegins> onSessionStart) {
            this.onSessionStart = onSessionStart;
            return this;
        }

        /**
         * Sets onPartialTranscript
         * @param onPartialTranscript an event handler for the partial transcript event. Defaults to a noop.
         * @return this
         */
        public RealtimeTranscriber.Builder onPartialTranscript(Consumer<PartialTranscript> onPartialTranscript) {
            this.onPartialTranscript = onPartialTranscript;
            return this;
        }

        /**
         * Sets onPartialTranscript
         * @param onFinalTranscript an event handler for the final transcript event. Defaults to a noop.
         * @return this
         */
        public RealtimeTranscriber.Builder onFinalTranscript(Consumer<FinalTranscript> onFinalTranscript) {
            this.onFinalTranscript = onFinalTranscript;
            return this;
        }

        /**
         * Sets onTranscript
         * @param onTranscript an event handler for any transcript event (partial or final). Defaults to a noop.
         * @return this
         */
        public RealtimeTranscriber.Builder onTranscript(Consumer<RealtimeTranscript> onTranscript) {
            this.onTranscript = onTranscript;
            return this;
        }

        /**
         * Sets onError
         * @param onError an event handler for an error event. Defaults to a noop.
         * @return this
         */
        public RealtimeTranscriber.Builder onError(Consumer<Throwable> onError) {
            this.onError = onError;
            return this;
        }

        public RealtimeTranscriber build() {
            if (apiKey == null) {
                throw new RuntimeException("apiKey must be specified to construct RealtimeTranscriber");
            }
            return new RealtimeTranscriber(
                    apiKey,
                    sampleRate == null ? DEFAULT_SAMPLE_RATE : sampleRate,
                    Optional.ofNullable(wordBoost),
                    onSessionStart,
                    onPartialTranscript,
                    onFinalTranscript,
                    onTranscript,
                    onError);
        }
    }

    private final class Listener extends WebSocketListener {

        @Override
        public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {}

        @Override
        public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
            try {
                RealtimeMessage realtimeMessage = ObjectMappers.JSON_MAPPER.readValue(text, RealtimeMessage.class);
                realtimeMessage.visit(realtimeMessageVisitor);
            } catch (JsonProcessingException e) {
                onError.accept(e);
            }
        }

        @Override
        public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
            onError.accept(t);
        }
    }

    private final class RealtimeMessageVisitor implements RealtimeMessage.Visitor<Void> {
        @Override
        public Void visit(SessionBegins value) {
            onSessionStart.accept(value);
            return null;
        }

        @Override
        public Void visit(PartialTranscript value) {
            onPartialTranscript.accept(value);
            onTranscript.accept(RealtimeTranscript.of(value));
            return null;
        }

        @Override
        public Void visit(FinalTranscript value) {
            onFinalTranscript.accept(value);
            onTranscript.accept(RealtimeTranscript.of(value));
            return null;
        }

        @Override
        public Void visit(SessionTerminated value) {
            return null;
        }

        @Override
        public Void visit(RealtimeError value) {
            onError.accept(new Exception(value.getError()));
            return null;
        }
    }
}