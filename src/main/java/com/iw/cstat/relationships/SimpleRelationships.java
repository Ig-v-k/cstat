package com.iw.cstat.relationships;

import com.iw.cstat.Institution;
import com.iw.cstat.Relationships;
import com.iw.cstat.Resources;

public final class SimpleRelationships implements Relationships {

    private final Resources resources;
    private final Institution institution;

    public SimpleRelationships(Resources resources, Institution institution) {
        this.resources = resources;
        this.institution = institution;
    }

    @Override
    public Resources resources() {
        return resources;
    }

    @Override
    public Institution institution() {
        return institution;
    }
}
