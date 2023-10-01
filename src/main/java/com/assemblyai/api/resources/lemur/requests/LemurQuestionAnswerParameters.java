/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.lemur.requests;

import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.types.ILemurBaseParameters;
import com.assemblyai.api.types.LemurBaseParametersContext;
import com.assemblyai.api.types.LemurModels;
import com.assemblyai.api.types.LemurQuestion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LemurQuestionAnswerParameters.Builder.class)
public final class LemurQuestionAnswerParameters implements ILemurBaseParameters {
    private final List<String> transcriptIds;

    private final Optional<LemurBaseParametersContext> context;

    private final Optional<LemurModels> finalModel;

    private final Optional<Integer> maxOutputSize;

    private final Optional<Double> temperature;

    private final List<LemurQuestion> questions;

    private LemurQuestionAnswerParameters(
            List<String> transcriptIds,
            Optional<LemurBaseParametersContext> context,
            Optional<LemurModels> finalModel,
            Optional<Integer> maxOutputSize,
            Optional<Double> temperature,
            List<LemurQuestion> questions) {
        this.transcriptIds = transcriptIds;
        this.context = context;
        this.finalModel = finalModel;
        this.maxOutputSize = maxOutputSize;
        this.temperature = temperature;
        this.questions = questions;
    }

    /**
     * @return A list of completed transcripts with text. Up to 100 files max, or 100 hours max. Whichever is lower.
     */
    @JsonProperty("transcript_ids")
    @Override
    public List<String> getTranscriptIds() {
        return transcriptIds;
    }

    /**
     * @return Context to provide the model. This can be a string or a free-form JSON value.
     */
    @JsonProperty("context")
    @Override
    public Optional<LemurBaseParametersContext> getContext() {
        return context;
    }

    @JsonProperty("final_model")
    @Override
    public Optional<LemurModels> getFinalModel() {
        return finalModel;
    }

    /**
     * @return Max output size in tokens. Up to 4000 allowed.
     */
    @JsonProperty("max_output_size")
    @Override
    public Optional<Integer> getMaxOutputSize() {
        return maxOutputSize;
    }

    /**
     * @return The temperature to use for the model.
     * Higher values result in answers that are more creative, lower values are more conservative.
     * Can be any value between 0.0 and 1.0 inclusive.
     */
    @JsonProperty("temperature")
    @Override
    public Optional<Double> getTemperature() {
        return temperature;
    }

    /**
     * @return A list of questions to ask.
     */
    @JsonProperty("questions")
    public List<LemurQuestion> getQuestions() {
        return questions;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LemurQuestionAnswerParameters && equalTo((LemurQuestionAnswerParameters) other);
    }

    private boolean equalTo(LemurQuestionAnswerParameters other) {
        return transcriptIds.equals(other.transcriptIds)
                && context.equals(other.context)
                && finalModel.equals(other.finalModel)
                && maxOutputSize.equals(other.maxOutputSize)
                && temperature.equals(other.temperature)
                && questions.equals(other.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.transcriptIds,
                this.context,
                this.finalModel,
                this.maxOutputSize,
                this.temperature,
                this.questions);
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
        private List<String> transcriptIds = new ArrayList<>();

        private Optional<LemurBaseParametersContext> context = Optional.empty();

        private Optional<LemurModels> finalModel = Optional.empty();

        private Optional<Integer> maxOutputSize = Optional.empty();

        private Optional<Double> temperature = Optional.empty();

        private List<LemurQuestion> questions = new ArrayList<>();

        private Builder() {}

        public Builder from(LemurQuestionAnswerParameters other) {
            transcriptIds(other.getTranscriptIds());
            context(other.getContext());
            finalModel(other.getFinalModel());
            maxOutputSize(other.getMaxOutputSize());
            temperature(other.getTemperature());
            questions(other.getQuestions());
            return this;
        }

        @JsonSetter(value = "transcript_ids", nulls = Nulls.SKIP)
        public Builder transcriptIds(List<String> transcriptIds) {
            this.transcriptIds.clear();
            this.transcriptIds.addAll(transcriptIds);
            return this;
        }

        public Builder addTranscriptIds(String transcriptIds) {
            this.transcriptIds.add(transcriptIds);
            return this;
        }

        public Builder addAllTranscriptIds(List<String> transcriptIds) {
            this.transcriptIds.addAll(transcriptIds);
            return this;
        }

        @JsonSetter(value = "context", nulls = Nulls.SKIP)
        public Builder context(Optional<LemurBaseParametersContext> context) {
            this.context = context;
            return this;
        }

        public Builder context(LemurBaseParametersContext context) {
            this.context = Optional.of(context);
            return this;
        }

        @JsonSetter(value = "final_model", nulls = Nulls.SKIP)
        public Builder finalModel(Optional<LemurModels> finalModel) {
            this.finalModel = finalModel;
            return this;
        }

        public Builder finalModel(LemurModels finalModel) {
            this.finalModel = Optional.of(finalModel);
            return this;
        }

        @JsonSetter(value = "max_output_size", nulls = Nulls.SKIP)
        public Builder maxOutputSize(Optional<Integer> maxOutputSize) {
            this.maxOutputSize = maxOutputSize;
            return this;
        }

        public Builder maxOutputSize(Integer maxOutputSize) {
            this.maxOutputSize = Optional.of(maxOutputSize);
            return this;
        }

        @JsonSetter(value = "temperature", nulls = Nulls.SKIP)
        public Builder temperature(Optional<Double> temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder temperature(Double temperature) {
            this.temperature = Optional.of(temperature);
            return this;
        }

        @JsonSetter(value = "questions", nulls = Nulls.SKIP)
        public Builder questions(List<LemurQuestion> questions) {
            this.questions.clear();
            this.questions.addAll(questions);
            return this;
        }

        public Builder addQuestions(LemurQuestion questions) {
            this.questions.add(questions);
            return this;
        }

        public Builder addAllQuestions(List<LemurQuestion> questions) {
            this.questions.addAll(questions);
            return this;
        }

        public LemurQuestionAnswerParameters build() {
            return new LemurQuestionAnswerParameters(
                    transcriptIds, context, finalModel, maxOutputSize, temperature, questions);
        }
    }
}