package com.assemblyai.api;

import com.assemblyai.api.core.Environment;
import com.assemblyai.api.core.UserAgent;
import com.assemblyai.api.core.UserAgentItem;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Optional;

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

    @Test
    public void ShouldUpdateUserAgentSdk() {
        Environment env = Environment.custom(Environment.DEFAULT.getUrl());
        env.updateUserAgent(new UserAgent(new HashMap<String, UserAgentItem>() {{
            put("sdk", new UserAgentItem("Kotlin", "0.0"));
        }}));

        Optional<UserAgent> userAgent = env.getUserAgent();
        assert userAgent.isPresent();
        String userAgentString = userAgent.get().toAssemblyAIUserAgentString();
        System.out.println(userAgentString);
        assert userAgentString != null;
        assert userAgentString.contains("AssemblyAI/1.0 (");
        assert userAgentString.endsWith(")");
        assert !userAgentString.contains("sdk=Java");
        assert userAgentString.contains("sdk=Kotlin/0.0");
        assert userAgentString.contains("runtime_env=OpenJDK Runtime Environment/");
    }

    @Test
    public void ShouldAddUserAgentIntegration() {
        Environment env = Environment.custom(Environment.DEFAULT.getUrl());
        env.updateUserAgent(new UserAgent(new HashMap<String, UserAgentItem>() {{
            put("integration", new UserAgentItem("Foo", "Bar"));
        }}));

        Optional<UserAgent> userAgent = env.getUserAgent();
        assert userAgent.isPresent();
        String userAgentString = userAgent.get().toAssemblyAIUserAgentString();
        System.out.println(userAgentString);
        assert userAgentString != null;
        assert userAgentString.contains("AssemblyAI/1.0 (");
        assert userAgentString.endsWith(")");
        assert userAgentString.contains("integration=Foo/Bar");
        assert userAgentString.contains("sdk=Java/" + SDK_VERSION);
        assert userAgentString.contains("runtime_env=OpenJDK Runtime Environment/");
    }

    @Test
    public void ShouldRemoveUserAgent() {
        Environment env = Environment.custom(Environment.DEFAULT.getUrl());
        env.updateUserAgent(null);

        Optional<UserAgent> userAgent = env.getUserAgent();
        assert !userAgent.isPresent();
    }

    @Test
    public void ShouldReplaceUserAgent() {
        Environment env = Environment.custom(Environment.DEFAULT.getUrl());
        env.updateUserAgent(null);
        env.updateUserAgent(new UserAgent(new HashMap<String, UserAgentItem>() {{
            put("custom", new UserAgentItem("Foo", "Bar"));
        }}));

        Optional<UserAgent> userAgent = env.getUserAgent();
        assert userAgent.isPresent();
        String userAgentString = userAgent.get().toAssemblyAIUserAgentString();
        System.out.println(userAgentString);
        assert userAgentString != null;
        assert userAgentString.contains("AssemblyAI/1.0 (");
        assert userAgentString.endsWith(")");
        assert userAgentString.contains("custom=Foo/Bar");
        assert !userAgentString.contains("sdk");
        assert !userAgentString.contains("runtime_env");
    }

    @Test
    public void ShouldRemoveUserAgentItem() {
        Environment env = Environment.custom(Environment.DEFAULT.getUrl());
        env.updateUserAgent(new UserAgent(new HashMap<String, UserAgentItem>() {{
            put("runtime_env", null);
        }}));
        Optional<UserAgent> userAgent = env.getUserAgent();
        assert userAgent.isPresent();
        String userAgentString = userAgent.get().toAssemblyAIUserAgentString();
        System.out.println(userAgentString);
        assert userAgentString != null;
        assert userAgentString.contains("AssemblyAI/1.0 (");
        assert userAgentString.endsWith(")");
        assert userAgentString.contains("sdk=Java/" + SDK_VERSION);
        assert !userAgentString.contains("runtime_env");
    }
}
