package com.iw.cstat.api;

import com.iw.cstat.API;

public final class ApiOf extends AbsApi {
    public ApiOf(final int id) {
        super(new DataAPI(new DatasetsAPI(new PolishAPI()), id));
    }
}
