/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.assemblyai.api;

import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.Environment;

public final class AssemblyAIBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();
    private ClientOptions.Builder lemurClientOptionsBuilder = ClientOptions.builder();

    private String apiKey = null;

    private Environment environment = Environment.DEFAULT;

    /**
     * Sets apiKey
     */
    public AssemblyAIBuilder apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public AssemblyAIBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public AssemblyAIBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public AssemblyAI build() {
        if (apiKey == null) {
            throw new RuntimeException("Please provide apiKey");
        }
        this.clientOptionsBuilder.addHeader("Authorization", this.apiKey);
        clientOptionsBuilder.environment(this.environment);
        this.lemurClientOptionsBuilder.addHeader("Authorization", this.apiKey);
        lemurClientOptionsBuilder.environment(this.environment).disableTimeouts();
        return new AssemblyAI(clientOptionsBuilder.build(), lemurClientOptionsBuilder.build());
    }
}
