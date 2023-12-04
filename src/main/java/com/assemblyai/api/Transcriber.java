package com.assemblyai.api;

import com.assemblyai.api.core.Environment;
import com.assemblyai.api.resources.transcripts.requests.TranscriptParams;
import com.assemblyai.api.types.ITranscriptOptionalParams;
import com.assemblyai.api.types.Transcript;
import com.assemblyai.api.types.TranscriptOptionalParams;
import com.assemblyai.api.types.TranscriptStatus;
import com.assemblyai.api.types.UploadedFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

final class Transcriber {

    private final AssemblyAI client;

    Transcriber(AssemblyAI client) {
        this.client = client;
    }

    /**
     * Transcribes an audio file whose location can be specified via a URL.
     * Polls until transcription is done.
     */
    public Transcript transcribe(String url) {
        return transcribe(url, TranscriptOptionalParams.builder().build(), true);
    }

    /**
     * Transcribes an audio file whose location can be specified via a URL.
     * Polls until transcription is done.
     */
    public Transcript transcribe(String url, TranscriptOptionalParams transcriptRequest) {
        return transcribe(url, transcriptRequest, true);
    }

    /**
     * Transcribes an audio file whose location can be specified via a URL.
     */
    public Transcript transcribe(
            String url,
            ITranscriptOptionalParams transcriptRequest,
            boolean poll) {
        TranscriptParams createTranscript = TranscriptParams.builder()
                .audioUrl(url)
                .languageCode(transcriptRequest.getLanguageCode())
                .punctuate(transcriptRequest.getPunctuate())
                .formatText(transcriptRequest.getFormatText())
                .dualChannel(transcriptRequest.getDualChannel())
                .webhookUrl(transcriptRequest.getWebhookUrl())
                .webhookAuthHeaderName(transcriptRequest.getWebhookAuthHeaderName())
                .webhookAuthHeaderValue(transcriptRequest.getWebhookAuthHeaderValue())
                .autoHighlights(transcriptRequest.getAutoHighlights())
                .audioStartFrom(transcriptRequest.getAudioStartFrom())
                .audioEndAt(transcriptRequest.getAudioEndAt())
                .wordBoost(transcriptRequest.getWordBoost())
                .boostParam(transcriptRequest.getBoostParam())
                .filterProfanity(transcriptRequest.getFilterProfanity())
                .redactPii(transcriptRequest.getRedactPii())
                .redactPiiAudio(transcriptRequest.getRedactPiiAudio())
                .redactPiiAudioQuality(transcriptRequest.getRedactPiiAudioQuality())
                .redactPiiPolicies(transcriptRequest.getRedactPiiPolicies())
                .redactPiiSub(transcriptRequest.getRedactPiiSub())
                .speakerLabels(transcriptRequest.getSpeakerLabels())
                .speakersExpected(transcriptRequest.getSpeakersExpected())
                .contentSafety(transcriptRequest.getContentSafety())
                .iabCategories(transcriptRequest.getIabCategories())
                .languageDetection(transcriptRequest.getLanguageDetection())
                .customSpelling(transcriptRequest.getCustomSpelling())
                .disfluencies(transcriptRequest.getDisfluencies())
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
     * Polls until transcription is done.
     */
    public Transcript transcribe(File data) throws IOException {
        return transcribe(data, TranscriptOptionalParams.builder().build(), true);
    }

    /**
     * Transcribes an audio file whose location can be specified via a filepath.
     * Polls until transcription is done.
     */
    public Transcript transcribe(File data, TranscriptOptionalParams transcriptRequest) throws IOException {
        return transcribe(data, transcriptRequest, true);
    }

    /**
     * Transcribes an audio file whose location can be specified via a filepath.
     */
    public Transcript transcribe(File data, TranscriptOptionalParams transcriptRequest, boolean poll)
            throws IOException {
        UploadedFile uploadedFile = this.client.files().upload(Files.readAllBytes(data.toPath()));
        return transcribe(uploadedFile.getUploadUrl(), transcriptRequest, poll);
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
