package com.iw.cstat.page;

import com.iw.cstat.Facet;
import com.iw.cstat.Page;
import j2html.tags.Tag;
import j2html.tags.specialized.FooterTag;
import j2html.tags.specialized.HeaderTag;

import static j2html.TagCreator.*;

public final class TmplPage implements Page {

    private final String title;
    private final Facet<? extends Tag<?>> facet;

    public TmplPage(String title, Facet<? extends Tag<?>> facet) {
        this.title = title;
        this.facet = facet;
    }

    @Override
    public String render() {
        return html(
                head(
                        meta().withCharset("UTF-8"),
                        meta().withName("viewport").withContent("width=device-width, initial-scale=1.0"),
                        meta().withName("keywords").withContent("statistic, progress, government"),
                        meta().withName("description").withContent("Country statistic"),
                        title(title.isEmpty() ? "cstat" : title),
                        link().withRel("stylesheet").withHref("/css/simple.min.css"),
                        link().withRel("icon").withType("image/png").withHref("/images/logo/logo_32.png")
                ),
                body(
                        hdr(),
                        facet.tag(),
                        ftr()
                )

        ).render();
    }

    private static HeaderTag hdr() {
        return header(
                nav(
                        a("Home").withHref("/"),
                        a("Github").withHref("https://github.com/Ig-v-k/cstat")
                )
        );
    }

    private static FooterTag ftr() {
        return footer(
                p(join("Made by ", a("@Ig-v-k").withHref("https://github.com/Ig-v-k"), ", 2024")),
                nav(a("GitHub").withHref("https://github.com/Ig-v-k/cstat"))
        );
    }
}
