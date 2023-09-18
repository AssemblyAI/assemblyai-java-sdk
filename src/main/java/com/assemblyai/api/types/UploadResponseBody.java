package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UploadResponseBody.Builder.class)
public final class UploadResponseBody {
    private final Optional<String> uploadUrl;

    private UploadResponseBody(Optional<String> uploadUrl) {
        this.uploadUrl = uploadUrl;
    }

    /**
     * @return A URL that points to your audio file, accessible only by AssemblyAI's servers
     */
    @JsonProperty("upload_url")
    public Optional<String> getUploadUrl() {
        return uploadUrl;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UploadResponseBody && equalTo((UploadResponseBody) other);
    }

    private boolean equalTo(UploadResponseBody other) {
        return uploadUrl.equals(other.uploadUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.uploadUrl);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> uploadUrl = Optional.empty();

        private Builder() {}

        public Builder from(UploadResponseBody other) {
            uploadUrl(other.getUploadUrl());
            return this;
        }

        @JsonSetter(value = "upload_url", nulls = Nulls.SKIP)
        public Builder uploadUrl(Optional<String> uploadUrl) {
            this.uploadUrl = uploadUrl;
            return this;
        }

        public Builder uploadUrl(String uploadUrl) {
            this.uploadUrl = Optional.of(uploadUrl);
            return this;
        }

        public UploadResponseBody build() {
            return new UploadResponseBody(uploadUrl);
        }
    }
}
