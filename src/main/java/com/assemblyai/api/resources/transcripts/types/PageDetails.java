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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PageDetails.Builder.class)
public final class PageDetails {
    private final int limit;

    private final int resultCount;

    private final String currentURL;

    private final String prevURL;

    private final Optional<String> nextURL;

    private final Map<String, Object> additionalProperties;

    private PageDetails(
            int limit,
            int resultCount,
            String currentURL,
            String prevURL,
            Optional<String> nextURL,
            Map<String, Object> additionalProperties) {
        this.limit = limit;
        this.resultCount = resultCount;
        this.currentURL = currentURL;
        this.prevURL = prevURL;
        this.nextURL = nextURL;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("limit")
    public int getLimit() {
        return limit;
    }

    @JsonProperty("result_count")
    public int getResultCount() {
        return resultCount;
    }

    @JsonProperty("current_url")
    public String getCurrentURL() {
        return currentURL;
    }

    @JsonProperty("prev_url")
    public String getPrevURL() {
        return prevURL;
    }

    @JsonProperty("next_url")
    public Optional<String> getNextURL() {
        return nextURL;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PageDetails && equalTo((PageDetails) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(PageDetails other) {
        return limit == other.limit
                && resultCount == other.resultCount
                && currentURL.equals(other.currentURL)
                && prevURL.equals(other.prevURL)
                && nextURL.equals(other.nextURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.limit, this.resultCount, this.currentURL, this.prevURL, this.nextURL);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LimitStage builder() {
        return new Builder();
    }

    public interface LimitStage {
        ResultCountStage limit(int limit);

        Builder from(PageDetails other);
    }

    public interface ResultCountStage {
        CurrentURLStage resultCount(int resultCount);
    }

    public interface CurrentURLStage {
        PrevURLStage currentURL(String currentURL);
    }

    public interface PrevURLStage {
        _FinalStage prevURL(String prevURL);
    }

    public interface _FinalStage {
        PageDetails build();

        _FinalStage nextURL(Optional<String> nextURL);

        _FinalStage nextURL(String nextURL);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements LimitStage, ResultCountStage, CurrentURLStage, PrevURLStage, _FinalStage {
        private int limit;

        private int resultCount;

        private String currentURL;

        private String prevURL;

        private Optional<String> nextURL = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(PageDetails other) {
            limit(other.getLimit());
            resultCount(other.getResultCount());
            currentURL(other.getCurrentURL());
            prevURL(other.getPrevURL());
            nextURL(other.getNextURL());
            return this;
        }

        @Override
        @JsonSetter("limit")
        public ResultCountStage limit(int limit) {
            this.limit = limit;
            return this;
        }

        @Override
        @JsonSetter("result_count")
        public CurrentURLStage resultCount(int resultCount) {
            this.resultCount = resultCount;
            return this;
        }

        @Override
        @JsonSetter("current_url")
        public PrevURLStage currentURL(String currentURL) {
            this.currentURL = currentURL;
            return this;
        }

        @Override
        @JsonSetter("prev_url")
        public _FinalStage prevURL(String prevURL) {
            this.prevURL = prevURL;
            return this;
        }

        @Override
        public _FinalStage nextURL(String nextURL) {
            this.nextURL = Optional.of(nextURL);
            return this;
        }

        @Override
        @JsonSetter(value = "next_url", nulls = Nulls.SKIP)
        public _FinalStage nextURL(Optional<String> nextURL) {
            this.nextURL = nextURL;
            return this;
        }

        @Override
        public PageDetails build() {
            return new PageDetails(limit, resultCount, currentURL, prevURL, nextURL, additionalProperties);
        }
    }
}
