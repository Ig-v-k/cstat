package com.iw.cstat.facet;

import com.iw.cstat.API;
import com.iw.cstat.CStat;
import com.iw.cstat.CStats;
import com.iw.cstat.Facet;
import com.iw.cstat.api.DatasetOf;
import com.iw.cstat.api.InstitutionOf;
import com.iw.cstat.api.ResourcesAPI;
import com.iw.cstat.cstat.JsonCStats;
import com.iw.cstat.dat.DateFormat;
import com.iw.cstat.res.RequestRes;
import j2html.tags.Tag;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.PTag;

import static j2html.TagCreator.*;

public final class Facet1681 implements Facet<DivTag> {

    private final CStat cStat;

    public Facet1681(CStat cStat) {
        this.cStat = cStat;
    }

    @Override
    public Tag<DivTag> tag() {
        final CStats cStats = new JsonCStats();
        final API api1681 = new DatasetOf(1681);
        final CStats mans = cStats.from(new RequestRes(new ResourcesAPI(api1681, "title[phrase]=m%C4%99skie", "created[gte]=2023")).body());
        final CStats woman = cStats.from(new RequestRes(new ResourcesAPI(api1681, "title[phrase]=%C5%BCe%C5%84skie", "created[gte]=2023")).body());
        return div(
                header(
                        h1(cStat.data().attributes().title()),
                        subline(cStat)),
                div(rawHtml(cStat.data().attributes().notes()))
        );
    }

    private static PTag subline(final CStat cStat) {
        final String verified = new DateFormat(
                "yyyy-MM-dd'T'HH:mm:ss'Z'",
                cStat.data().attributes().verified(),
                cStat.meta().language()).text();
        final CStat institution = cStat.from(new RequestRes(
                new InstitutionOf(cStat.data().relationships().institution().data().id())).body());
        return p(join(
                institution.data().attributes().title(), " • ",
                "Polish", " • ",
                verified, " • "
        ));
    }
}
