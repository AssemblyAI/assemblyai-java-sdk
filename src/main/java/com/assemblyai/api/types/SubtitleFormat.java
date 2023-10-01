/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Locale;

public final class SubtitleFormat {
    public static final SubtitleFormat VTT = new SubtitleFormat(Value.VTT, "vtt");

    public static final SubtitleFormat SRT = new SubtitleFormat(Value.SRT, "srt");

    private final Value value;

    private final String string;

    SubtitleFormat(Value value, String string) {
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
        return (this == other)
                || (other instanceof SubtitleFormat && this.string.equals(((SubtitleFormat) other).string));
    }

    @Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case VTT:
                return visitor.visitVtt();
            case SRT:
                return visitor.visitSrt();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SubtitleFormat valueOf(String value) {
        String upperCasedValue = value.toUpperCase(Locale.ROOT);
        switch (upperCasedValue) {
            case "vtt":
                return VTT;
            case "srt":
                return SRT;
            default:
                return new SubtitleFormat(Value.UNKNOWN, upperCasedValue);
        }
    }

    public enum Value {
        SRT,

        VTT,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitSrt();

        T visitVtt();

        T visitUnknown(String unknownType);
    }
}