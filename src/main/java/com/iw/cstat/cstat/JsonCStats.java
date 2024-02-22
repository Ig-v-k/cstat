package com.iw.cstat.cstat;

import com.google.gson.Gson;
import com.iw.cstat.*;
import com.iw.cstat.atttributes.SimpleAttributes;
import com.iw.cstat.data.SimpleData;
import com.iw.cstat.institution.SimpleInstitution;
import com.iw.cstat.jsonapi.SimpleJsonApi;
import com.iw.cstat.links.SimpleLinks;
import com.iw.cstat.meta.SimpleMeta;
import com.iw.cstat.relationships.SimpleRelationships;
import com.iw.cstat.resources.SimpleResources;

import java.util.List;

public final class JsonCStats implements CStats {

    private final List<Data> data;
    private final Links links;
    private final Meta meta;
    private final JsonApi jsonapi;

    public JsonCStats() {
        this(null, null, null, null);
    }

    public JsonCStats(List<Data> data, Links links, Meta meta, JsonApi jsonapi) {
        this.data = data;
        this.links = links;
        this.meta = meta;
        this.jsonapi = jsonapi;
    }

    @Override
    public CStats from(Object from) {
        final String str = (String) from;
        return new Gson().newBuilder()
                .registerTypeAdapter(Data.class, new Serialize<>(SimpleData.class))
                .registerTypeAdapter(Links.class, new Serialize<>(SimpleLinks.class))
                .registerTypeAdapter(Meta.class, new Serialize<>(SimpleMeta.class))
                .registerTypeAdapter(JsonApi.class, new Serialize<>(SimpleJsonApi.class))
                .registerTypeAdapter(Attributes.class, new Serialize<>(SimpleAttributes.class))
                .registerTypeAdapter(Relationships.class, new Serialize<>(SimpleRelationships.class))
                .registerTypeAdapter(Resources.class, new Serialize<>(SimpleResources.class))
                .registerTypeAdapter(Institution.class, new Serialize<>(SimpleInstitution.class))
                .registerTypeAdapter(CStats.class, new Serialize<>(JsonCStats.class))
                .create()
                .fromJson(str, CStats.class);
    }

    @Override
    public List<Data> data() {
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
