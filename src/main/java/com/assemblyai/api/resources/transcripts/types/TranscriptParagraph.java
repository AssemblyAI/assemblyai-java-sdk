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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TranscriptParagraph.Builder.class)
public final class TranscriptParagraph {
    private final String text;

    private final int start;

    private final int end;

    private final double confidence;

    private final List<TranscriptWord> words;

    private final Map<String, Object> additionalProperties;

    private TranscriptParagraph(
            String text,
            int start,
            int end,
            double confidence,
            List<TranscriptWord> words,
            Map<String, Object> additionalProperties) {
        this.text = text;
        this.start = start;
        this.end = end;
        this.confidence = confidence;
        this.words = words;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The transcript of the paragraph
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return The starting time, in milliseconds, of the paragraph
     */
    @JsonProperty("start")
    public int getStart() {
        return start;
    }

    /**
     * @return The ending time, in milliseconds, of the paragraph
     */
    @JsonProperty("end")
    public int getEnd() {
        return end;
    }

    /**
     * @return The confidence score for the transcript of this paragraph
     */
    @JsonProperty("confidence")
    public double getConfidence() {
        return confidence;
    }

    /**
     * @return An array of words in the paragraph
     */
    @JsonProperty("words")
    public List<TranscriptWord> getWords() {
        return words;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptParagraph && equalTo((TranscriptParagraph) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TranscriptParagraph other) {
        return text.equals(other.text)
                && start == other.start
                && end == other.end
                && confidence == other.confidence
                && words.equals(other.words);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.text, this.start, this.end, this.confidence, this.words);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TextStage builder() {
        return new Builder();
    }

    public interface TextStage {
        StartStage text(@NotNull String text);

        Builder from(TranscriptParagraph other);
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
        TranscriptParagraph build();

        _FinalStage words(List<TranscriptWord> words);

        _FinalStage addWords(TranscriptWord words);

        _FinalStage addAllWords(List<TranscriptWord> words);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, StartStage, EndStage, ConfidenceStage, _FinalStage {
        private String text;

        private int start;

        private int end;

        private double confidence;

        private List<TranscriptWord> words = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(TranscriptParagraph other) {
            text(other.getText());
            start(other.getStart());
            end(other.getEnd());
            confidence(other.getConfidence());
            words(other.getWords());
            return this;
        }

        /**
         * <p>The transcript of the paragraph</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("text")
        public StartStage text(@NotNull String text) {
            this.text = Objects.requireNonNull(text, "text must not be null");
            return this;
        }

        /**
         * <p>The starting time, in milliseconds, of the paragraph</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("start")
        public EndStage start(int start) {
            this.start = start;
            return this;
        }

        /**
         * <p>The ending time, in milliseconds, of the paragraph</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("end")
        public ConfidenceStage end(int end) {
            this.end = end;
            return this;
        }

        /**
         * <p>The confidence score for the transcript of this paragraph</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("confidence")
        public _FinalStage confidence(double confidence) {
            this.confidence = confidence;
            return this;
        }

        /**
         * <p>An array of words in the paragraph</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllWords(List<TranscriptWord> words) {
            this.words.addAll(words);
            return this;
        }

        /**
         * <p>An array of words in the paragraph</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
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
        public TranscriptParagraph build() {
            return new TranscriptParagraph(text, start, end, confidence, words, additionalProperties);
        }
    }
}
