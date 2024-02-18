package com.iw.cstat.api;

import com.iw.cstat.API;

public final class DataAPI implements API {

    private final API api;
    private final String id;

    public DataAPI(API api, int id) {
        this(api, String.valueOf(id));
    }

    public DataAPI(API api, String id) {
        this.api = api;
        this.id = id;
    }

    @Override
    public String url() {
        final String url = api.url();
        return url + "/" + id;
    }
}
