package com.iw.cstat.api;

import com.iw.cstat.API;

public final class DataAPI implements API {

    private final API api;
    private final String[] params;

    public DataAPI(API api, String... params) {
        this.api = api;
        this.params = params;
    }

    @Override
    public String url() {
        final String url = api.url();
        return url + "/data?" + String.join("&", params);
    }
}
