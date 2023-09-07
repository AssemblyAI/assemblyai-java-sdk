package com.assemblyai.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TranscriptLanguageCode {
    EN("en"),

    EN_AU("en_au"),

    EN_UK("en_uk"),

    EN_US("en_us"),

    ES("es"),

    FR("fr"),

    DE("de"),

    IT("it"),

    PT("pt"),

    NL("nl"),

    HI("hi"),

    JA("ja"),

    ZH("zh"),

    FI("fi"),

    KO("ko"),

    PL("pl"),

    RU("ru"),

    TR("tr"),

    UK("uk"),

    VI("vi");

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
