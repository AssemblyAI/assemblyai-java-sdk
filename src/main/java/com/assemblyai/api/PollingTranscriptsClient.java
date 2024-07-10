package com.assemblyai.api;

import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.RequestOptions;
import com.assemblyai.api.resources.files.types.UploadedFile;
import com.assemblyai.api.resources.transcripts.TranscriptsClient;
import com.assemblyai.api.resources.transcripts.requests.TranscriptParams;
import com.assemblyai.api.resources.transcripts.requests.WordSearchParams;
import com.assemblyai.api.resources.transcripts.types.Transcript;
import com.assemblyai.api.resources.transcripts.types.TranscriptOptionalParams;
import com.assemblyai.api.resources.transcripts.types.TranscriptStatus;
import com.assemblyai.api.resources.transcripts.types.WordSearchResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class PollingTranscriptsClient extends TranscriptsClient {

    private static final TranscriptOptionalParams EMPTY_PARAMS =
            TranscriptOptionalParams.builder().build();

    private final AssemblyAI client;

    public PollingTranscriptsClient(ClientOptions clientOptions, AssemblyAI client) {
        super(clientOptions);
        this.client = client;
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     * @param file Audio file to transcribe
     * @return Queued transcript
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript submit(File file) throws IOException {
        return submit(file, EMPTY_PARAMS);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     * @param file Audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @return Queued transcript
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript submit(File file, TranscriptOptionalParams transcriptParams) throws IOException {
        UploadedFile uploadedFile = client.files().upload(Files.readAllBytes(file.toPath()));
        return submit(uploadedFile.getUploadUrl(), transcriptParams);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     * @param url URL to the audio file to transcribe
     * @return Queued transcript
     */
    public Transcript submit(String url) {
        return submit(url, EMPTY_PARAMS);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     * @param url URL to the audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @return Queued transcript
     */
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
                .speechModel(transcriptParams.getSpeechModel())
                .speechThreshold(transcriptParams.getSpeechThreshold())
                .summarization(transcriptParams.getSummarization())
                .summaryModel(transcriptParams.getSummaryModel())
                .summaryType(transcriptParams.getSummaryType())
                .customTopics(transcriptParams.getCustomTopics())
                .topics(transcriptParams.getTopics())
                .build();
        return super.submit(createTranscriptParams);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     * @param file Audio file to transcribe
     * @return A transcript with status "completed" or "error"
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript transcribe(File file) throws IOException {
        return transcribe(file, EMPTY_PARAMS);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     * @param file Audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @return A transcript with status "completed" or "error"
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript transcribe(File file, TranscriptOptionalParams transcriptParams) throws IOException {
        UploadedFile uploadedFile = client.files().upload(Files.readAllBytes(file.toPath()));
        return transcribe(uploadedFile.getUploadUrl(), transcriptParams);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     * @param url URL to the audio file to transcribe
     * @return A transcript with status "completed" or "error"
     */
    public Transcript transcribe(String url) {
        return transcribe(url, EMPTY_PARAMS);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     * @param url URL to the audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @return A transcript with status "completed" or "error"
     */
    public Transcript transcribe(String url, TranscriptOptionalParams transcriptParams) {
        Transcript transcriptResponse = submit(url, transcriptParams);
        return awaitCompletion(transcriptResponse.getId());
    }

    private Transcript awaitCompletion(String transcriptId) {
        try {
            while (true) {
                Transcript transcript = this.client.transcripts().get(transcriptId);
                TranscriptStatus status = transcript.getStatus();
                if (status.equals(TranscriptStatus.COMPLETED) || status.equals(TranscriptStatus.ERROR)) {
                    return transcript;
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while polling transcript id=" + transcriptId);
        }
    }

    /**
     * Search through the transcript for a specific set of keywords. You can search for individual words, numbers, or phrases containing up to five words or numbers.
     */
    public WordSearchResponse wordSearch(String transcriptId, List<String> words) {
        return wordSearch(transcriptId, words, null);
    }

    /**
     * Search through the transcript for a specific set of keywords. You can search for individual words, numbers, or phrases containing up to five words or numbers.
     */
    public WordSearchResponse wordSearch(String transcriptId, List<String> words, RequestOptions requestOptions) {
        return wordSearch(
                transcriptId,
                WordSearchParams.builder()
                        .words(String.join(",", words))
                        .build(),
                requestOptions
        );
    }
}
