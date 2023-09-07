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
@JsonDeserialize(builder = ContentSafetyLabelResultSeverityScoreSummaryValue.Builder.class)
public final class ContentSafetyLabelResultSeverityScoreSummaryValue {
    private final Optional<Double> low;

    private final Optional<Double> medium;

    private final Optional<Double> high;

    private ContentSafetyLabelResultSeverityScoreSummaryValue(
            Optional<Double> low, Optional<Double> medium, Optional<Double> high) {
        this.low = low;
        this.medium = medium;
        this.high = high;
    }

    @JsonProperty("low")
    public Optional<Double> getLow() {
        return low;
    }

    @JsonProperty("medium")
    public Optional<Double> getMedium() {
        return medium;
    }

    @JsonProperty("high")
    public Optional<Double> getHigh() {
        return high;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ContentSafetyLabelResultSeverityScoreSummaryValue
                && equalTo((ContentSafetyLabelResultSeverityScoreSummaryValue) other);
    }

    private boolean equalTo(ContentSafetyLabelResultSeverityScoreSummaryValue other) {
        return low.equals(other.low) && medium.equals(other.medium) && high.equals(other.high);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.low, this.medium, this.high);
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
        private Optional<Double> low = Optional.empty();

        private Optional<Double> medium = Optional.empty();

        private Optional<Double> high = Optional.empty();

        private Builder() {}

        public Builder from(ContentSafetyLabelResultSeverityScoreSummaryValue other) {
            low(other.getLow());
            medium(other.getMedium());
            high(other.getHigh());
            return this;
        }

        @JsonSetter(value = "low", nulls = Nulls.SKIP)
        public Builder low(Optional<Double> low) {
            this.low = low;
            return this;
        }

        public Builder low(Double low) {
            this.low = Optional.of(low);
            return this;
        }

        @JsonSetter(value = "medium", nulls = Nulls.SKIP)
        public Builder medium(Optional<Double> medium) {
            this.medium = medium;
            return this;
        }

        public Builder medium(Double medium) {
            this.medium = Optional.of(medium);
            return this;
        }

        @JsonSetter(value = "high", nulls = Nulls.SKIP)
        public Builder high(Optional<Double> high) {
            this.high = high;
            return this;
        }

        public Builder high(Double high) {
            this.high = Optional.of(high);
            return this;
        }

        public ContentSafetyLabelResultSeverityScoreSummaryValue build() {
            return new ContentSafetyLabelResultSeverityScoreSummaryValue(low, medium, high);
        }
    }
}
