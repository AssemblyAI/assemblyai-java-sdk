package com.assemblyai.api.resources.lemur;

import com.assemblyai.api.core.ApiError;
import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.core.RequestOptions;
import com.assemblyai.api.resources.lemur.requests.LemurActionItemsParameters;
import com.assemblyai.api.resources.lemur.requests.LemurQuestionAnswerParameters;
import com.assemblyai.api.resources.lemur.requests.LemurSummaryParameters;
import com.assemblyai.api.resources.lemur.requests.LemurTaskParameters;
import com.assemblyai.api.types.LemurActionItemsResult;
import com.assemblyai.api.types.LemurQuestionAnswerResults;
import com.assemblyai.api.types.LemurSummaryResult;
import com.assemblyai.api.types.LemurTaskResult;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LemurClient {
    protected final ClientOptions clientOptions;

    public LemurClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public LemurSummaryResult summary(LemurSummaryParameters request) {
        return summary(request, null);
    }

    public LemurSummaryResult summary(LemurSummaryParameters request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lemur/v3/generate/summary")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("transcript_ids", request.getTranscriptIds());
        if (request.getContext().isPresent()) {
            _requestBodyProperties.put("context", request.getContext());
        }
        if (request.getAnswerFormat().isPresent()) {
            _requestBodyProperties.put("answer_format", request.getAnswerFormat());
        }
        if (request.getFinalModel().isPresent()) {
            _requestBodyProperties.put("final_model", request.getFinalModel());
        }
        if (request.getMaxOutputSize().isPresent()) {
            _requestBodyProperties.put("max_output_size", request.getMaxOutputSize());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), LemurSummaryResult.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LemurQuestionAnswerResults questionAnswer(LemurQuestionAnswerParameters request) {
        return questionAnswer(request, null);
    }

    public LemurQuestionAnswerResults questionAnswer(
            LemurQuestionAnswerParameters request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lemur/v3/generate/question-answer")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("transcript_ids", request.getTranscriptIds());
        _requestBodyProperties.put("questions", request.getQuestions());
        if (request.getContext().isPresent()) {
            _requestBodyProperties.put("context", request.getContext());
        }
        if (request.getAnswerFormat().isPresent()) {
            _requestBodyProperties.put("answer_format", request.getAnswerFormat());
        }
        if (request.getFinalModel().isPresent()) {
            _requestBodyProperties.put("final_model", request.getFinalModel());
        }
        if (request.getMaxOutputSize().isPresent()) {
            _requestBodyProperties.put("max_output_size", request.getMaxOutputSize());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), LemurQuestionAnswerResults.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LemurActionItemsResult actionItems(LemurActionItemsParameters request) {
        return actionItems(request, null);
    }

    public LemurActionItemsResult actionItems(LemurActionItemsParameters request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lemur/v3/generate/action-items")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("transcript_ids", request.getTranscriptIds());
        if (request.getContext().isPresent()) {
            _requestBodyProperties.put("context", request.getContext());
        }
        if (request.getFinalModel().isPresent()) {
            _requestBodyProperties.put("final_model", request.getFinalModel());
        }
        if (request.getMaxOutputSize().isPresent()) {
            _requestBodyProperties.put("max_output_size", request.getMaxOutputSize());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), LemurActionItemsResult.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LemurTaskResult task(LemurTaskParameters request) {
        return task(request, null);
    }

    public LemurTaskResult task(LemurTaskParameters request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("lemur/v3/generate/task")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("transcript_ids", request.getTranscriptIds());
        _requestBodyProperties.put("prompt", request.getPrompt());
        if (request.getContext().isPresent()) {
            _requestBodyProperties.put("context", request.getContext());
        }
        if (request.getFinalModel().isPresent()) {
            _requestBodyProperties.put("final_model", request.getFinalModel());
        }
        if (request.getMaxOutputSize().isPresent()) {
            _requestBodyProperties.put("max_output_size", request.getMaxOutputSize());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), LemurTaskResult.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
