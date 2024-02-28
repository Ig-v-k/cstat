package com.iw.cstat.api;

public final class DatasetOf extends AbsApi {
    public DatasetOf(final int id) {
        super(new DatasetsAPI(new PolishAPI(), id));
    }
}
