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
@JsonDeserialize(builder = TopicDetectionResultLabelsItem.Builder.class)
public final class TopicDetectionResultLabelsItem {
    private final Optional<Double> relevance;

    private final Optional<String> label;

    private TopicDetectionResultLabelsItem(Optional<Double> relevance, Optional<String> label) {
        this.relevance = relevance;
        this.label = label;
    }

    /**
     * @return How relevant the detected topic is of a detected topic
     */
    @JsonProperty("relevance")
    public Optional<Double> getRelevance() {
        return relevance;
    }

    /**
     * @return The IAB taxonomical label for the label of the detected topic, where &gt; denotes supertopic/subtopic relationship
     */
    @JsonProperty("label")
    public Optional<String> getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TopicDetectionResultLabelsItem && equalTo((TopicDetectionResultLabelsItem) other);
    }

    private boolean equalTo(TopicDetectionResultLabelsItem other) {
        return relevance.equals(other.relevance) && label.equals(other.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.relevance, this.label);
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
        private Optional<Double> relevance = Optional.empty();

        private Optional<String> label = Optional.empty();

        private Builder() {}

        public Builder from(TopicDetectionResultLabelsItem other) {
            relevance(other.getRelevance());
            label(other.getLabel());
            return this;
        }

        @JsonSetter(value = "relevance", nulls = Nulls.SKIP)
        public Builder relevance(Optional<Double> relevance) {
            this.relevance = relevance;
            return this;
        }

        public Builder relevance(Double relevance) {
            this.relevance = Optional.of(relevance);
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

        public TopicDetectionResultLabelsItem build() {
            return new TopicDetectionResultLabelsItem(relevance, label);
        }
    }
}
