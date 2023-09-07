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
@JsonDeserialize(builder = AutoHighlightsResultResultsItem.Builder.class)
public final class AutoHighlightsResultResultsItem {
    private final Optional<Integer> count;

    private final Optional<Double> rank;

    private final Optional<String> text;

    private final Optional<List<Timestamp>> timestamps;

    private AutoHighlightsResultResultsItem(
            Optional<Integer> count,
            Optional<Double> rank,
            Optional<String> text,
            Optional<List<Timestamp>> timestamps) {
        this.count = count;
        this.rank = rank;
        this.text = text;
        this.timestamps = timestamps;
    }

    /**
     * @return The total number of times the key phrase appears in the audio file
     */
    @JsonProperty("count")
    public Optional<Integer> getCount() {
        return count;
    }

    /**
     * @return The total relevancy to the overall audio file of this key phrase - a greater number means more relevant
     */
    @JsonProperty("rank")
    public Optional<Double> getRank() {
        return rank;
    }

    /**
     * @return The text itself of the key phrase
     */
    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    /**
     * @return The timestamp of the of the key phrase
     */
    @JsonProperty("timestamps")
    public Optional<List<Timestamp>> getTimestamps() {
        return timestamps;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AutoHighlightsResultResultsItem && equalTo((AutoHighlightsResultResultsItem) other);
    }

    private boolean equalTo(AutoHighlightsResultResultsItem other) {
        return count.equals(other.count)
                && rank.equals(other.rank)
                && text.equals(other.text)
                && timestamps.equals(other.timestamps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.count, this.rank, this.text, this.timestamps);
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
        private Optional<Integer> count = Optional.empty();

        private Optional<Double> rank = Optional.empty();

        private Optional<String> text = Optional.empty();

        private Optional<List<Timestamp>> timestamps = Optional.empty();

        private Builder() {}

        public Builder from(AutoHighlightsResultResultsItem other) {
            count(other.getCount());
            rank(other.getRank());
            text(other.getText());
            timestamps(other.getTimestamps());
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

        @JsonSetter(value = "rank", nulls = Nulls.SKIP)
        public Builder rank(Optional<Double> rank) {
            this.rank = rank;
            return this;
        }

        public Builder rank(Double rank) {
            this.rank = Optional.of(rank);
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

        @JsonSetter(value = "timestamps", nulls = Nulls.SKIP)
        public Builder timestamps(Optional<List<Timestamp>> timestamps) {
            this.timestamps = timestamps;
            return this;
        }

        public Builder timestamps(List<Timestamp> timestamps) {
            this.timestamps = Optional.of(timestamps);
            return this;
        }

        public AutoHighlightsResultResultsItem build() {
            return new AutoHighlightsResultResultsItem(count, rank, text, timestamps);
        }
    }
}
