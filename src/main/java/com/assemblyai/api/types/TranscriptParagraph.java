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
@JsonDeserialize(builder = TranscriptParagraph.Builder.class)
public final class TranscriptParagraph {
    private final Optional<String> text;

    private final Optional<Integer> start;

    private final Optional<Integer> end;

    private final Optional<Double> confidence;

    private final Optional<List<TranscriptWord>> words;

    private TranscriptParagraph(
            Optional<String> text,
            Optional<Integer> start,
            Optional<Integer> end,
            Optional<Double> confidence,
            Optional<List<TranscriptWord>> words) {
        this.text = text;
        this.start = start;
        this.end = end;
        this.confidence = confidence;
        this.words = words;
    }

    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    @JsonProperty("start")
    public Optional<Integer> getStart() {
        return start;
    }

    @JsonProperty("end")
    public Optional<Integer> getEnd() {
        return end;
    }

    @JsonProperty("confidence")
    public Optional<Double> getConfidence() {
        return confidence;
    }

    @JsonProperty("words")
    public Optional<List<TranscriptWord>> getWords() {
        return words;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptParagraph && equalTo((TranscriptParagraph) other);
    }

    private boolean equalTo(TranscriptParagraph other) {
        return text.equals(other.text)
                && start.equals(other.start)
                && end.equals(other.end)
                && confidence.equals(other.confidence)
                && words.equals(other.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.start, this.end, this.confidence, this.words);
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

        private Optional<Integer> start = Optional.empty();

        private Optional<Integer> end = Optional.empty();

        private Optional<Double> confidence = Optional.empty();

        private Optional<List<TranscriptWord>> words = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptParagraph other) {
            text(other.getText());
            start(other.getStart());
            end(other.getEnd());
            confidence(other.getConfidence());
            words(other.getWords());
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

        @JsonSetter(value = "start", nulls = Nulls.SKIP)
        public Builder start(Optional<Integer> start) {
            this.start = start;
            return this;
        }

        public Builder start(Integer start) {
            this.start = Optional.of(start);
            return this;
        }

        @JsonSetter(value = "end", nulls = Nulls.SKIP)
        public Builder end(Optional<Integer> end) {
            this.end = end;
            return this;
        }

        public Builder end(Integer end) {
            this.end = Optional.of(end);
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

        @JsonSetter(value = "words", nulls = Nulls.SKIP)
        public Builder words(Optional<List<TranscriptWord>> words) {
            this.words = words;
            return this;
        }

        public Builder words(List<TranscriptWord> words) {
            this.words = Optional.of(words);
            return this;
        }

        public TranscriptParagraph build() {
            return new TranscriptParagraph(text, start, end, confidence, words);
        }
    }
}
