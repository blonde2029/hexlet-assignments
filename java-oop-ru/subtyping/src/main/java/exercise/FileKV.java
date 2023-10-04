package exercise;

import jdk.jshell.execution.Util;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private Map<String, String> map = new HashMap<>();
    private String path;
    public FileKV(String path, Map<String, String> data) {
        this.path = path;
        this.map.putAll(data);
    }

    @Override
    public void set(String key, String value) {
    String content = Utils.readFile(path);
    Map<String, String> contentToMap = Utils.unserialize(content);
    contentToMap.put(key, value);
    Utils.writeFile(path, Utils.serialize(contentToMap));
    }

    @Override
    public void unset(String key) {
    String content = Utils.readFile(path);
    Map<String, String> contentToMap = Utils.unserialize(content);
    contentToMap.remove(key);
    Utils.writeFile(path, Utils.serialize(contentToMap));
    }

    @Override
    public String get(String key, String defaultValue) {
        String content = Utils.readFile(path);
        Map<String, String> contantToMap = Utils.unserialize(content);
        return contantToMap.containsKey(key) ? contantToMap.get(key) : defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        String content = Utils.readFile(path);
        Map<String, String> contantToMap = Utils.unserialize(content);
        return contantToMap;
    }
}
// END
