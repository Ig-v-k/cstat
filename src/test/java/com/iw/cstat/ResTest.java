package com.iw.cstat;

import com.iw.cstat.api.DatasetsAPI;
import com.iw.cstat.api.PolishAPI;
import com.iw.cstat.res.RequestRes;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class ResTest {
    @Test
    public void body() {
        final Res res = new RequestRes(new DatasetsAPI(new PolishAPI()));
        assertThat(res.body()).isNotEmpty();
    }
}