package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TranscriptBoostParam {
    LOW("low"),

    DEFAULT("default"),

    HIGH("high");

    private final String value;

    TranscriptBoostParam(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
