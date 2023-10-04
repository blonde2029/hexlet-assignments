package exercise;

import java.util.*;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> v1, Map<String, Object> v2) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        SortedSet<String> allKeys = new TreeSet<>(v1.keySet());
        allKeys.addAll(v2.keySet());
        System.out.println(allKeys);
        for (String key: allKeys) {
            if (!v1.containsKey(key)) {
                result.put(key, "added");
            } else if (!v2.containsKey(key)) {
                result.put(key, "deleted");
            } else if (v1.get(key).equals(v2.get(key))) {
                result.put(key, "unchanged");
            } else {
                result.put(key, "changed");
            }
        }
        System.out.println(result);
        return result;
    }
}
//END
