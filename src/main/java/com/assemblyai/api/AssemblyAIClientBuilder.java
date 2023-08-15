package com.assemblyai.api;

import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.Environment;

public final class AssemblyAIClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment = Environment.DEFAULT;

    public AssemblyAIClientBuilder apiKey(String apiKey) {
        this.clientOptionsBuilder.addHeader("Authorization", apiKey);
        return this;
    }

    public AssemblyAIClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public AssemblyAIClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public AssemblyAIClient build() {
        clientOptionsBuilder.environment(this.environment);
        return new AssemblyAIClient(clientOptionsBuilder.build());
    }
}
