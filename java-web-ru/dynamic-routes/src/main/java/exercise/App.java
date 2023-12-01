package exercise;

import io.javalin.Javalin;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            //var id = Integer.parseInt(ctx.pathParam("id"));
            var id = ctx.pathParam("id");
            var res = COMPANIES.stream()
                            .filter(c -> c.get("id").equals(id)).findFirst().orElse(null);
            if (res != null) {
                ctx.json(res);
            } else {
                ctx.status(404);
                ctx.result("Company not found");
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
