package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PageDetails.Builder.class)
public final class PageDetails {
    private final Optional<Integer> limit;

    private final Optional<Integer> resultCount;

    private final Optional<String> currentUrl;

    private final Optional<String> prevUrl;

    private final Optional<String> nextUrl;

    private PageDetails(
            Optional<Integer> limit,
            Optional<Integer> resultCount,
            Optional<String> currentUrl,
            Optional<String> prevUrl,
            Optional<String> nextUrl) {
        this.limit = limit;
        this.resultCount = resultCount;
        this.currentUrl = currentUrl;
        this.prevUrl = prevUrl;
        this.nextUrl = nextUrl;
    }

    @JsonProperty("limit")
    public Optional<Integer> getLimit() {
        return limit;
    }

    @JsonProperty("result_count")
    public Optional<Integer> getResultCount() {
        return resultCount;
    }

    @JsonProperty("current_url")
    public Optional<String> getCurrentUrl() {
        return currentUrl;
    }

    @JsonProperty("prev_url")
    public Optional<String> getPrevUrl() {
        return prevUrl;
    }

    @JsonProperty("next_url")
    public Optional<String> getNextUrl() {
        return nextUrl;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PageDetails && equalTo((PageDetails) other);
    }

    private boolean equalTo(PageDetails other) {
        return limit.equals(other.limit)
                && resultCount.equals(other.resultCount)
                && currentUrl.equals(other.currentUrl)
                && prevUrl.equals(other.prevUrl)
                && nextUrl.equals(other.nextUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.limit, this.resultCount, this.currentUrl, this.prevUrl, this.nextUrl);
    }

    @Override
    public String toString() {
        return "PageDetails{" + "limit: " + limit + ", resultCount: " + resultCount + ", currentUrl: " + currentUrl
                + ", prevUrl: " + prevUrl + ", nextUrl: " + nextUrl + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Integer> limit = Optional.empty();

        private Optional<Integer> resultCount = Optional.empty();

        private Optional<String> currentUrl = Optional.empty();

        private Optional<String> prevUrl = Optional.empty();

        private Optional<String> nextUrl = Optional.empty();

        private Builder() {}

        public Builder from(PageDetails other) {
            limit(other.getLimit());
            resultCount(other.getResultCount());
            currentUrl(other.getCurrentUrl());
            prevUrl(other.getPrevUrl());
            nextUrl(other.getNextUrl());
            return this;
        }

        @JsonSetter(value = "limit", nulls = Nulls.SKIP)
        public Builder limit(Optional<Integer> limit) {
            this.limit = limit;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = Optional.of(limit);
            return this;
        }

        @JsonSetter(value = "result_count", nulls = Nulls.SKIP)
        public Builder resultCount(Optional<Integer> resultCount) {
            this.resultCount = resultCount;
            return this;
        }

        public Builder resultCount(Integer resultCount) {
            this.resultCount = Optional.of(resultCount);
            return this;
        }

        @JsonSetter(value = "current_url", nulls = Nulls.SKIP)
        public Builder currentUrl(Optional<String> currentUrl) {
            this.currentUrl = currentUrl;
            return this;
        }

        public Builder currentUrl(String currentUrl) {
            this.currentUrl = Optional.of(currentUrl);
            return this;
        }

        @JsonSetter(value = "prev_url", nulls = Nulls.SKIP)
        public Builder prevUrl(Optional<String> prevUrl) {
            this.prevUrl = prevUrl;
            return this;
        }

        public Builder prevUrl(String prevUrl) {
            this.prevUrl = Optional.of(prevUrl);
            return this;
        }

        @JsonSetter(value = "next_url", nulls = Nulls.SKIP)
        public Builder nextUrl(Optional<String> nextUrl) {
            this.nextUrl = nextUrl;
            return this;
        }

        public Builder nextUrl(String nextUrl) {
            this.nextUrl = Optional.of(nextUrl);
            return this;
        }

        public PageDetails build() {
            return new PageDetails(limit, resultCount, currentUrl, prevUrl, nextUrl);
        }
    }
}
