package com.iw.cstat.facet;

import com.iw.cstat.Facet;
import j2html.tags.Tag;
import j2html.tags.specialized.MainTag;

import static j2html.TagCreator.main;

public final class TmplDataFacet implements Facet<MainTag> {

    private final String data;

    public TmplDataFacet(String data) {
        this.data = data;
    }

    @Override
    public Tag<MainTag> tag() {
        return main(data);
    }
}
