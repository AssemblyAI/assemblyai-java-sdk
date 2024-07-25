package com.assemblyai.api.core;

/**
 * This exception type will be thrown for any non-2XX API responses.
 * @deprecated Use {@link AssemblyAIApiException}. ApiError will be removed in a future release.
 */
@Deprecated
public class ApiError extends AssemblyAIException {
    /**
     * The error code of the response that triggered the exception.
     */
    private final int statusCode;

    /**
     * The body of the response that triggered the exception.
     */
    private final Object body;

    public ApiError(String message, int statusCode, Object body) {
        super(message);
        this.statusCode = statusCode;
        this.body = body;
    }

    /**
     * @return the statusCode
     */
    public int statusCode() {
        return this.statusCode;
    }

    /**
     * @return the body
     */
    public Object body() {
        return this.body;
    }

    @java.lang.Override
    public String toString() {
        return "AssemblyAIApiException{" + "message: " + getMessage() + ", statusCode: " + statusCode + ", body: "
                + body + "}";
    }
}
