package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TranscriptLanguageCode {
    ES("es"),

    EN("en"),

    NL("nl"),

    JA("ja"),

    HI("hi"),

    DE("de"),

    PT("pt"),

    FR("fr");

    private final String value;

    TranscriptLanguageCode(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
