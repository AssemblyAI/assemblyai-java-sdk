package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TranscriptIabCategoriesResult.Builder.class)
public final class TranscriptIabCategoriesResult {
    private final Optional<AudioIntellegenceModelStatus> status;

    private final Optional<List<TopicDetectionResult>> results;

    private final Optional<Map<String, Double>> summary;

    private TranscriptIabCategoriesResult(
            Optional<AudioIntellegenceModelStatus> status,
            Optional<List<TopicDetectionResult>> results,
            Optional<Map<String, Double>> summary) {
        this.status = status;
        this.results = results;
        this.summary = summary;
    }

    /**
     * @return Will be either success, or unavailable in the rare case that the Content Moderation model failed.
     */
    @JsonProperty("status")
    public Optional<AudioIntellegenceModelStatus> getStatus() {
        return status;
    }

    /**
     * @return An array of results for the Topic Detection model.
     */
    @JsonProperty("results")
    public Optional<List<TopicDetectionResult>> getResults() {
        return results;
    }

    /**
     * @return The overall relevance of topic to the entire audio file
     */
    @JsonProperty("summary")
    public Optional<Map<String, Double>> getSummary() {
        return summary;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptIabCategoriesResult && equalTo((TranscriptIabCategoriesResult) other);
    }

    private boolean equalTo(TranscriptIabCategoriesResult other) {
        return status.equals(other.status) && results.equals(other.results) && summary.equals(other.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.results, this.summary);
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

        private Optional<List<TopicDetectionResult>> results = Optional.empty();

        private Optional<Map<String, Double>> summary = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptIabCategoriesResult other) {
            status(other.getStatus());
            results(other.getResults());
            summary(other.getSummary());
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
        public Builder results(Optional<List<TopicDetectionResult>> results) {
            this.results = results;
            return this;
        }

        public Builder results(List<TopicDetectionResult> results) {
            this.results = Optional.of(results);
            return this;
        }

        @JsonSetter(value = "summary", nulls = Nulls.SKIP)
        public Builder summary(Optional<Map<String, Double>> summary) {
            this.summary = summary;
            return this;
        }

        public Builder summary(Map<String, Double> summary) {
            this.summary = Optional.of(summary);
            return this;
        }

        public TranscriptIabCategoriesResult build() {
            return new TranscriptIabCategoriesResult(status, results, summary);
        }
    }
}
