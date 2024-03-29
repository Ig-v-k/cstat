package com.iw.cstat;

public interface Attributes {
    String slug();

    String verified();

    String notes();

    String title();

    String website();

    int viewsCount();

    int downloadsCount();

    Col1 col1();

    Col2 col2();

    Col3 col3();

    Region[] regions();
}
