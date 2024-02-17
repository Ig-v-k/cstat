package com.iw.cstat;

import com.iw.cstat.res.RequestRes;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class ResTest {
    @Test
    public void body() {
        final Res res = new RequestRes("https://api.dane.gov.pl/1.4/datasets/1667");
        assertThat(res.body()).isNotEmpty();
    }
}
