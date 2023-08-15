package com.assemblyai.api.types;

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
@JsonDeserialize(builder = TranscriptUtterance.Builder.class)
public final class TranscriptUtterance {
    private final Optional<String> channel;

    private final Optional<Double> confidence;

    private final Optional<Integer> start;

    private final Optional<Integer> end;

    private final Optional<String> text;

    private final Optional<List<TranscriptWord>> words;

    private TranscriptUtterance(
            Optional<String> channel,
            Optional<Double> confidence,
            Optional<Integer> start,
            Optional<Integer> end,
            Optional<String> text,
            Optional<List<TranscriptWord>> words) {
        this.channel = channel;
        this.confidence = confidence;
        this.start = start;
        this.end = end;
        this.text = text;
        this.words = words;
    }

    @JsonProperty("channel")
    public Optional<String> getChannel() {
        return channel;
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

    @JsonProperty("words")
    public Optional<List<TranscriptWord>> getWords() {
        return words;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptUtterance && equalTo((TranscriptUtterance) other);
    }

    private boolean equalTo(TranscriptUtterance other) {
        return channel.equals(other.channel)
                && confidence.equals(other.confidence)
                && start.equals(other.start)
                && end.equals(other.end)
                && text.equals(other.text)
                && words.equals(other.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.channel, this.confidence, this.start, this.end, this.text, this.words);
    }

    @Override
    public String toString() {
        return "TranscriptUtterance{" + "channel: " + channel + ", confidence: " + confidence + ", start: " + start
                + ", end: " + end + ", text: " + text + ", words: " + words + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> channel = Optional.empty();

        private Optional<Double> confidence = Optional.empty();

        private Optional<Integer> start = Optional.empty();

        private Optional<Integer> end = Optional.empty();

        private Optional<String> text = Optional.empty();

        private Optional<List<TranscriptWord>> words = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptUtterance other) {
            channel(other.getChannel());
            confidence(other.getConfidence());
            start(other.getStart());
            end(other.getEnd());
            text(other.getText());
            words(other.getWords());
            return this;
        }

        @JsonSetter(value = "channel", nulls = Nulls.SKIP)
        public Builder channel(Optional<String> channel) {
            this.channel = channel;
            return this;
        }

        public Builder channel(String channel) {
            this.channel = Optional.of(channel);
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

        @JsonSetter(value = "words", nulls = Nulls.SKIP)
        public Builder words(Optional<List<TranscriptWord>> words) {
            this.words = words;
            return this;
        }

        public Builder words(List<TranscriptWord> words) {
            this.words = Optional.of(words);
            return this;
        }

        public TranscriptUtterance build() {
            return new TranscriptUtterance(channel, confidence, start, end, text, words);
        }
    }
}
