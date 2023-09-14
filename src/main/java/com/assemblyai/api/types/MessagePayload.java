package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

public final class MessagePayload {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private MessagePayload(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static MessagePayload partialTranscript(PartialTranscript value) {
        return new MessagePayload(new PartialTranscriptValue(value));
    }

    public static MessagePayload finalTranscript(FinalTranscript value) {
        return new MessagePayload(new FinalTranscriptValue(value));
    }

    public boolean isPartialTranscript() {
        return value instanceof PartialTranscriptValue;
    }

    public boolean isFinalTranscript() {
        return value instanceof FinalTranscriptValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<PartialTranscript> getPartialTranscript() {
        if (isPartialTranscript()) {
            return Optional.of(((PartialTranscriptValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<FinalTranscript> getFinalTranscript() {
        if (isFinalTranscript()) {
            return Optional.of(((FinalTranscriptValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<Object> _getUnknown() {
        if (_isUnknown()) {
            return Optional.of(((_UnknownValue) value).value);
        }
        return Optional.empty();
    }

    @JsonValue
    private Value getValue() {
        return this.value;
    }

    public interface Visitor<T> {
        T visitPartialTranscript(PartialTranscript partialTranscript);

        T visitFinalTranscript(FinalTranscript finalTranscript);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            property = "message_type",
            visible = true,
            defaultImpl = _UnknownValue.class)
    @JsonSubTypes({@JsonSubTypes.Type(PartialTranscriptValue.class), @JsonSubTypes.Type(FinalTranscriptValue.class)})
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("PartialTranscript")
    private static final class PartialTranscriptValue implements Value {
        @JsonUnwrapped
        private PartialTranscript value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private PartialTranscriptValue() {}

        private PartialTranscriptValue(PartialTranscript value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitPartialTranscript(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof PartialTranscriptValue && equalTo((PartialTranscriptValue) other);
        }

        private boolean equalTo(PartialTranscriptValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "MessagePayload{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("FinalTranscript")
    private static final class FinalTranscriptValue implements Value {
        @JsonUnwrapped
        private FinalTranscript value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private FinalTranscriptValue() {}

        private FinalTranscriptValue(FinalTranscript value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitFinalTranscript(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof FinalTranscriptValue && equalTo((FinalTranscriptValue) other);
        }

        private boolean equalTo(FinalTranscriptValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "MessagePayload{" + "value: " + value + "}";
        }
    }

    private static final class _UnknownValue implements Value {
        private String type;

        @JsonValue
        private Object value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private _UnknownValue(@JsonProperty("value") Object value) {}

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor._visitUnknown(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof _UnknownValue && equalTo((_UnknownValue) other);
        }

        private boolean equalTo(_UnknownValue other) {
            return type.equals(other.type) && value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.type, this.value);
        }

        @Override
        public String toString() {
            return "MessagePayload{" + "type: " + type + ", value: " + value + "}";
        }
    }
}
