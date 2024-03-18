package com.iw.cstat;

import com.iw.cstat.page.*;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {
    public static void main(String[] args) {
        final Page home = new HomePage();
        final Page p1861 = new Page1681();
        Javalin.create(cfg -> cfg.staticFiles.add("/assets/public", Location.CLASSPATH))
                .get("/", ctx -> ctx.html(home.render()))
                .get("/nazwiska-osob-zyjacych-wystepujace-w-rejestrze-pesel", ctx -> ctx.html(p1861.render()))
                .get("/imiona-nadawane-dzieciom-w-polsce", ctx -> ctx.html(new Page219(ctx.queryParamMap()).render()))
                .get("/names/{name}", ctx -> ctx.html(new NamePage(ctx.pathParam("name")).render()))
                .start(port());
    }

    private static int port() {
        final ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 8080;
    }
}
