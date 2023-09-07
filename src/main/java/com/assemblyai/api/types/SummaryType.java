package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SummaryType {
    BULLETS("bullets"),

    BULLETS_VERBOSE("bullets_verbose"),

    GIST("gist"),

    HEADLINE("headline"),

    PARAGRAPH("paragraph");

    private final String value;

    SummaryType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
