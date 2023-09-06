package exercise;

import java.util.*;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> v1, Map<String, Object> v2) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();

        //Set<Map<String,Object>> allMaps = new HashSet<>((Collection) v1.entrySet());
        //allMaps.addAll((Collection) v2.entrySet());
        Map<String, Object> allMaps = new HashMap<>(v1);
        allMaps.putAll(v2);

        for (String elem : allMaps.keySet()) {
            if (!v1.containsKey(elem)) {
                result.put(elem, "added");
            } else if (!v2.containsKey(elem)) {
                result.put(elem, "deleted");
            } else if (v1.containsValue(allMaps.get(elem))) {
                result.put(elem, "unchanged");
            } else if (!v1.containsValue(allMaps.get(elem))) {
                result.put(elem, "changed");
            }
        }

        System.out.println(result);
        return result;

    }
}
//END
