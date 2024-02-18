package com.iw.cstat.api;

import com.iw.cstat.API;

public final class DatasetsAPI implements API {

    private final API api;

    public DatasetsAPI(API api) {
        this.api = api;
    }

    @Override
    public String url() {
        final String url = api.url();
        return url + "/datasets";
    }
}
