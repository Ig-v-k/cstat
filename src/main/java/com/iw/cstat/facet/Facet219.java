package com.iw.cstat.facet;

import com.iw.cstat.CStat;
import com.iw.cstat.Facet;
import com.iw.cstat.api.InstitutionOf;
import com.iw.cstat.dat.DateFormat;
import com.iw.cstat.res.RequestRes;
import j2html.tags.Tag;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.PTag;

import static j2html.TagCreator.*;
import static j2html.TagCreator.rawHtml;

public final class Facet219 implements Facet<DivTag> {

    private final CStat cStat;

    public Facet219(CStat cStat) {
        this.cStat = cStat;
    }

    @Override
    public Tag<DivTag> tag() {
        return div(
                rawHtml(cStat.data().attributes().notes()));
    }
}
