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
@JsonDeserialize(builder = RedactedAudioResult.Builder.class)
public final class RedactedAudioResult {
    private final Optional<RedactedAudioStatus> status;

    private final Optional<String> redactedAudioUrl;

    private RedactedAudioResult(Optional<RedactedAudioStatus> status, Optional<String> redactedAudioUrl) {
        this.status = status;
        this.redactedAudioUrl = redactedAudioUrl;
    }

    /**
     * @return The status of the redacted audio
     */
    @JsonProperty("status")
    public Optional<RedactedAudioStatus> getStatus() {
        return status;
    }

    /**
     * @return The URL of the redacted audio file
     */
    @JsonProperty("redacted_audio_url")
    public Optional<String> getRedactedAudioUrl() {
        return redactedAudioUrl;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RedactedAudioResult && equalTo((RedactedAudioResult) other);
    }

    private boolean equalTo(RedactedAudioResult other) {
        return status.equals(other.status) && redactedAudioUrl.equals(other.redactedAudioUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.redactedAudioUrl);
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
        private Optional<RedactedAudioStatus> status = Optional.empty();

        private Optional<String> redactedAudioUrl = Optional.empty();

        private Builder() {}

        public Builder from(RedactedAudioResult other) {
            status(other.getStatus());
            redactedAudioUrl(other.getRedactedAudioUrl());
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<RedactedAudioStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(RedactedAudioStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "redacted_audio_url", nulls = Nulls.SKIP)
        public Builder redactedAudioUrl(Optional<String> redactedAudioUrl) {
            this.redactedAudioUrl = redactedAudioUrl;
            return this;
        }

        public Builder redactedAudioUrl(String redactedAudioUrl) {
            this.redactedAudioUrl = Optional.of(redactedAudioUrl);
            return this;
        }

        public RedactedAudioResult build() {
            return new RedactedAudioResult(status, redactedAudioUrl);
        }
    }
}
