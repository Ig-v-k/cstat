package com.iw.cstat.facet;

import com.iw.cstat.CStat;
import com.iw.cstat.Data;
import com.iw.cstat.Facet;
import com.iw.cstat.dat.DateFormat;
import j2html.tags.Tag;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.PTag;
import j2html.tags.specialized.SectionTag;

import java.util.List;

import static j2html.TagCreator.*;

public final class DatasetFacet implements Facet<DivTag> {

    private final List<CStat> cStats;

    public DatasetFacet(List<CStat> cStats) {
        this.cStats = cStats;
    }

    @Override
    public Tag<DivTag> tag() {
        return div(each(cStats, this::post));
    }

    private Tag<PTag> subline(final CStat cStat) {
        final String verified = new DateFormat(
                "yyyy-MM-dd'T'HH:mm:ss'Z'",
                cStat.data().attributes().verified(),
                cStat.meta().language()).text();
        return p(join(cStat.data().attributes().regions()[0].name(), " • ", verified));
    }

    private Tag<PTag> footline(final Data data) {
        return p(join(
                b(String.valueOf(data.attributes().viewsCount())), "Views"
        ));
    }

    private SectionTag post(final CStat cStat) {
        final Data data = cStat.data();
        return section(article(
                header(
                        h2(a(data.attributes().title()).withHref("/" + data.attributes().slug())),
                        subline(cStat)),
                div(attrs(".truncate"),
                        rawHtml(data.attributes().notes())),
                footer(footline(data))
        ));
    }
}
