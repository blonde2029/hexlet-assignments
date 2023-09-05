package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        List<String> result = users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .sorted(Comparator.comparing(birthday -> birthday.get("birthday")))
                .map(user -> user.get("name"))
                .collect(Collectors.toList());
        return result;

    }
}
// END
