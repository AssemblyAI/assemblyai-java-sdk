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
@JsonDeserialize(builder = TranscriptSearchMatch.Builder.class)
public final class TranscriptSearchMatch {
    private final Optional<String> text;

    private final Optional<Integer> count;

    private final Optional<List<List<Integer>>> timestamps;

    private final Optional<List<Integer>> indexes;

    private TranscriptSearchMatch(
            Optional<String> text,
            Optional<Integer> count,
            Optional<List<List<Integer>>> timestamps,
            Optional<List<Integer>> indexes) {
        this.text = text;
        this.count = count;
        this.timestamps = timestamps;
        this.indexes = indexes;
    }

    /**
     * @return The matched word
     */
    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    /**
     * @return The total amount of times the word is in the transcript
     */
    @JsonProperty("count")
    public Optional<Integer> getCount() {
        return count;
    }

    /**
     * @return An array of timestamps
     */
    @JsonProperty("timestamps")
    public Optional<List<List<Integer>>> getTimestamps() {
        return timestamps;
    }

    /**
     * @return An array of all index locations for that word within the <code>words</code> array of the completed transcript
     */
    @JsonProperty("indexes")
    public Optional<List<Integer>> getIndexes() {
        return indexes;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptSearchMatch && equalTo((TranscriptSearchMatch) other);
    }

    private boolean equalTo(TranscriptSearchMatch other) {
        return text.equals(other.text)
                && count.equals(other.count)
                && timestamps.equals(other.timestamps)
                && indexes.equals(other.indexes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.count, this.timestamps, this.indexes);
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
        private Optional<String> text = Optional.empty();

        private Optional<Integer> count = Optional.empty();

        private Optional<List<List<Integer>>> timestamps = Optional.empty();

        private Optional<List<Integer>> indexes = Optional.empty();

        private Builder() {}

        public Builder from(TranscriptSearchMatch other) {
            text(other.getText());
            count(other.getCount());
            timestamps(other.getTimestamps());
            indexes(other.getIndexes());
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

        @JsonSetter(value = "count", nulls = Nulls.SKIP)
        public Builder count(Optional<Integer> count) {
            this.count = count;
            return this;
        }

        public Builder count(Integer count) {
            this.count = Optional.of(count);
            return this;
        }

        @JsonSetter(value = "timestamps", nulls = Nulls.SKIP)
        public Builder timestamps(Optional<List<List<Integer>>> timestamps) {
            this.timestamps = timestamps;
            return this;
        }

        public Builder timestamps(List<List<Integer>> timestamps) {
            this.timestamps = Optional.of(timestamps);
            return this;
        }

        @JsonSetter(value = "indexes", nulls = Nulls.SKIP)
        public Builder indexes(Optional<List<Integer>> indexes) {
            this.indexes = indexes;
            return this;
        }

        public Builder indexes(List<Integer> indexes) {
            this.indexes = Optional.of(indexes);
            return this;
        }

        public TranscriptSearchMatch build() {
            return new TranscriptSearchMatch(text, count, timestamps, indexes);
        }
    }
}
