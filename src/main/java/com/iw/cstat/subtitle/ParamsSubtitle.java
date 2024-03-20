package com.iw.cstat.subtitle;

import com.iw.cstat.Subtitle;

import java.util.Map;

public final class ParamsSubtitle implements Subtitle {

    private final Map<String, String> original;

    public ParamsSubtitle(Map<String, String> original) {
        this.original = original;
    }

    @Override
    public String text() {
        final String sex = original.get("sex").equals("woman") ? "żeńskie" : "męskie";
        final String order = original.get("order").equals("first") ? "pierwsze" : "drugie";
        return String.format("Imie %s %s", sex, order);
    }
}
