package com.iw.cstat.region;

import com.iw.cstat.Region;

public final class SimpleRegion implements Region {

    private final String name;

    public SimpleRegion(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
