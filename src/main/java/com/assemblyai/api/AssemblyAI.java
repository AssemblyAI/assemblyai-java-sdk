package com.assemblyai.api;

import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.Suppliers;
import com.assemblyai.api.resources.files.FilesClient;
import com.assemblyai.api.resources.lemur.LemurClient;
import com.assemblyai.api.resources.transcript.TranscriptClient;
import java.util.function.Supplier;

public class AssemblyAI {
    protected final ClientOptions clientOptions;

    protected final Supplier<FilesClient> filesClient;

    protected final Supplier<LemurClient> lemurClient;

    protected final Supplier<TranscriptClient> transcriptClient;

    public AssemblyAI(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.filesClient = Suppliers.memoize(() -> new FilesClient(clientOptions));
        this.lemurClient = Suppliers.memoize(() -> new LemurClient(clientOptions));
        this.transcriptClient = Suppliers.memoize(() -> new TranscriptClient(clientOptions));
    }

    public FilesClient files() {
        return this.filesClient.get();
    }

    public LemurClient lemur() {
        return this.lemurClient.get();
    }

    public TranscriptClient transcript() {
        return this.transcriptClient.get();
    }

    public static AssemblyAIBuilder builder() {
        return new AssemblyAIBuilder();
    }
}
