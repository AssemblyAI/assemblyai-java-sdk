/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class LemurModels {
    public static final LemurModels BASIC = new LemurModels(Value.BASIC, "basic");

    public static final LemurModels DEFAULT = new LemurModels(Value.DEFAULT, "default");

    private final Value value;

    private final String string;

    LemurModels(Value value, String string) {
        this.value = value;
        this.string = string;
    }

    public Value getEnumValue() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return this.string;
    }

    @Override
    public boolean equals(Object other) {
        return (this == other) || (other instanceof LemurModels && this.string.equals(((LemurModels) other).string));
    }

    @Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case BASIC:
                return visitor.visitBasic();
            case DEFAULT:
                return visitor.visitDefault();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static LemurModels valueOf(String value) {
        switch (value) {
            case "basic":
                return BASIC;
            case "default":
                return DEFAULT;
            default:
                return new LemurModels(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        DEFAULT,

        BASIC,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitDefault();

        T visitBasic();

        T visitUnknown(String unknownType);
    }
}
