package com.assemblyai.api;

import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.resources.transcript.TranscriptClient;
import com.assemblyai.api.resources.transcript.requests.CreateTranscriptParameters;
import com.assemblyai.api.types.Transcript;

public class PollingTranscriptClient extends TranscriptClient {

    private final Transcriber transcriber;

    public PollingTranscriptClient(ClientOptions clientOptions, Transcriber transcriber) {
        super(clientOptions);
        this.transcriber = transcriber;
    }

    /**
     * Create a transcript from an audio or video file that is accessible via a URL.
     */
    public Transcript create(CreateTranscriptParameters request, boolean poll) {
        return transcriber.transcribe(request.getAudioUrl(), request, poll);
    }

}
