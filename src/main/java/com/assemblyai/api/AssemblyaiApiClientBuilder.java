package com.assemblyai.api;

import com.assemblyai.api.core.ClientOptions;
import com.assemblyai.api.core.Environment;

public final class AssemblyaiApiClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment = Environment.DEFAULT;

    public AssemblyaiApiClientBuilder apiKey(String apiKey) {
        this.clientOptionsBuilder.addHeader("Authorization", apiKey);
        return this;
    }

    public AssemblyaiApiClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public AssemblyaiApiClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public AssemblyaiApiClient build() {
        clientOptionsBuilder.environment(this.environment);
        return new AssemblyaiApiClient(clientOptionsBuilder.build());
    }
}
