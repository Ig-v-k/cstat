package com.iw.cstat.facet;

import com.iw.cstat.CStat;
import com.iw.cstat.Data;
import com.iw.cstat.Facet;
import j2html.tags.Tag;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.PTag;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

import static j2html.TagCreator.*;

public final class DatasetFacet implements Facet<DivTag> {

    private final List<CStat> cStats;

    public DatasetFacet(List<CStat> cStats) {
        this.cStats = cStats;
    }

    @Override
    public Tag<DivTag> tag() {
        return div(each(cStats, cStat -> {
            final Data data = cStat.data();
            return section(article(
                    header(
                            h2(a(data.attributes().title()).withHref("/" + data.attributes().slug())),
                            subline(cStat)),
                    div(attrs(".truncate"),
                            rawHtml(data.attributes().notes())),
                    footer(footline(data))
            ));
        }));
    }

    private Tag<PTag> subline(final CStat cStat) {
        final DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return p(join(
                LocalDateTime.parse(
                        cStat.data().attributes().verified(),
                        inputFormatter).format(DateTimeFormatter.ofLocalizedDate(
                                FormatStyle.LONG).withLocale(
                                        Locale.forLanguageTag(cStat.meta().language()))),
                " • ",
                String.format("%s resources", cStat.data().relationships().resources().meta().count())
        ));
    }

    private Tag<PTag> footline(final Data data) {
        return p(join(
                b(String.valueOf(data.attributes().viewsCount())), "Views",
                " • ",
                b(String.valueOf(data.attributes().downloadsCount())), "Downloads"
        ));
    }
}
