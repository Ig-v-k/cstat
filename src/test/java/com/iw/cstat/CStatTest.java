package com.iw.cstat;

import com.iw.cstat.cstat.JsonCStat;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public final class CStatTest {
    @Test
    public void from() {
        final OkHttpClient client = new OkHttpClient();
        final String url = "https://api.dane.gov.pl/1.4/datasets/1667";
        final Request request = new Request.Builder().url(url).build();
        try (final Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }
            String body = response.body().string();
            CStat cStat = new JsonCStat().from(body);
            assertThat(cStat.data().id()).isEqualTo(1667);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
