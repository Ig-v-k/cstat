package com.iw.cstat.api;

import com.iw.cstat.API;

public final class DatasetsAPI implements API {

    private final API api;
    private final int id;

    public DatasetsAPI(API api, String id) {
        this(api, Integer.parseInt(id));
    }

    public DatasetsAPI(API api, int id) {
        this.api = api;
        this.id = id;
    }

    @Override
    public String url() {
        final String url = api.url();
        return url + "/datasets/" + id;
    }
}
