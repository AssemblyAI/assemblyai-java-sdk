package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TranscriptContentSafetyLabels.Builder.class)
public final class TranscriptContentSafetyLabels {
    private final Optional<AudioIntellegenceModelStatus> status;

    private final Optional<List<ContentSafetyLabelResult>> results;

    private TranscriptContentSafetyLabels(
            Optional<AudioIntellegenceModelStatus> status, Optional<List<ContentSafetyLabelResult>> results) {
        this.status = status;
        this.results = results;
    }

    /**
     * @return Will be either success, or unavailable in the rare case that the Content Safety Labels model failed.
     */
    @JsonProperty("status")
    public Optional<AudioIntellegenceModelStatus> getStatus() {
        return status;
    }

    @JsonProperty("results")
    public Optional<List<ContentSafetyLabelResult>> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptContentSafetyLabels && equalTo((TranscriptContentSafetyLabels) other);
    }

    private boolean equalTo(TranscriptContentSafetyLabels other) {
        return status.equals(other.status) && results.equals(other.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.results);
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
        private Optional<AudioIntellegenceModelStatus> status = Optional.empty();

        private Optional<List<ContentSafetyLabelResult>> results = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptContentSafetyLabels other) {
            status(other.getStatus());
            results(other.getResults());
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<AudioIntellegenceModelStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(AudioIntellegenceModelStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "results", nulls = Nulls.SKIP)
        public Builder results(Optional<List<ContentSafetyLabelResult>> results) {
            this.results = results;
            return this;
        }

        public Builder results(List<ContentSafetyLabelResult> results) {
            this.results = Optional.of(results);
            return this;
        }

        public TranscriptContentSafetyLabels build() {
            return new TranscriptContentSafetyLabels(status, results);
        }
    }
}
