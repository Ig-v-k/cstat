package com.iw.cstat;

public interface CStat {
    CStat from(final Object from);

    Data data();

    Links links();

    Meta meta();

    JsonApi jsonapi();
}
