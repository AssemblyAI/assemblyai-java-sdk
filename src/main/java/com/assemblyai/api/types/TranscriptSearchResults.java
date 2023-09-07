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
@JsonDeserialize(builder = TranscriptSearchResults.Builder.class)
public final class TranscriptSearchResults {
    private final String id;

    private final int totalCount;

    private final List<TranscriptSearchMatch> matches;

    private TranscriptSearchResults(String id, int totalCount, List<TranscriptSearchMatch> matches) {
        this.id = id;
        this.totalCount = totalCount;
        this.matches = matches;
    }

    /**
     * @return The ID of the transcript
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The total count of all matched instances. For e.g., word 1 matched 2 times, and word 2 matched 3 times, <code>total_count</code> will equal 5.
     */
    @JsonProperty("total_count")
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @return The matches of the search
     */
    @JsonProperty("matches")
    public List<TranscriptSearchMatch> getMatches() {
        return matches;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptSearchResults && equalTo((TranscriptSearchResults) other);
    }

    private boolean equalTo(TranscriptSearchResults other) {
        return id.equals(other.id) && totalCount == other.totalCount && matches.equals(other.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.totalCount, this.matches);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        TotalCountStage id(String id);

        Builder from(TranscriptSearchResults other);
    }

    public interface TotalCountStage {
        _FinalStage totalCount(int totalCount);
    }

    public interface _FinalStage {
        TranscriptSearchResults build();

        _FinalStage matches(List<TranscriptSearchMatch> matches);

        _FinalStage addMatches(TranscriptSearchMatch matches);

        _FinalStage addAllMatches(List<TranscriptSearchMatch> matches);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, TotalCountStage, _FinalStage {
        private String id;

        private int totalCount;

        private List<TranscriptSearchMatch> matches = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(TranscriptSearchResults other) {
            id(other.getId());
            totalCount(other.getTotalCount());
            matches(other.getMatches());
            return this;
        }

        /**
         * <p>The ID of the transcript</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public TotalCountStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The total count of all matched instances. For e.g., word 1 matched 2 times, and word 2 matched 3 times, <code>total_count</code> will equal 5.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("total_count")
        public _FinalStage totalCount(int totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        /**
         * <p>The matches of the search</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllMatches(List<TranscriptSearchMatch> matches) {
            this.matches.addAll(matches);
            return this;
        }

        /**
         * <p>The matches of the search</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addMatches(TranscriptSearchMatch matches) {
            this.matches.add(matches);
            return this;
        }

        @Override
        @JsonSetter(value = "matches", nulls = Nulls.SKIP)
        public _FinalStage matches(List<TranscriptSearchMatch> matches) {
            this.matches.clear();
            this.matches.addAll(matches);
            return this;
        }

        @Override
        public TranscriptSearchResults build() {
            return new TranscriptSearchResults(id, totalCount, matches);
        }
    }
}
