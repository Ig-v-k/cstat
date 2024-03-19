package com.iw.cstat.page;

import com.iw.cstat.CStats;
import com.iw.cstat.Data;
import com.iw.cstat.Page;
import com.iw.cstat.Params;
import com.iw.cstat.api.*;
import com.iw.cstat.cstat.JsonCStats;
import com.iw.cstat.facet.NameFacet;
import com.iw.cstat.params.NameParams;
import com.iw.cstat.res.RequestRes;

import java.util.List;
import java.util.Map;

public final class NamePage implements Page {

    private final Map<String, String> params;

    public NamePage(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public String render() {
        final String name = this.params.get("name");
        final String upName = name.toUpperCase();

        final Params params = new NameParams(this.params);
        final CStats cStats = new JsonCStats();
        final CStats resources = cStats.from(
                new RequestRes(new ResourcesAPI(new DatasetOf(219), params)).body());
        final Data data = resources.data().get(0);
        final CStats resourceData = cStats.from(
                new RequestRes(
                        new DataAPI(
                                new ResourceAPI(new PolishAPI(), data.id()),
                                String.format("q=col1:%s", upName))).body());
        final List<Data> cols = resourceData.data();
        final Data col = cols.get(0);

        return new TmplPage(
                upName,
                upName,
                String.format("About %s", upName),
                new NameFacet(col)).render();
    }
}
