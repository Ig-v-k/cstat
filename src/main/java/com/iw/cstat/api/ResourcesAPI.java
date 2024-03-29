package com.iw.cstat.api;

import com.iw.cstat.API;
import com.iw.cstat.Params;

public final class ResourcesAPI implements API {

    private final API api;
    private final String[] params;

    public ResourcesAPI(API api, Params params) {
        this(api, params.array());
    }

    public ResourcesAPI(API api, String... params) {
        this.api = api;
        this.params = params;
    }

    @Override
    public String url() {
        final String url = api.url();
        return url + "/resources/?" + String.join("&", params);
    }
}
