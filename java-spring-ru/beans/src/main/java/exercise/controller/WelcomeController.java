package exercise.controller;

import exercise.daytime.Day;
import exercise.daytime.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// BEGIN
@RestController
@Component
public class WelcomeController {
    @Autowired
    private Daytime daytime;
    @GetMapping(path = "/welcome")
    public String welcome() {
        if (daytime.getName().equals("night")) {
            return "It is night now! Welcome to Spring!";
        }
        return "It is day now! Welcome to Spring!";
    }
}
// END
