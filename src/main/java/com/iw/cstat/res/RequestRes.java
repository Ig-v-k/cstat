package com.iw.cstat.res;

import com.iw.cstat.Res;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public final class RequestRes implements Res {

    private final String url;

    public RequestRes(String url) {
        this.url = url;
    }

    @Override
    public String body() {
        final OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(url).build();
        try (final Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }
            String body = response.body().string();
            return body;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
