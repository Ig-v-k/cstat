package com.iw.cstat.page;

import com.iw.cstat.Facet;
import com.iw.cstat.Page;
import j2html.tags.Tag;
import j2html.tags.specialized.SpanTag;

import static j2html.TagCreator.span;

public final class NamePage implements Page {

    private final String name;

    public NamePage(String name) {
        this.name = name;
    }

    @Override
    public String render() {
        return new TmplPage(
                name,
                name,
                String.format("About %s", name),
                new Facet<SpanTag>() {
                    @Override
                    public Tag<SpanTag> tag() {
                        return span("test");
                    }
                }).render();
    }
}
