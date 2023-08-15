package com.assemblyai.api.resources.transcript.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TranscriptSearchRequest.Builder.class)
public final class TranscriptSearchRequest {
    private final Optional<String> words;

    private TranscriptSearchRequest(Optional<String> words) {
        this.words = words;
    }

    /**
     * @return To control the maximum number of characters per caption
     */
    @JsonProperty("words")
    public Optional<String> getWords() {
        return words;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptSearchRequest && equalTo((TranscriptSearchRequest) other);
    }

    private boolean equalTo(TranscriptSearchRequest other) {
        return words.equals(other.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.words);
    }

    @Override
    public String toString() {
        return "TranscriptSearchRequest{" + "words: " + words + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> words = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptSearchRequest other) {
            words(other.getWords());
            return this;
        }

        @JsonSetter(value = "words", nulls = Nulls.SKIP)
        public Builder words(Optional<String> words) {
            this.words = words;
            return this;
        }

        public Builder words(String words) {
            this.words = Optional.of(words);
            return this;
        }

        public TranscriptSearchRequest build() {
            return new TranscriptSearchRequest(words);
        }
    }
}
