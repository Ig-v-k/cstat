package com.iw.cstat.api;

import com.iw.cstat.API;

public final class ResourceOf extends AbsApi {
    public ResourceOf(final int id) {
        this(new ResourceAPI(new PolishAPI(), id));
    }

    private ResourceOf(final API api) {
        super(api);
    }
}
