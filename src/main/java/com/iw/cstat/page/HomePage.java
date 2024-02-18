package com.iw.cstat.page;

import com.iw.cstat.Page;
import com.iw.cstat.dataset.CustomDataset;
import com.iw.cstat.facet.DatasetFacet;

public final class HomePage implements Page {
    @Override
    public String render() {
        final CustomDataset dataset = new CustomDataset(new String[]{"1667"});
        return new TmplPage("cstat", new DatasetFacet(dataset.list())).render();
    }
}
