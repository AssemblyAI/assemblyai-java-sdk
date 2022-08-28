/*
 * (c) Copyright 2022 Birch Solutions Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fern.java.client.generators.jersey;

import com.fern.ir.model.services.http.HttpHeader;
import com.fern.ir.model.services.http.PathParameter;
import com.fern.ir.model.services.http.QueryParameter;
import com.fern.ir.model.types.TypeReference;
import com.fern.java.AbstractGeneratorContext;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public final class JerseyParameterSpecFactory {

    private final AbstractGeneratorContext<?> generatorContext;

    public JerseyParameterSpecFactory(AbstractGeneratorContext<?> generatorContext) {
        this.generatorContext = generatorContext;
    }

    public ParameterSpec getHeaderParameterSpec(HttpHeader header) {
        return getParameterSpec(
                HeaderParam.class,
                header.getName().getWireValue(),
                header.getName().getCamelCase(),
                header.getValueType());
    }

    public ParameterSpec getPathParameterSpec(PathParameter pathParameter) {
        return getParameterSpec(
                PathParam.class,
                pathParameter.getName().getOriginalValue(),
                pathParameter.getName().getCamelCase(),
                pathParameter.getValueType());
    }

    public ParameterSpec getQueryParameterSpec(QueryParameter queryParameter) {
        return getParameterSpec(
                QueryParam.class,
                queryParameter.getName().getOriginalValue(),
                queryParameter.getName().getCamelCase(),
                queryParameter.getValueType());
    }

    private <T> ParameterSpec getParameterSpec(
            Class<T> paramClass, String annotationValue, String paramName, TypeReference paramType) {
        TypeName typeName = generatorContext.getPoetTypeNameMapper().convertToTypeName(false, paramType);
        return ParameterSpec.builder(typeName, paramName)
                .addAnnotation(AnnotationSpec.builder(paramClass)
                        .addMember("value", "$S", annotationValue)
                        .build())
                .build();
    }
}