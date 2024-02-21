package com.iw.cstat.institution;

import com.iw.cstat.Institution;
import com.iw.cstat.Links;

public final class SimpleInstitution implements Institution {

    private final Links links;

    public SimpleInstitution(Links links) {
        this.links = links;
    }

    @Override
    public Links links() {
        return links;
    }
}
