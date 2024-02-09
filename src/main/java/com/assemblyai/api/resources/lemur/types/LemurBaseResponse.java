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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LemurBaseResponse.Builder.class)
public final class LemurBaseResponse implements ILemurBaseResponse {
    private final String requestID;

    private final Map<String, Object> additionalProperties;

    private LemurBaseResponse(String requestID, Map<String, Object> additionalProperties) {
        this.requestID = requestID;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the LeMUR request
     */
    @JsonProperty("request_id")
    @Override
    public String getRequestID() {
        return requestID;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LemurBaseResponse && equalTo((LemurBaseResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LemurBaseResponse other) {
        return requestID.equals(other.requestID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.requestID);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RequestIDStage builder() {
        return new Builder();
    }

    public interface RequestIDStage {
        _FinalStage requestID(String requestID);

        Builder from(LemurBaseResponse other);
    }

    public interface _FinalStage {
        LemurBaseResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements RequestIDStage, _FinalStage {
        private String requestID;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(LemurBaseResponse other) {
            requestID(other.getRequestID());
            return this;
        }

        /**
         * <p>The ID of the LeMUR request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("request_id")
        public _FinalStage requestID(String requestID) {
            this.requestID = requestID;
            return this;
        }

        @Override
        public LemurBaseResponse build() {
            return new LemurBaseResponse(requestID, additionalProperties);
        }
    }
}
