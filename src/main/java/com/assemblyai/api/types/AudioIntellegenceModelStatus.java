package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AudioIntellegenceModelStatus {
    SUCCESS("success"),

    UNAVAILABLE("unavailable");

    private final String value;

    AudioIntellegenceModelStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
