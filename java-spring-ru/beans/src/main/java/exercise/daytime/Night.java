package exercise.daytime;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Night implements Daytime {
    private String name = "night";

    public String getName() {
        return name;
    }

    // BEGIN
    @PostConstruct
    public void init() {
        System.out.println("Bean has been created");
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("Bean has been destroyed");
    }
    // END
}
