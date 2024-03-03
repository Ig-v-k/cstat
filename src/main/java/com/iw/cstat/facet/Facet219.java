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
        final String slug = cStat.data().attributes().slug();
        return div(
                header(
                        h1(cStat.data().attributes().title()),
                        subline(cStat)),
                div(
                        rawHtml(cStat.data().attributes().notes()),
                        ul(
                                li(a("Imiona zenskie - imie perwsze").withHref(slug + "/imiona-zenskie-imie-pierwsze")),
                                li(a("Imiona meskie - imie perwsze").withHref(slug + "/imiona-meskie-imie-pierwsze"))
                        )));
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
                verified
        ));
    }
}
