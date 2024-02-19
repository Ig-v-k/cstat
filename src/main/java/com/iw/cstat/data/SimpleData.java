package com.iw.cstat.data;

import com.iw.cstat.Attributes;
import com.iw.cstat.Data;
import com.iw.cstat.Relationships;

public final class SimpleData implements Data {

    private final String id;
    private final Attributes attributes;
    private final Relationships relationships;

    public SimpleData(String id, Attributes attributes, Relationships relationships) {
        this.id = id;
        this.attributes = attributes;
        this.relationships = relationships;
    }

    @Override
    public int id() {
        return Integer.parseInt(id);
    }

    @Override
    public Attributes attributes() {
        return attributes;
    }

    @Override
    public Relationships relationships() {
        return relationships;
    }
}
