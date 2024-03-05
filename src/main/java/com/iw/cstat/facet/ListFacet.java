package com.iw.cstat.facet;

import com.iw.cstat.CStat;
import com.iw.cstat.CStats;
import com.iw.cstat.Facet;
import com.iw.cstat.cstat.JsonCStats;
import j2html.tags.Tag;
import j2html.tags.specialized.MainTag;

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
        final CStats cStats = new JsonCStats();
        final String[] params = new String[] {
                "title[prefix]=imiona zenskie",
                "title[phrase]=r. - imie pierwsze",
                "sort=-created",
                "per_page=1"};

        return main("test");
    }
}
