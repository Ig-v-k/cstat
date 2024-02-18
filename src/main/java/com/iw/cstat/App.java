package com.iw.cstat;

import com.iw.cstat.page.HomePage;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        final Page home = new HomePage();
        Javalin.create()
                .get("/", ctx -> ctx.html(home.render()))
                .start(8080);
    }
}
