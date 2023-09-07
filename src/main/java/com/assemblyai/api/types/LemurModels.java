package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LemurModels {
    DEFAULT("default"),

    BASIC("basic");

    private final String value;

    LemurModels(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
