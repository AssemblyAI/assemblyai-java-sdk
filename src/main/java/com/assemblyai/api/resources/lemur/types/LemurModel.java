/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.lemur.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class LemurModel {
    public static final LemurModel BASIC = new LemurModel(Value.BASIC, "basic");

    public static final LemurModel ANTHROPIC_CLAUDE2_1 =
            new LemurModel(Value.ANTHROPIC_CLAUDE2_1, "anthropic/claude-2-1");

    public static final LemurModel DEFAULT = new LemurModel(Value.DEFAULT, "default");

    public static final LemurModel ASSEMBLYAI_MISTRAL7B =
            new LemurModel(Value.ASSEMBLYAI_MISTRAL7B, "assemblyai/mistral-7b");

    private final Value value;

    private final String string;

    LemurModel(Value value, String string) {
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
        return (this == other) || (other instanceof LemurModel && this.string.equals(((LemurModel) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case BASIC:
                return visitor.visitBasic();
            case ANTHROPIC_CLAUDE2_1:
                return visitor.visitAnthropicClaude2_1();
            case DEFAULT:
                return visitor.visitDefault();
            case ASSEMBLYAI_MISTRAL7B:
                return visitor.visitAssemblyaiMistral7b();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static LemurModel valueOf(String value) {
        switch (value) {
            case "basic":
                return BASIC;
            case "anthropic/claude-2-1":
                return ANTHROPIC_CLAUDE2_1;
            case "default":
                return DEFAULT;
            case "assemblyai/mistral-7b":
                return ASSEMBLYAI_MISTRAL7B;
            default:
                return new LemurModel(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        DEFAULT,

        BASIC,

        ASSEMBLYAI_MISTRAL7B,

        ANTHROPIC_CLAUDE2_1,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitDefault();

        T visitBasic();

        T visitAssemblyaiMistral7b();

        T visitAnthropicClaude2_1();

        T visitUnknown(String unknownType);
    }
}
