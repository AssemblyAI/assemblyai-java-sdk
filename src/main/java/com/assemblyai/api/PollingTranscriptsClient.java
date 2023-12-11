package com.assemblyai.api;

import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.resources.files.types.UploadedFile;
import com.assemblyai.api.resources.transcripts.TranscriptsClient;
import com.assemblyai.api.resources.transcripts.requests.TranscriptParams;
import com.assemblyai.api.resources.transcripts.types.Transcript;
import com.assemblyai.api.resources.transcripts.types.TranscriptOptionalParams;
import com.assemblyai.api.resources.transcripts.types.TranscriptStatus;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class PollingTranscriptsClient extends TranscriptsClient {

    private static final TranscriptOptionalParams EMPTY_PARAMS = TranscriptOptionalParams.builder().build();

    private final AssemblyAI client;

    public PollingTranscriptsClient(ClientOptions clientOptions, AssemblyAI client) {
        super(clientOptions);
        this.client = client;
    }


    /*********************************************************************
     * Submit methods will immediately return the transcript
     *********************************************************************
     */

    public Transcript submit(File file) throws IOException {
        return submit(file, EMPTY_PARAMS);
    }

    public Transcript submit(File file, TranscriptOptionalParams transcriptParams) throws IOException {
        UploadedFile uploadedFile = client.files().upload(Files.readAllBytes(file.toPath()));
        return submit(uploadedFile.getUploadUrl(), transcriptParams);
    }

    public Transcript submit(String url) {
        return submit(url, EMPTY_PARAMS);
    }

    public Transcript submit(String url, TranscriptOptionalParams transcriptParams) {
        TranscriptParams createTranscriptParams = TranscriptParams.builder()
                .audioUrl(url)
                .languageCode(transcriptParams.getLanguageCode())
                .punctuate(transcriptParams.getPunctuate())
                .formatText(transcriptParams.getFormatText())
                .dualChannel(transcriptParams.getDualChannel())
                .webhookUrl(transcriptParams.getWebhookUrl())
                .webhookAuthHeaderName(transcriptParams.getWebhookAuthHeaderName())
                .webhookAuthHeaderValue(transcriptParams.getWebhookAuthHeaderValue())
                .autoHighlights(transcriptParams.getAutoHighlights())
                .audioStartFrom(transcriptParams.getAudioStartFrom())
                .audioEndAt(transcriptParams.getAudioEndAt())
                .wordBoost(transcriptParams.getWordBoost())
                .boostParam(transcriptParams.getBoostParam())
                .filterProfanity(transcriptParams.getFilterProfanity())
                .redactPii(transcriptParams.getRedactPii())
                .redactPiiAudio(transcriptParams.getRedactPiiAudio())
                .redactPiiAudioQuality(transcriptParams.getRedactPiiAudioQuality())
                .redactPiiPolicies(transcriptParams.getRedactPiiPolicies())
                .redactPiiSub(transcriptParams.getRedactPiiSub())
                .speakerLabels(transcriptParams.getSpeakerLabels())
                .speakersExpected(transcriptParams.getSpeakersExpected())
                .contentSafety(transcriptParams.getContentSafety())
                .iabCategories(transcriptParams.getIabCategories())
                .languageDetection(transcriptParams.getLanguageDetection())
                .customSpelling(transcriptParams.getCustomSpelling())
                .disfluencies(transcriptParams.getDisfluencies())
                .sentimentAnalysis(transcriptParams.getSentimentAnalysis())
                .autoChapters(transcriptParams.getAutoChapters())
                .entityDetection(transcriptParams.getEntityDetection())
                .speechThreshold(transcriptParams.getSpeechThreshold())
                .summarization(transcriptParams.getSummarization())
                .summaryModel(transcriptParams.getSummaryModel())
                .summaryType(transcriptParams.getSummaryType())
                .customTopics(transcriptParams.getCustomTopics())
                .topics(transcriptParams.getTopics())
                .build();
        return super.submit(createTranscriptParams);
    }

    /*********************************************************************
     * Transcribe methods will poll until transcription happens
     *********************************************************************
     */
    public Transcript transcribe(File file) throws IOException {
        return transcribe(file, EMPTY_PARAMS);
    }

    public Transcript transcribe(File file, TranscriptOptionalParams transcriptParams) throws IOException {
        UploadedFile uploadedFile = client.files().upload(Files.readAllBytes(file.toPath()));
        return transcribe(uploadedFile.getUploadUrl(), transcriptParams);
    }

    public Transcript transcribe(String url) {
        return transcribe(url, EMPTY_PARAMS);
    }

    public Transcript transcribe(String url, TranscriptOptionalParams transcriptParams) {
        Transcript transcriptResponse = submit(url, transcriptParams);
        return awaitCompletion(transcriptResponse.getId());
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
}
