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
@JsonDeserialize(builder = TranscriptList.Builder.class)
public final class TranscriptList {
    private final Optional<PageDetails> pageDetails;

    private final Optional<List<TranscriptListItem>> transcripts;

    private TranscriptList(Optional<PageDetails> pageDetails, Optional<List<TranscriptListItem>> transcripts) {
        this.pageDetails = pageDetails;
        this.transcripts = transcripts;
    }

    @JsonProperty("page_details")
    public Optional<PageDetails> getPageDetails() {
        return pageDetails;
    }

    @JsonProperty("transcripts")
    public Optional<List<TranscriptListItem>> getTranscripts() {
        return transcripts;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptList && equalTo((TranscriptList) other);
    }

    private boolean equalTo(TranscriptList other) {
        return pageDetails.equals(other.pageDetails) && transcripts.equals(other.transcripts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.pageDetails, this.transcripts);
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
        private Optional<PageDetails> pageDetails = Optional.empty();

        private Optional<List<TranscriptListItem>> transcripts = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptList other) {
            pageDetails(other.getPageDetails());
            transcripts(other.getTranscripts());
            return this;
        }

        @JsonSetter(value = "page_details", nulls = Nulls.SKIP)
        public Builder pageDetails(Optional<PageDetails> pageDetails) {
            this.pageDetails = pageDetails;
            return this;
        }

        public Builder pageDetails(PageDetails pageDetails) {
            this.pageDetails = Optional.of(pageDetails);
            return this;
        }

        @JsonSetter(value = "transcripts", nulls = Nulls.SKIP)
        public Builder transcripts(Optional<List<TranscriptListItem>> transcripts) {
            this.transcripts = transcripts;
            return this;
        }

        public Builder transcripts(List<TranscriptListItem> transcripts) {
            this.transcripts = Optional.of(transcripts);
            return this;
        }

        public TranscriptList build() {
            return new TranscriptList(pageDetails, transcripts);
        }
    }
}
