/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api.errors;

import com.assemblyai.api.core.AssemblyAIApiException;

public final class GatewayTimeoutError extends AssemblyAIApiException {
    /**
     * The body of the response that triggered the exception.
     */
    private final Object body;

    public GatewayTimeoutError(Object body) {
        super("GatewayTimeoutError", 504, body);
        this.body = body;
    }

    /**
     * @return the body
     */
    @java.lang.Override
    public Object body() {
        return this.body;
    }
}
