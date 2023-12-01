package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        List<Map<String, String>> users = Data.getUsers();

        app.get("/users", ctx -> {
           var page = ctx.queryParam("page");
           var per = ctx.queryParam("per");
           var actPage = page == null ? 1 : Integer.parseInt(page);
           var actPer  = per == null ? 5 : Integer.parseInt(per);
           List<Map<String, String>> res = new ArrayList<>();
           for (var i = 0; i < actPer; i++) {
               var currentUser = users.get(actPage * actPer - actPer + i);
               res.add(currentUser);
           }
           ctx.json(res);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
