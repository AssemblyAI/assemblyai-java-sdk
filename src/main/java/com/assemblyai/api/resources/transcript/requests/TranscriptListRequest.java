package com.assemblyai.api.resources.transcript.requests;

import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.types.TranscriptStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TranscriptListRequest.Builder.class)
public final class TranscriptListRequest {
    private final Optional<Integer> limit;

    private final Optional<TranscriptStatus> status;

    private final Optional<String> createdOn;

    private final Optional<String> beforeId;

    private final Optional<String> afterId;

    private final Optional<Boolean> throttledOnly;

    private TranscriptListRequest(
            Optional<Integer> limit,
            Optional<TranscriptStatus> status,
            Optional<String> createdOn,
            Optional<String> beforeId,
            Optional<String> afterId,
            Optional<Boolean> throttledOnly) {
        this.limit = limit;
        this.status = status;
        this.createdOn = createdOn;
        this.beforeId = beforeId;
        this.afterId = afterId;
        this.throttledOnly = throttledOnly;
    }

    /**
     * @return Max results to return in a single response
     */
    @JsonProperty("limit")
    public Optional<Integer> getLimit() {
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
     * @return Only return transcripts created on this date
     */
    @JsonProperty("created_on")
    public Optional<String> getCreatedOn() {
        return createdOn;
    }

    /**
     * @return Return transcripts that were created before this id
     */
    @JsonProperty("before_id")
    public Optional<String> getBeforeId() {
        return beforeId;
    }

    /**
     * @return Return transcripts that were created after this id
     */
    @JsonProperty("after_id")
    public Optional<String> getAfterId() {
        return afterId;
    }

    /**
     * @return Only return throttled transcripts, overrides status filter
     */
    @JsonProperty("throttled_only")
    public Optional<Boolean> getThrottledOnly() {
        return throttledOnly;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptListRequest && equalTo((TranscriptListRequest) other);
    }

    private boolean equalTo(TranscriptListRequest other) {
        return limit.equals(other.limit)
                && status.equals(other.status)
                && createdOn.equals(other.createdOn)
                && beforeId.equals(other.beforeId)
                && afterId.equals(other.afterId)
                && throttledOnly.equals(other.throttledOnly);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.limit, this.status, this.createdOn, this.beforeId, this.afterId, this.throttledOnly);
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
        private Optional<Integer> limit = Optional.empty();

        private Optional<TranscriptStatus> status = Optional.empty();

        private Optional<String> createdOn = Optional.empty();

        private Optional<String> beforeId = Optional.empty();

        private Optional<String> afterId = Optional.empty();

        private Optional<Boolean> throttledOnly = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptListRequest other) {
            limit(other.getLimit());
            status(other.getStatus());
            createdOn(other.getCreatedOn());
            beforeId(other.getBeforeId());
            afterId(other.getAfterId());
            throttledOnly(other.getThrottledOnly());
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

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<TranscriptStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(TranscriptStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "created_on", nulls = Nulls.SKIP)
        public Builder createdOn(Optional<String> createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder createdOn(String createdOn) {
            this.createdOn = Optional.of(createdOn);
            return this;
        }

        @JsonSetter(value = "before_id", nulls = Nulls.SKIP)
        public Builder beforeId(Optional<String> beforeId) {
            this.beforeId = beforeId;
            return this;
        }

        public Builder beforeId(String beforeId) {
            this.beforeId = Optional.of(beforeId);
            return this;
        }

        @JsonSetter(value = "after_id", nulls = Nulls.SKIP)
        public Builder afterId(Optional<String> afterId) {
            this.afterId = afterId;
            return this;
        }

        public Builder afterId(String afterId) {
            this.afterId = Optional.of(afterId);
            return this;
        }

        @JsonSetter(value = "throttled_only", nulls = Nulls.SKIP)
        public Builder throttledOnly(Optional<Boolean> throttledOnly) {
            this.throttledOnly = throttledOnly;
            return this;
        }

        public Builder throttledOnly(Boolean throttledOnly) {
            this.throttledOnly = Optional.of(throttledOnly);
            return this;
        }

        public TranscriptListRequest build() {
            return new TranscriptListRequest(limit, status, createdOn, beforeId, afterId, throttledOnly);
        }
    }
}
