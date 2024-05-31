package com.assemblyai.api.core;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class UserAgentInterceptor implements Interceptor {
    private final UserAgent userAgent;

    public UserAgentInterceptor(UserAgent userAgent) {
        this.userAgent = userAgent;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        if (userAgent == null) {
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

        String assemblyAIUserAgentString = userAgent.toAssemblyAIUserAgentString();
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
