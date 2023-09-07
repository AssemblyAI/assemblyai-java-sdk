package com.assemblyai.api.resources.lemur.requests;

import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.types.LemurModels;
import com.assemblyai.api.types.LemurQuestionAnswerParametersQuestionsItem;
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
public final class LemurQuestionAnswerParameters {
    private final List<String> transcriptIds;

    private final List<LemurQuestionAnswerParametersQuestionsItem> questions;

    private final Optional<Object> context;

    private final Optional<String> answerFormat;

    private final Optional<LemurModels> finalModel;

    private final Optional<Double> maxOutputSize;

    private LemurQuestionAnswerParameters(
            List<String> transcriptIds,
            List<LemurQuestionAnswerParametersQuestionsItem> questions,
            Optional<Object> context,
            Optional<String> answerFormat,
            Optional<LemurModels> finalModel,
            Optional<Double> maxOutputSize) {
        this.transcriptIds = transcriptIds;
        this.questions = questions;
        this.context = context;
        this.answerFormat = answerFormat;
        this.finalModel = finalModel;
        this.maxOutputSize = maxOutputSize;
    }

    /**
     * @return A list of completed transcripts with text. Up to 100 files max, or 100 hours max. Whichever is lower.
     */
    @JsonProperty("transcript_ids")
    public List<String> getTranscriptIds() {
        return transcriptIds;
    }

    /**
     * @return A list of questions to ask.
     */
    @JsonProperty("questions")
    public List<LemurQuestionAnswerParametersQuestionsItem> getQuestions() {
        return questions;
    }

    @JsonProperty("context")
    public Optional<Object> getContext() {
        return context;
    }

    /**
     * @return How you want the summary to be returned. This can be any text. Examples: &quot;TLDR&quot;, &quot;bullet points&quot;
     */
    @JsonProperty("answer_format")
    public Optional<String> getAnswerFormat() {
        return answerFormat;
    }

    @JsonProperty("final_model")
    public Optional<LemurModels> getFinalModel() {
        return finalModel;
    }

    /**
     * @return Max output size in tokens. Up to 4000 allowed.
     */
    @JsonProperty("max_output_size")
    public Optional<Double> getMaxOutputSize() {
        return maxOutputSize;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LemurQuestionAnswerParameters && equalTo((LemurQuestionAnswerParameters) other);
    }

    private boolean equalTo(LemurQuestionAnswerParameters other) {
        return transcriptIds.equals(other.transcriptIds)
                && questions.equals(other.questions)
                && context.equals(other.context)
                && answerFormat.equals(other.answerFormat)
                && finalModel.equals(other.finalModel)
                && maxOutputSize.equals(other.maxOutputSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.transcriptIds,
                this.questions,
                this.context,
                this.answerFormat,
                this.finalModel,
                this.maxOutputSize);
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

        private List<LemurQuestionAnswerParametersQuestionsItem> questions = new ArrayList<>();

        private Optional<Object> context = Optional.empty();

        private Optional<String> answerFormat = Optional.empty();

        private Optional<LemurModels> finalModel = Optional.empty();

        private Optional<Double> maxOutputSize = Optional.empty();

        private Builder() {}

        public Builder from(LemurQuestionAnswerParameters other) {
            transcriptIds(other.getTranscriptIds());
            questions(other.getQuestions());
            context(other.getContext());
            answerFormat(other.getAnswerFormat());
            finalModel(other.getFinalModel());
            maxOutputSize(other.getMaxOutputSize());
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

        @JsonSetter(value = "questions", nulls = Nulls.SKIP)
        public Builder questions(List<LemurQuestionAnswerParametersQuestionsItem> questions) {
            this.questions.clear();
            this.questions.addAll(questions);
            return this;
        }

        public Builder addQuestions(LemurQuestionAnswerParametersQuestionsItem questions) {
            this.questions.add(questions);
            return this;
        }

        public Builder addAllQuestions(List<LemurQuestionAnswerParametersQuestionsItem> questions) {
            this.questions.addAll(questions);
            return this;
        }

        @JsonSetter(value = "context", nulls = Nulls.SKIP)
        public Builder context(Optional<Object> context) {
            this.context = context;
            return this;
        }

        public Builder context(Object context) {
            this.context = Optional.of(context);
            return this;
        }

        @JsonSetter(value = "answer_format", nulls = Nulls.SKIP)
        public Builder answerFormat(Optional<String> answerFormat) {
            this.answerFormat = answerFormat;
            return this;
        }

        public Builder answerFormat(String answerFormat) {
            this.answerFormat = Optional.of(answerFormat);
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
        public Builder maxOutputSize(Optional<Double> maxOutputSize) {
            this.maxOutputSize = maxOutputSize;
            return this;
        }

        public Builder maxOutputSize(Double maxOutputSize) {
            this.maxOutputSize = Optional.of(maxOutputSize);
            return this;
        }

        public LemurQuestionAnswerParameters build() {
            return new LemurQuestionAnswerParameters(
                    transcriptIds, questions, context, answerFormat, finalModel, maxOutputSize);
        }
    }
}
