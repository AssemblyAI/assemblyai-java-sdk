package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AudioIntelligenceModelStatus {
    SUCCESS("success"),

    UNAVAILABLE("unavailable");

    private final String value;

    AudioIntelligenceModelStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
