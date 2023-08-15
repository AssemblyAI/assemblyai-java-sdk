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
@JsonDeserialize(builder = TranscriptParagraphResponse.Builder.class)
public final class TranscriptParagraphResponse {
    private final Optional<String> id;

    private final Optional<Double> confidence;

    private final Optional<Double> audioDuration;

    private final Optional<List<TranscriptParagraph>> paragraphs;

    private TranscriptParagraphResponse(
            Optional<String> id,
            Optional<Double> confidence,
            Optional<Double> audioDuration,
            Optional<List<TranscriptParagraph>> paragraphs) {
        this.id = id;
        this.confidence = confidence;
        this.audioDuration = audioDuration;
        this.paragraphs = paragraphs;
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

    @JsonProperty("paragraphs")
    public Optional<List<TranscriptParagraph>> getParagraphs() {
        return paragraphs;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptParagraphResponse && equalTo((TranscriptParagraphResponse) other);
    }

    private boolean equalTo(TranscriptParagraphResponse other) {
        return id.equals(other.id)
                && confidence.equals(other.confidence)
                && audioDuration.equals(other.audioDuration)
                && paragraphs.equals(other.paragraphs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.confidence, this.audioDuration, this.paragraphs);
    }

    @Override
    public String toString() {
        return "TranscriptParagraphResponse{" + "id: " + id + ", confidence: " + confidence + ", audioDuration: "
                + audioDuration + ", paragraphs: " + paragraphs + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<Double> confidence = Optional.empty();

        private Optional<Double> audioDuration = Optional.empty();

        private Optional<List<TranscriptParagraph>> paragraphs = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptParagraphResponse other) {
            id(other.getId());
            confidence(other.getConfidence());
            audioDuration(other.getAudioDuration());
            paragraphs(other.getParagraphs());
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

        @JsonSetter(value = "paragraphs", nulls = Nulls.SKIP)
        public Builder paragraphs(Optional<List<TranscriptParagraph>> paragraphs) {
            this.paragraphs = paragraphs;
            return this;
        }

        public Builder paragraphs(List<TranscriptParagraph> paragraphs) {
            this.paragraphs = Optional.of(paragraphs);
            return this;
        }

        public TranscriptParagraphResponse build() {
            return new TranscriptParagraphResponse(id, confidence, audioDuration, paragraphs);
        }
    }
}
