/**
 * This file was auto-generated by Fern from our API Definition.
 */
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
@JsonDeserialize(builder = TranscriptWord.Builder.class)
public final class TranscriptWord {
    private final double confidence;

    private final int start;

    private final int end;

    private final String text;

    private final Optional<String> speaker;

    private TranscriptWord(double confidence, int start, int end, String text, Optional<String> speaker) {
        this.confidence = confidence;
        this.start = start;
        this.end = end;
        this.text = text;
        this.speaker = speaker;
    }

    @JsonProperty("confidence")
    public double getConfidence() {
        return confidence;
    }

    @JsonProperty("start")
    public int getStart() {
        return start;
    }

    @JsonProperty("end")
    public int getEnd() {
        return end;
    }

    @JsonProperty("text")
    public String getText() {
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
        return confidence == other.confidence
                && start == other.start
                && end == other.end
                && text.equals(other.text)
                && speaker.equals(other.speaker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.confidence, this.start, this.end, this.text, this.speaker);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ConfidenceStage builder() {
        return new Builder();
    }

    public interface ConfidenceStage {
        StartStage confidence(double confidence);

        Builder from(TranscriptWord other);
    }

    public interface StartStage {
        EndStage start(int start);
    }

    public interface EndStage {
        TextStage end(int end);
    }

    public interface TextStage {
        _FinalStage text(String text);
    }

    public interface _FinalStage {
        TranscriptWord build();

        _FinalStage speaker(Optional<String> speaker);

        _FinalStage speaker(String speaker);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ConfidenceStage, StartStage, EndStage, TextStage, _FinalStage {
        private double confidence;

        private int start;

        private int end;

        private String text;

        private Optional<String> speaker = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(TranscriptWord other) {
            confidence(other.getConfidence());
            start(other.getStart());
            end(other.getEnd());
            text(other.getText());
            speaker(other.getSpeaker());
            return this;
        }

        @Override
        @JsonSetter("confidence")
        public StartStage confidence(double confidence) {
            this.confidence = confidence;
            return this;
        }

        @Override
        @JsonSetter("start")
        public EndStage start(int start) {
            this.start = start;
            return this;
        }

        @Override
        @JsonSetter("end")
        public TextStage end(int end) {
            this.end = end;
            return this;
        }

        @Override
        @JsonSetter("text")
        public _FinalStage text(String text) {
            this.text = text;
            return this;
        }

        @Override
        public _FinalStage speaker(String speaker) {
            this.speaker = Optional.of(speaker);
            return this;
        }

        @Override
        @JsonSetter(value = "speaker", nulls = Nulls.SKIP)
        public _FinalStage speaker(Optional<String> speaker) {
            this.speaker = speaker;
            return this;
        }

        @Override
        public TranscriptWord build() {
            return new TranscriptWord(confidence, start, end, text, speaker);
        }
    }
}