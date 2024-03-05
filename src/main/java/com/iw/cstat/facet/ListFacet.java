package com.iw.cstat.facet;

import com.iw.cstat.CStat;
import com.iw.cstat.Facet;
import j2html.tags.DomContent;
import j2html.tags.Tag;
import j2html.tags.specialized.ButtonTag;
import j2html.tags.specialized.MainTag;
import j2html.tags.specialized.SelectTag;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static j2html.TagCreator.*;

public final class ListFacet implements Facet<MainTag> {

    private final CStat cStat;
    private final Map<String, List<String>> filters;

    public ListFacet(CStat cStat, Map<String, List<String>> filters) {
        this.cStat = cStat;
        this.filters = filters;
    }

    @Override
    public Tag<MainTag> tag() {
        final String[] params = params();
        return main(
                p(Arrays.toString(params)),
                filters());
    }

    private String[] params() {
        final String name = filters.getOrDefault("name", Collections.singletonList("pierwsze")).get(0);
        final String sex = filters.getOrDefault("sex", Collections.singletonList("żeńskie")).get(0);
        return new String[] {
                String.format("title[prefix]=imiona %s", sex),
                String.format("title[phrase]=r. - imię %s", name),
                "sort=-created",
                "per_page=100",
                "page=1"};
    }

    private DomContent filters() {
        final SelectTag sex = select(
                option("żeńskie").withValue("żeńskie"),
                option("męskie").withValue("męskie")).withName("sex");
        final SelectTag name = select(
                option("pierwsze").withValue("pierwsze"),
                option("drugie").withValue("drugie")).withName("name");
        final ButtonTag submit = button("Filtruj").withType("submit");
        return form()
                .withMethod("get")
                .withAction("/imiona-nadawane-dzieciom-w-polsce/names")
                .with(sex, name, submit);
    }
}
