package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TranscriptList.Builder.class)
public final class TranscriptList {
    private final PageDetails pageDetails;

    private final List<TranscriptListItem> transcripts;

    private TranscriptList(PageDetails pageDetails, List<TranscriptListItem> transcripts) {
        this.pageDetails = pageDetails;
        this.transcripts = transcripts;
    }

    @JsonProperty("page_details")
    public PageDetails getPageDetails() {
        return pageDetails;
    }

    @JsonProperty("transcripts")
    public List<TranscriptListItem> getTranscripts() {
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

    public static PageDetailsStage builder() {
        return new Builder();
    }

    public interface PageDetailsStage {
        _FinalStage pageDetails(PageDetails pageDetails);

        Builder from(TranscriptList other);
    }

    public interface _FinalStage {
        TranscriptList build();

        _FinalStage transcripts(List<TranscriptListItem> transcripts);

        _FinalStage addTranscripts(TranscriptListItem transcripts);

        _FinalStage addAllTranscripts(List<TranscriptListItem> transcripts);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PageDetailsStage, _FinalStage {
        private PageDetails pageDetails;

        private List<TranscriptListItem> transcripts = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(TranscriptList other) {
            pageDetails(other.getPageDetails());
            transcripts(other.getTranscripts());
            return this;
        }

        @Override
        @JsonSetter("page_details")
        public _FinalStage pageDetails(PageDetails pageDetails) {
            this.pageDetails = pageDetails;
            return this;
        }

        @Override
        public _FinalStage addAllTranscripts(List<TranscriptListItem> transcripts) {
            this.transcripts.addAll(transcripts);
            return this;
        }

        @Override
        public _FinalStage addTranscripts(TranscriptListItem transcripts) {
            this.transcripts.add(transcripts);
            return this;
        }

        @Override
        @JsonSetter(value = "transcripts", nulls = Nulls.SKIP)
        public _FinalStage transcripts(List<TranscriptListItem> transcripts) {
            this.transcripts.clear();
            this.transcripts.addAll(transcripts);
            return this;
        }

        @Override
        public TranscriptList build() {
            return new TranscriptList(pageDetails, transcripts);
        }
    }
}
