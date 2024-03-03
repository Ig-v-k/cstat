package com.iw.cstat.facet;

import com.iw.cstat.*;
import com.iw.cstat.api.DataAPI;
import com.iw.cstat.api.DatasetOf;
import com.iw.cstat.api.ResourceOf;
import com.iw.cstat.api.ResourcesAPI;
import com.iw.cstat.cstat.JsonCStats;
import com.iw.cstat.res.RequestRes;
import j2html.tags.Tag;
import j2html.tags.specialized.MainTag;

import java.util.List;

import static j2html.TagCreator.*;

public final class ListFacet implements Facet<MainTag> {

    private final CStat cStat;

    public ListFacet(CStat cStat) {
        this.cStat = cStat;
    }

    @Override
    public Tag<MainTag> tag() {
        final CStats cStats = new JsonCStats();
        final API api219 = new DatasetOf(219);

        return main(
                table(each())
        );
    }
}
