package com.iw.cstat;

import java.util.List;

public interface CStats {
    CStats from(final Object from);
    List<Data> data();
    Links links();
    Meta meta();
    JsonApi jsonapi();
}
