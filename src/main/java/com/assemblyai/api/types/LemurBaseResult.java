/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LemurBaseResult.Builder.class)
public final class LemurBaseResult implements ILemurBaseResult {
    private final String requestId;

    private LemurBaseResult(String requestId) {
        this.requestId = requestId;
    }

    /**
     * @return The ID of the LeMUR request
     */
    @JsonProperty("request_id")
    @Override
    public String getRequestId() {
        return requestId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LemurBaseResult && equalTo((LemurBaseResult) other);
    }

    private boolean equalTo(LemurBaseResult other) {
        return requestId.equals(other.requestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.requestId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RequestIdStage builder() {
        return new Builder();
    }

    public interface RequestIdStage {
        _FinalStage requestId(String requestId);

        Builder from(LemurBaseResult other);
    }

    public interface _FinalStage {
        LemurBaseResult build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements RequestIdStage, _FinalStage {
        private String requestId;

        private Builder() {}

        @Override
        public Builder from(LemurBaseResult other) {
            requestId(other.getRequestId());
            return this;
        }

        /**
         * <p>The ID of the LeMUR request</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("request_id")
        public _FinalStage requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        @Override
        public LemurBaseResult build() {
            return new LemurBaseResult(requestId);
        }
    }
}
