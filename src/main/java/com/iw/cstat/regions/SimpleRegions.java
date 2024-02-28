package com.iw.cstat.regions;

import com.iw.cstat.Regions;

public final class SimpleRegions implements Regions {

    private final String name;

    public SimpleRegions(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
