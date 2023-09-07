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
@JsonDeserialize(builder = TranscriptCustomSpelling.Builder.class)
public final class TranscriptCustomSpelling {
    private final List<String> from;

    private final String to;

    private TranscriptCustomSpelling(List<String> from, String to) {
        this.from = from;
        this.to = to;
    }

    /**
     * @return Words or phrases to replace
     */
    @JsonProperty("from")
    public List<String> getFrom() {
        return from;
    }

    /**
     * @return Word or phrase to replace with
     */
    @JsonProperty("to")
    public String getTo() {
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

    public static ToStage builder() {
        return new Builder();
    }

    public interface ToStage {
        _FinalStage to(String to);

        Builder from(TranscriptCustomSpelling other);
    }

    public interface _FinalStage {
        TranscriptCustomSpelling build();

        _FinalStage from(List<String> from);

        _FinalStage addFrom(String from);

        _FinalStage addAllFrom(List<String> from);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ToStage, _FinalStage {
        private String to;

        private List<String> from = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(TranscriptCustomSpelling other) {
            from(other.getFrom());
            to(other.getTo());
            return this;
        }

        /**
         * <p>Word or phrase to replace with</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("to")
        public _FinalStage to(String to) {
            this.to = to;
            return this;
        }

        /**
         * <p>Words or phrases to replace</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllFrom(List<String> from) {
            this.from.addAll(from);
            return this;
        }

        /**
         * <p>Words or phrases to replace</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addFrom(String from) {
            this.from.add(from);
            return this;
        }

        @Override
        @JsonSetter(value = "from", nulls = Nulls.SKIP)
        public _FinalStage from(List<String> from) {
            this.from.clear();
            this.from.addAll(from);
            return this;
        }

        @Override
        public TranscriptCustomSpelling build() {
            return new TranscriptCustomSpelling(from, to);
        }
    }
}
