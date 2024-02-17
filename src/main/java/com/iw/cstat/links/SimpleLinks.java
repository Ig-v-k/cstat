package com.iw.cstat.links;

import com.iw.cstat.Links;

public final class SimpleLinks implements Links {

    private final String self;

    public SimpleLinks(String self) {
        this.self = self;
    }

    @Override
    public String self() {
        return self;
    }
}
