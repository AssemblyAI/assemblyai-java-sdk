package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TranscriptListItem.Builder.class)
public final class TranscriptListItem {
    private final Optional<String> id;

    private final Optional<String> resourceUrl;

    private final Optional<TranscriptStatus> status;

    private final Optional<String> created;

    private final Optional<String> completed;

    private final Optional<String> audioUrl;

    private TranscriptListItem(
            Optional<String> id,
            Optional<String> resourceUrl,
            Optional<TranscriptStatus> status,
            Optional<String> created,
            Optional<String> completed,
            Optional<String> audioUrl) {
        this.id = id;
        this.resourceUrl = resourceUrl;
        this.status = status;
        this.created = created;
        this.completed = completed;
        this.audioUrl = audioUrl;
    }

    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("resource_url")
    public Optional<String> getResourceUrl() {
        return resourceUrl;
    }

    @JsonProperty("status")
    public Optional<TranscriptStatus> getStatus() {
        return status;
    }

    @JsonProperty("created")
    public Optional<String> getCreated() {
        return created;
    }

    @JsonProperty("completed")
    public Optional<String> getCompleted() {
        return completed;
    }

    @JsonProperty("audio_url")
    public Optional<String> getAudioUrl() {
        return audioUrl;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptListItem && equalTo((TranscriptListItem) other);
    }

    private boolean equalTo(TranscriptListItem other) {
        return id.equals(other.id)
                && resourceUrl.equals(other.resourceUrl)
                && status.equals(other.status)
                && created.equals(other.created)
                && completed.equals(other.completed)
                && audioUrl.equals(other.audioUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.resourceUrl, this.status, this.created, this.completed, this.audioUrl);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> resourceUrl = Optional.empty();

        private Optional<TranscriptStatus> status = Optional.empty();

        private Optional<String> created = Optional.empty();

        private Optional<String> completed = Optional.empty();

        private Optional<String> audioUrl = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptListItem other) {
            id(other.getId());
            resourceUrl(other.getResourceUrl());
            status(other.getStatus());
            created(other.getCreated());
            completed(other.getCompleted());
            audioUrl(other.getAudioUrl());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "resource_url", nulls = Nulls.SKIP)
        public Builder resourceUrl(Optional<String> resourceUrl) {
            this.resourceUrl = resourceUrl;
            return this;
        }

        public Builder resourceUrl(String resourceUrl) {
            this.resourceUrl = Optional.of(resourceUrl);
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<TranscriptStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(TranscriptStatus status) {
            this.status = Optional.of(status);
            return this;
        }

        @JsonSetter(value = "created", nulls = Nulls.SKIP)
        public Builder created(Optional<String> created) {
            this.created = created;
            return this;
        }

        public Builder created(String created) {
            this.created = Optional.of(created);
            return this;
        }

        @JsonSetter(value = "completed", nulls = Nulls.SKIP)
        public Builder completed(Optional<String> completed) {
            this.completed = completed;
            return this;
        }

        public Builder completed(String completed) {
            this.completed = Optional.of(completed);
            return this;
        }

        @JsonSetter(value = "audio_url", nulls = Nulls.SKIP)
        public Builder audioUrl(Optional<String> audioUrl) {
            this.audioUrl = audioUrl;
            return this;
        }

        public Builder audioUrl(String audioUrl) {
            this.audioUrl = Optional.of(audioUrl);
            return this;
        }

        public TranscriptListItem build() {
            return new TranscriptListItem(id, resourceUrl, status, created, completed, audioUrl);
        }
    }
}
