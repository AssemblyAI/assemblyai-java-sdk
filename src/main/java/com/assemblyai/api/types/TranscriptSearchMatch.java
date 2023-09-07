package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TranscriptSearchMatch.Builder.class)
public final class TranscriptSearchMatch {
    private final String text;

    private final int count;

    private final List<List<Integer>> timestamps;

    private final List<Integer> indexes;

    private TranscriptSearchMatch(String text, int count, List<List<Integer>> timestamps, List<Integer> indexes) {
        this.text = text;
        this.count = count;
        this.timestamps = timestamps;
        this.indexes = indexes;
    }

    /**
     * @return The matched word
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return The total amount of times the word is in the transcript
     */
    @JsonProperty("count")
    public int getCount() {
        return count;
    }

    /**
     * @return An array of timestamps
     */
    @JsonProperty("timestamps")
    public List<List<Integer>> getTimestamps() {
        return timestamps;
    }

    /**
     * @return An array of all index locations for that word within the <code>words</code> array of the completed transcript
     */
    @JsonProperty("indexes")
    public List<Integer> getIndexes() {
        return indexes;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TranscriptSearchMatch && equalTo((TranscriptSearchMatch) other);
    }

    private boolean equalTo(TranscriptSearchMatch other) {
        return text.equals(other.text)
                && count == other.count
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

    public static TextStage builder() {
        return new Builder();
    }

    public interface TextStage {
        CountStage text(String text);

        Builder from(TranscriptSearchMatch other);
    }

    public interface CountStage {
        _FinalStage count(int count);
    }

    public interface _FinalStage {
        TranscriptSearchMatch build();

        _FinalStage timestamps(List<List<Integer>> timestamps);

        _FinalStage addTimestamps(List<Integer> timestamps);

        _FinalStage addAllTimestamps(List<List<Integer>> timestamps);

        _FinalStage indexes(List<Integer> indexes);

        _FinalStage addIndexes(Integer indexes);

        _FinalStage addAllIndexes(List<Integer> indexes);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, CountStage, _FinalStage {
        private String text;

        private int count;

        private List<Integer> indexes = new ArrayList<>();

        private List<List<Integer>> timestamps = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(TranscriptSearchMatch other) {
            text(other.getText());
            count(other.getCount());
            timestamps(other.getTimestamps());
            indexes(other.getIndexes());
            return this;
        }

        /**
         * <p>The matched word</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("text")
        public CountStage text(String text) {
            this.text = text;
            return this;
        }

        /**
         * <p>The total amount of times the word is in the transcript</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("count")
        public _FinalStage count(int count) {
            this.count = count;
            return this;
        }

        /**
         * <p>An array of all index locations for that word within the <code>words</code> array of the completed transcript</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllIndexes(List<Integer> indexes) {
            this.indexes.addAll(indexes);
            return this;
        }

        /**
         * <p>An array of all index locations for that word within the <code>words</code> array of the completed transcript</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addIndexes(Integer indexes) {
            this.indexes.add(indexes);
            return this;
        }

        @Override
        @JsonSetter(value = "indexes", nulls = Nulls.SKIP)
        public _FinalStage indexes(List<Integer> indexes) {
            this.indexes.clear();
            this.indexes.addAll(indexes);
            return this;
        }

        /**
         * <p>An array of timestamps</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllTimestamps(List<List<Integer>> timestamps) {
            this.timestamps.addAll(timestamps);
            return this;
        }

        /**
         * <p>An array of timestamps</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addTimestamps(List<Integer> timestamps) {
            this.timestamps.add(timestamps);
            return this;
        }

        @Override
        @JsonSetter(value = "timestamps", nulls = Nulls.SKIP)
        public _FinalStage timestamps(List<List<Integer>> timestamps) {
            this.timestamps.clear();
            this.timestamps.addAll(timestamps);
            return this;
        }

        @Override
        public TranscriptSearchMatch build() {
            return new TranscriptSearchMatch(text, count, timestamps, indexes);
        }
    }
}
