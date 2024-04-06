package com.iw.cstat;

import com.iw.cstat.api.ChatGPTAPI;
import com.iw.cstat.res.ChatGPTRes;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class APITest {
    @Test
    public void chatgpt() throws IOException {
        final String chatgpt = "src/main/resources/chatgpt.properties";
        final Properties properties = new Properties();
        properties.load(new FileInputStream(chatgpt));
        final String key = properties.getProperty("api.key");
        final Res res = new ChatGPTRes(key, new ChatGPTAPI(), "Igor");
        System.out.println(res.body());
    }
}
