/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Error.Builder.class)
public final class Error {
    private final String error;

    private final Optional<String> status;

    private Error(String error, Optional<String> status) {
        this.error = error;
        this.status = status;
    }

    /**
     * @return Error message
     */
    @JsonProperty("error")
    public String getError() {
        return error;
    }

    @JsonProperty("status")
    public Optional<String> getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Error && equalTo((Error) other);
    }

    private boolean equalTo(Error other) {
        return error.equals(other.error) && status.equals(other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.error, this.status);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ErrorStage builder() {
        return new Builder();
    }

    public interface ErrorStage {
        _FinalStage error(String error);

        Builder from(Error other);
    }

    public interface _FinalStage {
        Error build();

        _FinalStage status(Optional<String> status);

        _FinalStage status(String status);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ErrorStage, _FinalStage {
        private String error;

        private Optional<String> status = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(Error other) {
            error(other.getError());
            status(other.getStatus());
            return this;
        }

        /**
         * <p>Error message</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("error")
        public _FinalStage error(String error) {
            this.error = error;
            return this;
        }

        @Override
        public _FinalStage status(String status) {
            this.status = Optional.of(status);
            return this;
        }

        @Override
        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public _FinalStage status(Optional<String> status) {
            this.status = status;
            return this;
        }

        @Override
        public Error build() {
            return new Error(error, status);
        }
    }
}