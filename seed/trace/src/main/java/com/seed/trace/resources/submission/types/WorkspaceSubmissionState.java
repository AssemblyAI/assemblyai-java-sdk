package com.seed.trace.resources.submission.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.trace.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = WorkspaceSubmissionState.Builder.class)
public final class WorkspaceSubmissionState {
    private final WorkspaceSubmissionStatus status;

    private WorkspaceSubmissionState(WorkspaceSubmissionStatus status) {
        this.status = status;
    }

    @JsonProperty("status")
    public WorkspaceSubmissionStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof WorkspaceSubmissionState && equalTo((WorkspaceSubmissionState) other);
    }

    private boolean equalTo(WorkspaceSubmissionState other) {
        return status.equals(other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static StatusStage builder() {
        return new Builder();
    }

    public interface StatusStage {
        _FinalStage status(WorkspaceSubmissionStatus status);

        Builder from(WorkspaceSubmissionState other);
    }

    public interface _FinalStage {
        WorkspaceSubmissionState build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements StatusStage, _FinalStage {
        private WorkspaceSubmissionStatus status;

        private Builder() {}

        @Override
        public Builder from(WorkspaceSubmissionState other) {
            status(other.getStatus());
            return this;
        }

        @Override
        @JsonSetter("status")
        public _FinalStage status(WorkspaceSubmissionStatus status) {
            this.status = status;
            return this;
        }

        @Override
        public WorkspaceSubmissionState build() {
            return new WorkspaceSubmissionState(status);
        }
    }
}