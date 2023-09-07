package com.assemblyai.api.resources.transcript.requests;

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
@JsonDeserialize(builder = TranscriptExportAsSrtRequest.Builder.class)
public final class TranscriptExportAsSrtRequest {
    private final Optional<Integer> charsPerCaption;

    private TranscriptExportAsSrtRequest(Optional<Integer> charsPerCaption) {
        this.charsPerCaption = charsPerCaption;
    }

    /**
     * @return The maximum number of characters per caption
     */
    @JsonProperty("chars_per_caption")
    public Optional<Integer> getCharsPerCaption() {
        return charsPerCaption;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptExportAsSrtRequest && equalTo((TranscriptExportAsSrtRequest) other);
    }

    private boolean equalTo(TranscriptExportAsSrtRequest other) {
        return charsPerCaption.equals(other.charsPerCaption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.charsPerCaption);
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
        private Optional<Integer> charsPerCaption = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptExportAsSrtRequest other) {
            charsPerCaption(other.getCharsPerCaption());
            return this;
        }

        @JsonSetter(value = "chars_per_caption", nulls = Nulls.SKIP)
        public Builder charsPerCaption(Optional<Integer> charsPerCaption) {
            this.charsPerCaption = charsPerCaption;
            return this;
        }

        public Builder charsPerCaption(Integer charsPerCaption) {
            this.charsPerCaption = Optional.of(charsPerCaption);
            return this;
        }

        public TranscriptExportAsSrtRequest build() {
            return new TranscriptExportAsSrtRequest(charsPerCaption);
        }
    }
}
