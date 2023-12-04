package com.assemblyai.api;

import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.resources.transcripts.TranscriptsClient;
import com.assemblyai.api.types.Transcript;
import com.assemblyai.api.types.TranscriptOptionalParams;
import java.io.File;
import java.io.IOException;

public class PollingTranscriptsClient extends TranscriptsClient {

    private static final TranscriptOptionalParams EMPTY_PARAMS = TranscriptOptionalParams.builder().build();

    private final Transcriber transcriber;

    public PollingTranscriptsClient(ClientOptions clientOptions, Transcriber transcriber) {
        super(clientOptions);
        this.transcriber = transcriber;
    }

    /*********************************************************************
     * Submit methods will immediately return the transcript
     *********************************************************************
     */

    public Transcript submit(File file) throws IOException {
        return submit(file, EMPTY_PARAMS);
    }

    public Transcript submit(File file, TranscriptOptionalParams params) throws IOException {
        return transcriber.transcribe(file, params, false);
    }

    public Transcript submit(String url) {
        return submit(url, EMPTY_PARAMS);
    }

    public Transcript submit(String url, TranscriptOptionalParams params) {
        return transcriber.transcribe(url, params, false);
    }

    /*********************************************************************
     * Transcribe methods will poll until transcription happens
     *********************************************************************
     */

    public Transcript transcribe(File file) throws IOException {
        return transcribe(file, EMPTY_PARAMS);
    }

    public Transcript transcribe(File file, TranscriptOptionalParams params) throws IOException {
        return transcriber.transcribe(file, params, true);
    }

    public Transcript transcribe(String url) {
        return transcribe(url, EMPTY_PARAMS);
    }

    public Transcript transcribe(String url, TranscriptOptionalParams params) {
        return transcriber.transcribe(url, params, true);
    }

}
