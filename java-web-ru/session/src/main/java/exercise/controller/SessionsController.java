package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        var page = new LoginPage("","");
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }
    public static void enter(Context ctx) {
        var login = ctx.formParam("name");
        var password = encrypt(ctx.formParam("password"));
        var user = UsersRepository.findByName(login);
        var userPassword = "";
        if (user != null) {
             userPassword = user.getPassword();
        } else {
             userPassword = "";
        }
        if (password.equals(userPassword) && user != null) {
        ctx.sessionAttribute("authorized", String.valueOf(true));
        ctx.sessionAttribute("name", login);
        ctx.redirect(NamedRoutes.loginPath());
        } else {
            var error = "Wrong username or password";
            var page = new LoginPage(login, error);
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }

    }

    public static void show(Context ctx) {
        var authorized = ctx.sessionAttribute("authorized");
        if (authorized != null) {
            var name = ctx.sessionAttribute("name");
            var page = new MainPage(name);
            ctx.render("index.jte", Collections.singletonMap("page", page));
        } else {
            var page = new MainPage("");
            ctx.render("index.jte", Collections.singletonMap("page", page));
        }
    }
    public static void destroy(Context ctx) {
        ctx.sessionAttribute("authorized", null);
        ctx.redirect(NamedRoutes.loginPath());
    }
    // END
}
