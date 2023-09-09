package com.seed.trace.resources.langserver.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.trace.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LangServerResponse.Builder.class)
public final class LangServerResponse {
    private final Object response;

    private LangServerResponse(Object response) {
        this.response = response;
    }

    @JsonProperty("response")
    public Object getResponse() {
        return response;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LangServerResponse && equalTo((LangServerResponse) other);
    }

    private boolean equalTo(LangServerResponse other) {
        return response.equals(other.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.response);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ResponseStage builder() {
        return new Builder();
    }

    public interface ResponseStage {
        _FinalStage response(Object response);

        Builder from(LangServerResponse other);
    }

    public interface _FinalStage {
        LangServerResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ResponseStage, _FinalStage {
        private Object response;

        private Builder() {}

        @Override
        public Builder from(LangServerResponse other) {
            response(other.getResponse());
            return this;
        }

        @Override
        @JsonSetter("response")
        public _FinalStage response(Object response) {
            this.response = response;
            return this;
        }

        @Override
        public LangServerResponse build() {
            return new LangServerResponse(response);
        }
    }
}