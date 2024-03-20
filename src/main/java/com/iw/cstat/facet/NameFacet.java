package com.iw.cstat.facet;

import com.iw.cstat.Data;
import com.iw.cstat.Facet;
import j2html.tags.Tag;
import j2html.tags.specialized.MainTag;

import java.text.DecimalFormat;

import static j2html.TagCreator.*;

public final class NameFacet implements Facet<MainTag> {

    private final Data data;

    private final DecimalFormat decimalFormat = new DecimalFormat("#,###,###,###");

    public NameFacet(Data data) {
        this.data = data;
    }

    @Override
    public Tag<MainTag> tag() {
        final String count = decimalFormat.format(data.attributes().col3().val());
        return main(
                span("Liczba wystapien za ostatni rok:"),
                br(),
                span(count).withStyle("font-size:96px;")
        );
    }
}
