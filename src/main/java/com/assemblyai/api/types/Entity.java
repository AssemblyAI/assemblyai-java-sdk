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
@JsonDeserialize(builder = Entity.Builder.class)
public final class Entity {
    private final Optional<String> entityType;

    private final Optional<String> text;

    private final Optional<Integer> start;

    private final Optional<Integer> end;

    private Entity(Optional<String> entityType, Optional<String> text, Optional<Integer> start, Optional<Integer> end) {
        this.entityType = entityType;
        this.text = text;
        this.start = start;
        this.end = end;
    }

    /**
     * @return The type of entity for the detected entity
     */
    @JsonProperty("entity_type")
    public Optional<String> getEntityType() {
        return entityType;
    }

    /**
     * @return The text for the detected entity
     */
    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    /**
     * @return The starting time, in milliseconds, at which the detected entity appears in the audio file
     */
    @JsonProperty("start")
    public Optional<Integer> getStart() {
        return start;
    }

    /**
     * @return The ending time, in milliseconds, for the detected entity in the audio file
     */
    @JsonProperty("end")
    public Optional<Integer> getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Entity && equalTo((Entity) other);
    }

    private boolean equalTo(Entity other) {
        return entityType.equals(other.entityType)
                && text.equals(other.text)
                && start.equals(other.start)
                && end.equals(other.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.entityType, this.text, this.start, this.end);
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
        private Optional<String> entityType = Optional.empty();

        private Optional<String> text = Optional.empty();

        private Optional<Integer> start = Optional.empty();

        private Optional<Integer> end = Optional.empty();

        private Builder() {}

        public Builder from(Entity other) {
            entityType(other.getEntityType());
            text(other.getText());
            start(other.getStart());
            end(other.getEnd());
            return this;
        }

        @JsonSetter(value = "entity_type", nulls = Nulls.SKIP)
        public Builder entityType(Optional<String> entityType) {
            this.entityType = entityType;
            return this;
        }

        public Builder entityType(String entityType) {
            this.entityType = Optional.of(entityType);
            return this;
        }

        @JsonSetter(value = "text", nulls = Nulls.SKIP)
        public Builder text(Optional<String> text) {
            this.text = text;
            return this;
        }

        public Builder text(String text) {
            this.text = Optional.of(text);
            return this;
        }

        @JsonSetter(value = "start", nulls = Nulls.SKIP)
        public Builder start(Optional<Integer> start) {
            this.start = start;
            return this;
        }

        public Builder start(Integer start) {
            this.start = Optional.of(start);
            return this;
        }

        @JsonSetter(value = "end", nulls = Nulls.SKIP)
        public Builder end(Optional<Integer> end) {
            this.end = end;
            return this;
        }

        public Builder end(Integer end) {
            this.end = Optional.of(end);
            return this;
        }

        public Entity build() {
            return new Entity(entityType, text, start, end);
        }
    }
}
