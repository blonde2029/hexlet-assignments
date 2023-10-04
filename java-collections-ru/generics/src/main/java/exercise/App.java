package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> search) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book : books) {
            if (book.entrySet().containsAll(search.entrySet())) {
                result.add(book);
            }
        }
        System.out.println(result);
        return result;
    }
}
//END
