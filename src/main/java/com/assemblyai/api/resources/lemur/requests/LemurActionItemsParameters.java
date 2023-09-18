package com.assemblyai.api.resources.lemur.requests;

import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.types.LemurModels;
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
@JsonDeserialize(builder = LemurActionItemsParameters.Builder.class)
public final class LemurActionItemsParameters {
    private final Optional<List<String>> transcriptIds;

    private final Optional<Object> context;

    private final Optional<LemurModels> finalModel;

    private final Optional<Integer> maxOutputSize;

    private LemurActionItemsParameters(
            Optional<List<String>> transcriptIds,
            Optional<Object> context,
            Optional<LemurModels> finalModel,
            Optional<Integer> maxOutputSize) {
        this.transcriptIds = transcriptIds;
        this.context = context;
        this.finalModel = finalModel;
        this.maxOutputSize = maxOutputSize;
    }

    /**
     * @return A list of completed transcripts with text. Up to 100 files max, or 100 hours max. Whichever is lower.
     */
    @JsonProperty("transcript_ids")
    public Optional<List<String>> getTranscriptIds() {
        return transcriptIds;
    }

    @JsonProperty("context")
    public Optional<Object> getContext() {
        return context;
    }

    @JsonProperty("final_model")
    public Optional<LemurModels> getFinalModel() {
        return finalModel;
    }

    /**
     * @return Max output size in tokens. Up to 4000 allowed.
     */
    @JsonProperty("max_output_size")
    public Optional<Integer> getMaxOutputSize() {
        return maxOutputSize;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LemurActionItemsParameters && equalTo((LemurActionItemsParameters) other);
    }

    private boolean equalTo(LemurActionItemsParameters other) {
        return transcriptIds.equals(other.transcriptIds)
                && context.equals(other.context)
                && finalModel.equals(other.finalModel)
                && maxOutputSize.equals(other.maxOutputSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.transcriptIds, this.context, this.finalModel, this.maxOutputSize);
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
        private Optional<List<String>> transcriptIds = Optional.empty();

        private Optional<Object> context = Optional.empty();

        private Optional<LemurModels> finalModel = Optional.empty();

        private Optional<Integer> maxOutputSize = Optional.empty();

        private Builder() {}

        public Builder from(LemurActionItemsParameters other) {
            transcriptIds(other.getTranscriptIds());
            context(other.getContext());
            finalModel(other.getFinalModel());
            maxOutputSize(other.getMaxOutputSize());
            return this;
        }

        @JsonSetter(value = "transcript_ids", nulls = Nulls.SKIP)
        public Builder transcriptIds(Optional<List<String>> transcriptIds) {
            this.transcriptIds = transcriptIds;
            return this;
        }

        public Builder transcriptIds(List<String> transcriptIds) {
            this.transcriptIds = Optional.of(transcriptIds);
            return this;
        }

        @JsonSetter(value = "context", nulls = Nulls.SKIP)
        public Builder context(Optional<Object> context) {
            this.context = context;
            return this;
        }

        public Builder context(Object context) {
            this.context = Optional.of(context);
            return this;
        }

        @JsonSetter(value = "final_model", nulls = Nulls.SKIP)
        public Builder finalModel(Optional<LemurModels> finalModel) {
            this.finalModel = finalModel;
            return this;
        }

        public Builder finalModel(LemurModels finalModel) {
            this.finalModel = Optional.of(finalModel);
            return this;
        }

        @JsonSetter(value = "max_output_size", nulls = Nulls.SKIP)
        public Builder maxOutputSize(Optional<Integer> maxOutputSize) {
            this.maxOutputSize = maxOutputSize;
            return this;
        }

        public Builder maxOutputSize(Integer maxOutputSize) {
            this.maxOutputSize = Optional.of(maxOutputSize);
            return this;
        }

        public LemurActionItemsParameters build() {
            return new LemurActionItemsParameters(transcriptIds, context, finalModel, maxOutputSize);
        }
    }
}
