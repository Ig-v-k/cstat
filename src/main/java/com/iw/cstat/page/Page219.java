package com.iw.cstat.page;

import com.iw.cstat.CStat;
import com.iw.cstat.Page;
import com.iw.cstat.Res;
import com.iw.cstat.api.DatasetOf;
import com.iw.cstat.cstat.JsonCStat;
import com.iw.cstat.facet.Facet219;
import com.iw.cstat.res.RequestRes;

public final class Page219 implements Page {
    @Override
    public String render() {
        final Res res = new RequestRes(new DatasetOf(219));
        final CStat cstat = new JsonCStat().from(res.body());
        return new TmplPage(cstat.data().attributes().title(), new Facet219(cstat)).render();
    }
}
