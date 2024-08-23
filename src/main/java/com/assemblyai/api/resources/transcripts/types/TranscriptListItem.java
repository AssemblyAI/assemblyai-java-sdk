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
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = TranscriptListItem.Builder.class)
public final class TranscriptListItem {
    private final String id;

    private final String resourceUrl;

    private final TranscriptStatus status;

    private final OffsetDateTime created;

    private final Optional<OffsetDateTime> completed;

    private final String audioUrl;

    private final Optional<String> error;

    private final Map<String, Object> additionalProperties;

    private TranscriptListItem(
            String id,
            String resourceUrl,
            TranscriptStatus status,
            OffsetDateTime created,
            Optional<OffsetDateTime> completed,
            String audioUrl,
            Optional<String> error,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.resourceUrl = resourceUrl;
        this.status = status;
        this.created = created;
        this.completed = completed;
        this.audioUrl = audioUrl;
        this.error = error;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("resource_url")
    public String getResourceUrl() {
        return resourceUrl;
    }

    @JsonProperty("status")
    public TranscriptStatus getStatus() {
        return status;
    }

    @JsonProperty("created")
    public OffsetDateTime getCreated() {
        return created;
    }

    @JsonProperty("completed")
    public Optional<OffsetDateTime> getCompleted() {
        return completed;
    }

    @JsonProperty("audio_url")
    public String getAudioUrl() {
        return audioUrl;
    }

    /**
     * @return Error message of why the transcript failed
     */
    @JsonProperty("error")
    public Optional<String> getError() {
        return error;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptListItem && equalTo((TranscriptListItem) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TranscriptListItem other) {
        return id.equals(other.id)
                && resourceUrl.equals(other.resourceUrl)
                && status.equals(other.status)
                && created.equals(other.created)
                && completed.equals(other.completed)
                && audioUrl.equals(other.audioUrl)
                && error.equals(other.error);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id, this.resourceUrl, this.status, this.created, this.completed, this.audioUrl, this.error);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        ResourceUrlStage id(String id);

        Builder from(TranscriptListItem other);
    }

    public interface ResourceUrlStage {
        StatusStage resourceUrl(String resourceUrl);
    }

    public interface StatusStage {
        CreatedStage status(TranscriptStatus status);
    }

    public interface CreatedStage {
        AudioUrlStage created(OffsetDateTime created);
    }

    public interface AudioUrlStage {
        _FinalStage audioUrl(String audioUrl);
    }

    public interface _FinalStage {
        TranscriptListItem build();

        _FinalStage completed(Optional<OffsetDateTime> completed);

        _FinalStage completed(OffsetDateTime completed);

        _FinalStage error(Optional<String> error);

        _FinalStage error(String error);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdStage, ResourceUrlStage, StatusStage, CreatedStage, AudioUrlStage, _FinalStage {
        private String id;

        private String resourceUrl;

        private TranscriptStatus status;

        private OffsetDateTime created;

        private String audioUrl;

        private Optional<String> error = Optional.empty();

        private Optional<OffsetDateTime> completed = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(TranscriptListItem other) {
            id(other.getId());
            resourceUrl(other.getResourceUrl());
            status(other.getStatus());
            created(other.getCreated());
            completed(other.getCompleted());
            audioUrl(other.getAudioUrl());
            error(other.getError());
            return this;
        }

        @java.lang.Override
        @JsonSetter("id")
        public ResourceUrlStage id(String id) {
            this.id = id;
            return this;
        }

        @java.lang.Override
        @JsonSetter("resource_url")
        public StatusStage resourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
            return this;
        }

        @java.lang.Override
        @JsonSetter("status")
        public CreatedStage status(TranscriptStatus status) {
            this.status = status;
            return this;
        }

        @java.lang.Override
        @JsonSetter("created")
        public AudioUrlStage created(OffsetDateTime created) {
            this.created = created;
            return this;
        }

        @java.lang.Override
        @JsonSetter("audio_url")
        public _FinalStage audioUrl(String audioUrl) {
            this.audioUrl = audioUrl;
            return this;
        }

        /**
         * <p>Error message of why the transcript failed</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage error(String error) {
            this.error = Optional.ofNullable(error);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "error", nulls = Nulls.SKIP)
        public _FinalStage error(Optional<String> error) {
            this.error = error;
            return this;
        }

        @java.lang.Override
        public _FinalStage completed(OffsetDateTime completed) {
            this.completed = Optional.ofNullable(completed);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "completed", nulls = Nulls.SKIP)
        public _FinalStage completed(Optional<OffsetDateTime> completed) {
            this.completed = completed;
            return this;
        }

        @java.lang.Override
        public TranscriptListItem build() {
            return new TranscriptListItem(
                    id, resourceUrl, status, created, completed, audioUrl, error, additionalProperties);
        }
    }
}
