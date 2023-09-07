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
@JsonDeserialize(builder = Word.Builder.class)
public final class Word {
    private final Optional<Integer> start;

    private final Optional<Integer> end;

    private final Optional<Double> confidence;

    private final Optional<String> text;

    private Word(Optional<Integer> start, Optional<Integer> end, Optional<Double> confidence, Optional<String> text) {
        this.start = start;
        this.end = end;
        this.confidence = confidence;
        this.text = text;
    }

    /**
     * @return Start time of the word in milliseconds
     */
    @JsonProperty("start")
    public Optional<Integer> getStart() {
        return start;
    }

    /**
     * @return End time of the word in milliseconds
     */
    @JsonProperty("end")
    public Optional<Integer> getEnd() {
        return end;
    }

    /**
     * @return Confidence score of the word
     */
    @JsonProperty("confidence")
    public Optional<Double> getConfidence() {
        return confidence;
    }

    /**
     * @return The word itself
     */
    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Word && equalTo((Word) other);
    }

    private boolean equalTo(Word other) {
        return start.equals(other.start)
                && end.equals(other.end)
                && confidence.equals(other.confidence)
                && text.equals(other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.start, this.end, this.confidence, this.text);
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
        private Optional<Integer> start = Optional.empty();

        private Optional<Integer> end = Optional.empty();

        private Optional<Double> confidence = Optional.empty();

        private Optional<String> text = Optional.empty();

        private Builder() {}

        public Builder from(Word other) {
            start(other.getStart());
            end(other.getEnd());
            confidence(other.getConfidence());
            text(other.getText());
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

        @JsonSetter(value = "text", nulls = Nulls.SKIP)
        public Builder text(Optional<String> text) {
            this.text = text;
            return this;
        }

        public Builder text(String text) {
            this.text = Optional.of(text);
            return this;
        }

        public Word build() {
            return new Word(start, end, confidence, text);
        }
    }
}
