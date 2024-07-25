/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.transcripts.types;

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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TopicDetectionResultLabelsItem.Builder.class)
public final class TopicDetectionResultLabelsItem {
    private final double relevance;

    private final String label;

    private final Map<String, Object> additionalProperties;

    private TopicDetectionResultLabelsItem(double relevance, String label, Map<String, Object> additionalProperties) {
        this.relevance = relevance;
        this.label = label;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return How relevant the detected topic is of a detected topic
     */
    @JsonProperty("relevance")
    public double getRelevance() {
        return relevance;
    }

    /**
     * @return The IAB taxonomical label for the label of the detected topic, where &gt; denotes supertopic/subtopic relationship
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TopicDetectionResultLabelsItem && equalTo((TopicDetectionResultLabelsItem) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TopicDetectionResultLabelsItem other) {
        return relevance == other.relevance && label.equals(other.label);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.relevance, this.label);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RelevanceStage builder() {
        return new Builder();
    }

    public interface RelevanceStage {
        LabelStage relevance(double relevance);

        Builder from(TopicDetectionResultLabelsItem other);
    }

    public interface LabelStage {
        _FinalStage label(String label);
    }

    public interface _FinalStage {
        TopicDetectionResultLabelsItem build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements RelevanceStage, LabelStage, _FinalStage {
        private double relevance;

        private String label;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(TopicDetectionResultLabelsItem other) {
            relevance(other.getRelevance());
            label(other.getLabel());
            return this;
        }

        /**
         * <p>How relevant the detected topic is of a detected topic</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("relevance")
        public LabelStage relevance(double relevance) {
            this.relevance = relevance;
            return this;
        }

        /**
         * <p>The IAB taxonomical label for the label of the detected topic, where &gt; denotes supertopic/subtopic relationship</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("label")
        public _FinalStage label(String label) {
            this.label = label;
            return this;
        }

        @java.lang.Override
        public TopicDetectionResultLabelsItem build() {
            return new TopicDetectionResultLabelsItem(relevance, label, additionalProperties);
        }
    }
}
