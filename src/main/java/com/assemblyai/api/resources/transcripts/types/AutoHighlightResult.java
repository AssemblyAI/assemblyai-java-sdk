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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = AutoHighlightResult.Builder.class)
public final class AutoHighlightResult {
    private final int count;

    private final double rank;

    private final String text;

    private final List<Timestamp> timestamps;

    private final Map<String, Object> additionalProperties;

    private AutoHighlightResult(
            int count, double rank, String text, List<Timestamp> timestamps, Map<String, Object> additionalProperties) {
        this.count = count;
        this.rank = rank;
        this.text = text;
        this.timestamps = timestamps;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The total number of times the key phrase appears in the audio file
     */
    @JsonProperty("count")
    public int getCount() {
        return count;
    }

    /**
     * @return The total relevancy to the overall audio file of this key phrase - a greater number means more relevant
     */
    @JsonProperty("rank")
    public double getRank() {
        return rank;
    }

    /**
     * @return The text itself of the key phrase
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return The timestamp of the of the key phrase
     */
    @JsonProperty("timestamps")
    public List<Timestamp> getTimestamps() {
        return timestamps;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AutoHighlightResult && equalTo((AutoHighlightResult) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(AutoHighlightResult other) {
        return count == other.count
                && rank == other.rank
                && text.equals(other.text)
                && timestamps.equals(other.timestamps);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.count, this.rank, this.text, this.timestamps);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CountStage builder() {
        return new Builder();
    }

    public interface CountStage {
        RankStage count(int count);

        Builder from(AutoHighlightResult other);
    }

    public interface RankStage {
        TextStage rank(double rank);
    }

    public interface TextStage {
        _FinalStage text(@NotNull String text);
    }

    public interface _FinalStage {
        AutoHighlightResult build();

        _FinalStage timestamps(List<Timestamp> timestamps);

        _FinalStage addTimestamps(Timestamp timestamps);

        _FinalStage addAllTimestamps(List<Timestamp> timestamps);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CountStage, RankStage, TextStage, _FinalStage {
        private int count;

        private double rank;

        private String text;

        private List<Timestamp> timestamps = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(AutoHighlightResult other) {
            count(other.getCount());
            rank(other.getRank());
            text(other.getText());
            timestamps(other.getTimestamps());
            return this;
        }

        /**
         * <p>The total number of times the key phrase appears in the audio file</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("count")
        public RankStage count(int count) {
            this.count = count;
            return this;
        }

        /**
         * <p>The total relevancy to the overall audio file of this key phrase - a greater number means more relevant</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("rank")
        public TextStage rank(double rank) {
            this.rank = rank;
            return this;
        }

        /**
         * <p>The text itself of the key phrase</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("text")
        public _FinalStage text(@NotNull String text) {
            this.text = Objects.requireNonNull(text, "text must not be null");
            return this;
        }

        /**
         * <p>The timestamp of the of the key phrase</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addAllTimestamps(List<Timestamp> timestamps) {
            this.timestamps.addAll(timestamps);
            return this;
        }

        /**
         * <p>The timestamp of the of the key phrase</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage addTimestamps(Timestamp timestamps) {
            this.timestamps.add(timestamps);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "timestamps", nulls = Nulls.SKIP)
        public _FinalStage timestamps(List<Timestamp> timestamps) {
            this.timestamps.clear();
            this.timestamps.addAll(timestamps);
            return this;
        }

        @java.lang.Override
        public AutoHighlightResult build() {
            return new AutoHighlightResult(count, rank, text, timestamps, additionalProperties);
        }
    }
}
