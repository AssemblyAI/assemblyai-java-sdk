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
@JsonDeserialize(builder = SentimentAnalysisResult.Builder.class)
public final class SentimentAnalysisResult {
    private final Optional<String> text;

    private final Optional<Integer> start;

    private final Optional<Integer> end;

    private final Optional<SentimentAnalysisResultSentiment> sentiment;

    private final Optional<Double> confidence;

    private final Optional<String> speaker;

    private SentimentAnalysisResult(
            Optional<String> text,
            Optional<Integer> start,
            Optional<Integer> end,
            Optional<SentimentAnalysisResultSentiment> sentiment,
            Optional<Double> confidence,
            Optional<String> speaker) {
        this.text = text;
        this.start = start;
        this.end = end;
        this.sentiment = sentiment;
        this.confidence = confidence;
        this.speaker = speaker;
    }

    /**
     * @return The transcript of the sentence
     */
    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    /**
     * @return The starting time, in milliseconds, of the sentence
     */
    @JsonProperty("start")
    public Optional<Integer> getStart() {
        return start;
    }

    /**
     * @return The ending time, in milliseconds, of the sentence
     */
    @JsonProperty("end")
    public Optional<Integer> getEnd() {
        return end;
    }

    /**
     * @return The detected sentiment for the sentence, one of POSITIVE, NEUTRAL, NEGATIVE
     */
    @JsonProperty("sentiment")
    public Optional<SentimentAnalysisResultSentiment> getSentiment() {
        return sentiment;
    }

    /**
     * @return The confidence score for the detected sentiment of the sentence, from 0 to 1
     */
    @JsonProperty("confidence")
    public Optional<Double> getConfidence() {
        return confidence;
    }

    /**
     * @return The speaker of the sentence if Speaker Diarization is enabled, else null
     */
    @JsonProperty("speaker")
    public Optional<String> getSpeaker() {
        return speaker;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SentimentAnalysisResult && equalTo((SentimentAnalysisResult) other);
    }

    private boolean equalTo(SentimentAnalysisResult other) {
        return text.equals(other.text)
                && start.equals(other.start)
                && end.equals(other.end)
                && sentiment.equals(other.sentiment)
                && confidence.equals(other.confidence)
                && speaker.equals(other.speaker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.start, this.end, this.sentiment, this.confidence, this.speaker);
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

        private Optional<SentimentAnalysisResultSentiment> sentiment = Optional.empty();

        private Optional<Double> confidence = Optional.empty();

        private Optional<String> speaker = Optional.empty();

        private Builder() {}

        public Builder from(SentimentAnalysisResult other) {
            text(other.getText());
            start(other.getStart());
            end(other.getEnd());
            sentiment(other.getSentiment());
            confidence(other.getConfidence());
            speaker(other.getSpeaker());
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

        @JsonSetter(value = "sentiment", nulls = Nulls.SKIP)
        public Builder sentiment(Optional<SentimentAnalysisResultSentiment> sentiment) {
            this.sentiment = sentiment;
            return this;
        }

        public Builder sentiment(SentimentAnalysisResultSentiment sentiment) {
            this.sentiment = Optional.of(sentiment);
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

        @JsonSetter(value = "speaker", nulls = Nulls.SKIP)
        public Builder speaker(Optional<String> speaker) {
            this.speaker = speaker;
            return this;
        }

        public Builder speaker(String speaker) {
            this.speaker = Optional.of(speaker);
            return this;
        }

        public SentimentAnalysisResult build() {
            return new SentimentAnalysisResult(text, start, end, sentiment, confidence, speaker);
        }
    }
}
