package com.iw.cstat.page;

import com.iw.cstat.CStat;
import com.iw.cstat.Page;
import com.iw.cstat.Res;
import com.iw.cstat.api.DatasetOf;
import com.iw.cstat.api.InstitutionOf;
import com.iw.cstat.cstat.JsonCStat;
import com.iw.cstat.dat.DateFormat;
import com.iw.cstat.facet.Facet219;
import com.iw.cstat.res.RequestRes;
import j2html.tags.specialized.PTag;

import static j2html.TagCreator.*;

public final class Page219 implements Page {
    @Override
    public String render() {
        final Res res = new RequestRes(new DatasetOf(219));
        final CStat cstat = new JsonCStat().from(res.body());
        return new TmplPage(
                cstat.data().attributes().title(),
                cstat.data().attributes().title(),
                subline(cstat),
                new Facet219(cstat)).render();
    }

    private static String subline(final CStat cStat) {
        final String verified = new DateFormat(
                "yyyy-MM-dd'T'HH:mm:ss'Z'",
                cStat.data().attributes().verified(),
                cStat.meta().language()).text();
        return verified;
    }
}
