package com.iw.cstat.page;

import com.iw.cstat.Page;
import com.iw.cstat.facet.NameFacet;

public final class NamePage implements Page {

    private final String name;

    public NamePage(String name) {
        this.name = name;
    }

    @Override
    public String render() {
        final String upName = name.toUpperCase();
        return new TmplPage(
                upName,
                upName,
                String.format("About %s", upName),
                new NameFacet(name)).render();
    }
}
