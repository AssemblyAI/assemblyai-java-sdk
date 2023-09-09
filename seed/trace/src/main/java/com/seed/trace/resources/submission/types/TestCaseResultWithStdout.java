package com.seed.trace.resources.submission.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.trace.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TestCaseResultWithStdout.Builder.class)
public final class TestCaseResultWithStdout {
    private final TestCaseResult result;

    private final String stdout;

    private TestCaseResultWithStdout(TestCaseResult result, String stdout) {
        this.result = result;
        this.stdout = stdout;
    }

    @JsonProperty("result")
    public TestCaseResult getResult() {
        return result;
    }

    @JsonProperty("stdout")
    public String getStdout() {
        return stdout;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TestCaseResultWithStdout && equalTo((TestCaseResultWithStdout) other);
    }

    private boolean equalTo(TestCaseResultWithStdout other) {
        return result.equals(other.result) && stdout.equals(other.stdout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.result, this.stdout);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ResultStage builder() {
        return new Builder();
    }

    public interface ResultStage {
        StdoutStage result(TestCaseResult result);

        Builder from(TestCaseResultWithStdout other);
    }

    public interface StdoutStage {
        _FinalStage stdout(String stdout);
    }

    public interface _FinalStage {
        TestCaseResultWithStdout build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ResultStage, StdoutStage, _FinalStage {
        private TestCaseResult result;

        private String stdout;

        private Builder() {}

        @Override
        public Builder from(TestCaseResultWithStdout other) {
            result(other.getResult());
            stdout(other.getStdout());
            return this;
        }

        @Override
        @JsonSetter("result")
        public StdoutStage result(TestCaseResult result) {
            this.result = result;
            return this;
        }

        @Override
        @JsonSetter("stdout")
        public _FinalStage stdout(String stdout) {
            this.stdout = stdout;
            return this;
        }

        @Override
        public TestCaseResultWithStdout build() {
            return new TestCaseResultWithStdout(result, stdout);
        }
    }
}