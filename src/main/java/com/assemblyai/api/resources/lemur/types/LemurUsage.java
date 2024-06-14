/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.lemur.types;

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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LemurUsage.Builder.class)
public final class LemurUsage {
    private final int inputTokens;

    private final int outputTokens;

    private final Map<String, Object> additionalProperties;

    private LemurUsage(int inputTokens, int outputTokens, Map<String, Object> additionalProperties) {
        this.inputTokens = inputTokens;
        this.outputTokens = outputTokens;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The number of input tokens used by the model
     */
    @JsonProperty("input_tokens")
    public int getInputTokens() {
        return inputTokens;
    }

    /**
     * @return The number of output tokens generated by the model
     */
    @JsonProperty("output_tokens")
    public int getOutputTokens() {
        return outputTokens;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LemurUsage && equalTo((LemurUsage) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LemurUsage other) {
        return inputTokens == other.inputTokens && outputTokens == other.outputTokens;
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.inputTokens, this.outputTokens);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static InputTokensStage builder() {
        return new Builder();
    }

    public interface InputTokensStage {
        OutputTokensStage inputTokens(int inputTokens);

        Builder from(LemurUsage other);
    }

    public interface OutputTokensStage {
        _FinalStage outputTokens(int outputTokens);
    }

    public interface _FinalStage {
        LemurUsage build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements InputTokensStage, OutputTokensStage, _FinalStage {
        private int inputTokens;

        private int outputTokens;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(LemurUsage other) {
            inputTokens(other.getInputTokens());
            outputTokens(other.getOutputTokens());
            return this;
        }

        /**
         * <p>The number of input tokens used by the model</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("input_tokens")
        public OutputTokensStage inputTokens(int inputTokens) {
            this.inputTokens = inputTokens;
            return this;
        }

        /**
         * <p>The number of output tokens generated by the model</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("output_tokens")
        public _FinalStage outputTokens(int outputTokens) {
            this.outputTokens = outputTokens;
            return this;
        }

        @java.lang.Override
        public LemurUsage build() {
            return new LemurUsage(inputTokens, outputTokens, additionalProperties);
        }
    }
}