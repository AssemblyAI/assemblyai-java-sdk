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
@JsonDeserialize(builder = Chapter.Builder.class)
public final class Chapter {
    private final Optional<String> gist;

    private final Optional<String> headline;

    private final Optional<String> summary;

    private final Optional<Integer> start;

    private final Optional<Integer> end;

    private Chapter(
            Optional<String> gist,
            Optional<String> headline,
            Optional<String> summary,
            Optional<Integer> start,
            Optional<Integer> end) {
        this.gist = gist;
        this.headline = headline;
        this.summary = summary;
        this.start = start;
        this.end = end;
    }

    /**
     * @return An ultra-short summary (just a few words) of the content spoken in the chapter
     */
    @JsonProperty("gist")
    public Optional<String> getGist() {
        return gist;
    }

    /**
     * @return A single sentence summary of the content spoken during the chapter
     */
    @JsonProperty("headline")
    public Optional<String> getHeadline() {
        return headline;
    }

    /**
     * @return A one paragraph summary of the content spoken during the chapter
     */
    @JsonProperty("summary")
    public Optional<String> getSummary() {
        return summary;
    }

    /**
     * @return The starting time, in milliseconds, for the chapter
     */
    @JsonProperty("start")
    public Optional<Integer> getStart() {
        return start;
    }

    /**
     * @return The starting time, in milliseconds, for the chapter
     */
    @JsonProperty("end")
    public Optional<Integer> getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Chapter && equalTo((Chapter) other);
    }

    private boolean equalTo(Chapter other) {
        return gist.equals(other.gist)
                && headline.equals(other.headline)
                && summary.equals(other.summary)
                && start.equals(other.start)
                && end.equals(other.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.gist, this.headline, this.summary, this.start, this.end);
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
        private Optional<String> gist = Optional.empty();

        private Optional<String> headline = Optional.empty();

        private Optional<String> summary = Optional.empty();

        private Optional<Integer> start = Optional.empty();

        private Optional<Integer> end = Optional.empty();

        private Builder() {}

        public Builder from(Chapter other) {
            gist(other.getGist());
            headline(other.getHeadline());
            summary(other.getSummary());
            start(other.getStart());
            end(other.getEnd());
            return this;
        }

        @JsonSetter(value = "gist", nulls = Nulls.SKIP)
        public Builder gist(Optional<String> gist) {
            this.gist = gist;
            return this;
        }

        public Builder gist(String gist) {
            this.gist = Optional.of(gist);
            return this;
        }

        @JsonSetter(value = "headline", nulls = Nulls.SKIP)
        public Builder headline(Optional<String> headline) {
            this.headline = headline;
            return this;
        }

        public Builder headline(String headline) {
            this.headline = Optional.of(headline);
            return this;
        }

        @JsonSetter(value = "summary", nulls = Nulls.SKIP)
        public Builder summary(Optional<String> summary) {
            this.summary = summary;
            return this;
        }

        public Builder summary(String summary) {
            this.summary = Optional.of(summary);
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

        public Chapter build() {
            return new Chapter(gist, headline, summary, start, end);
        }
    }
}
