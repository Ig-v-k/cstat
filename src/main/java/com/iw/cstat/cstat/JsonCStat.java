package com.iw.cstat.cstat;

import com.google.gson.Gson;
import com.iw.cstat.*;
import com.iw.cstat.data.SimpleData;
import com.iw.cstat.jsonapi.SimpleJsonApi;
import com.iw.cstat.links.SimpleLinks;
import com.iw.cstat.meta.SimpleMeta;

public final class JsonCStat implements CStat {

    private final Data data;
    private final Links links;
    private final Meta meta;
    private final JsonApi jsonapi;

    public JsonCStat() {
        this(null, null, null, null);
    }

    public JsonCStat(Data data, Links links, Meta meta, JsonApi jsonapi) {
        this.data = data;
        this.links = links;
        this.meta = meta;
        this.jsonapi = jsonapi;
    }

    @Override
    public CStat from(Object from) {
        final String str = (String) from;
        return new Gson().newBuilder()
                .registerTypeAdapter(Data.class, new Serialize<>(SimpleData.class))
                .registerTypeAdapter(Links.class, new Serialize<>(SimpleLinks.class))
                .registerTypeAdapter(Meta.class, new Serialize<>(SimpleMeta.class))
                .registerTypeAdapter(JsonApi.class, new Serialize<>(SimpleJsonApi.class))
                .registerTypeAdapter(CStat.class, new Serialize<>(JsonCStat.class))
                .create()
                .fromJson(str, CStat.class);
    }

    @Override
    public Data data() {
        return data;
    }

    @Override
    public Links links() {
        return links;
    }

    @Override
    public Meta meta() {
        return meta;
    }

    @Override
    public JsonApi jsonapi() {
        return jsonapi;
    }
}
