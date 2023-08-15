package com.assemblyai.api.resources.transcript;

import com.assemblyai.api.core.ApiError;
import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.core.RequestOptions;
import com.assemblyai.api.resources.transcript.requests.TranscriptExportAsSrtRequest;
import com.assemblyai.api.resources.transcript.requests.TranscriptExportAsVttRequest;
import com.assemblyai.api.resources.transcript.requests.TranscriptListRequest;
import com.assemblyai.api.resources.transcript.requests.TranscriptRequest;
import com.assemblyai.api.resources.transcript.requests.TranscriptSearchRequest;
import com.assemblyai.api.types.TranscriptListResponse;
import com.assemblyai.api.types.TranscriptParagraphResponse;
import com.assemblyai.api.types.TranscriptResponse;
import com.assemblyai.api.types.TranscriptSearchResponse;
import com.assemblyai.api.types.TranscriptSentenceResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TranscriptClient {
    protected final ClientOptions clientOptions;

    public TranscriptClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public TranscriptListResponse list() {
        return list(TranscriptListRequest.builder().build(), null);
    }

    public TranscriptListResponse list(TranscriptListRequest request) {
        return list(request, null);
    }

    public TranscriptListResponse list(TranscriptListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("transcript");
        if (request.getLimit().isPresent()) {
            _httpUrl.addQueryParameter("limit", request.getLimit().get().toString());
        }
        if (request.getStatus().isPresent()) {
            _httpUrl.addQueryParameter("status", request.getStatus().get().toString());
        }
        if (request.getCreatedOn().isPresent()) {
            _httpUrl.addQueryParameter("created_on", request.getCreatedOn().get());
        }
        if (request.getBeforeId().isPresent()) {
            _httpUrl.addQueryParameter("before_id", request.getBeforeId().get());
        }
        if (request.getAfterId().isPresent()) {
            _httpUrl.addQueryParameter("after_id", request.getAfterId().get());
        }
        if (request.getThrottledOnly().isPresent()) {
            _httpUrl.addQueryParameter(
                    "throttled_only", request.getThrottledOnly().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), TranscriptListResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TranscriptResponse create(TranscriptRequest request) {
        return create(request, null);
    }

    public TranscriptResponse create(TranscriptRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("transcript")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        if (request.getAudioUrl().isPresent()) {
            _requestBodyProperties.put("audio_url", request.getAudioUrl());
        }
        if (request.getLanguageCode().isPresent()) {
            _requestBodyProperties.put("language_code", request.getLanguageCode());
        }
        if (request.getSpeakerLabels().isPresent()) {
            _requestBodyProperties.put("speaker_labels", request.getSpeakerLabels());
        }
        if (request.getWordBoost().isPresent()) {
            _requestBodyProperties.put("word_boost", request.getWordBoost());
        }
        if (request.getBoostParam().isPresent()) {
            _requestBodyProperties.put("boost_param", request.getBoostParam());
        }
        if (request.getCustomSpelling().isPresent()) {
            _requestBodyProperties.put("custom_spelling", request.getCustomSpelling());
        }
        if (request.getDualChannel().isPresent()) {
            _requestBodyProperties.put("dual_channel", request.getDualChannel());
        }
        if (request.getDisfluencies().isPresent()) {
            _requestBodyProperties.put("disfluencies", request.getDisfluencies());
        }
        if (request.getLanguageDetection().isPresent()) {
            _requestBodyProperties.put("language_detection", request.getLanguageDetection());
        }
        if (request.getPunctuate().isPresent()) {
            _requestBodyProperties.put("punctuate", request.getPunctuate());
        }
        if (request.getFormatText().isPresent()) {
            _requestBodyProperties.put("format_text", request.getFormatText());
        }
        if (request.getFilterProfanity().isPresent()) {
            _requestBodyProperties.put("filter_profanity", request.getFilterProfanity());
        }
        if (request.getWebhookUrl().isPresent()) {
            _requestBodyProperties.put("webhook_url", request.getWebhookUrl());
        }
        if (request.getWebhookAuthHeaderName().isPresent()) {
            _requestBodyProperties.put("webhook_auth_header_name", request.getWebhookAuthHeaderName());
        }
        if (request.getWebhookAuthHeaderValue().isPresent()) {
            _requestBodyProperties.put("webhook_auth_header_value", request.getWebhookAuthHeaderValue());
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), TranscriptResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TranscriptResponse get(String transcriptId) {
        return get(transcriptId, null);
    }

    public TranscriptResponse get(String transcriptId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("transcript")
                .addPathSegment(transcriptId)
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), TranscriptResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TranscriptResponse delete(String transcriptId) {
        return delete(transcriptId, null);
    }

    public TranscriptResponse delete(String transcriptId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("transcript")
                .addPathSegment(transcriptId)
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), TranscriptResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String exportAsVtt(String transcriptId) {
        return exportAsVtt(transcriptId, TranscriptExportAsVttRequest.builder().build(), null);
    }

    public String exportAsVtt(String transcriptId, TranscriptExportAsVttRequest request) {
        return exportAsVtt(transcriptId, request, null);
    }

    public String exportAsVtt(
            String transcriptId, TranscriptExportAsVttRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("transcript")
                .addPathSegment(transcriptId)
                .addPathSegments("vtt");
        if (request.getCharsPerCaption().isPresent()) {
            _httpUrl.addQueryParameter(
                    "chars_per_caption", request.getCharsPerCaption().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return _response.body().string();
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String exportAsSrt(String transcriptId) {
        return exportAsSrt(transcriptId, TranscriptExportAsSrtRequest.builder().build(), null);
    }

    public String exportAsSrt(String transcriptId, TranscriptExportAsSrtRequest request) {
        return exportAsSrt(transcriptId, request, null);
    }

    public String exportAsSrt(
            String transcriptId, TranscriptExportAsSrtRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("transcript")
                .addPathSegment(transcriptId)
                .addPathSegments("srt");
        if (request.getCharsPerCaption().isPresent()) {
            _httpUrl.addQueryParameter(
                    "chars_per_caption", request.getCharsPerCaption().get().toString());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), String.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TranscriptSentenceResponse exportSentences(String transcriptId) {
        return exportSentences(transcriptId, null);
    }

    public TranscriptSentenceResponse exportSentences(String transcriptId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("transcript")
                .addPathSegment(transcriptId)
                .addPathSegments("sentences")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), TranscriptSentenceResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TranscriptParagraphResponse exportParagraphs(String transcriptId) {
        return exportParagraphs(transcriptId, null);
    }

    public TranscriptParagraphResponse exportParagraphs(String transcriptId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("transcript")
                .addPathSegment(transcriptId)
                .addPathSegments("paragraphs")
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), TranscriptParagraphResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TranscriptSearchResponse search(String transcriptId, TranscriptSearchRequest request) {
        return search(transcriptId, request, null);
    }

    public TranscriptSearchResponse search(
            String transcriptId, TranscriptSearchRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("transcript")
                .addPathSegment(transcriptId)
                .addPathSegments("word-search");
        if (request.getWords().isPresent()) {
            _httpUrl.addQueryParameter("words", request.getWords().get());
        }
        RequestBody _requestBody = null;
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("GET", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), TranscriptSearchResponse.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
