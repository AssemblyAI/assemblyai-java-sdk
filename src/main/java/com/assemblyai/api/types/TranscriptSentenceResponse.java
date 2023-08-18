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
@JsonDeserialize(builder = TranscriptSentenceResponse.Builder.class)
public final class TranscriptSentenceResponse {
    private final Optional<String> id;

    private final Optional<Double> confidence;

    private final Optional<Double> audioDuration;

    private final Optional<List<TranscriptSentence>> sentences;

    private TranscriptSentenceResponse(
            Optional<String> id,
            Optional<Double> confidence,
            Optional<Double> audioDuration,
            Optional<List<TranscriptSentence>> sentences) {
        this.id = id;
        this.confidence = confidence;
        this.audioDuration = audioDuration;
        this.sentences = sentences;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("confidence")
    public Optional<Double> getConfidence() {
        return confidence;
    }

    @JsonProperty("audio_duration")
    public Optional<Double> getAudioDuration() {
        return audioDuration;
    }

    @JsonProperty("sentences")
    public Optional<List<TranscriptSentence>> getSentences() {
        return sentences;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptSentenceResponse && equalTo((TranscriptSentenceResponse) other);
    }

    private boolean equalTo(TranscriptSentenceResponse other) {
        return id.equals(other.id)
                && confidence.equals(other.confidence)
                && audioDuration.equals(other.audioDuration)
                && sentences.equals(other.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.confidence, this.audioDuration, this.sentences);
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
        private Optional<String> id = Optional.empty();

        private Optional<Double> confidence = Optional.empty();

        private Optional<Double> audioDuration = Optional.empty();

        private Optional<List<TranscriptSentence>> sentences = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptSentenceResponse other) {
            id(other.getId());
            confidence(other.getConfidence());
            audioDuration(other.getAudioDuration());
            sentences(other.getSentences());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
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

        @JsonSetter(value = "audio_duration", nulls = Nulls.SKIP)
        public Builder audioDuration(Optional<Double> audioDuration) {
            this.audioDuration = audioDuration;
            return this;
        }

        public Builder audioDuration(Double audioDuration) {
            this.audioDuration = Optional.of(audioDuration);
            return this;
        }

        @JsonSetter(value = "sentences", nulls = Nulls.SKIP)
        public Builder sentences(Optional<List<TranscriptSentence>> sentences) {
            this.sentences = sentences;
            return this;
        }

        public Builder sentences(List<TranscriptSentence> sentences) {
            this.sentences = Optional.of(sentences);
            return this;
        }

        public TranscriptSentenceResponse build() {
            return new TranscriptSentenceResponse(id, confidence, audioDuration, sentences);
        }
    }
}
