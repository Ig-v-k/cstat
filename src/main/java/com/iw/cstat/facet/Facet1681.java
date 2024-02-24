package com.iw.cstat.facet;

import com.iw.cstat.*;
import com.iw.cstat.api.*;
import com.iw.cstat.cstat.JsonCStat;
import com.iw.cstat.cstat.JsonCStats;
import com.iw.cstat.dat.DateFormat;
import com.iw.cstat.res.RequestRes;
import j2html.tags.Tag;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.PTag;

import java.util.Calendar;
import java.util.List;

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

        final CStats resources1 = cStats.from(new RequestRes(new ResourcesAPI(api1681, "title[phrase]=m%C4%99skie", "created[gte]=2024")).body());
        final Data data1 = resources1.data().get(0);
        final CStats man = cStats.from(new RequestRes(new DataAPI(new ResourceOf(data1.id()))).body());
        final List<Data> mansTable = man.data();

        final CStats resources2 = cStats.from(new RequestRes(new ResourcesAPI(api1681, "title[phrase]=%C5%BCe%C5%84skie", "created[gte]=2024")).body());
        final Data data2 = resources2.data().get(0);
        final CStats woman = cStats.from(new RequestRes(new DataAPI(new ResourceOf(data2.id()))).body());
        final List<Data> womanTable = woman.data();

        return div(
                header(
                        h1(cStat.data().attributes().title()),
                        subline(cStat)),
                div(
                        rawHtml(cStat.data().attributes().notes()),
                        h3("Statystyka:"),
                        div(
                                p("Meskie:"),
                                table(
                                        tbody(each(mansTable, i -> tr(
                                                td(i.attributes().col1().repr()),
                                                td(i.attributes().col2().repr())
                                        ))))),
                        div(
                                p("Zenskie:"),
                                table(
                                        tbody(each(womanTable, i -> tr(
                                                td(i.attributes().col1().repr()),
                                                td(i.attributes().col2().repr())
                                        )))))
                )
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
                a(institution.data().attributes().title()).withHref(institution.data().attributes().website()), " • ",
                "Polish", " • ",
                verified
        ));
    }
}
