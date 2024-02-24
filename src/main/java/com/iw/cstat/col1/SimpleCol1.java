package com.iw.cstat.col1;

import com.iw.cstat.Col1;

public final class SimpleCol1 implements Col1 {

    private final String repr;
    private final Object val;

    public SimpleCol1(String repr, Object val) {
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
