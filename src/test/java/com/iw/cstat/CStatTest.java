package com.iw.cstat;

import com.iw.cstat.cstat.JsonCStat;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public final class CStatTest {

    private CStat cStat;

    @Before
    public void initialize() {
        final OkHttpClient client = new OkHttpClient();
        final String url = "https://api.dane.gov.pl/1.4/datasets/1667";
        final Request request = new Request.Builder().url(url).build();
        try (final Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }
            String body = response.body().string();
            cStat = new JsonCStat().from(body);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void from() {
        assertThat(cStat).isNotNull();
    }

    @Test
    public void data() {
        assertThat(cStat.data()).isNotNull();
    }

    @Test
    public void links() {
        assertThat(cStat.links()).isNotNull();
    }

    @Test
    public void meta() {
        assertThat(cStat.meta()).isNotNull();
    }

    @Test
    public void jsonapi() {
        assertThat(cStat.jsonapi()).isNotNull();
    }
}
