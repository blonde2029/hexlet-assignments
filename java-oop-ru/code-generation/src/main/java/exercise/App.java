package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

// BEGIN
class App {
    public static void save(Path path, Car car) {
        String json = car.serialize();
        try {
            Files.write(path, json.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static Car extract(Path path) {
        ObjectMapper mapper = new ObjectMapper();
        Car car;
        try {
            car = mapper.readValue(path.toFile(), Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return car;
    }
}
// END
