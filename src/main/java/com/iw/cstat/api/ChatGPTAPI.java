package com.iw.cstat.api;

import com.iw.cstat.API;

public final class ChatGPTAPI implements API {
    @Override
    public String url() {
        return "https://api.openai.com/v1/chat/completions";
    }
}
