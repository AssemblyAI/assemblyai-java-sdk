package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SentimentAnalysisResultSentiment {
    POSITIVE("POSITIVE"),

    NEUTRAL("NEUTRAL"),

    NEGATIVE("NEGATIVE");

    private final String value;

    SentimentAnalysisResultSentiment(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
