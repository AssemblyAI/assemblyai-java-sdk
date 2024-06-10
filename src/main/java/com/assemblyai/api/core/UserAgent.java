package com.assemblyai.api.core;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.assemblyai.api.core.Constants.SDK_VERSION;

public class UserAgent {
    private static final UserAgent defaultUserAgent;

    static {
        defaultUserAgent = createDefaultUserAgent();
    }

    private final Map<String, UserAgentItem> userAgent;

    public UserAgent(Map<String, UserAgentItem> userAgent) {
        this.userAgent = userAgent;
    }

    public UserAgent(UserAgent a, UserAgent b) {
        this.userAgent = UserAgent.merge(a.userAgent, b.userAgent);
    }

    public String toAssemblyAIUserAgentString() {
        StringBuilder sb = new StringBuilder();
        if (this.userAgent == null) {
            return sb.toString();
        }

        sb.append(" AssemblyAI/1.0 (");
        sb.append(
                this.userAgent
                        .entrySet()
                        .stream()
                        .map(entry -> String.format(
                                "%s=%s/%s",
                                entry.getKey(),
                                entry.getValue().getName(),
                                entry.getValue().getVersion()
                        ))
                        .collect(Collectors.joining(" "))
        );
        sb.append(")");
        return sb.toString();
    }

    public static UserAgent getDefault(){
        return defaultUserAgent;
    }

    private static UserAgent createDefaultUserAgent() {
        HashMap<String, UserAgentItem> defaultUserAgent = new HashMap<>();
        defaultUserAgent.put(
                "sdk",
                new UserAgentItem(
                        "Java",
                        SDK_VERSION
                )
        );
        defaultUserAgent.put(
                "runtime_env",
                new UserAgentItem(
                        System.getProperty("java.runtime.name"),
                        System.getProperty("java.runtime.version")
                )
        );

        return new UserAgent(defaultUserAgent);
    }

    private UserAgent merge(UserAgent other) {
        return new UserAgent(UserAgent.merge(this.userAgent, other.userAgent));
    }

    private static Map<String, UserAgentItem> merge(Map<String, UserAgentItem> a, Map<String, UserAgentItem> b) {
        Map<String, UserAgentItem> newUserAgent = new HashMap<>();

        // user this user agent
        newUserAgent.putAll(a);
        // override with incoming user agent
        newUserAgent.putAll(b);

        // remove all null values
        for (Map.Entry<String, UserAgentItem> entry : b.entrySet()) {
            if (entry.getValue() == null) {
                newUserAgent.remove(entry.getKey());
            }
        }
        return newUserAgent;
    }
}

