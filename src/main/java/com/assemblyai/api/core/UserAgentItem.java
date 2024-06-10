package com.assemblyai.api.core;

public class UserAgentItem{
    private final String name;
    private final String version;

    public UserAgentItem(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}
