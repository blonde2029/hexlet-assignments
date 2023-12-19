package exercise;

import io.javalin.Javalin;
import exercise.controller.SessionsController;
import exercise.util.NamedRoutes;


public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
//        app.get(NamedRoutes.rootPath(), ctx -> {
//           ctx.render("index.jte");
////            ctx.redirect(NamedRoutes.buildSessionPath());
//        });
        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.loginPath(),SessionsController::enter);
        app.get(NamedRoutes.rootPath(),SessionsController::show);
        app.get(NamedRoutes.loginPath(), SessionsController::show);
        app.post(NamedRoutes.logoutPath(), SessionsController::destroy);
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
