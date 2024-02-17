package com.iw.cstat.jsonapi;

import com.iw.cstat.JsonApi;

public final class SimpleJsonApi implements JsonApi {

    private final String version;

    public SimpleJsonApi(String version) {
        this.version = version;
    }

    @Override
    public String version() {
        return version;
    }
}
