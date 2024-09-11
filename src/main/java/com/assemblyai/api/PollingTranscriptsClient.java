package com.assemblyai.api;

import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.core.RequestOptions;
import com.assemblyai.api.resources.files.types.UploadedFile;
import com.assemblyai.api.resources.transcripts.TranscriptsClient;
import com.assemblyai.api.resources.transcripts.requests.TranscriptParams;
import com.assemblyai.api.resources.transcripts.requests.WordSearchParams;
import com.assemblyai.api.resources.transcripts.types.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
     *
     * @param file Audio file to transcribe
     * @return Queued transcript
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript submit(File file) throws IOException {
        return submit(file.toPath(), EMPTY_PARAMS, null);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param file           Audio file to transcribe
     * @param requestOptions The HTTP request options
     * @return Queued transcript
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript submit(File file, RequestOptions requestOptions) throws IOException {
        return submit(file.toPath(), EMPTY_PARAMS, requestOptions);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param file             Audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @return Queued transcript
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript submit(File file, TranscriptOptionalParams transcriptParams) throws IOException {
        return submit(file.toPath(), transcriptParams, null);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param file             Audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @param requestOptions   The HTTP request options
     * @return Queued transcript
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript submit(
            File file,
            TranscriptOptionalParams transcriptParams,
            RequestOptions requestOptions
    ) throws IOException {
        return submit(file.toPath(), transcriptParams, requestOptions);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param filePath Path to audio file to transcribe
     * @return Queued transcript
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript submit(Path filePath) throws IOException {
        return submit(filePath, EMPTY_PARAMS, null);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param filePath       Path to audio file to transcribe
     * @param requestOptions The HTTP request options
     * @return Queued transcript
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript submit(
            Path filePath,
            RequestOptions requestOptions
    ) throws IOException {
        return submit(filePath, EMPTY_PARAMS, requestOptions);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param filePath         Path to audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @return Queued transcript
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript submit(
            Path filePath,
            TranscriptOptionalParams transcriptParams
    ) throws IOException {
        UploadedFile uploadedFile = client.files().upload(filePath);
        return submit(uploadedFile.getUploadUrl(), transcriptParams, null);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param filePath         Path to audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @param requestOptions   The HTTP request options
     * @return Queued transcript
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript submit(
            Path filePath,
            TranscriptOptionalParams transcriptParams,
            RequestOptions requestOptions
    ) throws IOException {
        UploadedFile uploadedFile = client.files().upload(filePath, requestOptions);
        return submit(uploadedFile.getUploadUrl(), transcriptParams, requestOptions);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param file The file uploaded to AssemblyAI
     * @return Queued transcript
     */
    public Transcript submit(UploadedFile file) {
        return submit(file.getUploadUrl(), EMPTY_PARAMS, null);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param file           The file uploaded to AssemblyAI
     * @param requestOptions The HTTP request options
     * @return Queued transcript
     */
    public Transcript submit(
            UploadedFile file,
            RequestOptions requestOptions
    ) {
        return submit(file.getUploadUrl(), EMPTY_PARAMS, requestOptions);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param file             The file uploaded to AssemblyAI
     * @param transcriptParams The parameters to transcribe an audio file.
     * @return Queued transcript
     */
    public Transcript submit(UploadedFile file, TranscriptOptionalParams transcriptParams) {
        return submit(file.getUploadUrl(), transcriptParams, null);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param file             The file uploaded to AssemblyAI
     * @param transcriptParams The parameters to transcribe an audio file.
     * @param requestOptions   The HTTP request options
     * @return Queued transcript
     */
    public Transcript submit(
            UploadedFile file,
            TranscriptOptionalParams transcriptParams,
            RequestOptions requestOptions
    ) {
        return submit(file.getUploadUrl(), transcriptParams, requestOptions);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param url URL to the audio file to transcribe
     * @return Queued transcript
     */
    public Transcript submit(String url) {
        return submit(url, EMPTY_PARAMS, null);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param url            URL to the audio file to transcribe
     * @param requestOptions The HTTP request options
     * @return Queued transcript
     */
    public Transcript submit(String url, RequestOptions requestOptions) {
        return submit(url, EMPTY_PARAMS, requestOptions);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param url              URL to the audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @return Queued transcript
     */
    public Transcript submit(String url, TranscriptOptionalParams transcriptParams) {
        return submit(url, transcriptParams, null);
    }

    /**
     * Submits a transcription job for an audio file. This will not wait until the transcript status is "completed" or "error".
     *
     * @param url              URL to the audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @param requestOptions   The HTTP request options
     * @return Queued transcript
     */
    public Transcript submit(String url, TranscriptOptionalParams transcriptParams, RequestOptions requestOptions) {
        ObjectNode transcriptParamsJson = ObjectMappers.JSON_MAPPER.valueToTree(transcriptParams);
        transcriptParamsJson.put("audio_url", url);
        TranscriptParams fullTranscriptParams;
        try {
            fullTranscriptParams = ObjectMappers.JSON_MAPPER.treeToValue(transcriptParamsJson, TranscriptParams.class);
        } catch (JsonProcessingException e) {
            // this should never happen
            throw new RuntimeException(e);
        }
        return super.submit(fullTranscriptParams, requestOptions);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param filePath Audio file to transcribe
     * @return A transcript with status "completed" or "error"
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript transcribe(Path filePath) throws IOException {
        return transcribe(filePath, EMPTY_PARAMS, null);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param filePath       Audio file to transcribe
     * @param requestOptions The HTTP request options
     * @return A transcript with status "completed" or "error"
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript transcribe(Path filePath, RequestOptions requestOptions) throws IOException {
        return transcribe(filePath, EMPTY_PARAMS, requestOptions);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param filePath         Audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @return A transcript with status "completed" or "error"
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript transcribe(Path filePath, TranscriptOptionalParams transcriptParams) throws IOException {
        UploadedFile uploadedFile = client.files().upload(filePath);
        return transcribe(uploadedFile.getUploadUrl(), transcriptParams, null);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param filePath         Audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @param requestOptions   The HTTP request options
     * @return A transcript with status "completed" or "error"
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript transcribe(Path filePath, TranscriptOptionalParams transcriptParams, RequestOptions requestOptions) throws IOException {
        UploadedFile uploadedFile = client.files().upload(filePath, requestOptions);
        return transcribe(uploadedFile.getUploadUrl(), transcriptParams, requestOptions);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param file Audio file to transcribe
     * @return A transcript with status "completed" or "error"
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript transcribe(File file) throws IOException {
        return transcribe(file, EMPTY_PARAMS, null);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param file           Audio file to transcribe
     * @param requestOptions The HTTP request options
     * @return A transcript with status "completed" or "error"
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript transcribe(File file, RequestOptions requestOptions) throws IOException {
        return transcribe(file, EMPTY_PARAMS, requestOptions);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param file             Audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @return A transcript with status "completed" or "error"
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript transcribe(File file, TranscriptOptionalParams transcriptParams) throws IOException {
        return transcribe(file, transcriptParams, null);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param file             Audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @param requestOptions   The HTTP request options
     * @return A transcript with status "completed" or "error"
     * @throws IOException The file will be read and an IOException may be thrown.
     */
    public Transcript transcribe(
            File file,
            TranscriptOptionalParams transcriptParams,
            RequestOptions requestOptions
    ) throws IOException {
        UploadedFile uploadedFile = client.files().upload(Files.readAllBytes(file.toPath()), requestOptions);
        return transcribe(uploadedFile.getUploadUrl(), transcriptParams, requestOptions);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param file The file uploaded to AssemblyAI
     * @return A transcript with status "completed" or "error"
     */
    public Transcript transcribe(UploadedFile file) {
        return transcribe(file, EMPTY_PARAMS, null);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param file           The file uploaded to AssemblyAI
     * @param requestOptions The HTTP request options
     * @return A transcript with status "completed" or "error"
     */
    public Transcript transcribe(UploadedFile file, RequestOptions requestOptions) {
        return transcribe(file, EMPTY_PARAMS, requestOptions);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param file             The file uploaded to AssemblyAI
     * @param transcriptParams The parameters to transcribe an audio file.
     * @return A transcript with status "completed" or "error"
     */
    public Transcript transcribe(UploadedFile file, TranscriptOptionalParams transcriptParams) {
        return transcribe(file.getUploadUrl(), transcriptParams, null);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param file             The file uploaded to AssemblyAI
     * @param transcriptParams The parameters to transcribe an audio file
     * @param requestOptions   The HTTP request options.
     * @return A transcript with status "completed" or "error"
     */
    public Transcript transcribe(
            UploadedFile file,
            TranscriptOptionalParams transcriptParams,
            RequestOptions requestOptions
    ) {
        return transcribe(file.getUploadUrl(), transcriptParams, requestOptions);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param url URL to the audio file to transcribe
     * @return A transcript with status "completed" or "error"
     */
    public Transcript transcribe(String url) {
        return transcribe(url, EMPTY_PARAMS, null);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param url            URL to the audio file to transcribe
     * @param requestOptions The HTTP request options
     * @return A transcript with status "completed" or "error"
     */
    public Transcript transcribe(String url, RequestOptions requestOptions) {
        return transcribe(url, EMPTY_PARAMS, requestOptions);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param url              URL to the audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @return A transcript with status "completed" or "error"
     */
    public Transcript transcribe(String url, TranscriptOptionalParams transcriptParams) {
        return transcribe(url, transcriptParams, null);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param url              URL to the audio file to transcribe
     * @param transcriptParams The parameters to transcribe an audio file.
     * @param requestOptions   The HTTP request options
     * @return A transcript with status "completed" or "error"
     */
    public Transcript transcribe(
            String url,
            TranscriptOptionalParams transcriptParams,
            RequestOptions requestOptions
    ) {
        Transcript transcriptResponse = submit(url, transcriptParams, requestOptions);
        return waitUntilReady(transcriptResponse.getId(), requestOptions);
    }

    /**
     * Transcribe an audio file. This will create a transcript and wait until the transcript status is "completed" or "error".
     *
     * @param transcriptParams The parameters to transcribe an audio file.
     * @return A transcript with status "completed" or "error"
     */
    public Transcript transcribe(TranscriptParams transcriptParams) {
        Transcript transcriptResponse = submit(transcriptParams, null);
        return waitUntilReady(transcriptResponse.getId());
    }

    /**
     * Wait until an existing transcript has the status "completed" or "error".
     *
     * @param transcriptId The ID of the transcript
     * @return The transcript with status "completed" or "error"
     */
    public Transcript waitUntilReady(String transcriptId) {
        return waitUntilReady(transcriptId, null);
    }

    /**
     * Wait until an existing transcript has the status "completed" or "error".
     *
     * @param transcriptId   The ID of the transcript
     * @param requestOptions The HTTP request options
     * @return The transcript with status "completed" or "error"
     */
    public Transcript waitUntilReady(String transcriptId, RequestOptions requestOptions) {
        try {
            while (true) {
                Transcript transcript = this.client.transcripts().get(transcriptId, requestOptions);
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
     *
     * @param transcriptId The ID of the transcript
     * @param words        Keywords to search for
     */
    public WordSearchResponse wordSearch(String transcriptId, List<String> words) {
        return wordSearch(transcriptId, words, null);
    }

    /**
     * Search through the transcript for a specific set of keywords. You can search for individual words, numbers, or phrases containing up to five words or numbers.
     *
     * @param transcriptId   The ID of the transcript
     * @param words          Keywords to search for
     * @param requestOptions The HTTP request options
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
