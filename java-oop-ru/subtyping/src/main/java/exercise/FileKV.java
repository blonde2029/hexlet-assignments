package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private Map<String, String> data = new HashMap<>();
    private String path;
    public FileKV(String path, Map<String, String> data) {
        this.path = path;
        this.data = data;
    }

    @Override
    public void set(String key, String value) {

    }

    @Override
    public void unset(String key) {

    }

    @Override
    public String get(String key, String defaultValue) {
        return null;
    }

    @Override
    public Map<String, String> toMap() {
        return null;
    }
}
// END
