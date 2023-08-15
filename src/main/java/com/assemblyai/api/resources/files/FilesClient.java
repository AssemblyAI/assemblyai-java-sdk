package com.assemblyai.api.resources.files;

import com.assemblyai.api.core.ApiError;
import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.core.RequestOptions;
import com.assemblyai.api.types.UploadResponse;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class FilesClient {
    protected final ClientOptions clientOptions;

    public FilesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public UploadResponse upload() {
        return upload(null);
    }

    public UploadResponse upload(RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("upload")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("POST", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
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
