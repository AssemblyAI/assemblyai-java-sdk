package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RedactedAudioStatus {
    REDACTED_AUDIO_READY("redacted_audio_ready");

    private final String value;

    RedactedAudioStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
