package com.iw.cstat;

import com.iw.cstat.api.ApiOf;
import com.iw.cstat.cstat.JsonCStat;
import com.iw.cstat.res.RequestRes;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class InstitutionTest {

    private CStat cStat;

    @Before
    public void initialization() {
        final Res res = new RequestRes(new ApiOf(1681));
        this.cStat = new JsonCStat().from(res.body());
    }

    @Test
    public void self() {
        final String self = cStat.data().links().self();
        assertThat(self).isNotBlank();
    }

    @Test
    public void related() {
        final String related = cStat.data().relationships().institution().links().related();
        assertThat(related).isNotBlank();
    }
}
