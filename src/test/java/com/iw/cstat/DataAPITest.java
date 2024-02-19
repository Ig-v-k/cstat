package com.iw.cstat;

import com.iw.cstat.api.DataAPI;
import com.iw.cstat.api.DatasetsAPI;
import com.iw.cstat.api.PolishAPI;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class DataAPITest {
    @Test
    public void notEmpty() {
        final API api =
                new DataAPI(
                        new DatasetsAPI(
                                new PolishAPI()), "1681");
        assertThat(api.url()).isNotEmpty();
    }

    @Test
    public void url() {
        final API api =
                new DataAPI(
                        new DatasetsAPI(
                                new PolishAPI()), "1681");
        assertThat(api.url()).isEqualTo("https://api.dane.gov.pl/1.4/datasets/1681");
    }
}
