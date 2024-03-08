package com.iw.cstat.col3;

import com.iw.cstat.Col3;

public final class SimpleCol3 implements Col3 {

    private final String repr;
    private final Object val;

    public SimpleCol3(String repr, Object val) {
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
