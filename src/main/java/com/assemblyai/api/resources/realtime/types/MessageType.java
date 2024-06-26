/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.realtime.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class MessageType {
    public static final MessageType SESSION_BEGINS = new MessageType(Value.SESSION_BEGINS, "SessionBegins");

    public static final MessageType SESSION_TERMINATED = new MessageType(Value.SESSION_TERMINATED, "SessionTerminated");

    public static final MessageType PARTIAL_TRANSCRIPT = new MessageType(Value.PARTIAL_TRANSCRIPT, "PartialTranscript");

    public static final MessageType SESSION_INFORMATION =
            new MessageType(Value.SESSION_INFORMATION, "SessionInformation");

    public static final MessageType FINAL_TRANSCRIPT = new MessageType(Value.FINAL_TRANSCRIPT, "FinalTranscript");

    private final Value value;

    private final String string;

    MessageType(Value value, String string) {
        this.value = value;
        this.string = string;
    }

    public Value getEnumValue() {
        return value;
    }

    @java.lang.Override
    @JsonValue
    public String toString() {
        return this.string;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        return (this == other) || (other instanceof MessageType && this.string.equals(((MessageType) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case SESSION_BEGINS:
                return visitor.visitSessionBegins();
            case SESSION_TERMINATED:
                return visitor.visitSessionTerminated();
            case PARTIAL_TRANSCRIPT:
                return visitor.visitPartialTranscript();
            case SESSION_INFORMATION:
                return visitor.visitSessionInformation();
            case FINAL_TRANSCRIPT:
                return visitor.visitFinalTranscript();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static MessageType valueOf(String value) {
        switch (value) {
            case "SessionBegins":
                return SESSION_BEGINS;
            case "SessionTerminated":
                return SESSION_TERMINATED;
            case "PartialTranscript":
                return PARTIAL_TRANSCRIPT;
            case "SessionInformation":
                return SESSION_INFORMATION;
            case "FinalTranscript":
                return FINAL_TRANSCRIPT;
            default:
                return new MessageType(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        SESSION_BEGINS,

        PARTIAL_TRANSCRIPT,

        FINAL_TRANSCRIPT,

        SESSION_INFORMATION,

        SESSION_TERMINATED,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitSessionBegins();

        T visitPartialTranscript();

        T visitFinalTranscript();

        T visitSessionInformation();

        T visitSessionTerminated();

        T visitUnknown(String unknownType);
    }
}
