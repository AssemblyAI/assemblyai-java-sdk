package com.assemblyai.api;

import com.assemblyai.api.core.Environment;
import com.assemblyai.api.resources.transcript.requests.TranscriptRequest;
import com.assemblyai.api.types.TranscriptResponse;
import com.assemblyai.api.types.TranscriptStatus;
import com.assemblyai.api.types.UploadResponse;
import java.io.File;

public final class Transcriber {

    private final AssemblyAIClient client;

    private Transcriber(AssemblyAIClient client) {
        this.client = client;
    }

    /**
     * Transcribes an audio file whose location can be specified via a URL.
     */
    public TranscriptResponse transcribe(String url, boolean poll) {
        return transcribe(url, TranscriptRequest.builder().build(), poll);
    }

    /**
     * Transcribes an audio file whose location can be specified via a URL.
     */
    public TranscriptResponse transcribe(String url, TranscriptRequest transcriptRequest, boolean poll) {
        TranscriptResponse transcriptResponse = this.client
                .transcript()
                .create(TranscriptRequest.builder()
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
    public TranscriptResponse transcribe(File data, boolean poll) {
        return transcribe(data, TranscriptRequest.builder().build(), poll);
    }

    /**
     * Transcribes an audio file whose location can be specified via a filepath.
     */
    public TranscriptResponse transcribe(File data, TranscriptRequest transcriptRequest, boolean poll) {
        UploadResponse uploadResponse = this.client.files().upload(data);
        return transcribe(uploadResponse.getUploadUrl(), transcriptRequest, poll);
    }

    private TranscriptResponse awaitCompletion(String transcriptId) {
        try {
            while (true) {
                TranscriptResponse transcript = this.client.transcript().get(transcriptId);
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
        private final AssemblyAIClientBuilder clientBuilder = new AssemblyAIClientBuilder();

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
