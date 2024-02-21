package com.iw.cstat.facet;

import com.iw.cstat.CStat;
import com.iw.cstat.CStats;
import com.iw.cstat.Facet;
import com.iw.cstat.api.ApiOf;
import com.iw.cstat.api.ResourcesAPI;
import com.iw.cstat.cstat.JsonCStats;
import com.iw.cstat.res.RequestRes;
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
        final CStats mans = new JsonCStats().from(
                new RequestRes(new ResourcesAPI(new ApiOf(1681), "created[gte]=2023")).body());
        return div(
                header(h1(cStat.data().attributes().title()))
        );
    }
}
