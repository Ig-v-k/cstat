package com.iw.cstat.col2;

import com.iw.cstat.Col2;

public final class SimpleCol2 implements Col2 {

    private final String repr;
    private final Object val;

    public SimpleCol2(String repr, Object val) {
        this.repr = repr;
        this.val = val;
    }

    @Override
    public String repr() {
        return repr;
    }

    @Override
    public Object val() {
        return val;
    }
}
