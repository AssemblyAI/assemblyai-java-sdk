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
     * Get the transcript resource. The transcript is ready when the &quot;status&quot; is &quot;completed&quot;.
     */
    public Transcript create(CreateTranscriptParameters request, boolean poll) {
        return transcriber.transcribe(request.getAudioUrl(), request, poll);
    }

}
