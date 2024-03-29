package com.iw.cstat.facet;

import com.iw.cstat.CStat;
import com.iw.cstat.CStats;
import com.iw.cstat.Data;
import com.iw.cstat.Facet;
import com.iw.cstat.api.*;
import com.iw.cstat.cstat.JsonCStats;
import com.iw.cstat.res.RequestRes;
import j2html.tags.DomContent;
import j2html.tags.Tag;
import j2html.tags.specialized.ButtonTag;
import j2html.tags.specialized.MainTag;
import j2html.tags.specialized.SelectTag;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static j2html.TagCreator.*;

public final class ListFacet implements Facet<MainTag> {

    private final CStat cStat;
    private final Map<String, List<String>> filters;
    final DecimalFormat decimalFormat = new DecimalFormat("#,###,###,###");

    public ListFacet(CStat cStat, Map<String, List<String>> filters) {
        this.cStat = cStat;
        this.filters = filters;
    }

    @Override
    public Tag<MainTag> tag() {
        final String[] params = params();
        final CStats cStats = new JsonCStats();
        final CStats resources = cStats.from(
                new RequestRes(new ResourcesAPI(new DatasetOf(219), params)).body());
        final Data data = resources.data().get(0);
        final CStats resourceData = cStats.from(
                new RequestRes(new DataAPI(new ResourceAPI(new PolishAPI(), data.id()), "per_page=100")).body());
        final List<Data> cols = resourceData.data();

        final String order = filters.getOrDefault("name", Collections.singletonList("first")).get(0);
        final String sex = filters.getOrDefault("sex", Collections.singletonList("woman")).get(0);

        return main(
                aside(
                        p(b("Filtry")),
                        filters()),
                table(tbody(each(cols, (i, d) -> {
                    final String name = d.attributes().col1().repr();
                    return tr(
                            td(String.valueOf(i + 1)),
                            td(a(name).withHref(String.format("/name/%s/%s/%s", sex, order, name.toLowerCase()))),
                            td(b(decimalFormat.format(d.attributes().col3().val())))
                    );
                }))));
    }

    private String[] params() {
        final String nameParam = filters.getOrDefault("name", Collections.singletonList("first")).get(0);
        final String sexParam = filters.getOrDefault("sex", Collections.singletonList("woman")).get(0);

        final String name = nameParam.equals("first") ? "pierwsze" : "drugie";
        final String sex = sexParam.equals("woman") ? "żeńskie" : "męskie";

        return new String[] {
                String.format("title[prefix]=imiona %s", sex),
                String.format("title[phrase]=r. - imię %s", name),
                "sort=-created",
                "per_page=1",
                "page=1"};
    }

    private DomContent filters() {
        final SelectTag sex = select(
                option("żeńskie").withValue("woman"),
                option("męskie").withValue("man")).withName("sex");
        final SelectTag name = select(
                option("pierwsze").withValue("first"),
                option("drugie").withValue("second")).withName("name");
        final ButtonTag submit = button("Filtruj").withType("submit");
        return form()
                .withMethod("get")
                .withAction("/imiona-nadawane-dzieciom-w-polsce")
                .with(sex, name, submit);
    }
}
