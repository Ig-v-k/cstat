package com.iw.cstat.relationships;

import com.iw.cstat.Relationships;
import com.iw.cstat.Resources;

public final class SimpleRelationships implements Relationships {

    private final Resources resources;

    public SimpleRelationships(Resources resources) {
        this.resources = resources;
    }

    @Override
    public Resources resources() {
        return resources;
    }
}
