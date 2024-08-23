/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.transcripts.requests;

import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.resources.transcripts.types.TranscriptStatus;
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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ListTranscriptParams.Builder.class)
public final class ListTranscriptParams {
    private final Optional<Long> limit;

    private final Optional<TranscriptStatus> status;

    private final Optional<String> createdOn;

    private final Optional<String> beforeId;

    private final Optional<String> afterId;

    private final Optional<Boolean> throttledOnly;

    private final Map<String, Object> additionalProperties;

    private ListTranscriptParams(
            Optional<Long> limit,
            Optional<TranscriptStatus> status,
            Optional<String> createdOn,
            Optional<String> beforeId,
            Optional<String> afterId,
            Optional<Boolean> throttledOnly,
            Map<String, Object> additionalProperties) {
        this.limit = limit;
        this.status = status;
        this.createdOn = createdOn;
        this.beforeId = beforeId;
        this.afterId = afterId;
        this.throttledOnly = throttledOnly;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Maximum amount of transcripts to retrieve
     */
    @JsonProperty("limit")
    public Optional<Long> getLimit() {
        return limit;
    }

    /**
     * @return Filter by transcript status
     */
    @JsonProperty("status")
    public Optional<TranscriptStatus> getStatus() {
        return status;
    }

    /**
     * @return Only get transcripts created on this date
     */
    @JsonProperty("created_on")
    public Optional<String> getCreatedOn() {
        return createdOn;
    }

    /**
     * @return Get transcripts that were created before this transcript ID
     */
    @JsonProperty("before_id")
    public Optional<String> getBeforeId() {
        return beforeId;
    }

    /**
     * @return Get transcripts that were created after this transcript ID
     */
    @JsonProperty("after_id")
    public Optional<String> getAfterId() {
        return afterId;
    }

    /**
     * @return Only get throttled transcripts, overrides the status filter
     */
    @JsonProperty("throttled_only")
    public Optional<Boolean> getThrottledOnly() {
        return throttledOnly;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListTranscriptParams && equalTo((ListTranscriptParams) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListTranscriptParams other) {
        return limit.equals(other.limit)
                && status.equals(other.status)
                && createdOn.equals(other.createdOn)
                && beforeId.equals(other.beforeId)
                && afterId.equals(other.afterId)
                && throttledOnly.equals(other.throttledOnly);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.limit, this.status, this.createdOn, this.beforeId, this.afterId, this.throttledOnly);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Long> limit = Optional.empty();

        private Optional<TranscriptStatus> status = Optional.empty();

        private Optional<String> createdOn = Optional.empty();

        private Optional<String> beforeId = Optional.empty();

        private Optional<String> afterId = Optional.empty();

        private Optional<Boolean> throttledOnly = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListTranscriptParams other) {
            limit(other.getLimit());
            status(other.getStatus());
            createdOn(other.getCreatedOn());
            beforeId(other.getBeforeId());
            afterId(other.getAfterId());
            throttledOnly(other.getThrottledOnly());
            return this;
        }

        @JsonSetter(value = "limit", nulls = Nulls.SKIP)
        public Builder limit(Optional<Long> limit) {
            this.limit = limit;
            return this;
        }

        public Builder limit(Long limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<TranscriptStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(TranscriptStatus status) {
            this.status = Optional.ofNullable(status);
            return this;
        }

        @JsonSetter(value = "created_on", nulls = Nulls.SKIP)
        public Builder createdOn(Optional<String> createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = Optional.ofNullable(createdOn);
            return this;
        }

        @JsonSetter(value = "before_id", nulls = Nulls.SKIP)
        public Builder beforeId(Optional<String> beforeId) {
            this.beforeId = beforeId;
            return this;
        }

        public Builder beforeId(String beforeId) {
            this.beforeId = Optional.ofNullable(beforeId);
            return this;
        }

        @JsonSetter(value = "after_id", nulls = Nulls.SKIP)
        public Builder afterId(Optional<String> afterId) {
            this.afterId = afterId;
            return this;
        }

        public Builder afterId(String afterId) {
            this.afterId = Optional.ofNullable(afterId);
            return this;
        }

        @JsonSetter(value = "throttled_only", nulls = Nulls.SKIP)
        public Builder throttledOnly(Optional<Boolean> throttledOnly) {
            this.throttledOnly = throttledOnly;
            return this;
        }

        public Builder throttledOnly(Boolean throttledOnly) {
            this.throttledOnly = Optional.ofNullable(throttledOnly);
            return this;
        }

        public ListTranscriptParams build() {
            return new ListTranscriptParams(
                    limit, status, createdOn, beforeId, afterId, throttledOnly, additionalProperties);
        }
    }
}
