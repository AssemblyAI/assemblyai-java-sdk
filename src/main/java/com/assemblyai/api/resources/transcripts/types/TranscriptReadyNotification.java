/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.resources.transcripts.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TranscriptReadyNotification.Builder.class)
public final class TranscriptReadyNotification {
    private final String transcriptId;

    private final TranscriptReadyStatus status;

    private final Map<String, Object> additionalProperties;

    private TranscriptReadyNotification(
            String transcriptId, TranscriptReadyStatus status, Map<String, Object> additionalProperties) {
        this.transcriptId = transcriptId;
        this.status = status;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the transcript
     */
    @JsonProperty("transcript_id")
    public String getTranscriptId() {
        return transcriptId;
    }

    /**
     * @return The status of the transcript. Either completed or error.
     */
    @JsonProperty("status")
    public TranscriptReadyStatus getStatus() {
        return status;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptReadyNotification && equalTo((TranscriptReadyNotification) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TranscriptReadyNotification other) {
        return transcriptId.equals(other.transcriptId) && status.equals(other.status);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.transcriptId, this.status);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TranscriptIdStage builder() {
        return new Builder();
    }

    public interface TranscriptIdStage {
        StatusStage transcriptId(@NotNull String transcriptId);

        Builder from(TranscriptReadyNotification other);
    }

    public interface StatusStage {
        _FinalStage status(@NotNull TranscriptReadyStatus status);
    }

    public interface _FinalStage {
        TranscriptReadyNotification build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TranscriptIdStage, StatusStage, _FinalStage {
        private String transcriptId;

        private TranscriptReadyStatus status;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(TranscriptReadyNotification other) {
            transcriptId(other.getTranscriptId());
            status(other.getStatus());
            return this;
        }

        /**
         * <p>The ID of the transcript</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("transcript_id")
        public StatusStage transcriptId(@NotNull String transcriptId) {
            this.transcriptId = Objects.requireNonNull(transcriptId, "transcriptId must not be null");
            return this;
        }

        /**
         * <p>The status of the transcript. Either completed or error.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("status")
        public _FinalStage status(@NotNull TranscriptReadyStatus status) {
            this.status = Objects.requireNonNull(status, "status must not be null");
            return this;
        }

        @java.lang.Override
        public TranscriptReadyNotification build() {
            return new TranscriptReadyNotification(transcriptId, status, additionalProperties);
        }
    }
}
