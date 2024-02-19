package com.iw.cstat;

import com.iw.cstat.api.ApiOf;
import com.iw.cstat.cstat.JsonCStat;
import com.iw.cstat.res.RequestRes;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class MetaTest {

    private Meta meta;

    @Before
    public void initialize() {
        final Res res = new RequestRes(new ApiOf(1681));
        final CStat cStat = new JsonCStat().from(res.body());
        this.meta = cStat.meta();
    }

    @Test
    public void language() {
        final String language = meta.language();
        assertThat(language).isNotBlank();
    }
}
