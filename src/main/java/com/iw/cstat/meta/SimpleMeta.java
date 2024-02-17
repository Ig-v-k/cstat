package com.iw.cstat.meta;

import com.iw.cstat.Meta;

public final class SimpleMeta implements Meta {

    private final String language;

    public SimpleMeta(String language) {
        this.language = language;
    }

    @Override
    public String language() {
        return language;
    }
}
