package com.iw.cstat.links;

import com.iw.cstat.Links;

public final class SimpleLinks implements Links {

    private final String self;
    private final String related;

    public SimpleLinks(String self, String related) {
        this.self = self;
        this.related = related;
    }

    @Override
    public String self() {
        return self;
    }

    @Override
    public String related() {
        return related;
    }
}
