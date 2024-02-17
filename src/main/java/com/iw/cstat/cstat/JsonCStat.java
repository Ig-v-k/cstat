package com.iw.cstat.cstat;

import com.google.gson.Gson;
import com.iw.cstat.CStat;
import com.iw.cstat.Data;
import com.iw.cstat.Serialize;
import com.iw.cstat.data.SimpleData;

import java.util.ArrayList;
import java.util.List;

public final class JsonCStat implements CStat {

    private final List<Data> data;

    public JsonCStat() {
        this(new ArrayList<>());
    }

    public JsonCStat(List<Data> data) {
        this.data = data;
    }

    @Override
    public CStat from(Object from) {
        final String str = (String) from;
        return new Gson().newBuilder()
                .registerTypeAdapter(Data.class, new Serialize<>(SimpleData.class))
                .registerTypeAdapter(CStat.class, new Serialize<>(JsonCStat.class))
                .create()
                .fromJson(str, CStat.class);
    }

    @Override
    public List<Data> products() {
        return data;
    }
}
