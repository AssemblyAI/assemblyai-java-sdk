package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TranscriptCustomSpelling.Builder.class)
public final class TranscriptCustomSpelling {
    private final Optional<List<String>> from;

    private final Optional<String> to;

    private TranscriptCustomSpelling(Optional<List<String>> from, Optional<String> to) {
        this.from = from;
        this.to = to;
    }

    @JsonProperty("from")
    public Optional<List<String>> getFrom() {
        return from;
    }

    @JsonProperty("to")
    public Optional<String> getTo() {
        return to;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptCustomSpelling && equalTo((TranscriptCustomSpelling) other);
    }

    private boolean equalTo(TranscriptCustomSpelling other) {
        return from.equals(other.from) && to.equals(other.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.from, this.to);
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
        private Optional<List<String>> from = Optional.empty();

        private Optional<String> to = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptCustomSpelling other) {
            from(other.getFrom());
            to(other.getTo());
            return this;
        }

        @JsonSetter(value = "from", nulls = Nulls.SKIP)
        public Builder from(Optional<List<String>> from) {
            this.from = from;
            return this;
        }

        public Builder from(List<String> from) {
            this.from = Optional.of(from);
            return this;
        }

        @JsonSetter(value = "to", nulls = Nulls.SKIP)
        public Builder to(Optional<String> to) {
            this.to = to;
            return this;
        }

        public Builder to(String to) {
            this.to = Optional.of(to);
            return this;
        }

        public TranscriptCustomSpelling build() {
            return new TranscriptCustomSpelling(from, to);
        }
    }
}
