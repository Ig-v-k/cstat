package com.iw.cstat.atttributes;

import com.iw.cstat.Attributes;

public final class SimpleAttributes implements Attributes {

    private final String title;

    public SimpleAttributes(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }
}
