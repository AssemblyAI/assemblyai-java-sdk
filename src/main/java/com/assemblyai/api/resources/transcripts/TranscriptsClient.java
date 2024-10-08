/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.transcripts;

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
import com.assemblyai.api.resources.transcripts.requests.GetSubtitlesParams;
import com.assemblyai.api.resources.transcripts.requests.ListTranscriptParams;
import com.assemblyai.api.resources.transcripts.requests.TranscriptParams;
import com.assemblyai.api.resources.transcripts.requests.WordSearchParams;
import com.assemblyai.api.resources.transcripts.types.ParagraphsResponse;
import com.assemblyai.api.resources.transcripts.types.RedactedAudioResponse;
import com.assemblyai.api.resources.transcripts.types.SentencesResponse;
import com.assemblyai.api.resources.transcripts.types.SubtitleFormat;
import com.assemblyai.api.resources.transcripts.types.Transcript;
import com.assemblyai.api.resources.transcripts.types.TranscriptList;
import com.assemblyai.api.resources.transcripts.types.WordSearchResponse;
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

public class TranscriptsClient {
    protected final ClientOptions clientOptions;

    public TranscriptsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Retrieve a list of transcripts you created.
     * Transcripts are sorted from newest to oldest. The previous URL always points to a page with older transcripts.
     */
    public TranscriptList list() {
        return list(ListTranscriptParams.builder().build());
    }

    /**
     * Retrieve a list of transcripts you created.
     * Transcripts are sorted from newest to oldest. The previous URL always points to a page with older transcripts.
     */
    public TranscriptList list(ListTranscriptParams request) {
        return list(request, null);
    }

    /**
     * Retrieve a list of transcripts you created.
     * Transcripts are sorted from newest to oldest. The previous URL always points to a page with older transcripts.
     */
    public TranscriptList list(ListTranscriptParams request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/transcript");
        if (request.getLimit().isPresent()) {
            httpUrl.addQueryParameter("limit", request.getLimit().get().toString());
        }
        if (request.getStatus().isPresent()) {
            httpUrl.addQueryParameter("status", request.getStatus().get().toString());
        }
        if (request.getCreatedOn().isPresent()) {
            httpUrl.addQueryParameter("created_on", request.getCreatedOn().get());
        }
        if (request.getBeforeId().isPresent()) {
            httpUrl.addQueryParameter("before_id", request.getBeforeId().get());
        }
        if (request.getAfterId().isPresent()) {
            httpUrl.addQueryParameter("after_id", request.getAfterId().get());
        }
        if (request.getThrottledOnly().isPresent()) {
            httpUrl.addQueryParameter(
                    "throttled_only", request.getThrottledOnly().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), TranscriptList.class);
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
     * Create a transcript from a media file that is accessible via a URL.
     */
    public Transcript submit(TranscriptParams request) {
        return submit(request, null);
    }

    /**
     * Create a transcript from a media file that is accessible via a URL.
     */
    public Transcript submit(TranscriptParams request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/transcript")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Transcript.class);
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
     * Get the transcript resource. The transcript is ready when the &quot;status&quot; is &quot;completed&quot;.
     */
    public Transcript get(String transcriptId) {
        return get(transcriptId, null);
    }

    /**
     * Get the transcript resource. The transcript is ready when the &quot;status&quot; is &quot;completed&quot;.
     */
    public Transcript get(String transcriptId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/transcript")
                .addPathSegment(transcriptId)
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Transcript.class);
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
     * Remove the data from the transcript and mark it as deleted.
     */
    public Transcript delete(String transcriptId) {
        return delete(transcriptId, null);
    }

    /**
     * Remove the data from the transcript and mark it as deleted.
     */
    public Transcript delete(String transcriptId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/transcript")
                .addPathSegment(transcriptId)
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Transcript.class);
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
     * Export your transcript in SRT or VTT format to use with a video player for subtitles and closed captions.
     */
    public String getSubtitles(String transcriptId, SubtitleFormat subtitleFormat) {
        return getSubtitles(
                transcriptId, subtitleFormat, GetSubtitlesParams.builder().build());
    }

    /**
     * Export your transcript in SRT or VTT format to use with a video player for subtitles and closed captions.
     */
    public String getSubtitles(String transcriptId, SubtitleFormat subtitleFormat, GetSubtitlesParams request) {
        return getSubtitles(transcriptId, subtitleFormat, request, null);
    }

    /**
     * Export your transcript in SRT or VTT format to use with a video player for subtitles and closed captions.
     */
    public String getSubtitles(
            String transcriptId,
            SubtitleFormat subtitleFormat,
            GetSubtitlesParams request,
            RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/transcript")
                .addPathSegment(transcriptId)
                .addPathSegment(subtitleFormat.toString());
        if (request.getCharsPerCaption().isPresent()) {
            httpUrl.addQueryParameter(
                    "chars_per_caption", request.getCharsPerCaption().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return responseBody.string();
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
     * Get the transcript split by sentences. The API will attempt to semantically segment the transcript into sentences to create more reader-friendly transcripts.
     */
    public SentencesResponse getSentences(String transcriptId) {
        return getSentences(transcriptId, null);
    }

    /**
     * Get the transcript split by sentences. The API will attempt to semantically segment the transcript into sentences to create more reader-friendly transcripts.
     */
    public SentencesResponse getSentences(String transcriptId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/transcript")
                .addPathSegment(transcriptId)
                .addPathSegments("sentences")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), SentencesResponse.class);
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
     * Get the transcript split by paragraphs. The API will attempt to semantically segment your transcript into paragraphs to create more reader-friendly transcripts.
     */
    public ParagraphsResponse getParagraphs(String transcriptId) {
        return getParagraphs(transcriptId, null);
    }

    /**
     * Get the transcript split by paragraphs. The API will attempt to semantically segment your transcript into paragraphs to create more reader-friendly transcripts.
     */
    public ParagraphsResponse getParagraphs(String transcriptId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/transcript")
                .addPathSegment(transcriptId)
                .addPathSegments("paragraphs")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ParagraphsResponse.class);
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
     * Search through the transcript for keywords. You can search for individual words, numbers, or phrases containing up to five words or numbers.
     */
    public WordSearchResponse wordSearch(String transcriptId) {
        return wordSearch(transcriptId, WordSearchParams.builder().build());
    }

    /**
     * Search through the transcript for keywords. You can search for individual words, numbers, or phrases containing up to five words or numbers.
     */
    public WordSearchResponse wordSearch(String transcriptId, WordSearchParams request) {
        return wordSearch(transcriptId, request, null);
    }

    /**
     * Search through the transcript for keywords. You can search for individual words, numbers, or phrases containing up to five words or numbers.
     */
    public WordSearchResponse wordSearch(String transcriptId, WordSearchParams request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/transcript")
                .addPathSegment(transcriptId)
                .addPathSegments("word-search");
        if (request.getWords().isPresent()) {
            httpUrl.addQueryParameter("words", request.getWords().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), WordSearchResponse.class);
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
     * Retrieve the redacted audio object containing the status and URL to the redacted audio.
     */
    public RedactedAudioResponse getRedactedAudio(String transcriptId) {
        return getRedactedAudio(transcriptId, null);
    }

    /**
     * Retrieve the redacted audio object containing the status and URL to the redacted audio.
     */
    public RedactedAudioResponse getRedactedAudio(String transcriptId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/transcript")
                .addPathSegment(transcriptId)
                .addPathSegments("redacted-audio")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), RedactedAudioResponse.class);
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
