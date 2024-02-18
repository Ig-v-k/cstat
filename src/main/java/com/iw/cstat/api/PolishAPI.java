package com.iw.cstat.api;

import com.iw.cstat.API;

public final class PolishAPI implements API {
    @Override
    public String url() {
        return "https://api.dane.gov.pl/1.4";
    }
}
