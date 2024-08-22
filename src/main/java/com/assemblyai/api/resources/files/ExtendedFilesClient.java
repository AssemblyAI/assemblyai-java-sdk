package com.assemblyai.api.resources.files;

import com.assemblyai.api.core.*;
import com.assemblyai.api.resources.files.types.UploadedFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExtendedFilesClient extends FilesClient {
    public ExtendedFilesClient(ClientOptions clientOptions) {
        super(clientOptions);
    }

    /**
     * Upload a media file to AssemblyAI's servers.
     */
    public UploadedFile upload(File file) throws IOException {
        return upload(file, null);
    }

    /**
     * Upload a media file to AssemblyAI's servers.
     */
    public UploadedFile upload(File file, RequestOptions requestOptions) throws IOException {
        return upload(file.toPath(), requestOptions);
    }

    /**
     * Upload a media file to AssemblyAI's servers.
     */
    public UploadedFile upload(Path filePath) throws IOException {
        return upload(filePath, null);
    }

    /**
     * Upload a media file to AssemblyAI's servers.
     */
    public UploadedFile upload(Path filePath, RequestOptions requestOptions) throws IOException {
        return upload(Files.readAllBytes(filePath), requestOptions);
    }
}
