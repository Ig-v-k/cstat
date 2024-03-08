package com.iw.cstat.atttributes;

import com.iw.cstat.*;

public final class SimpleAttributes implements Attributes {

    private final String slug;
    private final String verified;
    private final String notes;
    private final String title;
    private final String website;
    private final int views_count;
    private final int downloads_count;
    private final Col1 col1;
    private final Col2 col2;
    private final Col3 col3;
    private final Region[] regions;

    public SimpleAttributes(String slug, String verified, String notes, String title, String website, int views_count, int downloads_count, Col1 col1, Col2 col2, Col3 col3, Region[] regions) {
        this.slug = slug;
        this.verified = verified;
        this.notes = notes;
        this.title = title;
        this.website = website;
        this.views_count = views_count;
        this.downloads_count = downloads_count;
        this.col1 = col1;
        this.col2 = col2;
        this.col3 = col3;
        this.regions = regions;
    }

    @Override
    public String slug() {
        return slug;
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
    public String website() {
        return website;
    }

    @Override
    public int viewsCount() {
        return views_count;
    }

    @Override
    public int downloadsCount() {
        return downloads_count;
    }

    @Override
    public Col1 col1() {
        return col1;
    }

    @Override
    public Col2 col2() {
        return col2;
    }

    @Override
    public Col3 col3() {
        return col3;
    }

    @Override
    public Region[] regions() {
        return regions;
    }
}
