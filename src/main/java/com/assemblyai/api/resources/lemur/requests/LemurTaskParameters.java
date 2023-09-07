package com.assemblyai.api.resources.lemur.requests;

import com.assemblyai.api.core.ObjectMappers;
import com.assemblyai.api.types.LemurModels;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LemurTaskParameters.Builder.class)
public final class LemurTaskParameters {
    private final List<String> transcriptIds;

    private final String prompt;

    private final Optional<Object> context;

    private final Optional<LemurModels> finalModel;

    private final Optional<Integer> maxOutputSize;

    private LemurTaskParameters(
            List<String> transcriptIds,
            String prompt,
            Optional<Object> context,
            Optional<LemurModels> finalModel,
            Optional<Integer> maxOutputSize) {
        this.transcriptIds = transcriptIds;
        this.prompt = prompt;
        this.context = context;
        this.finalModel = finalModel;
        this.maxOutputSize = maxOutputSize;
    }

    /**
     * @return A list of completed transcripts with text. Up to 100 files max, or 100 hours max. Whichever is lower.
     */
    @JsonProperty("transcript_ids")
    public List<String> getTranscriptIds() {
        return transcriptIds;
    }

    /**
     * @return Your text to prompt the model to produce a desired output, including any context you want to pass into the model.
     */
    @JsonProperty("prompt")
    public String getPrompt() {
        return prompt;
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
        return other instanceof LemurTaskParameters && equalTo((LemurTaskParameters) other);
    }

    private boolean equalTo(LemurTaskParameters other) {
        return transcriptIds.equals(other.transcriptIds)
                && prompt.equals(other.prompt)
                && context.equals(other.context)
                && finalModel.equals(other.finalModel)
                && maxOutputSize.equals(other.maxOutputSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.transcriptIds, this.prompt, this.context, this.finalModel, this.maxOutputSize);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PromptStage builder() {
        return new Builder();
    }

    public interface PromptStage {
        _FinalStage prompt(String prompt);

        Builder from(LemurTaskParameters other);
    }

    public interface _FinalStage {
        LemurTaskParameters build();

        _FinalStage transcriptIds(List<String> transcriptIds);

        _FinalStage addTranscriptIds(String transcriptIds);

        _FinalStage addAllTranscriptIds(List<String> transcriptIds);

        _FinalStage context(Optional<Object> context);

        _FinalStage context(Object context);

        _FinalStage finalModel(Optional<LemurModels> finalModel);

        _FinalStage finalModel(LemurModels finalModel);

        _FinalStage maxOutputSize(Optional<Integer> maxOutputSize);

        _FinalStage maxOutputSize(Integer maxOutputSize);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PromptStage, _FinalStage {
        private String prompt;

        private Optional<Integer> maxOutputSize = Optional.empty();

        private Optional<LemurModels> finalModel = Optional.empty();

        private Optional<Object> context = Optional.empty();

        private List<String> transcriptIds = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(LemurTaskParameters other) {
            transcriptIds(other.getTranscriptIds());
            prompt(other.getPrompt());
            context(other.getContext());
            finalModel(other.getFinalModel());
            maxOutputSize(other.getMaxOutputSize());
            return this;
        }

        /**
         * <p>Your text to prompt the model to produce a desired output, including any context you want to pass into the model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("prompt")
        public _FinalStage prompt(String prompt) {
            this.prompt = prompt;
            return this;
        }

        /**
         * <p>Max output size in tokens. Up to 4000 allowed.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage maxOutputSize(Integer maxOutputSize) {
            this.maxOutputSize = Optional.of(maxOutputSize);
            return this;
        }

        @Override
        @JsonSetter(value = "max_output_size", nulls = Nulls.SKIP)
        public _FinalStage maxOutputSize(Optional<Integer> maxOutputSize) {
            this.maxOutputSize = maxOutputSize;
            return this;
        }

        @Override
        public _FinalStage finalModel(LemurModels finalModel) {
            this.finalModel = Optional.of(finalModel);
            return this;
        }

        @Override
        @JsonSetter(value = "final_model", nulls = Nulls.SKIP)
        public _FinalStage finalModel(Optional<LemurModels> finalModel) {
            this.finalModel = finalModel;
            return this;
        }

        @Override
        public _FinalStage context(Object context) {
            this.context = Optional.of(context);
            return this;
        }

        @Override
        @JsonSetter(value = "context", nulls = Nulls.SKIP)
        public _FinalStage context(Optional<Object> context) {
            this.context = context;
            return this;
        }

        /**
         * <p>A list of completed transcripts with text. Up to 100 files max, or 100 hours max. Whichever is lower.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllTranscriptIds(List<String> transcriptIds) {
            this.transcriptIds.addAll(transcriptIds);
            return this;
        }

        /**
         * <p>A list of completed transcripts with text. Up to 100 files max, or 100 hours max. Whichever is lower.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addTranscriptIds(String transcriptIds) {
            this.transcriptIds.add(transcriptIds);
            return this;
        }

        @Override
        @JsonSetter(value = "transcript_ids", nulls = Nulls.SKIP)
        public _FinalStage transcriptIds(List<String> transcriptIds) {
            this.transcriptIds.clear();
            this.transcriptIds.addAll(transcriptIds);
            return this;
        }

        @Override
        public LemurTaskParameters build() {
            return new LemurTaskParameters(transcriptIds, prompt, context, finalModel, maxOutputSize);
        }
    }
}
