package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class InMemoryKV implements KeyValueStorage {
    private Map<String, String> map;
    public InMemoryKV(Map<String, String> dataObject) {
        this.map = new HashMap<>();
        this.map.putAll(dataObject);
    }

    @Override
    public void set(String key, String value) {
            map.put(key, value);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return map.containsKey(key) ? map.get(key) : defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> newMap = new HashMap<>();
        newMap.putAll(map);
        return newMap;
    }
}
// END
