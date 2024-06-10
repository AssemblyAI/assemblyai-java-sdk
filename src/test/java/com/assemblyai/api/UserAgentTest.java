package com.assemblyai.api;

import com.assemblyai.api.core.UserAgent;
import org.junit.jupiter.api.Test;

import static com.assemblyai.api.core.Constants.SDK_VERSION;

public final class UserAgentTest {
    @Test
    public void ShouldCreateDefaultUserAgent() {
        UserAgent agent = UserAgent.getDefault();
        assert agent != null;
        String userAgentString = agent.toAssemblyAIUserAgentString();
        assert userAgentString != null;
        assert userAgentString.contains("AssemblyAI/1.0 (");
        assert userAgentString.endsWith(")");
        assert userAgentString.contains("sdk=Java/" + SDK_VERSION);
        assert userAgentString.contains("runtime_env=OpenJDK Runtime Environment/");
    }
}
