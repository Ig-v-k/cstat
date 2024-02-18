package com.iw.cstat;

import com.iw.cstat.page.HomePage;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {
    public static void main(String[] args) {
        final Page home = new HomePage();
        Javalin.create(cfg -> {
                    cfg.staticFiles.add("/assets/public", Location.CLASSPATH);
                })
                .get("/", ctx -> ctx.html(home.render()))
                .start(8080);
    }
}
