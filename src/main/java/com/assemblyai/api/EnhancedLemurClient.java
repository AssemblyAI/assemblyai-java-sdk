package com.assemblyai.api;

import com.assemblyai.api.core.ApiError;
import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.core.RequestOptions;
import com.assemblyai.api.resources.lemur.LemurClient;
import com.assemblyai.api.resources.lemur.types.ILemurBaseResponse;
import okhttp3.*;

import java.io.IOException;

public final class EnhancedLemurClient extends LemurClient {
    public EnhancedLemurClient(ClientOptions clientOptions) {
        super(clientOptions);
    }

    /**
     * Retrieve a LeMUR response that was previously generated.
     */
    public <T extends ILemurBaseResponse> T getResponse(String requestId, Class<T> responseType) {
        return this.getResponse(requestId, responseType, null);
    }

    /**
     * Retrieve a LeMUR response that was previously generated.
     */
    public <T extends ILemurBaseResponse> T getResponse(String requestId, Class<T> responseType, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lemur/v3")
                .addPathSegment(requestId)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
                client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            Response response = client.newCall(okhttpRequest).execute();
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), responseType);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(
                            responseBody != null ? responseBody.string() : "{}", Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
