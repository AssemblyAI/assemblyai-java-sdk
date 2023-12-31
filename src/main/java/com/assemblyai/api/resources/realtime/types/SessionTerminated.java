/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.realtime.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.Map;

public final class SessionTerminated {

    @JsonSetter("message_type")
    private final String messageType = "SessionTerminated";
    private final Map<String, Object> additionalProperties;

    private SessionTerminated(String messageType, Map<String, Object> additionalProperties) {
        if (!messageType.equals("SessionTerminated")) {
            throw new IllegalArgumentException("messageType must be SessionTerminated");
        }
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("message_type")
    public String getMessageType() {
        return "SessionTerminated";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SessionTerminated;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }
}
