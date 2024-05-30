package com.assemblyai.api.core;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Optional;

public class UserAgentInterceptor implements Interceptor {
    private final Environment environment;

    public UserAgentInterceptor(Environment environment) {
        this.environment = environment;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Optional<UserAgent> userAgent = this.environment.getUserAgent();
        if (!userAgent.isPresent()) {
            return chain.proceed(chain.request());
        }

        Request originalRequest = chain.request();
        String userAgentString = originalRequest.headers().get("User-Agent");
        if (userAgentString != null) {
            // if already contains AssemblyAI UA, skip
            if (userAgentString.contains("AssemblyAI/")) {
                return chain.proceed(chain.request());
            }
        } else {
            userAgentString = "";
        }

        String assemblyAIUserAgentString = userAgent.get().toAssemblyAIUserAgentString();
        // if AAI UA null or empty, skip
        if (assemblyAIUserAgentString == null || assemblyAIUserAgentString.isEmpty()) {
            return chain.proceed(chain.request());
        }

        userAgentString += " " + assemblyAIUserAgentString;
        Request requestWithUserAgent = originalRequest.newBuilder()
                .header("User-Agent", userAgentString)
                .build();
        return chain.proceed(requestWithUserAgent);
    }
}
