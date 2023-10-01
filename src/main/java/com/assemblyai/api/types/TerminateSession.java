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
@JsonDeserialize(builder = TerminateSession.Builder.class)
public final class TerminateSession implements IRealtimeBaseMessage {
    private final MessageTypes messageType;

    private final boolean terminateSession;

    private TerminateSession(MessageTypes messageType, boolean terminateSession) {
        this.messageType = messageType;
        this.terminateSession = terminateSession;
    }

    /**
     * @return Describes the type of the message.
     */
    @JsonProperty("message_type")
    @Override
    public MessageTypes getMessageType() {
        return messageType;
    }

    /**
     * @return A boolean value to communicate that you wish to end your real-time session forever.
     */
    @JsonProperty("terminate_session")
    public boolean getTerminateSession() {
        return terminateSession;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TerminateSession && equalTo((TerminateSession) other);
    }

    private boolean equalTo(TerminateSession other) {
        return messageType.equals(other.messageType) && terminateSession == other.terminateSession;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.messageType, this.terminateSession);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static MessageTypeStage builder() {
        return new Builder();
    }

    public interface MessageTypeStage {
        TerminateSessionStage messageType(MessageTypes messageType);

        Builder from(TerminateSession other);
    }

    public interface TerminateSessionStage {
        _FinalStage terminateSession(boolean terminateSession);
    }

    public interface _FinalStage {
        TerminateSession build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MessageTypeStage, TerminateSessionStage, _FinalStage {
        private MessageTypes messageType;

        private boolean terminateSession;

        private Builder() {}

        @Override
        public Builder from(TerminateSession other) {
            messageType(other.getMessageType());
            terminateSession(other.getTerminateSession());
            return this;
        }

        /**
         * <p>Describes the type of the message.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("message_type")
        public TerminateSessionStage messageType(MessageTypes messageType) {
            this.messageType = messageType;
            return this;
        }

        /**
         * <p>A boolean value to communicate that you wish to end your real-time session forever.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("terminate_session")
        public _FinalStage terminateSession(boolean terminateSession) {
            this.terminateSession = terminateSession;
            return this;
        }

        @Override
        public TerminateSession build() {
            return new TerminateSession(messageType, terminateSession);
        }
    }
}