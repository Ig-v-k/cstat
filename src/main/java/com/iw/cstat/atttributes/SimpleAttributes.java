package com.iw.cstat.atttributes;

import com.iw.cstat.Attributes;

public final class SimpleAttributes implements Attributes {

    private final String verified;
    private final String notes;
    private final String title;
    private final int views_count;
    private final int downloads_count;

    public SimpleAttributes(String verified, String notes, String title, int views_count, int downloads_count) {
        this.verified = verified;
        this.notes = notes;
        this.title = title;
        this.views_count = views_count;
        this.downloads_count = downloads_count;
    }

    @Override
    public String verified() {
        return verified;
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
        return views_count;
    }

    @Override
    public int downloadsCount() {
        return downloads_count;
    }
}
