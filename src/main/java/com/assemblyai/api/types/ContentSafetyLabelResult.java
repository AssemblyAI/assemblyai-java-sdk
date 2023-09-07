package com.assemblyai.api.types;

import com.assemblyai.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ContentSafetyLabelResult.Builder.class)
public final class ContentSafetyLabelResult {
    private final Optional<String> text;

    private final Optional<List<ContentSafetyLabel>> labels;

    private final Optional<Integer> sentencesIdxStart;

    private final Optional<Integer> sentencesIdxEnd;

    private final Optional<Timestamp> timestamp;

    private final Optional<Map<String, Double>> summary;

    private final Optional<Map<String, ContentSafetyLabelResultSeverityScoreSummaryValue>> severityScoreSummary;

    private ContentSafetyLabelResult(
            Optional<String> text,
            Optional<List<ContentSafetyLabel>> labels,
            Optional<Integer> sentencesIdxStart,
            Optional<Integer> sentencesIdxEnd,
            Optional<Timestamp> timestamp,
            Optional<Map<String, Double>> summary,
            Optional<Map<String, ContentSafetyLabelResultSeverityScoreSummaryValue>> severityScoreSummary) {
        this.text = text;
        this.labels = labels;
        this.sentencesIdxStart = sentencesIdxStart;
        this.sentencesIdxEnd = sentencesIdxEnd;
        this.timestamp = timestamp;
        this.summary = summary;
        this.severityScoreSummary = severityScoreSummary;
    }

    /**
     * @return The transcript of the section flagged by the Content Moderation model
     */
    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    /**
     * @return An array of objects, one per sensitive topic that was detected in the section
     */
    @JsonProperty("labels")
    public Optional<List<ContentSafetyLabel>> getLabels() {
        return labels;
    }

    /**
     * @return The sentence index at which the section begins
     */
    @JsonProperty("sentences_idx_start")
    public Optional<Integer> getSentencesIdxStart() {
        return sentencesIdxStart;
    }

    /**
     * @return The sentence index at which the section ends
     */
    @JsonProperty("sentences_idx_end")
    public Optional<Integer> getSentencesIdxEnd() {
        return sentencesIdxEnd;
    }

    /**
     * @return Timestamp information for the section
     */
    @JsonProperty("timestamp")
    public Optional<Timestamp> getTimestamp() {
        return timestamp;
    }

    /**
     * @return A summary of the Content Moderation confidence results for the entire audio file
     */
    @JsonProperty("summary")
    public Optional<Map<String, Double>> getSummary() {
        return summary;
    }

    /**
     * @return A summary of the Content Moderation severity results for the entire audio file
     */
    @JsonProperty("severity_score_summary")
    public Optional<Map<String, ContentSafetyLabelResultSeverityScoreSummaryValue>> getSeverityScoreSummary() {
        return severityScoreSummary;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentSafetyLabelResult && equalTo((ContentSafetyLabelResult) other);
    }

    private boolean equalTo(ContentSafetyLabelResult other) {
        return text.equals(other.text)
                && labels.equals(other.labels)
                && sentencesIdxStart.equals(other.sentencesIdxStart)
                && sentencesIdxEnd.equals(other.sentencesIdxEnd)
                && timestamp.equals(other.timestamp)
                && summary.equals(other.summary)
                && severityScoreSummary.equals(other.severityScoreSummary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.text,
                this.labels,
                this.sentencesIdxStart,
                this.sentencesIdxEnd,
                this.timestamp,
                this.summary,
                this.severityScoreSummary);
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

        private Optional<List<ContentSafetyLabel>> labels = Optional.empty();

        private Optional<Integer> sentencesIdxStart = Optional.empty();

        private Optional<Integer> sentencesIdxEnd = Optional.empty();

        private Optional<Timestamp> timestamp = Optional.empty();

        private Optional<Map<String, Double>> summary = Optional.empty();

        private Optional<Map<String, ContentSafetyLabelResultSeverityScoreSummaryValue>> severityScoreSummary =
                Optional.empty();

        private Builder() {}

        public Builder from(ContentSafetyLabelResult other) {
            text(other.getText());
            labels(other.getLabels());
            sentencesIdxStart(other.getSentencesIdxStart());
            sentencesIdxEnd(other.getSentencesIdxEnd());
            timestamp(other.getTimestamp());
            summary(other.getSummary());
            severityScoreSummary(other.getSeverityScoreSummary());
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

        @JsonSetter(value = "labels", nulls = Nulls.SKIP)
        public Builder labels(Optional<List<ContentSafetyLabel>> labels) {
            this.labels = labels;
            return this;
        }

        public Builder labels(List<ContentSafetyLabel> labels) {
            this.labels = Optional.of(labels);
            return this;
        }

        @JsonSetter(value = "sentences_idx_start", nulls = Nulls.SKIP)
        public Builder sentencesIdxStart(Optional<Integer> sentencesIdxStart) {
            this.sentencesIdxStart = sentencesIdxStart;
            return this;
        }

        public Builder sentencesIdxStart(Integer sentencesIdxStart) {
            this.sentencesIdxStart = Optional.of(sentencesIdxStart);
            return this;
        }

        @JsonSetter(value = "sentences_idx_end", nulls = Nulls.SKIP)
        public Builder sentencesIdxEnd(Optional<Integer> sentencesIdxEnd) {
            this.sentencesIdxEnd = sentencesIdxEnd;
            return this;
        }

        public Builder sentencesIdxEnd(Integer sentencesIdxEnd) {
            this.sentencesIdxEnd = Optional.of(sentencesIdxEnd);
            return this;
        }

        @JsonSetter(value = "timestamp", nulls = Nulls.SKIP)
        public Builder timestamp(Optional<Timestamp> timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder timestamp(Timestamp timestamp) {
            this.timestamp = Optional.of(timestamp);
            return this;
        }

        @JsonSetter(value = "summary", nulls = Nulls.SKIP)
        public Builder summary(Optional<Map<String, Double>> summary) {
            this.summary = summary;
            return this;
        }

        public Builder summary(Map<String, Double> summary) {
            this.summary = Optional.of(summary);
            return this;
        }

        @JsonSetter(value = "severity_score_summary", nulls = Nulls.SKIP)
        public Builder severityScoreSummary(
                Optional<Map<String, ContentSafetyLabelResultSeverityScoreSummaryValue>> severityScoreSummary) {
            this.severityScoreSummary = severityScoreSummary;
            return this;
        }

        public Builder severityScoreSummary(
                Map<String, ContentSafetyLabelResultSeverityScoreSummaryValue> severityScoreSummary) {
            this.severityScoreSummary = Optional.of(severityScoreSummary);
            return this;
        }

        public ContentSafetyLabelResult build() {
            return new ContentSafetyLabelResult(
                    text, labels, sentencesIdxStart, sentencesIdxEnd, timestamp, summary, severityScoreSummary);
        }
    }
}
