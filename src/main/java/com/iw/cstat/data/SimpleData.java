package com.iw.cstat.data;

import com.iw.cstat.Data;

public final class SimpleData implements Data {

    private final String id;

    public SimpleData(String id) {
        this.id = id;
    }

    @Override
    public int id() {
        return Integer.parseInt(id);
    }
}
