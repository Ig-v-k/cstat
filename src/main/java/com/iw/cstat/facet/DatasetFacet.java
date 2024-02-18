package com.iw.cstat.facet;

import com.iw.cstat.Data;
import com.iw.cstat.Dataset;
import com.iw.cstat.Facet;
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
        return div(ul(each(data, d -> li(String.valueOf(d.id())))));
    }
}