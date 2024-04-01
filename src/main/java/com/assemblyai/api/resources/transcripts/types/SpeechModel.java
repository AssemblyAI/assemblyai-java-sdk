/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.transcripts.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class SpeechModel {
    public static final SpeechModel NANO = new SpeechModel(Value.NANO, "nano");

    public static final SpeechModel BEST = new SpeechModel(Value.BEST, "best");

    public static final SpeechModel CONFORMER2 = new SpeechModel(Value.CONFORMER2, "conformer-2");

    private final Value value;

    private final String string;

    SpeechModel(Value value, String string) {
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
        return (this == other) || (other instanceof SpeechModel && this.string.equals(((SpeechModel) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case NANO:
                return visitor.visitNano();
            case BEST:
                return visitor.visitBest();
            case CONFORMER2:
                return visitor.visitConformer2();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SpeechModel valueOf(String value) {
        switch (value) {
            case "nano":
                return NANO;
            case "best":
                return BEST;
            case "conformer-2":
                return CONFORMER2;
            default:
                return new SpeechModel(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        BEST,

        NANO,

        CONFORMER2,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitBest();

        T visitNano();

        T visitConformer2();

        T visitUnknown(String unknownType);
    }
}
