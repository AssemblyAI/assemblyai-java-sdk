/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Locale;

public final class SummaryType {
    public static final SummaryType HEADLINE = new SummaryType(Value.HEADLINE, "headline");

    public static final SummaryType GIST = new SummaryType(Value.GIST, "gist");

    public static final SummaryType BULLETS_VERBOSE = new SummaryType(Value.BULLETS_VERBOSE, "bullets_verbose");

    public static final SummaryType BULLETS = new SummaryType(Value.BULLETS, "bullets");

    public static final SummaryType PARAGRAPH = new SummaryType(Value.PARAGRAPH, "paragraph");

    private final Value value;

    private final String string;

    SummaryType(Value value, String string) {
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
        return (this == other) || (other instanceof SummaryType && this.string.equals(((SummaryType) other).string));
    }

    @Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case HEADLINE:
                return visitor.visitHeadline();
            case GIST:
                return visitor.visitGist();
            case BULLETS_VERBOSE:
                return visitor.visitBulletsVerbose();
            case BULLETS:
                return visitor.visitBullets();
            case PARAGRAPH:
                return visitor.visitParagraph();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SummaryType valueOf(String value) {
        String upperCasedValue = value.toUpperCase(Locale.ROOT);
        switch (upperCasedValue) {
            case "headline":
                return HEADLINE;
            case "gist":
                return GIST;
            case "bullets_verbose":
                return BULLETS_VERBOSE;
            case "bullets":
                return BULLETS;
            case "paragraph":
                return PARAGRAPH;
            default:
                return new SummaryType(Value.UNKNOWN, upperCasedValue);
        }
    }

    public enum Value {
        BULLETS,

        BULLETS_VERBOSE,

        GIST,

        HEADLINE,

        PARAGRAPH,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitBullets();

        T visitBulletsVerbose();

        T visitGist();

        T visitHeadline();

        T visitParagraph();

        T visitUnknown(String unknownType);
    }
}