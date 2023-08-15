package com.assemblyai.api.resources.files;

import com.assemblyai.api.core.ApiError;
import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.core.RequestOptions;
import com.assemblyai.api.types.UploadResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FilesClient {
    protected final ClientOptions clientOptions;

    public FilesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public UploadResponse upload(File file) {
        return upload(file, null);
    }

    public UploadResponse upload(File file, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("upload")
                .build();
        try {
            byte[] _body = Files.readAllBytes(file.toPath());
            Request _request = new Request.Builder()
                    .url(_httpUrl)
                    .method("POST", RequestBody.create(MediaType.get("application/octet-stream"), _body))
                    .headers(Headers.of(clientOptions.headers(requestOptions)))
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), UploadResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
