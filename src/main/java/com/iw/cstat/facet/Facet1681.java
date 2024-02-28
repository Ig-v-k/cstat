package com.iw.cstat.facet;

import com.iw.cstat.*;
import com.iw.cstat.api.*;
import com.iw.cstat.cstat.JsonCStats;
import com.iw.cstat.dat.DateFormat;
import com.iw.cstat.res.RequestRes;
import j2html.tags.Tag;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.PTag;
import j2html.tags.specialized.SpanTag;

import java.text.DecimalFormat;
import java.util.List;

import static j2html.TagCreator.*;

public final class Facet1681 implements Facet<DivTag> {

    private final CStat cStat;

    public Facet1681(CStat cStat) {
        this.cStat = cStat;
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

    private static SpanTag statline(final Data data, final List<Data> lastYearData) {
        final Data dataYearLow = lastYearData.stream()
                .filter(d -> d.attributes().col1().repr().equals(data.attributes().col1().repr()))
                .findFirst()
                .get();
        final double valueYear = Double.parseDouble(String.valueOf(data.attributes().col2().val()));
        final double valueYearLow = Double.parseDouble(String.valueOf(dataYearLow.attributes().col2().val()));
        final int difference = (int) (valueYear - valueYearLow);
        final double percent = difference / valueYearLow * 100;
        final String text = String.format("%,d (%.1f %%) za rok", difference, percent);
        return span(text).withClass(iffElse(difference > 0, "positive", "negative"));
    }

    @Override
    public Tag<DivTag> tag() {
        final CStats cStats = new JsonCStats();
        final API api1681 = new DatasetOf(1681);

        final CStats resources1 = cStats.from(new RequestRes(new ResourcesAPI(api1681, "sort=-created", "title[phrase]=m%C4%99skie", "per_page=2")).body());
        final Data data1Year = resources1.data().get(0);
        final Data data1YearLow = resources1.data().get(1);
        final CStats mansYear = cStats.from(new RequestRes(new DataAPI(new ResourceOf(data1Year.id()))).body());
        final CStats mansYearLow = cStats.from(new RequestRes(new DataAPI(new ResourceOf(data1YearLow.id()), "per_page=100")).body());
        final List<Data> mansYearTable = mansYear.data().subList(0, 3);
        final List<Data> mansYearLowTable = mansYearLow.data();

        final CStats resources2 = cStats.from(new RequestRes(new ResourcesAPI(api1681, "sort=-created", "title[phrase]=%C5%BCe%C5%84skie", "per_page=2")).body());
        final Data data2Year = resources2.data().get(0);
        final Data data2YearLow = resources2.data().get(1);
        final CStats womanYear = cStats.from(new RequestRes(new DataAPI(new ResourceOf(data2Year.id()))).body());
        final CStats womanYearLow = cStats.from(new RequestRes(new DataAPI(new ResourceOf(data2YearLow.id()), "per_page=100")).body());
        final List<Data> womanYearTable = womanYear.data().subList(0, 3);
        final List<Data> womanYearLowTable = womanYearLow.data();

        final DecimalFormat decimalFormat = new DecimalFormat("#,###,###,###");

        return div(
                header(
                        h1(cStat.data().attributes().title()),
                        subline(cStat)),
                div(
                        rawHtml(cStat.data().attributes().notes()),
                        h3("Statystyka:"),
                        div(
                                p("Męskie:"),
                                table(
                                        tbody(each(mansYearTable, (i, data) -> tr(
                                                td(String.valueOf(i + 1)),
                                                td(data.attributes().col1().repr()),
                                                td(
                                                        b(decimalFormat.format(data.attributes().col2().val())),
                                                        br(),
                                                        statline(data, mansYearLowTable))
                                        ))))),
                        div(
                                p("Żeńskie:"),
                                table(
                                        tbody(each(womanYearTable, (i, data) -> tr(
                                                td(String.valueOf(i + 1)),
                                                td(data.attributes().col1().repr()),
                                                td(
                                                        b(decimalFormat.format(data.attributes().col2().val())),
                                                        br(),
                                                        statline(data, womanYearLowTable))
                                        )))))
                )
        );
    }
}
