package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FinalTranscript.Builder.class)
public final class FinalTranscript {
    private final Optional<Boolean> punctuated;

    private final Optional<Boolean> textFormatted;

    private final Optional<Integer> audioStart;

    private final Optional<Integer> audioEnd;

    private final Optional<Double> confidence;

    private final Optional<String> text;

    private final Optional<List<Word>> words;

    private final Optional<OffsetDateTime> created;

    private FinalTranscript(
            Optional<Boolean> punctuated,
            Optional<Boolean> textFormatted,
            Optional<Integer> audioStart,
            Optional<Integer> audioEnd,
            Optional<Double> confidence,
            Optional<String> text,
            Optional<List<Word>> words,
            Optional<OffsetDateTime> created) {
        this.punctuated = punctuated;
        this.textFormatted = textFormatted;
        this.audioStart = audioStart;
        this.audioEnd = audioEnd;
        this.confidence = confidence;
        this.text = text;
        this.words = words;
        this.created = created;
    }

    /**
     * @return Whether the text has been punctuated and cased.
     */
    @JsonProperty("punctuated")
    public Optional<Boolean> getPunctuated() {
        return punctuated;
    }

    /**
     * @return Whether the text has been formatted (e.g. Dollar -&gt; $)
     */
    @JsonProperty("text_formatted")
    public Optional<Boolean> getTextFormatted() {
        return textFormatted;
    }

    /**
     * @return Start time of audio sample relative to session start, in milliseconds.
     */
    @JsonProperty("audio_start")
    public Optional<Integer> getAudioStart() {
        return audioStart;
    }

    /**
     * @return End time of audio sample relative to session start, in milliseconds.
     */
    @JsonProperty("audio_end")
    public Optional<Integer> getAudioEnd() {
        return audioEnd;
    }

    /**
     * @return The confidence score of the entire transcription, between 0 and 1.
     */
    @JsonProperty("confidence")
    public Optional<Double> getConfidence() {
        return confidence;
    }

    /**
     * @return The partial transcript for your audio.
     */
    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    /**
     * @return An array of objects, with the information for each word in the transcription text. Includes the start/end time (in milliseconds) of the word, the confidence score of the word, and the text (i.e. the word itself).
     */
    @JsonProperty("words")
    public Optional<List<Word>> getWords() {
        return words;
    }

    /**
     * @return The timestamp for the partial transcript.
     */
    @JsonProperty("created")
    public Optional<OffsetDateTime> getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FinalTranscript && equalTo((FinalTranscript) other);
    }

    private boolean equalTo(FinalTranscript other) {
        return punctuated.equals(other.punctuated)
                && textFormatted.equals(other.textFormatted)
                && audioStart.equals(other.audioStart)
                && audioEnd.equals(other.audioEnd)
                && confidence.equals(other.confidence)
                && text.equals(other.text)
                && words.equals(other.words)
                && created.equals(other.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.punctuated,
                this.textFormatted,
                this.audioStart,
                this.audioEnd,
                this.confidence,
                this.text,
                this.words,
                this.created);
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
        private Optional<Boolean> punctuated = Optional.empty();

        private Optional<Boolean> textFormatted = Optional.empty();

        private Optional<Integer> audioStart = Optional.empty();

        private Optional<Integer> audioEnd = Optional.empty();

        private Optional<Double> confidence = Optional.empty();

        private Optional<String> text = Optional.empty();

        private Optional<List<Word>> words = Optional.empty();

        private Optional<OffsetDateTime> created = Optional.empty();

        private Builder() {}

        public Builder from(FinalTranscript other) {
            punctuated(other.getPunctuated());
            textFormatted(other.getTextFormatted());
            audioStart(other.getAudioStart());
            audioEnd(other.getAudioEnd());
            confidence(other.getConfidence());
            text(other.getText());
            words(other.getWords());
            created(other.getCreated());
            return this;
        }

        @JsonSetter(value = "punctuated", nulls = Nulls.SKIP)
        public Builder punctuated(Optional<Boolean> punctuated) {
            this.punctuated = punctuated;
            return this;
        }

        public Builder punctuated(Boolean punctuated) {
            this.punctuated = Optional.of(punctuated);
            return this;
        }

        @JsonSetter(value = "text_formatted", nulls = Nulls.SKIP)
        public Builder textFormatted(Optional<Boolean> textFormatted) {
            this.textFormatted = textFormatted;
            return this;
        }

        public Builder textFormatted(Boolean textFormatted) {
            this.textFormatted = Optional.of(textFormatted);
            return this;
        }

        @JsonSetter(value = "audio_start", nulls = Nulls.SKIP)
        public Builder audioStart(Optional<Integer> audioStart) {
            this.audioStart = audioStart;
            return this;
        }

        public Builder audioStart(Integer audioStart) {
            this.audioStart = Optional.of(audioStart);
            return this;
        }

        @JsonSetter(value = "audio_end", nulls = Nulls.SKIP)
        public Builder audioEnd(Optional<Integer> audioEnd) {
            this.audioEnd = audioEnd;
            return this;
        }

        public Builder audioEnd(Integer audioEnd) {
            this.audioEnd = Optional.of(audioEnd);
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

        @JsonSetter(value = "words", nulls = Nulls.SKIP)
        public Builder words(Optional<List<Word>> words) {
            this.words = words;
            return this;
        }

        public Builder words(List<Word> words) {
            this.words = Optional.of(words);
            return this;
        }

        @JsonSetter(value = "created", nulls = Nulls.SKIP)
        public Builder created(Optional<OffsetDateTime> created) {
            this.created = created;
            return this;
        }

        public Builder created(OffsetDateTime created) {
            this.created = Optional.of(created);
            return this;
        }

        public FinalTranscript build() {
            return new FinalTranscript(
                    punctuated, textFormatted, audioStart, audioEnd, confidence, text, words, created);
        }
    }
}
