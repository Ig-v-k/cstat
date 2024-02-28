package com.iw.cstat.api;

import com.iw.cstat.API;

public final class InstitutionOf extends AbsApi {

    public InstitutionOf(final int id) {
        this(new InstitutionAPI(new PolishAPI(), id));
    }

    private InstitutionOf(API api) {
        super(api);
    }
}
