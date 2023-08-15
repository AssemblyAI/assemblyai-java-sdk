package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TranscriptStatus {
    QUEUED("queued"),

    PROCESSING("processing"),

    COMPLETED("completed");

    private final String value;

    TranscriptStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
