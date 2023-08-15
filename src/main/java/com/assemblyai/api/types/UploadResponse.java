package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UploadResponse.Builder.class)
public final class UploadResponse {
    private final String uploadUrl;

    private UploadResponse(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }

    /**
     * @return A URL that points to your audio file, accessible only by AssemblyAI's servers
     */
    @JsonProperty("upload_url")
    public String getUploadUrl() {
        return uploadUrl;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UploadResponse && equalTo((UploadResponse) other);
    }

    private boolean equalTo(UploadResponse other) {
        return uploadUrl.equals(other.uploadUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.uploadUrl);
    }

    @Override
    public String toString() {
        return "UploadResponse{" + "uploadUrl: " + uploadUrl + "}";
    }

    public static UploadUrlStage builder() {
        return new Builder();
    }

    public interface UploadUrlStage {
        _FinalStage uploadUrl(String uploadUrl);

        Builder from(UploadResponse other);
    }

    public interface _FinalStage {
        UploadResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UploadUrlStage, _FinalStage {
        private String uploadUrl;

        private Builder() {}

        @Override
        public Builder from(UploadResponse other) {
            uploadUrl(other.getUploadUrl());
            return this;
        }

        /**
         * <p>A URL that points to your audio file, accessible only by AssemblyAI's servers</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("upload_url")
        public _FinalStage uploadUrl(String uploadUrl) {
            this.uploadUrl = uploadUrl;
            return this;
        }

        @Override
        public UploadResponse build() {
            return new UploadResponse(uploadUrl);
        }
    }
}
