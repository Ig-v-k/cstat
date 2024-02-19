package com.iw.cstat;

import com.iw.cstat.page.HomePage;
import com.iw.cstat.page.Page1681;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {
    public static void main(String[] args) {
        final Page home = new HomePage();
        final Page p1861 = new Page1681();
        Javalin.create(cfg -> {
                    cfg.staticFiles.add("/assets/public", Location.CLASSPATH);
                })
                .get("/", ctx -> ctx.html(home.render()))
                .get("/nazwiska-osob-zyjacych-wystepujace-w-rejestrze-pesel", ctx -> ctx.html(p1861.render()))
                .start(8080);
    }
}
