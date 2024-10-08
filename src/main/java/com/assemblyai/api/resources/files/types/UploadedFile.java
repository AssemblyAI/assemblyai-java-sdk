/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.files.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UploadedFile.Builder.class)
public final class UploadedFile {
    private final String uploadUrl;

    private final Map<String, Object> additionalProperties;

    private UploadedFile(String uploadUrl, Map<String, Object> additionalProperties) {
        this.uploadUrl = uploadUrl;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A URL that points to your audio file, accessible only by AssemblyAI's servers
     */
    @JsonProperty("upload_url")
    public String getUploadUrl() {
        return uploadUrl;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UploadedFile && equalTo((UploadedFile) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UploadedFile other) {
        return uploadUrl.equals(other.uploadUrl);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.uploadUrl);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static UploadUrlStage builder() {
        return new Builder();
    }

    public interface UploadUrlStage {
        _FinalStage uploadUrl(@NotNull String uploadUrl);

        Builder from(UploadedFile other);
    }

    public interface _FinalStage {
        UploadedFile build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UploadUrlStage, _FinalStage {
        private String uploadUrl;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(UploadedFile other) {
            uploadUrl(other.getUploadUrl());
            return this;
        }

        /**
         * <p>A URL that points to your audio file, accessible only by AssemblyAI's servers</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("upload_url")
        public _FinalStage uploadUrl(@NotNull String uploadUrl) {
            this.uploadUrl = Objects.requireNonNull(uploadUrl, "uploadUrl must not be null");
            return this;
        }

        @java.lang.Override
        public UploadedFile build() {
            return new UploadedFile(uploadUrl, additionalProperties);
        }
    }
}
