package com.assemblyai.api;

import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.resources.transcripts.TranscriptsClient;
import com.assemblyai.api.resources.transcripts.requests.TranscriptParams;
import com.assemblyai.api.types.Transcript;

public class PollingTranscriptClient extends TranscriptsClient {

    private final Transcriber transcriber;

    public PollingTranscriptClient(ClientOptions clientOptions, Transcriber transcriber) {
        super(clientOptions);
        this.transcriber = transcriber;
    }

    /**
     * Create a transcript from an audio or video file that is accessible via a URL.
     */
    public Transcript create(TranscriptParams request, boolean poll) {
        return transcriber.transcribe(request.getAudioUrl(), request, poll);
    }

}
