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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = LemurSummaryResponse.Builder.class)
public final class LemurSummaryResponse implements ILemurStringResponse {
    private final String response;

    private final String requestId;

    private final LemurUsage usage;

    private final Map<String, Object> additionalProperties;

    private LemurSummaryResponse(
            String response, String requestId, LemurUsage usage, Map<String, Object> additionalProperties) {
        this.response = response;
        this.requestId = requestId;
        this.usage = usage;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The response generated by LeMUR.
     */
    @JsonProperty("response")
    @java.lang.Override
    public String getResponse() {
        return response;
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
        return other instanceof LemurSummaryResponse && equalTo((LemurSummaryResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LemurSummaryResponse other) {
        return response.equals(other.response) && requestId.equals(other.requestId) && usage.equals(other.usage);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.response, this.requestId, this.usage);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ResponseStage builder() {
        return new Builder();
    }

    public interface ResponseStage {
        RequestIdStage response(@NotNull String response);

        Builder from(LemurSummaryResponse other);
    }

    public interface RequestIdStage {
        UsageStage requestId(@NotNull String requestId);
    }

    public interface UsageStage {
        _FinalStage usage(@NotNull LemurUsage usage);
    }

    public interface _FinalStage {
        LemurSummaryResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ResponseStage, RequestIdStage, UsageStage, _FinalStage {
        private String response;

        private String requestId;

        private LemurUsage usage;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(LemurSummaryResponse other) {
            response(other.getResponse());
            requestId(other.getRequestId());
            usage(other.getUsage());
            return this;
        }

        /**
         * <p>The response generated by LeMUR.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("response")
        public RequestIdStage response(@NotNull String response) {
            this.response = Objects.requireNonNull(response, "response must not be null");
            return this;
        }

        /**
         * <p>The ID of the LeMUR request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("request_id")
        public UsageStage requestId(@NotNull String requestId) {
            this.requestId = Objects.requireNonNull(requestId, "requestId must not be null");
            return this;
        }

        /**
         * <p>The usage numbers for the LeMUR request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("usage")
        public _FinalStage usage(@NotNull LemurUsage usage) {
            this.usage = Objects.requireNonNull(usage, "usage must not be null");
            return this;
        }

        @java.lang.Override
        public LemurSummaryResponse build() {
            return new LemurSummaryResponse(response, requestId, usage, additionalProperties);
        }
    }
}
