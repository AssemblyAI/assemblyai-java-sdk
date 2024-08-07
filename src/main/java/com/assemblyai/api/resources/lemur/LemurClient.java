/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.lemur;

import com.assemblyai.api.core.AssemblyAIApiException;
import com.assemblyai.api.core.AssemblyAIException;
import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.MediaTypes;
import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.core.RequestOptions;
import com.assemblyai.api.errors.BadRequestError;
import com.assemblyai.api.errors.GatewayTimeoutError;
import com.assemblyai.api.errors.InternalServerError;
import com.assemblyai.api.errors.NotFoundError;
import com.assemblyai.api.errors.ServiceUnavailableError;
import com.assemblyai.api.errors.TooManyRequestsError;
import com.assemblyai.api.errors.UnauthorizedError;
import com.assemblyai.api.resources.lemur.requests.LemurActionItemsParams;
import com.assemblyai.api.resources.lemur.requests.LemurQuestionAnswerParams;
import com.assemblyai.api.resources.lemur.requests.LemurSummaryParams;
import com.assemblyai.api.resources.lemur.requests.LemurTaskParams;
import com.assemblyai.api.resources.lemur.types.LemurActionItemsResponse;
import com.assemblyai.api.resources.lemur.types.LemurQuestionAnswerResponse;
import com.assemblyai.api.resources.lemur.types.LemurResponse;
import com.assemblyai.api.resources.lemur.types.LemurSummaryResponse;
import com.assemblyai.api.resources.lemur.types.LemurTaskResponse;
import com.assemblyai.api.resources.lemur.types.PurgeLemurRequestDataResponse;
import com.assemblyai.api.types.Error;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LemurClient {
    protected final ClientOptions clientOptions;

    public LemurClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Use the LeMUR task endpoint to input your own LLM prompt.
     */
    public LemurTaskResponse task(LemurTaskParams request) {
        return task(request, null);
    }

    /**
     * Use the LeMUR task endpoint to input your own LLM prompt.
     */
    public LemurTaskResponse task(LemurTaskParams request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lemur/v3/generate/task")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new AssemblyAIException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), LemurTaskResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 404:
                        throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 429:
                        throw new TooManyRequestsError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 500:
                        throw new InternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 503:
                        throw new ServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new GatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new AssemblyAIApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new AssemblyAIException("Network error executing HTTP request", e);
        }
    }

    /**
     * Custom Summary allows you to distill a piece of audio into a few impactful sentences.
     * You can give the model context to obtain more targeted results while outputting the results in a variety of formats described in human language.
     */
    public LemurSummaryResponse summary() {
        return summary(LemurSummaryParams.builder().build());
    }

    /**
     * Custom Summary allows you to distill a piece of audio into a few impactful sentences.
     * You can give the model context to obtain more targeted results while outputting the results in a variety of formats described in human language.
     */
    public LemurSummaryResponse summary(LemurSummaryParams request) {
        return summary(request, null);
    }

    /**
     * Custom Summary allows you to distill a piece of audio into a few impactful sentences.
     * You can give the model context to obtain more targeted results while outputting the results in a variety of formats described in human language.
     */
    public LemurSummaryResponse summary(LemurSummaryParams request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lemur/v3/generate/summary")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new AssemblyAIException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), LemurSummaryResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 404:
                        throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 429:
                        throw new TooManyRequestsError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 500:
                        throw new InternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 503:
                        throw new ServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new GatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new AssemblyAIApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new AssemblyAIException("Network error executing HTTP request", e);
        }
    }

    /**
     * Question &amp; Answer allows you to ask free-form questions about a single transcript or a group of transcripts.
     * The questions can be any whose answers you find useful, such as judging whether a caller is likely to become a customer or whether all items on a meeting's agenda were covered.
     */
    public LemurQuestionAnswerResponse questionAnswer(LemurQuestionAnswerParams request) {
        return questionAnswer(request, null);
    }

    /**
     * Question &amp; Answer allows you to ask free-form questions about a single transcript or a group of transcripts.
     * The questions can be any whose answers you find useful, such as judging whether a caller is likely to become a customer or whether all items on a meeting's agenda were covered.
     */
    public LemurQuestionAnswerResponse questionAnswer(
            LemurQuestionAnswerParams request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lemur/v3/generate/question-answer")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new AssemblyAIException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), LemurQuestionAnswerResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 404:
                        throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 429:
                        throw new TooManyRequestsError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 500:
                        throw new InternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 503:
                        throw new ServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new GatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new AssemblyAIApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new AssemblyAIException("Network error executing HTTP request", e);
        }
    }

    /**
     * Use LeMUR to generate a list of action items from a transcript
     */
    public LemurActionItemsResponse actionItems() {
        return actionItems(LemurActionItemsParams.builder().build());
    }

    /**
     * Use LeMUR to generate a list of action items from a transcript
     */
    public LemurActionItemsResponse actionItems(LemurActionItemsParams request) {
        return actionItems(request, null);
    }

    /**
     * Use LeMUR to generate a list of action items from a transcript
     */
    public LemurActionItemsResponse actionItems(LemurActionItemsParams request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lemur/v3/generate/action-items")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new AssemblyAIException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), LemurActionItemsResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 404:
                        throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 429:
                        throw new TooManyRequestsError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 500:
                        throw new InternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 503:
                        throw new ServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new GatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new AssemblyAIApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new AssemblyAIException("Network error executing HTTP request", e);
        }
    }

    /**
     * Retrieve a LeMUR response that was previously generated.
     */
    public LemurResponse getResponse(String requestId) {
        return getResponse(requestId, null);
    }

    /**
     * Retrieve a LeMUR response that was previously generated.
     */
    public LemurResponse getResponse(String requestId, RequestOptions requestOptions) {
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
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), LemurResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 404:
                        throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 429:
                        throw new TooManyRequestsError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 500:
                        throw new InternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 503:
                        throw new ServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new GatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new AssemblyAIApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new AssemblyAIException("Network error executing HTTP request", e);
        }
    }

    /**
     * Delete the data for a previously submitted LeMUR request.
     * The LLM response data, as well as any context provided in the original request will be removed.
     */
    public PurgeLemurRequestDataResponse purgeRequestData(String requestId) {
        return purgeRequestData(requestId, null);
    }

    /**
     * Delete the data for a previously submitted LeMUR request.
     * The LLM response data, as well as any context provided in the original request will be removed.
     */
    public PurgeLemurRequestDataResponse purgeRequestData(String requestId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lemur/v3")
                .addPathSegment(requestId)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), PurgeLemurRequestDataResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 404:
                        throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 429:
                        throw new TooManyRequestsError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 500:
                        throw new InternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Error.class));
                    case 503:
                        throw new ServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new GatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new AssemblyAIApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new AssemblyAIException("Network error executing HTTP request", e);
        }
    }
}
