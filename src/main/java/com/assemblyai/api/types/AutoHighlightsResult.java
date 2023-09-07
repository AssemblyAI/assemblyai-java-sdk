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
@JsonDeserialize(builder = AutoHighlightsResult.Builder.class)
public final class AutoHighlightsResult {
    private final Optional<List<AutoHighlightsResultResultsItem>> results;

    private AutoHighlightsResult(Optional<List<AutoHighlightsResultResultsItem>> results) {
        this.results = results;
    }

    /**
     * @return A temporally-sequential array of Key Phrases
     */
    @JsonProperty("results")
    public Optional<List<AutoHighlightsResultResultsItem>> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AutoHighlightsResult && equalTo((AutoHighlightsResult) other);
    }

    private boolean equalTo(AutoHighlightsResult other) {
        return results.equals(other.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.results);
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
        private Optional<List<AutoHighlightsResultResultsItem>> results = Optional.empty();

        private Builder() {}

        public Builder from(AutoHighlightsResult other) {
            results(other.getResults());
            return this;
        }

        @JsonSetter(value = "results", nulls = Nulls.SKIP)
        public Builder results(Optional<List<AutoHighlightsResultResultsItem>> results) {
            this.results = results;
            return this;
        }

        public Builder results(List<AutoHighlightsResultResultsItem> results) {
            this.results = Optional.of(results);
            return this;
        }

        public AutoHighlightsResult build() {
            return new AutoHighlightsResult(results);
        }
    }
}
