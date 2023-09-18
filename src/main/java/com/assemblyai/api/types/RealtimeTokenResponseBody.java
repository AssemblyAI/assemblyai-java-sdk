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
@JsonDeserialize(builder = RealtimeTokenResponseBody.Builder.class)
public final class RealtimeTokenResponseBody {
    private final Optional<String> token;

    private RealtimeTokenResponseBody(Optional<String> token) {
        this.token = token;
    }

    /**
     * @return The temporary authentication token for realtime transcription
     */
    @JsonProperty("token")
    public Optional<String> getToken() {
        return token;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RealtimeTokenResponseBody && equalTo((RealtimeTokenResponseBody) other);
    }

    private boolean equalTo(RealtimeTokenResponseBody other) {
        return token.equals(other.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.token);
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
        private Optional<String> token = Optional.empty();

        private Builder() {}

        public Builder from(RealtimeTokenResponseBody other) {
            token(other.getToken());
            return this;
        }

        @JsonSetter(value = "token", nulls = Nulls.SKIP)
        public Builder token(Optional<String> token) {
            this.token = token;
            return this;
        }

        public Builder token(String token) {
            this.token = Optional.of(token);
            return this;
        }

        public RealtimeTokenResponseBody build() {
            return new RealtimeTokenResponseBody(token);
        }
    }
}
