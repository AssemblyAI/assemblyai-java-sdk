package com.seed.fileUpload.resources.service.requests;

import com.seed.fileUpload.core.ObjectMappers;

public final class JustFileRequet {
    private JustFileRequet() {}

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof JustFileRequet;
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }
}