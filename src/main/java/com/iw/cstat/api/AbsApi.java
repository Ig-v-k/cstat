package com.iw.cstat.api;

import com.iw.cstat.API;

public abstract class AbsApi implements API {

    private final API api;

    protected AbsApi(API api) {
        this.api = api;
    }

    @Override
    public String url() {
        return api.url();
    }
}
