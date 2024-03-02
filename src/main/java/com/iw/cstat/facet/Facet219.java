package com.iw.cstat.facet;

import com.iw.cstat.CStat;
import com.iw.cstat.Facet;
import j2html.tags.Tag;
import j2html.tags.specialized.DivTag;

import static j2html.TagCreator.div;

public final class Facet219 implements Facet<DivTag> {

    private final CStat cStat;

    public Facet219(CStat cStat) {
        this.cStat = cStat;
    }

    @Override
    public Tag<DivTag> tag() {
        return div("Page");
    }
}
