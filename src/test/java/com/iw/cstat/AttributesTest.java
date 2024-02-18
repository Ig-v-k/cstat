package com.iw.cstat;

import com.iw.cstat.api.ApiOf;
import com.iw.cstat.cstat.JsonCStat;
import com.iw.cstat.res.RequestRes;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class AttributesTest {

    private Attributes attributes;

    @Before
    public void initialize() {
        final Res res = new RequestRes(new ApiOf(1667));
        final CStat cStat = new JsonCStat().from(res.body());
        final Data data = cStat.data();
        this.attributes = data.attributes();
    }

    @Test
    public void titleAvailable() {
        final String title = attributes.title();
        assertThat(title).isNotEmpty();
    }
}
