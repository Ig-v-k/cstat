package com.iw.cstat.api;

import com.iw.cstat.API;

public final class DatasetAPI implements API {

    private final API api;

    public DatasetAPI(API api) {
        this.api = api;
    }

    @Override
    public String url() {
        final String url = api.url();
        return url + "/dataset";
    }
}
