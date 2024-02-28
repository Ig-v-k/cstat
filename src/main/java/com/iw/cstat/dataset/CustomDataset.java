package com.iw.cstat.dataset;

import com.iw.cstat.CStat;
import com.iw.cstat.Dataset;
import com.iw.cstat.Res;
import com.iw.cstat.api.DatasetsAPI;
import com.iw.cstat.api.PolishAPI;
import com.iw.cstat.cstat.JsonCStat;
import com.iw.cstat.res.RequestRes;

import java.util.ArrayList;
import java.util.List;

public final class CustomDataset implements Dataset {

    private final String[] ids;

    public CustomDataset(String[] ids) {
        this.ids = ids;
    }

    @Override
    public List<CStat> list() {
        final List<CStat> cStats = new ArrayList<>(1);
        final CStat cStat = new JsonCStat();
        for (String id : ids) {
            final Res res =
                    new RequestRes(new DatasetsAPI(new PolishAPI(), id));
            final CStat from = cStat.from(res.body());
            cStats.add(from);
        }
        return cStats;
    }
}
