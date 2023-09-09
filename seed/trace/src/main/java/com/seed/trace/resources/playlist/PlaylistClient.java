package com.seed.trace.resources.playlist;

import com.fasterxml.jackson.core.type.TypeReference;
import com.seed.trace.core.ApiError;
import com.seed.trace.core.ClientOptions;
import com.seed.trace.core.ObjectMappers;
import com.seed.trace.core.RequestOptions;
import com.seed.trace.resources.playlist.requests.CreatePlaylistRequest;
import com.seed.trace.resources.playlist.requests.GetPlaylistsRequest;
import com.seed.trace.resources.playlist.types.Playlist;
import com.seed.trace.resources.playlist.types.UpdatePlaylistRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PlaylistClient {
    protected final ClientOptions clientOptions;

    public PlaylistClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public Playlist createPlaylist(int serviceParam, CreatePlaylistRequest request) {
        return createPlaylist(serviceParam, request, null);
    }

    public Playlist createPlaylist(int serviceParam, CreatePlaylistRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/playlist")
                .addPathSegment(Integer.toString(serviceParam))
                .addPathSegments("create");
        _httpUrl.addQueryParameter("datetime", request.getDatetime().toString());
        if (request.getOptionalDatetime().isPresent()) {
            _httpUrl.addQueryParameter(
                    "optionalDatetime", request.getOptionalDatetime().get().toString());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request.getBody()),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl.build())
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Playlist.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Playlist> getPlaylists(int serviceParam, GetPlaylistsRequest request) {
        return getPlaylists(serviceParam, request, null);
    }

    public List<Playlist> getPlaylists(int serviceParam, GetPlaylistsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder _httpUrl = HttpUrl.parse(
                        this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/playlist")
                .addPathSegment(Integer.toString(serviceParam))
                .addPathSegments("all");
        if (request.getLimit().isPresent()) {
            _httpUrl.addQueryParameter("limit", request.getLimit().get().toString());
        }
        _httpUrl.addQueryParameter("otherField", request.getOtherField());
        _httpUrl.addQueryParameter("multiLineDocs", request.getMultiLineDocs());
        if (request.getOptionalMultipleField().isPresent()) {
            _httpUrl.addQueryParameter(
                    "optionalMultipleField", request.getOptionalMultipleField().get());
        }
        _httpUrl.addQueryParameter("multipleField", request.getMultipleField());
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), new TypeReference<List<Playlist>>() {});
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Playlist getPlaylist(int serviceParam, String playlistId) {
        return getPlaylist(serviceParam, playlistId, null);
    }

    public Playlist getPlaylist(int serviceParam, String playlistId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/playlist")
                .addPathSegment(Integer.toString(serviceParam))
                .addPathSegment(playlistId)
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
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Playlist.class);
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Playlist> updatePlaylist(
            int serviceParam, String playlistId, Optional<UpdatePlaylistRequest> request) {
        return updatePlaylist(serviceParam, playlistId, request, null);
    }

    public Optional<Playlist> updatePlaylist(
            int serviceParam,
            String playlistId,
            Optional<UpdatePlaylistRequest> request,
            RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/playlist")
                .addPathSegment(Integer.toString(serviceParam))
                .addPathSegment(playlistId)
                .build();
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("PUT", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        _response.body().string(), new TypeReference<Optional<Playlist>>() {});
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Playlist> updatePlaylist(int serviceParam, String playlistId) {
        return updatePlaylist(serviceParam, playlistId, Optional.empty());
    }

    public void deletePlaylist(int serviceParam, String playlistId) {
        deletePlaylist(serviceParam, playlistId, null);
    }

    public void deletePlaylist(int serviceParam, String playlistId, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/playlist")
                .addPathSegment(Integer.toString(serviceParam))
                .addPathSegment(playlistId)
                .build();
        Request _request = new Request.Builder()
                .url(_httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    _response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}