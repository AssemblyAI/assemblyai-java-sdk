package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SessionStart.Builder.class)
public final class SessionStart {
    private final Optional<String> messageType;

    private final Optional<String> sessionId;

    private final Optional<OffsetDateTime> expiresAt;

    private SessionStart(Optional<String> messageType, Optional<String> sessionId, Optional<OffsetDateTime> expiresAt) {
        this.messageType = messageType;
        this.sessionId = sessionId;
        this.expiresAt = expiresAt;
    }

    /**
     * @return Describes the type of the message.
     */
    @JsonProperty("message_type")
    public Optional<String> getMessageType() {
        return messageType;
    }

    /**
     * @return Unique identifier for the established session.
     */
    @JsonProperty("session_id")
    public Optional<String> getSessionId() {
        return sessionId;
    }

    /**
     * @return Timestamp when this session will expire.
     */
    @JsonProperty("expires_at")
    public Optional<OffsetDateTime> getExpiresAt() {
        return expiresAt;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SessionStart && equalTo((SessionStart) other);
    }

    private boolean equalTo(SessionStart other) {
        return messageType.equals(other.messageType)
                && sessionId.equals(other.sessionId)
                && expiresAt.equals(other.expiresAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.messageType, this.sessionId, this.expiresAt);
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
        private Optional<String> messageType = Optional.empty();

        private Optional<String> sessionId = Optional.empty();

        private Optional<OffsetDateTime> expiresAt = Optional.empty();

        private Builder() {}

        public Builder from(SessionStart other) {
            messageType(other.getMessageType());
            sessionId(other.getSessionId());
            expiresAt(other.getExpiresAt());
            return this;
        }

        @JsonSetter(value = "message_type", nulls = Nulls.SKIP)
        public Builder messageType(Optional<String> messageType) {
            this.messageType = messageType;
            return this;
        }

        public Builder messageType(String messageType) {
            this.messageType = Optional.of(messageType);
            return this;
        }

        @JsonSetter(value = "session_id", nulls = Nulls.SKIP)
        public Builder sessionId(Optional<String> sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public Builder sessionId(String sessionId) {
            this.sessionId = Optional.of(sessionId);
            return this;
        }

        @JsonSetter(value = "expires_at", nulls = Nulls.SKIP)
        public Builder expiresAt(Optional<OffsetDateTime> expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        public Builder expiresAt(OffsetDateTime expiresAt) {
            this.expiresAt = Optional.of(expiresAt);
            return this;
        }

        public SessionStart build() {
            return new SessionStart(messageType, sessionId, expiresAt);
        }
    }
}
