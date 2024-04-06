package com.iw.cstat.res;

import com.iw.cstat.API;
import com.iw.cstat.Res;
import okhttp3.*;

import java.io.IOException;

public final class ChatGPTRes implements Res {

    private final String key;
    private final API api;
    private final String name;

    public ChatGPTRes(String key, API api, String name) {
        this.key = key;
        this.api = api;
        this.name = name;
    }

    @Override
    public String body() {
        final OkHttpClient client = new OkHttpClient();

        final MediaType media = MediaType.parse("application/json; charset=utf-8");
        final String json = json(prompt(name));
        final RequestBody body = RequestBody.create(media, json);

        final Request request = new Request.Builder()
                .url(api.url())
                .post(body)
                .addHeader("Authorization", "Bearer " + key)
                .build();
        try (final Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String json(String prompt) {
        return String.format("{\"model\": \"%s\", \"prompt\": \"%s\", \"max_tokens\": %d, \"n\": %d, \"stop\": null, \"temperature\": %.1f}",
                "gpt-3.5-turbo", prompt, 100, 1, 0.7);
    }

    private String prompt(final String name) {
        return String.format("Please, analyzing the name \"%s\" and provide more different statistics about this name.", name);
    }
}
