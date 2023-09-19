package com.assemblyai.api;

import com.assemblyai.api.core.Environment;
import com.assemblyai.api.resources.transcript.requests.CreateTranscriptParameters;
import com.assemblyai.api.types.BaseTranscriptCreate;
import com.assemblyai.api.types.SummaryModel;
import com.assemblyai.api.types.SummaryType;
import com.assemblyai.api.types.Transcript;
import com.assemblyai.api.types.TranscriptStatus;
import com.assemblyai.api.types.UploadResponseBody;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

public final class Transcriber {

    private final AssemblyAI client;

    private Transcriber(AssemblyAI client) {
        this.client = client;
    }

    /**
     * Transcribes an audio file whose location can be specified via a URL.
     */
    public Transcript transcribe(String url, boolean poll) {
        return transcribe(url, BaseTranscriptCreate.builder().build(), poll);
    }

    /**
     * Transcribes an audio file whose location can be specified via a URL.
     */
    public Transcript transcribe(String url, BaseTranscriptCreate transcriptRequest, boolean poll) {
        CreateTranscriptParameters createTranscript = CreateTranscriptParameters.builder()
                .audioUrl(url)
                .topics(transcriptRequest.getTopics())
                .customTopics(transcriptRequest.getCustomTopics())
                .summaryType(transcriptRequest.getSummaryType())
                .summaryModel(transcriptRequest.getSummaryModel())
                .summarization(transcriptRequest.getSummarization())
                .speechThreshold(transcriptRequest.getSpeechThreshold())
                .entityDetection(transcriptRequest.getEntityDetection())
                .autoChapters(transcriptRequest.getAutoChapters())
                .sentimentAnalysis(transcriptRequest.getSentimentAnalysis())
                .autoChapters(transcriptRequest.getAutoChapters())
                .entityDetection(transcriptRequest.getEntityDetection())
                .speechThreshold(transcriptRequest.getSpeechThreshold())
                .summarization(transcriptRequest.getSummarization())
                .summaryModel(transcriptRequest.getSummaryModel())
                .summaryType(transcriptRequest.getSummaryType())
                .customTopics(transcriptRequest.getCustomTopics())
                .topics(transcriptRequest.getTopics())
                .build();
        Transcript transcriptResponse = this.client.transcript().create(createTranscript);
        if (poll) {
            return awaitCompletion(transcriptResponse.getId());
        }
        return transcriptResponse;
    }

    /**
     * Transcribes an audio file whose location can be specified via a filepath.
     */
    public Transcript transcribe(File data, boolean poll) throws IOException {
        return transcribe(data, BaseTranscriptCreate.builder().build(), poll);
    }

    /**
     * Transcribes an audio file whose location can be specified via a filepath.
     */
    public Transcript transcribe(File data, BaseTranscriptCreate transcriptRequest, boolean poll)
            throws IOException {
        UploadResponseBody uploadResponse = this.client.files().upload(Files.readAllBytes(data.toPath()));
        return transcribe(uploadResponse.getUploadUrl(), transcriptRequest, poll);
    }

    private Transcript awaitCompletion(String transcriptId) {
        try {
            while (true) {
                Transcript transcript = this.client.transcript().get(transcriptId);
                if (transcript.getStatus().equals(TranscriptStatus.COMPLETED)) {
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
