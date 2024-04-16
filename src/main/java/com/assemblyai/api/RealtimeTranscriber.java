package com.assemblyai.api;

import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.resources.realtime.types.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

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
    private final AudioEncoding encoding;
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
    private final Consumer<SessionInformation> onSessionInformation;
    private WebSocket webSocket;
    private SessionInformation sessionInformation;
    private CompletableFuture<SessionInformation> sessionTerminatedFuture;
    private boolean isConnected;

    private RealtimeTranscriber(
            String apiKey,
            int sampleRate,
            AudioEncoding encoding,
            boolean disablePartialTranscripts,
            Optional<List<String>> wordBoost,
            Optional<Integer> endUtteranceSilenceThreshold,
            Consumer<SessionBegins> onSessionBegins,
            Consumer<PartialTranscript> onPartialTranscript,
            Consumer<FinalTranscript> onFinalTranscript,
            Consumer<RealtimeTranscript> onTranscript,
            Consumer<Throwable> onError,
            Consumer<SessionInformation> onSessionInformation,
            BiConsumer<Integer, String> onClose) {
        this.apiKey = apiKey;
        this.sampleRate = sampleRate;
        this.encoding = encoding;
        this.disablePartialTranscripts = disablePartialTranscripts;
        this.wordBoost = wordBoost;
        this.endUtteranceSilenceThreshold = endUtteranceSilenceThreshold;
        this.onSessionBegins = onSessionBegins;
        this.onPartialTranscript = onPartialTranscript;
        this.onFinalTranscript = onFinalTranscript;
        this.onTranscript = onTranscript;
        this.onError = onError;
        this.onSessionInformation = onSessionInformation;
        this.onClose = onClose;
        this.realtimeMessageVisitor = new RealtimeMessageVisitor();
    }

    /**
     * Establishes connection with the websocket. Defaults to a 10s timeout.
     */
    public void connect() {
        String url = BASE_URL + "/v2/realtime/ws?sample_rate=" + sampleRate;
        if (encoding != null) {
            url += "&encoding=" + encoding;
        }
        if (disablePartialTranscripts) {
            url += "&disable_partial_transcripts=true";
        }

        // always set so it can be return from closeWithSessionTermination
        url += "&enable_extra_session_information=true";

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

    public Future<SessionInformation> closeWithSessionTermination() {
        this.sessionTerminatedFuture = new CompletableFuture<SessionInformation>();
        this.webSocket.send("{\"terminate_session\":true}");
        sessionTerminatedFuture.whenComplete((sessionInformation1, throwable) -> this.closeSocket());
        return this.sessionTerminatedFuture;
    }

    /**
     * Closes the websocket connection immediately, without waiting for session termination.
     * Use closeWithSessionTermination() if possible.
     *
     * @see #closeWithSessionTermination
     * Terminate the session, wait for session termination, and then close the connection.
     */
    @Override
    public void close() {
        if (isConnected) {
            this.webSocket.send("{\"terminate_session\":true}");
        }
        this.closeSocket();
    }

    private void closeSocket() {
        if(webSocket == null) return;
        this.webSocket.close(1000, "Shutting down");
        this.webSocket.cancel();
        this.webSocket = null;
    }

    public static RealtimeTranscriber.Builder builder() {
        return new RealtimeTranscriber.Builder();
    }

    public static final class Builder {
        private static final int DEFAULT_SAMPLE_RATE = 16_000;
        private String apiKey;
        private Integer sampleRate;
        private AudioEncoding encoding;
        private boolean disablePartialTranscripts;
        private List<String> wordBoost;
        private Optional<Integer> endUtteranceSilenceThreshold = Optional.empty();
        private Consumer<SessionBegins> onSessionBegins;
        private Consumer<PartialTranscript> onPartialTranscript;
        private Consumer<FinalTranscript> onFinalTranscript;
        private Consumer<RealtimeTranscript> onTranscript;
        private Consumer<Throwable> onError;
        private BiConsumer<Integer, String> onClose;
        private Consumer<SessionInformation> onSessionInformation;

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
         * Sets audio encoding
         *
         * @param encoding The encoding of the audio data
         * @return this
         */
        public RealtimeTranscriber.Builder encoding(AudioEncoding encoding) {
            this.encoding = encoding;
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
         * Sets onSessionInformation
         *
         * @param onSessionInformation an event handler for the session information event.
         *                             This message is sent at the end of the session, before the SessionTerminated message.
         *                             Defaults to a noop.
         * @return this
         */
        public RealtimeTranscriber.Builder onSessionInformation(Consumer<SessionInformation> onSessionInformation) {
            this.onSessionInformation = onSessionInformation;
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
                    encoding,
                    disablePartialTranscripts,
                    Optional.ofNullable(wordBoost),
                    endUtteranceSilenceThreshold,
                    onSessionBegins,
                    onPartialTranscript,
                    onFinalTranscript,
                    onTranscript,
                    onError,
                    onSessionInformation,
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
            isConnected = true;
            if (onOpen != null) {
                onOpen.accept(response);
            }
        }

        @Override
        public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
            try {
                RealtimeBaseMessage baseMessage = ObjectMappers.parseOrThrow(text, RealtimeBaseMessage.class);
                MessageType messageType = baseMessage.getMessageType();
                if (messageType == MessageType.SESSION_BEGINS) {
                    realtimeMessageVisitor.visit(
                            ObjectMappers.JSON_MAPPER.readValue(text, SessionBegins.class)
                    );
                } else if (messageType == MessageType.PARTIAL_TRANSCRIPT) {
                    realtimeMessageVisitor.visit(
                            ObjectMappers.JSON_MAPPER.readValue(text, PartialTranscript.class)
                    );
                } else if (messageType == MessageType.FINAL_TRANSCRIPT) {
                    realtimeMessageVisitor.visit(
                            ObjectMappers.JSON_MAPPER.readValue(text, FinalTranscript.class)
                    );
                } else if (messageType == MessageType.SESSION_INFORMATION) {
                    realtimeMessageVisitor.visit(
                            ObjectMappers.JSON_MAPPER.readValue(text, SessionInformation.class)
                    );
                } else if (messageType == MessageType.SESSION_TERMINATED) {
                    realtimeMessageVisitor.visit((SessionTerminated) null);
                }
                // Intentionally don't throw an exception for unknown message type.
                // New message types shouldn't cause this to break.
            } catch (JsonProcessingException e) {
                if (onError == null) return;
                onError.accept(e);
            }
        }

        @Override
        public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
            isConnected = false;
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

        @Override
        public void onClosed(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
            isConnected = false;
            super.onClosed(webSocket, code, reason);
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
        public Void visit(SessionInformation value) {
            sessionInformation = value;
            if (onSessionInformation == null) return null;
            onSessionInformation.accept(value);
            return null;
        }


        @Override
        public Void visit(SessionTerminated value) {
            if (sessionTerminatedFuture != null) {
                sessionTerminatedFuture.complete(sessionInformation);
            }
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
