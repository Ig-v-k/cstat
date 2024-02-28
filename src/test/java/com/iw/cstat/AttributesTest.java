package com.iw.cstat;

import com.iw.cstat.api.DatasetOf;
import com.iw.cstat.cstat.JsonCStat;
import com.iw.cstat.res.RequestRes;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class AttributesTest {

    private Attributes attributes;

    @Before
    public void initialize() {
        final Res res = new RequestRes(new DatasetOf(1681));
        final CStat cStat = new JsonCStat().from(res.body());
        final Data data = cStat.data();
        this.attributes = data.attributes();
    }

    @Test
    public void notesAvailable() {
        final String notes = attributes.notes();
        assertThat(notes).isNotEmpty();
    }

    @Test
    public void titleAvailable() {
        final String title = attributes.title();
        assertThat(title).isNotEmpty();
    }

    @Test
    public void viewsCountAvailable() {
        final int viewsCount = attributes.viewsCount();
        assertThat(viewsCount).isGreaterThanOrEqualTo(0);
    }
}
