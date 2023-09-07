package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SubstitutionPolicy {
    ENTITY_TYPE("entity_type"),

    HASH("hash");

    private final String value;

    SubstitutionPolicy(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
