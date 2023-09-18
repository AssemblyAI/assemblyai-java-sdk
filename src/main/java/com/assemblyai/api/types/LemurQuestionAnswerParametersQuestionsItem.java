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
@JsonDeserialize(builder = LemurQuestionAnswerParametersQuestionsItem.Builder.class)
public final class LemurQuestionAnswerParametersQuestionsItem {
    private final Optional<String> question;

    private final Optional<Object> context;

    private final Optional<String> answerFormat;

    private final Optional<List<String>> answerOptions;

    private LemurQuestionAnswerParametersQuestionsItem(
            Optional<String> question,
            Optional<Object> context,
            Optional<String> answerFormat,
            Optional<List<String>> answerOptions) {
        this.question = question;
        this.context = context;
        this.answerFormat = answerFormat;
        this.answerOptions = answerOptions;
    }

    /**
     * @return The question you wish to ask. For more complex questions use default model.
     */
    @JsonProperty("question")
    public Optional<String> getQuestion() {
        return question;
    }

    @JsonProperty("context")
    public Optional<Object> getContext() {
        return context;
    }

    /**
     * @return How you want the answer to be returned. This can be any text. Can't be used with answer_options. Examples: &quot;short sentence&quot;, &quot;bullet points&quot;
     */
    @JsonProperty("answer_format")
    public Optional<String> getAnswerFormat() {
        return answerFormat;
    }

    /**
     * @return What discrete options to return. Useful for precise responses. Can't be used with answer_format. Example: [&quot;Yes&quot;, &quot;No&quot;]
     */
    @JsonProperty("answer_options")
    public Optional<List<String>> getAnswerOptions() {
        return answerOptions;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LemurQuestionAnswerParametersQuestionsItem
                && equalTo((LemurQuestionAnswerParametersQuestionsItem) other);
    }

    private boolean equalTo(LemurQuestionAnswerParametersQuestionsItem other) {
        return question.equals(other.question)
                && context.equals(other.context)
                && answerFormat.equals(other.answerFormat)
                && answerOptions.equals(other.answerOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.question, this.context, this.answerFormat, this.answerOptions);
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
        private Optional<String> question = Optional.empty();

        private Optional<Object> context = Optional.empty();

        private Optional<String> answerFormat = Optional.empty();

        private Optional<List<String>> answerOptions = Optional.empty();

        private Builder() {}

        public Builder from(LemurQuestionAnswerParametersQuestionsItem other) {
            question(other.getQuestion());
            context(other.getContext());
            answerFormat(other.getAnswerFormat());
            answerOptions(other.getAnswerOptions());
            return this;
        }

        @JsonSetter(value = "question", nulls = Nulls.SKIP)
        public Builder question(Optional<String> question) {
            this.question = question;
            return this;
        }

        public Builder question(String question) {
            this.question = Optional.of(question);
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

        @JsonSetter(value = "answer_options", nulls = Nulls.SKIP)
        public Builder answerOptions(Optional<List<String>> answerOptions) {
            this.answerOptions = answerOptions;
            return this;
        }

        public Builder answerOptions(List<String> answerOptions) {
            this.answerOptions = Optional.of(answerOptions);
            return this;
        }

        public LemurQuestionAnswerParametersQuestionsItem build() {
            return new LemurQuestionAnswerParametersQuestionsItem(question, context, answerFormat, answerOptions);
        }
    }
}
