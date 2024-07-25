/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.lemur.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = LemurBaseResponse.Builder.class)
public final class LemurBaseResponse implements ILemurBaseResponse {
    private final String requestId;

    private final LemurUsage usage;

    private final Map<String, Object> additionalProperties;

    private LemurBaseResponse(String requestId, LemurUsage usage, Map<String, Object> additionalProperties) {
        this.requestId = requestId;
        this.usage = usage;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the LeMUR request
     */
    @JsonProperty("request_id")
    @java.lang.Override
    public String getRequestId() {
        return requestId;
    }

    /**
     * @return The usage numbers for the LeMUR request
     */
    @JsonProperty("usage")
    @java.lang.Override
    public LemurUsage getUsage() {
        return usage;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LemurBaseResponse && equalTo((LemurBaseResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LemurBaseResponse other) {
        return requestId.equals(other.requestId) && usage.equals(other.usage);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.requestId, this.usage);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RequestIdStage builder() {
        return new Builder();
    }

    public interface RequestIdStage {
        UsageStage requestId(String requestId);

        Builder from(LemurBaseResponse other);
    }

    public interface UsageStage {
        _FinalStage usage(LemurUsage usage);
    }

    public interface _FinalStage {
        LemurBaseResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements RequestIdStage, UsageStage, _FinalStage {
        private String requestId;

        private LemurUsage usage;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(LemurBaseResponse other) {
            requestId(other.getRequestId());
            usage(other.getUsage());
            return this;
        }

        /**
         * <p>The ID of the LeMUR request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("request_id")
        public UsageStage requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        /**
         * <p>The usage numbers for the LeMUR request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("usage")
        public _FinalStage usage(LemurUsage usage) {
            this.usage = usage;
            return this;
        }

        @java.lang.Override
        public LemurBaseResponse build() {
            return new LemurBaseResponse(requestId, usage, additionalProperties);
        }
    }
}
