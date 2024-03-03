package com.iw.cstat.page;

import com.iw.cstat.Page;
import com.iw.cstat.facet.ListFacet;

public final class PageFirstNames219 implements Page {
    @Override
    public String render() {
        return new TmplPage("Imiona zenskie - imie perwsze", new ListFacet()).render();
    }
}
