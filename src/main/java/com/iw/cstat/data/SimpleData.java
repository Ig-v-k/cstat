package com.iw.cstat.data;

import com.iw.cstat.Attributes;
import com.iw.cstat.Data;
import com.iw.cstat.Links;
import com.iw.cstat.Relationships;

public final class SimpleData implements Data {

    private final String id;
    private final Attributes attributes;
    private final Relationships relationships;
    private final Links links;
    private final String type;

    public SimpleData(String id, Attributes attributes, Relationships relationships, Links links, String type) {
        this.id = id;
        this.attributes = attributes;
        this.relationships = relationships;
        this.links = links;
        this.type = type;
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

    @Override
    public Links links() {
        return links;
    }

    @Override
    public String type() {
        return type;
    }
}
