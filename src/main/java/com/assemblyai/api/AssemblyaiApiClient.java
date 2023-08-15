package com.assemblyai.api;

import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.Suppliers;
import com.assemblyai.api.resources.files.FilesClient;
import com.assemblyai.api.resources.transcript.TranscriptClient;
import java.util.function.Supplier;

public class AssemblyaiApiClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<TranscriptClient> transcriptClient;

    protected final Supplier<FilesClient> filesClient;

    public AssemblyaiApiClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.transcriptClient = Suppliers.memoize(() -> new TranscriptClient(clientOptions));
        this.filesClient = Suppliers.memoize(() -> new FilesClient(clientOptions));
    }

    public TranscriptClient transcript() {
        return this.transcriptClient.get();
    }

    public FilesClient files() {
        return this.filesClient.get();
    }

    public static AssemblyaiApiClientBuilder builder() {
        return new AssemblyaiApiClientBuilder();
    }
}
