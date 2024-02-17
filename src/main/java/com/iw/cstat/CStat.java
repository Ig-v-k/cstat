package com.iw.cstat;

import java.util.List;

public interface CStat {
    CStat from(final Object from);
    List<Data> products();
}
