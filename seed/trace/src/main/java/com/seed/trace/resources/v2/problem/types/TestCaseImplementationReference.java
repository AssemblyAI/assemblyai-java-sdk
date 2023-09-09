package com.seed.trace.resources.v2.problem.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;

public final class TestCaseImplementationReference {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private TestCaseImplementationReference(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static TestCaseImplementationReference templateId(String value) {
        return new TestCaseImplementationReference(new TemplateIdValue(value));
    }

    public static TestCaseImplementationReference implementation(TestCaseImplementation value) {
        return new TestCaseImplementationReference(new ImplementationValue(value));
    }

    public boolean isTemplateId() {
        return value instanceof TemplateIdValue;
    }

    public boolean isImplementation() {
        return value instanceof ImplementationValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<String> getTemplateId() {
        if (isTemplateId()) {
            return Optional.of(((TemplateIdValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<TestCaseImplementation> getImplementation() {
        if (isImplementation()) {
            return Optional.of(((ImplementationValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<Object> _getUnknown() {
        if (_isUnknown()) {
            return Optional.of(((_UnknownValue) value).value);
        }
        return Optional.empty();
    }

    @JsonValue
    private Value getValue() {
        return this.value;
    }

    public interface Visitor<T> {
        T visitTemplateId(String templateId);

        T visitImplementation(TestCaseImplementation implementation);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = _UnknownValue.class)
    @JsonSubTypes({@JsonSubTypes.Type(TemplateIdValue.class), @JsonSubTypes.Type(ImplementationValue.class)})
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("templateId")
    private static final class TemplateIdValue implements Value {
        @JsonProperty("value")
        private String value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private TemplateIdValue(@JsonProperty("value") String value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitTemplateId(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof TemplateIdValue && equalTo((TemplateIdValue) other);
        }

        private boolean equalTo(TemplateIdValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "TestCaseImplementationReference{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("implementation")
    private static final class ImplementationValue implements Value {
        @JsonUnwrapped
        private TestCaseImplementation value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private ImplementationValue() {}

        private ImplementationValue(TestCaseImplementation value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitImplementation(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof ImplementationValue && equalTo((ImplementationValue) other);
        }

        private boolean equalTo(ImplementationValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "TestCaseImplementationReference{" + "value: " + value + "}";
        }
    }

    private static final class _UnknownValue implements Value {
        private String type;

        @JsonValue
        private Object value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private _UnknownValue(@JsonProperty("value") Object value) {}

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor._visitUnknown(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof _UnknownValue && equalTo((_UnknownValue) other);
        }

        private boolean equalTo(_UnknownValue other) {
            return type.equals(other.type) && value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.type, this.value);
        }

        @Override
        public String toString() {
            return "TestCaseImplementationReference{" + "type: " + type + ", value: " + value + "}";
        }
    }
}