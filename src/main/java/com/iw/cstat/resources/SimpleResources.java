package com.iw.cstat.resources;

import com.iw.cstat.Meta;
import com.iw.cstat.Resources;

public final class SimpleResources implements Resources {

    private final Meta meta;

    public SimpleResources(Meta meta) {
        this.meta = meta;
    }

    @Override
    public Meta meta() {
        return meta;
    }
}
