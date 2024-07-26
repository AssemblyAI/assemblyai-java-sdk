package com.assemblyai.api.core;

/**
 * This exception type will be thrown for any non-2XX API responses.
 */
public class AssemblyAIApiException extends ApiError {
    public AssemblyAIApiException(String message, int statusCode, Object body) {
        super(message, statusCode, body);
    }
}
