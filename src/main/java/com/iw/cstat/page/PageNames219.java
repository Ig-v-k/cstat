package com.iw.cstat.page;

import com.iw.cstat.CStat;
import com.iw.cstat.Page;
import com.iw.cstat.Res;
import com.iw.cstat.api.DatasetOf;
import com.iw.cstat.cstat.JsonCStat;
import com.iw.cstat.facet.ListFacet;
import com.iw.cstat.res.RequestRes;

public final class PageNames219 implements Page {
    @Override
    public String render() {
        final Res res = new RequestRes(new DatasetOf(219));
        final CStat cstat = new JsonCStat().from(res.body());
        return new TmplPage(
                "Imiona zenskie - imie perwsze",
                "Imiona zenskie - imie perwsze",
                "Śledź trendy w nazwach",
                new ListFacet(cstat)).render();
    }
}
