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
@JsonDeserialize(builder = Timestamp.Builder.class)
public final class Timestamp {
    private final Optional<Integer> start;

    private final Optional<Integer> end;

    private Timestamp(Optional<Integer> start, Optional<Integer> end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @return The start time in milliseconds
     */
    @JsonProperty("start")
    public Optional<Integer> getStart() {
        return start;
    }

    /**
     * @return The end time in milliseconds
     */
    @JsonProperty("end")
    public Optional<Integer> getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Timestamp && equalTo((Timestamp) other);
    }

    private boolean equalTo(Timestamp other) {
        return start.equals(other.start) && end.equals(other.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.start, this.end);
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
        private Optional<Integer> start = Optional.empty();

        private Optional<Integer> end = Optional.empty();

        private Builder() {}

        public Builder from(Timestamp other) {
            start(other.getStart());
            end(other.getEnd());
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

        public Timestamp build() {
            return new Timestamp(start, end);
        }
    }
}
