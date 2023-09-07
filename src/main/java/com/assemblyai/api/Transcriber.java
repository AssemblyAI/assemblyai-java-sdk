package com.assemblyai.api;

import com.assemblyai.api.core.Environment;
import com.assemblyai.api.resources.transcript.requests.CreateTranscriptParameters;
import com.assemblyai.api.types.Transcript;
import com.assemblyai.api.types.TranscriptStatus;
import com.assemblyai.api.types.UploadResponseBody;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class Transcriber {

    private final AssemblyAI client;

    private Transcriber(AssemblyAI client) {
        this.client = client;
    }

    /**
     * Transcribes an audio file whose location can be specified via a URL.
     */
    public Transcript transcribe(String url, boolean poll) {
        return transcribe(url, CreateTranscriptParameters.builder().build(), poll);
    }

    /**
     * Transcribes an audio file whose location can be specified via a URL.
     */
    public Transcript transcribe(String url, CreateTranscriptParameters transcriptRequest, boolean poll) {
        Transcript transcriptResponse = this.client
                .transcript()
                .create(CreateTranscriptParameters.builder()
                        .from(transcriptRequest)
                        .audioUrl(url)
                        .build());
        if (poll) {
            return awaitCompletion(transcriptResponse.getId());
        }
        return transcriptResponse;
    }

    /**
     * Transcribes an audio file whose location can be specified via a filepath.
     */
    public Transcript transcribe(File data, boolean poll) throws IOException {
        return transcribe(data, CreateTranscriptParameters.builder().build(), poll);
    }

    /**
     * Transcribes an audio file whose location can be specified via a filepath.
     */
    public Transcript transcribe(File data, CreateTranscriptParameters transcriptRequest, boolean poll)
            throws IOException {
        UploadResponseBody uploadResponse = this.client.files().upload(Files.readAllBytes(data.toPath()));
        return transcribe(uploadResponse.getUploadUrl(), transcriptRequest, poll);
    }

    private Transcript awaitCompletion(String transcriptId) {
        try {
            while (true) {
                Transcript transcript = this.client.transcript().get(transcriptId);
                if (transcript.getStatus().isPresent()
                        && transcript.getStatus().get().equals(TranscriptStatus.COMPLETED)) {
                    return transcript;
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while polling transcript id=" + transcriptId);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final AssemblyAIBuilder clientBuilder = new AssemblyAIBuilder();

        public Builder apiKey(String apiKey) {
            this.clientBuilder.apiKey(apiKey);
            return this;
        }

        public Builder environment(Environment environment) {
            this.clientBuilder.environment(environment);
            return this;
        }

        public Builder url(String url) {
            this.clientBuilder.url(url);
            return this;
        }

        public Transcriber build() {
            return new Transcriber(clientBuilder.build());
        }
    }
}
