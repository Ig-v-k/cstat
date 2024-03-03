package com.iw.cstat.page;

import com.iw.cstat.Page;
import com.iw.cstat.facet.ListFacet;

public final class PageFirstNames219 implements Page {
    @Override
    public String render() {
        return new TmplPage(
                "Imiona zenskie - imie perwsze",
                "Imiona zenskie - imie perwsze",
                "Śledź trendy w nazwach",
                new ListFacet()).render();
    }
}
