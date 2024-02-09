/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.lemur.requests;

import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.resources.lemur.types.ILemurBaseParams;
import com.assemblyai.api.resources.lemur.types.LemurBaseParamsContext;
import com.assemblyai.api.resources.lemur.types.LemurModel;
import com.assemblyai.api.resources.lemur.types.LemurQuestion;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LemurQuestionAnswerParams.Builder.class)
public final class LemurQuestionAnswerParams implements ILemurBaseParams {
    private final Optional<List<String>> transcriptIDs;

    private final Optional<String> inputText;

    private final Optional<LemurBaseParamsContext> context;

    private final Optional<LemurModel> finalModel;

    private final Optional<Integer> maxOutputSize;

    private final Optional<Double> temperature;

    private final List<LemurQuestion> questions;

    private final Map<String, Object> additionalProperties;

    private LemurQuestionAnswerParams(
            Optional<List<String>> transcriptIDs,
            Optional<String> inputText,
            Optional<LemurBaseParamsContext> context,
            Optional<LemurModel> finalModel,
            Optional<Integer> maxOutputSize,
            Optional<Double> temperature,
            List<LemurQuestion> questions,
            Map<String, Object> additionalProperties) {
        this.transcriptIDs = transcriptIDs;
        this.inputText = inputText;
        this.context = context;
        this.finalModel = finalModel;
        this.maxOutputSize = maxOutputSize;
        this.temperature = temperature;
        this.questions = questions;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A list of completed transcripts with text. Up to a maximum of 100 files or 100 hours, whichever is lower.
     * Use either transcript_ids or input_text as input into LeMUR.
     */
    @JsonProperty("transcript_ids")
    @Override
    public Optional<List<String>> getTranscriptIDs() {
        return transcriptIDs;
    }

    /**
     * @return Custom formatted transcript data. Maximum size is the context limit of the selected model, which defaults to 100000.
     * Use either transcript_ids or input_text as input into LeMUR.
     */
    @JsonProperty("input_text")
    @Override
    public Optional<String> getInputText() {
        return inputText;
    }

    /**
     * @return Context to provide the model. This can be a string or a free-form JSON value.
     */
    @JsonProperty("context")
    @Override
    public Optional<LemurBaseParamsContext> getContext() {
        return context;
    }

    /**
     * @return The model that is used for the final prompt after compression is performed.
     * Defaults to &quot;default&quot;.
     */
    @JsonProperty("final_model")
    @Override
    public Optional<LemurModel> getFinalModel() {
        return finalModel;
    }

    /**
     * @return Max output size in tokens, up to 4000
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
     * @return A list of questions to ask
     */
    @JsonProperty("questions")
    public List<LemurQuestion> getQuestions() {
        return questions;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LemurQuestionAnswerParams && equalTo((LemurQuestionAnswerParams) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LemurQuestionAnswerParams other) {
        return transcriptIDs.equals(other.transcriptIDs)
                && inputText.equals(other.inputText)
                && context.equals(other.context)
                && finalModel.equals(other.finalModel)
                && maxOutputSize.equals(other.maxOutputSize)
                && temperature.equals(other.temperature)
                && questions.equals(other.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.transcriptIDs,
                this.inputText,
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
        private Optional<List<String>> transcriptIDs = Optional.empty();

        private Optional<String> inputText = Optional.empty();

        private Optional<LemurBaseParamsContext> context = Optional.empty();

        private Optional<LemurModel> finalModel = Optional.empty();

        private Optional<Integer> maxOutputSize = Optional.empty();

        private Optional<Double> temperature = Optional.empty();

        private List<LemurQuestion> questions = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(LemurQuestionAnswerParams other) {
            transcriptIDs(other.getTranscriptIDs());
            inputText(other.getInputText());
            context(other.getContext());
            finalModel(other.getFinalModel());
            maxOutputSize(other.getMaxOutputSize());
            temperature(other.getTemperature());
            questions(other.getQuestions());
            return this;
        }

        @JsonSetter(value = "transcript_ids", nulls = Nulls.SKIP)
        public Builder transcriptIDs(Optional<List<String>> transcriptIDs) {
            this.transcriptIDs = transcriptIDs;
            return this;
        }

        public Builder transcriptIDs(List<String> transcriptIDs) {
            this.transcriptIDs = Optional.of(transcriptIDs);
            return this;
        }

        @JsonSetter(value = "input_text", nulls = Nulls.SKIP)
        public Builder inputText(Optional<String> inputText) {
            this.inputText = inputText;
            return this;
        }

        public Builder inputText(String inputText) {
            this.inputText = Optional.of(inputText);
            return this;
        }

        @JsonSetter(value = "context", nulls = Nulls.SKIP)
        public Builder context(Optional<LemurBaseParamsContext> context) {
            this.context = context;
            return this;
        }

        public Builder context(LemurBaseParamsContext context) {
            this.context = Optional.of(context);
            return this;
        }

        @JsonSetter(value = "final_model", nulls = Nulls.SKIP)
        public Builder finalModel(Optional<LemurModel> finalModel) {
            this.finalModel = finalModel;
            return this;
        }

        public Builder finalModel(LemurModel finalModel) {
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

        public LemurQuestionAnswerParams build() {
            return new LemurQuestionAnswerParams(
                    transcriptIDs,
                    inputText,
                    context,
                    finalModel,
                    maxOutputSize,
                    temperature,
                    questions,
                    additionalProperties);
        }
    }
}
