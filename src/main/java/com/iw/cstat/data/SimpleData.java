package com.iw.cstat.data;

import com.iw.cstat.Attributes;
import com.iw.cstat.Data;

public final class SimpleData implements Data {

    private final String id;
    private final Attributes attributes;

    public SimpleData(String id, Attributes attributes) {
        this.id = id;
        this.attributes = attributes;
    }

    @Override
    public int id() {
        return Integer.parseInt(id);
    }

    @Override
    public Attributes attributes() {
        return attributes;
    }
}
