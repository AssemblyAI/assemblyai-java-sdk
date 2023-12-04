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

    public Transcript submit(TranscriptParams request) {
        return transcriber.transcribe(request.getAudioUrl(), request, false);
    }

    public Transcript transcribe(TranscriptParams request) {
        return transcriber.transcribe(request.getAudioUrl(), request, true);
    }

}
