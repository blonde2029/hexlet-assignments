package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        ObjectMapper om = new ObjectMapper();
        var app = Javalin.create(javalinConfig -> javalinConfig.plugins.enableDevLogging());
        String phones = "";
        try {
            phones = om.writeValueAsString(Data.getPhones());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String finalPhones = phones;
        app.get("/phones", ctx -> ctx.result(finalPhones));
        String domains = null;
        try {
            domains = om.writeValueAsString(Data.getDomains());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String finalDomains = domains;
        app.get("/domains", ctx -> ctx.result(finalDomains));
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
