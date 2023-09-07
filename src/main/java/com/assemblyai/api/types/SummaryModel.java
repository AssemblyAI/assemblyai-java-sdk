package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SummaryModel {
    INFORMATIVE("informative"),

    CONVERSATIONAL("conversational"),

    CATCHY("catchy");

    private final String value;

    SummaryModel(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
