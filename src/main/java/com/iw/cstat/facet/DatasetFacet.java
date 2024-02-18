package com.iw.cstat.facet;

import com.iw.cstat.Data;
import com.iw.cstat.Facet;
import j2html.TagCreator;
import j2html.tags.DomContent;
import j2html.tags.EmptyTag;
import j2html.tags.Tag;
import j2html.tags.specialized.DivTag;

import java.util.List;

import static j2html.TagCreator.*;

public final class DatasetFacet implements Facet<DivTag> {

    private final List<Data> data;

    public DatasetFacet(List<Data> data) {
        this.data = data;
    }

    @Override
    public Tag<DivTag> tag() {
        return div(each(data, d -> section(article(
                head(h2(d.attributes().title())),
                main(rawHtml(d.attributes().notes())),
                footer(String.valueOf(d.attributes().viewsCount()))
        ))));
    }
}
