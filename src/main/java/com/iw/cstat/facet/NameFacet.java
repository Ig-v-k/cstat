package com.iw.cstat.facet;

import com.iw.cstat.Data;
import com.iw.cstat.Facet;
import j2html.tags.Tag;
import j2html.tags.specialized.MainTag;

import static j2html.TagCreator.h2;
import static j2html.TagCreator.main;

public final class NameFacet implements Facet<MainTag> {

    private final Data data;

    public NameFacet(Data data) {
        this.data = data;
    }

    @Override
    public Tag<MainTag> tag() {
        return main(
                h2(data.attributes().col3().repr())
        );
    }
}
