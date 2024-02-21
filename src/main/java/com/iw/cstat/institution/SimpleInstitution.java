package com.iw.cstat.institution;

import com.iw.cstat.Data;
import com.iw.cstat.Institution;
import com.iw.cstat.Links;

public final class SimpleInstitution implements Institution {

    private final Data data;
    private final Links links;

    public SimpleInstitution(Data data, Links links) {
        this.data = data;
        this.links = links;
    }

    @Override
    public Data data() {
        return data;
    }

    @Override
    public Links links() {
        return links;
    }
}
