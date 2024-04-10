package com.assemblyai.api;

import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.resources.realtime.types.FinalTranscript;
import com.assemblyai.api.resources.realtime.types.PartialTranscript;
import com.assemblyai.api.resources.realtime.types.RealtimeError;
import com.assemblyai.api.resources.realtime.types.RealtimeMessage;
import com.assemblyai.api.resources.realtime.types.RealtimeTranscript;
import com.assemblyai.api.resources.realtime.types.SessionBegins;
import com.assemblyai.api.resources.realtime.types.SessionTerminated;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.sun.org.apache.xpath.internal.operations.Bool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RealtimeTranscriber implements AutoCloseable {

    private static final String BASE_URL = "wss://api.assemblyai.com";
    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder().build();
    private final String apiKey;
    private final int sampleRate;
    private final boolean disablePartialTranscripts;
    private final Optional<List<String>> wordBoost;
    private final Optional<Integer> endUtteranceSilenceThreshold;
    private final Consumer<SessionBegins> onSessionBegins;
    private final Consumer<PartialTranscript> onPartialTranscript;
    private final Consumer<FinalTranscript> onFinalTranscript;
    private final Consumer<RealtimeTranscript> onTranscript;
    private final Consumer<Throwable> onError;
    private final BiConsumer<Integer, String> onClose;
    private final RealtimeMessageVisitor realtimeMessageVisitor;
    private WebSocket webSocket;

    private RealtimeTranscriber(
            String apiKey,
            int sampleRate,
            boolean disablePartialTranscripts,
            Optional<List<String>> wordBoost,
            Optional<Integer> endUtteranceSilenceThreshold,
            Consumer<SessionBegins> onSessionBegins,
            Consumer<PartialTranscript> onPartialTranscript,
            Consumer<FinalTranscript> onFinalTranscript,
            Consumer<RealtimeTranscript> onTranscript,
            Consumer<Throwable> onError,
            BiConsumer<Integer, String> onClose) {
        this.apiKey = apiKey;
        this.sampleRate = sampleRate;
        this.disablePartialTranscripts = disablePartialTranscripts;
        this.wordBoost = wordBoost;
        this.endUtteranceSilenceThreshold = endUtteranceSilenceThreshold;
        this.onSessionBegins = onSessionBegins;
        this.onPartialTranscript = onPartialTranscript;
        this.onFinalTranscript = onFinalTranscript;
        this.onTranscript = onTranscript;
        this.onError = onError;
        this.onClose = onClose;
        this.realtimeMessageVisitor = new RealtimeMessageVisitor();
    }

    /**
     * Establishes connection with the websocket. Defaults to a 10s timeout.
     */
    public void connect() {
        String url = BASE_URL + "/v2/realtime/ws?sample_rate=" + sampleRate;
        if (disablePartialTranscripts) {
            url += "&disable_partial_transcripts=true";
        }
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
        this.webSocket = OK_HTTP_CLIENT.newWebSocket(request, new Listener(
                (response) -> endUtteranceSilenceThreshold.ifPresent(this::configureEndUtteranceSilenceThreshold)
        ));
    }

    /**
     * Stream binary audio data
     *
     * @param audio byte array audio data
     */
    public void sendAudio(byte[] audio) {
        this.webSocket.send(ByteString.of(audio));
    }

    /**
     * Stream base64 encoded audio data
     *
     * @param audio base64 audio data string
     */
    public void sendAudio(String audio) {
        sendAudio(Base64.getDecoder().decode(audio));
    }

    /**
     * Manually end an utterance
     */
    public void forceEndUtterance() {
        this.webSocket.send("{\"force_end_utterance\":true}");
    }

    /**
     * Configure the threshold for how long to wait before ending an utterance. Default is 700ms.
     *
     * @param threshold The duration of the end utterance silence threshold in milliseconds
     */
    public void configureEndUtteranceSilenceThreshold(int threshold) {
        this.webSocket.send(String.format(
                "{\"end_utterance_silence_threshold\":%d}",
                threshold
        ));
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
        private boolean disablePartialTranscripts;
        private List<String> wordBoost;
        private Optional<Integer> endUtteranceSilenceThreshold = Optional.empty();
        private Consumer<SessionBegins> onSessionBegins;
        private Consumer<PartialTranscript> onPartialTranscript;
        private Consumer<FinalTranscript> onFinalTranscript;
        private Consumer<RealtimeTranscript> onTranscript;
        private Consumer<Throwable> onError;
        private BiConsumer<Integer, String> onClose;

        /**
         * Sets api key
         *
         * @param apiKey The AssemblyAI API Key
         * @return this
         */
        public RealtimeTranscriber.Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /**
         * Sets sample rate
         *
         * @param sampleRate The audio sample rate. Defaults to 16_000
         * @return this
         */
        public RealtimeTranscriber.Builder sampleRate(int sampleRate) {
            this.sampleRate = sampleRate;
            return this;
        }

        /**
         * Disable partial transcripts.
         *
         * @return this
         */
        public RealtimeTranscriber.Builder disablePartialTranscripts() {
            this.disablePartialTranscripts = true;
            return this;
        }

        /**
         * Sets word boost
         *
         * @param wordBoost An array of words to boost
         * @return this
         */
        public RealtimeTranscriber.Builder wordBoost(List<String> wordBoost) {
            this.wordBoost = wordBoost;
            return this;
        }

        /**
         * Configure the threshold for how long to wait before ending an utterance. Default is 700ms.
         *
         * @param threshold The duration of the end utterance silence threshold in milliseconds
         * @return this
         */
        public RealtimeTranscriber.Builder endUtteranceSilenceThreshold(int threshold) {
            this.endUtteranceSilenceThreshold = Optional.of(threshold);
            return this;
        }


        /**
         * Sets onSessionStart
         *
         * @param onSessionStart an event handler for the start event. Defaults to a noop.
         * @return this
         * @deprecated use {@link #onSessionBegins(Consumer)} instead.
         */
        public RealtimeTranscriber.Builder onSessionStart(Consumer<SessionBegins> onSessionStart) {
            onSessionBegins(onSessionStart);
            return this;
        }

        /**
         * Sets onSessionBegins
         *
         * @param onSessionBegins an event handler for the start event. Defaults to a noop.
         * @return this
         */
        public RealtimeTranscriber.Builder onSessionBegins(Consumer<SessionBegins> onSessionBegins) {
            this.onSessionBegins = onSessionBegins;
            return this;
        }

        /**
         * Sets onPartialTranscript
         *
         * @param onPartialTranscript an event handler for the partial transcript event. Defaults to a noop.
         * @return this
         */
        public RealtimeTranscriber.Builder onPartialTranscript(Consumer<PartialTranscript> onPartialTranscript) {
            this.onPartialTranscript = onPartialTranscript;
            return this;
        }

        /**
         * Sets onPartialTranscript
         *
         * @param onFinalTranscript an event handler for the final transcript event. Defaults to a noop.
         * @return this
         */
        public RealtimeTranscriber.Builder onFinalTranscript(Consumer<FinalTranscript> onFinalTranscript) {
            this.onFinalTranscript = onFinalTranscript;
            return this;
        }

        /**
         * Sets onTranscript
         *
         * @param onTranscript an event handler for any transcript event (partial or final). Defaults to a noop.
         * @return this
         */
        public RealtimeTranscriber.Builder onTranscript(Consumer<RealtimeTranscript> onTranscript) {
            this.onTranscript = onTranscript;
            return this;
        }

        /**
         * Sets onError
         *
         * @param onError an event handler for an error event. Defaults to a noop.
         * @return this
         */
        public RealtimeTranscriber.Builder onError(Consumer<Throwable> onError) {
            this.onError = onError;
            return this;
        }

        /**
         * Sets onClose
         *
         * @param onClose an event handler for the closing event. Defaults to a noop.
         * @return this
         */
        public RealtimeTranscriber.Builder onClose(BiConsumer<Integer, String> onClose) {
            this.onClose = onClose;
            return this;
        }

        public RealtimeTranscriber build() {
            if (apiKey == null) {
                throw new RuntimeException("apiKey must be specified to construct RealtimeTranscriber");
            }
            return new RealtimeTranscriber(
                    apiKey,
                    sampleRate == null ? DEFAULT_SAMPLE_RATE : sampleRate,
                    disablePartialTranscripts,
                    Optional.ofNullable(wordBoost),
                    endUtteranceSilenceThreshold,
                    onSessionBegins,
                    onPartialTranscript,
                    onFinalTranscript,
                    onTranscript,
                    onError,
                    onClose);
        }
    }

    private final class Listener extends WebSocketListener {
        private final Consumer<Response> onOpen;

        public Listener(Consumer<Response> onOpen) {
            this.onOpen = onOpen;
        }

        @Override
        public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
            if (onOpen != null) {
                onOpen.accept(response);
            }
        }

        @Override
        public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
            try {
                RealtimeMessage realtimeMessage = ObjectMappers.JSON_MAPPER.readValue(text, RealtimeMessage.class);
                realtimeMessage.visit(realtimeMessageVisitor);
            } catch (JsonProcessingException e) {
                if (onError == null) return;
                onError.accept(e);
            }
        }

        @Override
        public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
            if (onError == null) return;
            onError.accept(t);
        }

        @Override
        public void onClosing(@NotNull WebSocket webSocket, int code, String reason) {
            if (onClose == null) return;
            if (reason == null || reason.isEmpty()) {
                reason = closeCodeErrorMessages.getOrDefault(code, null);
            }
            onClose.accept(code, reason);
            super.onClosing(webSocket, code, reason);
        }
    }

    private final class RealtimeMessageVisitor implements RealtimeMessage.Visitor<Void> {
        @Override
        public Void visit(SessionBegins value) {
            if (onSessionBegins == null) return null;
            onSessionBegins.accept(value);
            return null;
        }

        @Override
        public Void visit(PartialTranscript value) {
            if (onPartialTranscript != null) onPartialTranscript.accept(value);
            if (onTranscript != null) onTranscript.accept(RealtimeTranscript.of(value));
            return null;
        }

        @Override
        public Void visit(FinalTranscript value) {
            if (onFinalTranscript != null) onFinalTranscript.accept(value);
            if (onTranscript != null) onTranscript.accept(RealtimeTranscript.of(value));
            return null;
        }

        @Override
        public Void visit(SessionTerminated value) {
            return null;
        }

        @Override
        public Void visit(RealtimeError value) {
            if (onError == null) return null;
            onError.accept(new Exception(value.getError()));
            return null;
        }
    }

    private final HashMap<Integer, String> closeCodeErrorMessages = new HashMap<Integer, String>() {{
        put(4000, "Sample rate must be a positive integer");
        put(4001, "Not Authorized");
        put(4002, "Insufficient funds or you are using a free account. This feature is paid-only and requires you to add a credit card. Please visit https://assemblyai.com/dashboard/ to add a credit card to your account.");
        put(4004, "Session ID does not exist");
        put(4008, "Session has expired");
        put(4010, "Session is closed");
        put(4029, "Rate limited");
        put(4030, "Unique session violation");
        put(4031, "Session Timeout");
        put(4032, "Audio too short");
        put(4033, "Audio too long");
        put(4100, "Bad JSON");
        put(4101, "Bad schema");
        put(4102, "Too many streams");
        put(4103, "Reconnected");
        put(1013, "Reconnect attempts exhausted");
    }};
}
