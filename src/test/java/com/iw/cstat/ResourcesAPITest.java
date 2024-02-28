package com.iw.cstat;

import com.iw.cstat.api.DatasetOf;
import com.iw.cstat.api.ResourcesAPI;
import com.iw.cstat.cstat.JsonCStats;
import com.iw.cstat.res.RequestRes;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class ResourcesAPITest {
    @Test
    public void filtered() {
        final Res res = new RequestRes(new ResourcesAPI(new DatasetOf(1681), "created[gte]=2023"));
        final CStats cStats = new JsonCStats().from(res.body());
        assertThat(cStats.data()).isNotEmpty();
    }
}
