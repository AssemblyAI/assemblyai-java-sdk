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
@JsonDeserialize(builder = SessionBegins.Builder.class)
public final class SessionBegins {
    private final String sessionId;

    private final String expiresAt;

    private SessionBegins(String sessionId, String expiresAt) {
        this.sessionId = sessionId;
        this.expiresAt = expiresAt;
    }

    @JsonProperty("message_type")
    public String getMessageType() {
        return "SessionBegins";
    }

    /**
     * @return Unique identifier for the established session.
     */
    @JsonProperty("session_id")
    public String getSessionId() {
        return sessionId;
    }

    /**
     * @return Timestamp when this session will expire.
     */
    @JsonProperty("expires_at")
    public String getExpiresAt() {
        return expiresAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SessionBegins && equalTo((SessionBegins) other);
    }

    private boolean equalTo(SessionBegins other) {
        return sessionId.equals(other.sessionId) && expiresAt.equals(other.expiresAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.sessionId, this.expiresAt);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SessionIdStage builder() {
        return new Builder();
    }

    public interface SessionIdStage {
        ExpiresAtStage sessionId(String sessionId);

        Builder from(SessionBegins other);
    }

    public interface ExpiresAtStage {
        _FinalStage expiresAt(String expiresAt);
    }

    public interface _FinalStage {
        SessionBegins build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SessionIdStage, ExpiresAtStage, _FinalStage {
        private String sessionId;

        private String expiresAt;

        private Builder() {}

        @Override
        public Builder from(SessionBegins other) {
            sessionId(other.getSessionId());
            expiresAt(other.getExpiresAt());
            return this;
        }

        /**
         * <p>Unique identifier for the established session.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("session_id")
        public ExpiresAtStage sessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        /**
         * <p>Timestamp when this session will expire.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("expires_at")
        public _FinalStage expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        @Override
        public SessionBegins build() {
            return new SessionBegins(sessionId, expiresAt);
        }
    }
}
