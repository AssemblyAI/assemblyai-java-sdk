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
@JsonDeserialize(builder = TopicDetectionResult.Builder.class)
public final class TopicDetectionResult {
    private final Optional<String> text;

    private final Optional<List<TopicDetectionResultLabelsItem>> labels;

    private final Optional<Timestamp> timestamp;

    private TopicDetectionResult(
            Optional<String> text,
            Optional<List<TopicDetectionResultLabelsItem>> labels,
            Optional<Timestamp> timestamp) {
        this.text = text;
        this.labels = labels;
        this.timestamp = timestamp;
    }

    /**
     * @return The text in the transcript in which a detected topic occurs
     */
    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    @JsonProperty("labels")
    public Optional<List<TopicDetectionResultLabelsItem>> getLabels() {
        return labels;
    }

    @JsonProperty("timestamp")
    public Optional<Timestamp> getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TopicDetectionResult && equalTo((TopicDetectionResult) other);
    }

    private boolean equalTo(TopicDetectionResult other) {
        return text.equals(other.text) && labels.equals(other.labels) && timestamp.equals(other.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.labels, this.timestamp);
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
        private Optional<String> text = Optional.empty();

        private Optional<List<TopicDetectionResultLabelsItem>> labels = Optional.empty();

        private Optional<Timestamp> timestamp = Optional.empty();

        private Builder() {}

        public Builder from(TopicDetectionResult other) {
            text(other.getText());
            labels(other.getLabels());
            timestamp(other.getTimestamp());
            return this;
        }

        @JsonSetter(value = "text", nulls = Nulls.SKIP)
        public Builder text(Optional<String> text) {
            this.text = text;
            return this;
        }

        public Builder text(String text) {
            this.text = Optional.of(text);
            return this;
        }

        @JsonSetter(value = "labels", nulls = Nulls.SKIP)
        public Builder labels(Optional<List<TopicDetectionResultLabelsItem>> labels) {
            this.labels = labels;
            return this;
        }

        public Builder labels(List<TopicDetectionResultLabelsItem> labels) {
            this.labels = Optional.of(labels);
            return this;
        }

        @JsonSetter(value = "timestamp", nulls = Nulls.SKIP)
        public Builder timestamp(Optional<Timestamp> timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder timestamp(Timestamp timestamp) {
            this.timestamp = Optional.of(timestamp);
            return this;
        }

        public TopicDetectionResult build() {
            return new TopicDetectionResult(text, labels, timestamp);
        }
    }
}
