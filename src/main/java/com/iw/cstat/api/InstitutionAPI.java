package com.iw.cstat.api;

import com.iw.cstat.API;

public final class InstitutionAPI implements API {

    private final API api;
    private final int id;

    public InstitutionAPI(API api, int id) {
        this.api = api;
        this.id = id;
    }

    @Override
    public String url() {
        final String url = api.url();
        return url + "/institutions/" + id;
    }
}
