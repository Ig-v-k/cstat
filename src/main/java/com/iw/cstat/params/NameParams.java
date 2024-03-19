package com.iw.cstat.params;

import com.iw.cstat.Params;

import java.util.Collections;
import java.util.Map;

public final class NameParams implements Params {

    private final Map<String, String> original;

    public NameParams(Map<String, String> original) {
        this.original = original;
    }

    @Override
    public String[] array() {
        final String nameParam = original.get("order");
        final String sexParam = original.get("sex");

        final String name = nameParam.equals("first") ? "pierwsze" : "drugie";
        final String sex = sexParam.equals("woman") ? "żeńskie" : "męskie";

        return new String[] {
                String.format("title[prefix]=imiona %s", sex),
                String.format("title[phrase]=r. - imię %s", name),
                "sort=-created",
                "per_page=1",
                "page=1"};
    }
}
