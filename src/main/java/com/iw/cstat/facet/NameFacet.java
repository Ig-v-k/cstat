package com.iw.cstat.facet;

import com.iw.cstat.Facet;
import j2html.tags.Tag;
import j2html.tags.specialized.MainTag;

import static j2html.TagCreator.h2;
import static j2html.TagCreator.main;

public final class NameFacet implements Facet<MainTag> {

    private final String name;

    public NameFacet(String name) {
        this.name = name;
    }

    @Override
    public Tag<MainTag> tag() {
        return main(
                h2()
        );
    }
}
