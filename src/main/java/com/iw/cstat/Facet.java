package com.iw.cstat;

import j2html.tags.Tag;

public interface Facet<T extends Tag<T>> {
    Tag<T> tag();
}
