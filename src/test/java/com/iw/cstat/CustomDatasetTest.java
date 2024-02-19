package com.iw.cstat;

import com.iw.cstat.dataset.CustomDataset;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class CustomDatasetTest {
    @Test
    public void list() {
        final String[] ids = new String[] {"1681"};
        final Dataset dataset = new CustomDataset(ids);
        final List<CStat> list = dataset.list();
        assertThat(list).hasSizeGreaterThan(0);
    }
}
