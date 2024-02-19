package com.iw.cstat.meta;

import com.iw.cstat.Meta;

public final class SimpleMeta implements Meta {

    private final String language;
    private final int count;

    public SimpleMeta(String language, int count) {
        this.language = language;
        this.count = count;
    }

    @Override
    public String language() {
        return language;
    }

    @Override
    public int count() {
        return count;
    }
}
