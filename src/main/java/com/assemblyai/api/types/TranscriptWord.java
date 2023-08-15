package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TranscriptWord.Builder.class)
public final class TranscriptWord {
    private final Optional<Double> confidence;

    private final Optional<Integer> start;

    private final Optional<Integer> end;

    private final Optional<String> text;

    private final Optional<String> speaker;

    private TranscriptWord(
            Optional<Double> confidence,
            Optional<Integer> start,
            Optional<Integer> end,
            Optional<String> text,
            Optional<String> speaker) {
        this.confidence = confidence;
        this.start = start;
        this.end = end;
        this.text = text;
        this.speaker = speaker;
    }

    @JsonProperty("confidence")
    public Optional<Double> getConfidence() {
        return confidence;
    }

    @JsonProperty("start")
    public Optional<Integer> getStart() {
        return start;
    }

    @JsonProperty("end")
    public Optional<Integer> getEnd() {
        return end;
    }

    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    @JsonProperty("speaker")
    public Optional<String> getSpeaker() {
        return speaker;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptWord && equalTo((TranscriptWord) other);
    }

    private boolean equalTo(TranscriptWord other) {
        return confidence.equals(other.confidence)
                && start.equals(other.start)
                && end.equals(other.end)
                && text.equals(other.text)
                && speaker.equals(other.speaker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.confidence, this.start, this.end, this.text, this.speaker);
    }

    @Override
    public String toString() {
        return "TranscriptWord{" + "confidence: " + confidence + ", start: " + start + ", end: " + end + ", text: "
                + text + ", speaker: " + speaker + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Double> confidence = Optional.empty();

        private Optional<Integer> start = Optional.empty();

        private Optional<Integer> end = Optional.empty();

        private Optional<String> text = Optional.empty();

        private Optional<String> speaker = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptWord other) {
            confidence(other.getConfidence());
            start(other.getStart());
            end(other.getEnd());
            text(other.getText());
            speaker(other.getSpeaker());
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

        @JsonSetter(value = "text", nulls = Nulls.SKIP)
        public Builder text(Optional<String> text) {
            this.text = text;
            return this;
        }

        public Builder text(String text) {
            this.text = Optional.of(text);
            return this;
        }

        @JsonSetter(value = "speaker", nulls = Nulls.SKIP)
        public Builder speaker(Optional<String> speaker) {
            this.speaker = speaker;
            return this;
        }

        public Builder speaker(String speaker) {
            this.speaker = Optional.of(speaker);
            return this;
        }

        public TranscriptWord build() {
            return new TranscriptWord(confidence, start, end, text, speaker);
        }
    }
}
