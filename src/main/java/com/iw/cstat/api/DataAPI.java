package com.iw.cstat.api;

import com.iw.cstat.API;

public final class DataAPI implements API {

    private final API api;

    public DataAPI(API api) {
        this.api = api;
    }

    @Override
    public String url() {
        final String url = api.url();
        return url + "/data";
    }
}
