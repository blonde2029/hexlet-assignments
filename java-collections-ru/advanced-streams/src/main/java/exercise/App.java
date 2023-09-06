package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String str) {
        List<String> arr = Arrays.stream(str.split("\n")).toList();
        List<String> result = arr.stream()
                .filter(s -> s.startsWith("environment="))
                .map(s -> s.replaceAll("environment=", ""))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .filter(s -> s.contains("X_FORWARDED_"))
                .map(s -> s.replaceAll("\"", ""))
                .map(s -> s.replaceAll("X_FORWARDED_", ""))
                .peek(s -> System.out.println(s))
                .collect(Collectors.toList());

        String finalResult = result.stream()
                .map(s -> String.valueOf(s))
                .collect(Collectors.joining(","));
        return finalResult;//Arrays.stream(result).flatMap(s -> s.replaceAll(" ","")).toString();
    }
}
//END
