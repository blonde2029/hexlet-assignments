package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String tagName;
    private Map<String, String> tagValue;

    @Override
    public String toString() {
        return "Tag{" +
                "tagName='" + tagName + '\'' +
                ", tagValue=" + tagValue +
                '}';
    }

    public Tag(String tagName, Map<String, String> tagValue) {
        this.tagName = tagName;
        this.tagValue = tagValue;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Map<String, String> getTagValue() {
        return tagValue;
    }

    public void setTagValue(Map<String, String> tagValue) {
        this.tagValue = tagValue;
    }
}
// END
