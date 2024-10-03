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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Chapter.Builder.class)
public final class Chapter {
    private final String gist;

    private final String headline;

    private final String summary;

    private final int start;

    private final int end;

    private final Map<String, Object> additionalProperties;

    private Chapter(
            String gist,
            String headline,
            String summary,
            int start,
            int end,
            Map<String, Object> additionalProperties) {
        this.gist = gist;
        this.headline = headline;
        this.summary = summary;
        this.start = start;
        this.end = end;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return An ultra-short summary (just a few words) of the content spoken in the chapter
     */
    @JsonProperty("gist")
    public String getGist() {
        return gist;
    }

    /**
     * @return A single sentence summary of the content spoken during the chapter
     */
    @JsonProperty("headline")
    public String getHeadline() {
        return headline;
    }

    /**
     * @return A one paragraph summary of the content spoken during the chapter
     */
    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    /**
     * @return The starting time, in milliseconds, for the chapter
     */
    @JsonProperty("start")
    public int getStart() {
        return start;
    }

    /**
     * @return The starting time, in milliseconds, for the chapter
     */
    @JsonProperty("end")
    public int getEnd() {
        return end;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Chapter && equalTo((Chapter) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Chapter other) {
        return gist.equals(other.gist)
                && headline.equals(other.headline)
                && summary.equals(other.summary)
                && start == other.start
                && end == other.end;
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.gist, this.headline, this.summary, this.start, this.end);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static GistStage builder() {
        return new Builder();
    }

    public interface GistStage {
        HeadlineStage gist(@NotNull String gist);

        Builder from(Chapter other);
    }

    public interface HeadlineStage {
        SummaryStage headline(@NotNull String headline);
    }

    public interface SummaryStage {
        StartStage summary(@NotNull String summary);
    }

    public interface StartStage {
        EndStage start(int start);
    }

    public interface EndStage {
        _FinalStage end(int end);
    }

    public interface _FinalStage {
        Chapter build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements GistStage, HeadlineStage, SummaryStage, StartStage, EndStage, _FinalStage {
        private String gist;

        private String headline;

        private String summary;

        private int start;

        private int end;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(Chapter other) {
            gist(other.getGist());
            headline(other.getHeadline());
            summary(other.getSummary());
            start(other.getStart());
            end(other.getEnd());
            return this;
        }

        /**
         * <p>An ultra-short summary (just a few words) of the content spoken in the chapter</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("gist")
        public HeadlineStage gist(@NotNull String gist) {
            this.gist = Objects.requireNonNull(gist, "gist must not be null");
            return this;
        }

        /**
         * <p>A single sentence summary of the content spoken during the chapter</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("headline")
        public SummaryStage headline(@NotNull String headline) {
            this.headline = Objects.requireNonNull(headline, "headline must not be null");
            return this;
        }

        /**
         * <p>A one paragraph summary of the content spoken during the chapter</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("summary")
        public StartStage summary(@NotNull String summary) {
            this.summary = Objects.requireNonNull(summary, "summary must not be null");
            return this;
        }

        /**
         * <p>The starting time, in milliseconds, for the chapter</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("start")
        public EndStage start(int start) {
            this.start = start;
            return this;
        }

        /**
         * <p>The starting time, in milliseconds, for the chapter</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("end")
        public _FinalStage end(int end) {
            this.end = end;
            return this;
        }

        @java.lang.Override
        public Chapter build() {
            return new Chapter(gist, headline, summary, start, end, additionalProperties);
        }
    }
}
