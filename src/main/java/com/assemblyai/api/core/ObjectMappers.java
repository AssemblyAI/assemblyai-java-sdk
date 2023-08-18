package com.assemblyai.api.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;

public final class ObjectMappers {
    public static final ObjectMapper JSON_MAPPER = JsonMapper.builder()
            .addModule(new Jdk8Module())
            .addModule(new JavaTimeModule())
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .build();

    private ObjectMappers() {}

    public static String stringify(Object o) {
        try {
            return JSON_MAPPER
                    .setSerializationInclusion(JsonInclude.Include.ALWAYS)
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(o);
        } catch (IOException e) {
            return o.getClass().getName() + "@" + Integer.toHexString(o.hashCode());
        }
    }
}
