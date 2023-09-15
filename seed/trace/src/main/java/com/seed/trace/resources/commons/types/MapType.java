/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.trace.resources.commons.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.trace.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = MapType.Builder.class)
public final class MapType {
    private final VariableType keyType;

    private final VariableType valueType;

    private MapType(VariableType keyType, VariableType valueType) {
        this.keyType = keyType;
        this.valueType = valueType;
    }

    @JsonProperty("keyType")
    public VariableType getKeyType() {
        return keyType;
    }

    @JsonProperty("valueType")
    public VariableType getValueType() {
        return valueType;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof MapType && equalTo((MapType) other);
    }

    private boolean equalTo(MapType other) {
        return keyType.equals(other.keyType) && valueType.equals(other.valueType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.keyType, this.valueType);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static KeyTypeStage builder() {
        return new Builder();
    }

    public interface KeyTypeStage {
        ValueTypeStage keyType(VariableType keyType);

        Builder from(MapType other);
    }

    public interface ValueTypeStage {
        _FinalStage valueType(VariableType valueType);
    }

    public interface _FinalStage {
        MapType build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements KeyTypeStage, ValueTypeStage, _FinalStage {
        private VariableType keyType;

        private VariableType valueType;

        private Builder() {}

        @Override
        public Builder from(MapType other) {
            keyType(other.getKeyType());
            valueType(other.getValueType());
            return this;
        }

        @Override
        @JsonSetter("keyType")
        public ValueTypeStage keyType(VariableType keyType) {
            this.keyType = keyType;
            return this;
        }

        @Override
        @JsonSetter("valueType")
        public _FinalStage valueType(VariableType valueType) {
            this.valueType = valueType;
            return this;
        }

        @Override
        public MapType build() {
            return new MapType(keyType, valueType);
        }
    }
}