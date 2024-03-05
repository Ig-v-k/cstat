package com.iw.cstat.page;

import com.iw.cstat.CStat;
import com.iw.cstat.Page;
import com.iw.cstat.Res;
import com.iw.cstat.api.DatasetOf;
import com.iw.cstat.cstat.JsonCStat;
import com.iw.cstat.facet.ListFacet;
import com.iw.cstat.res.RequestRes;

import java.util.List;
import java.util.Map;

public final class PageNames219 implements Page {

    private final Res res;
    private final Map<String, List<String>> params;

    public PageNames219(final Map<String, List<String>> params) {
        this(new RequestRes(new DatasetOf(219)), params);
    }

    private PageNames219(Res res, final Map<String, List<String>> params) {
        this.res = res;
        this.params = params;
    }

    @Override
    public String render() {
        final CStat cstat = new JsonCStat().from(res.body());
        return new TmplPage(
                "Imiona",
                "Imiona",
                "Lista imion",
                new ListFacet(cstat, params)).render();
    }
}
