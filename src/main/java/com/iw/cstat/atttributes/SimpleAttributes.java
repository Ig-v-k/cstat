package com.iw.cstat.atttributes;

import com.iw.cstat.Attributes;

public final class SimpleAttributes implements Attributes {

    private final String notes;
    private final String title;
    private final int viewsCount;

    public SimpleAttributes(String notes, String title, int viewsCount) {
        this.notes = notes;
        this.title = title;
        this.viewsCount = viewsCount;
    }

    @Override
    public String notes() {
        return notes;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public int viewsCount() {
        return viewsCount;
    }
}
