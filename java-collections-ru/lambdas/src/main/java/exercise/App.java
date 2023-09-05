package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .map(rows -> Arrays.stream(rows)
                        .flatMap(item -> Arrays.stream(new String[] {item, item}))
                        .toArray(String[]::new))
                .flatMap(line -> Arrays.stream(new String[][] {line, line}))
                .toArray(String[][]::new);
    }
}
// END
