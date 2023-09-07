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
@JsonDeserialize(builder = ContentSafetyLabel.Builder.class)
public final class ContentSafetyLabel {
    private final Optional<String> label;

    private final Optional<Double> confidence;

    private final Optional<Double> severity;

    private ContentSafetyLabel(Optional<String> label, Optional<Double> confidence, Optional<Double> severity) {
        this.label = label;
        this.confidence = confidence;
        this.severity = severity;
    }

    /**
     * @return The label of the sensitive topic
     */
    @JsonProperty("label")
    public Optional<String> getLabel() {
        return label;
    }

    /**
     * @return The confidence score for the topic being discussed, from 0 to 1
     */
    @JsonProperty("confidence")
    public Optional<Double> getConfidence() {
        return confidence;
    }

    /**
     * @return How severely the topic is discussed in the section, from 0 to 1
     */
    @JsonProperty("severity")
    public Optional<Double> getSeverity() {
        return severity;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentSafetyLabel && equalTo((ContentSafetyLabel) other);
    }

    private boolean equalTo(ContentSafetyLabel other) {
        return label.equals(other.label) && confidence.equals(other.confidence) && severity.equals(other.severity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.label, this.confidence, this.severity);
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
        private Optional<String> label = Optional.empty();

        private Optional<Double> confidence = Optional.empty();

        private Optional<Double> severity = Optional.empty();

        private Builder() {}

        public Builder from(ContentSafetyLabel other) {
            label(other.getLabel());
            confidence(other.getConfidence());
            severity(other.getSeverity());
            return this;
        }

        @JsonSetter(value = "label", nulls = Nulls.SKIP)
        public Builder label(Optional<String> label) {
            this.label = label;
            return this;
        }

        public Builder label(String label) {
            this.label = Optional.of(label);
            return this;
        }

        @JsonSetter(value = "confidence", nulls = Nulls.SKIP)
        public Builder confidence(Optional<Double> confidence) {
            this.confidence = confidence;
            return this;
        }

        public Builder confidence(Double confidence) {
            this.confidence = Optional.of(confidence);
            return this;
        }

        @JsonSetter(value = "severity", nulls = Nulls.SKIP)
        public Builder severity(Optional<Double> severity) {
            this.severity = severity;
            return this;
        }

        public Builder severity(Double severity) {
            this.severity = Optional.of(severity);
            return this;
        }

        public ContentSafetyLabel build() {
            return new ContentSafetyLabel(label, confidence, severity);
        }
    }
}
