package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage dataObject) {
        dataObject.toMap().entrySet().stream().forEach(data -> {
            dataObject.set(data.getValue(), data.getKey());
            dataObject.unset(data.getKey());
        });
    }
}
// END
