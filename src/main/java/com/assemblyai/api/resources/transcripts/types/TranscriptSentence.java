/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.transcripts.types;

import com.assemblyai.api.core.ObjectMappers;
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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TranscriptSentence.Builder.class)
public final class TranscriptSentence {
    private final String text;

    private final int start;

    private final int end;

    private final double confidence;

    private final List<TranscriptWord> words;

    private final Optional<String> speaker;

    private final Map<String, Object> additionalProperties;

    private TranscriptSentence(
            String text,
            int start,
            int end,
            double confidence,
            List<TranscriptWord> words,
            Optional<String> speaker,
            Map<String, Object> additionalProperties) {
        this.text = text;
        this.start = start;
        this.end = end;
        this.confidence = confidence;
        this.words = words;
        this.speaker = speaker;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("start")
    public int getStart() {
        return start;
    }

    @JsonProperty("end")
    public int getEnd() {
        return end;
    }

    @JsonProperty("confidence")
    public double getConfidence() {
        return confidence;
    }

    @JsonProperty("words")
    public List<TranscriptWord> getWords() {
        return words;
    }

    /**
     * @return The speaker of the sentence if <a href="https://www.assemblyai.com/docs/models/speaker-diarization">Speaker Diarization</a> is enabled, else null
     */
    @JsonProperty("speaker")
    public Optional<String> getSpeaker() {
        return speaker;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptSentence && equalTo((TranscriptSentence) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TranscriptSentence other) {
        return text.equals(other.text)
                && start == other.start
                && end == other.end
                && confidence == other.confidence
                && words.equals(other.words)
                && speaker.equals(other.speaker);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.text, this.start, this.end, this.confidence, this.words, this.speaker);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TextStage builder() {
        return new Builder();
    }

    public interface TextStage {
        StartStage text(String text);

        Builder from(TranscriptSentence other);
    }

    public interface StartStage {
        EndStage start(int start);
    }

    public interface EndStage {
        ConfidenceStage end(int end);
    }

    public interface ConfidenceStage {
        _FinalStage confidence(double confidence);
    }

    public interface _FinalStage {
        TranscriptSentence build();

        _FinalStage words(List<TranscriptWord> words);

        _FinalStage addWords(TranscriptWord words);

        _FinalStage addAllWords(List<TranscriptWord> words);

        _FinalStage speaker(Optional<String> speaker);

        _FinalStage speaker(String speaker);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, StartStage, EndStage, ConfidenceStage, _FinalStage {
        private String text;

        private int start;

        private int end;

        private double confidence;

        private Optional<String> speaker = Optional.empty();

        private List<TranscriptWord> words = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(TranscriptSentence other) {
            text(other.getText());
            start(other.getStart());
            end(other.getEnd());
            confidence(other.getConfidence());
            words(other.getWords());
            speaker(other.getSpeaker());
            return this;
        }

        @java.lang.Override
        @JsonSetter("text")
        public StartStage text(String text) {
            this.text = text;
            return this;
        }

        @java.lang.Override
        @JsonSetter("start")
        public EndStage start(int start) {
            this.start = start;
            return this;
        }

        @java.lang.Override
        @JsonSetter("end")
        public ConfidenceStage end(int end) {
            this.end = end;
            return this;
        }

        @java.lang.Override
        @JsonSetter("confidence")
        public _FinalStage confidence(double confidence) {
            this.confidence = confidence;
            return this;
        }

        /**
         * <p>The speaker of the sentence if <a href="https://www.assemblyai.com/docs/models/speaker-diarization">Speaker Diarization</a> is enabled, else null</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage speaker(String speaker) {
            this.speaker = Optional.ofNullable(speaker);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "speaker", nulls = Nulls.SKIP)
        public _FinalStage speaker(Optional<String> speaker) {
            this.speaker = speaker;
            return this;
        }

        @java.lang.Override
        public _FinalStage addAllWords(List<TranscriptWord> words) {
            this.words.addAll(words);
            return this;
        }

        @java.lang.Override
        public _FinalStage addWords(TranscriptWord words) {
            this.words.add(words);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "words", nulls = Nulls.SKIP)
        public _FinalStage words(List<TranscriptWord> words) {
            this.words.clear();
            this.words.addAll(words);
            return this;
        }

        @java.lang.Override
        public TranscriptSentence build() {
            return new TranscriptSentence(text, start, end, confidence, words, speaker, additionalProperties);
        }
    }
}
