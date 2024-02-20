package com.iw.cstat.facet;

import com.iw.cstat.CStat;
import com.iw.cstat.Facet;
import j2html.tags.Tag;
import j2html.tags.specialized.DivTag;

import static j2html.TagCreator.*;

public final class Facet1681 implements Facet<DivTag> {

    private final CStat cStat;

    public Facet1681(CStat cStat) {
        this.cStat = cStat;
    }

    @Override
    public Tag<DivTag> tag() {
        // TODO: get Data by filter[created]. Use @ResourcesAPI.class
        return div(
                header(h1(cStat.data().attributes().title()))
        );
    }
}
