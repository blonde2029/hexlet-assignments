package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String tagName, Map<String, String> tagValue) {
        super(tagName, tagValue);
    }

    @Override
    public Map<String, String> getTagValue() {
        return super.getTagValue();
    }

    @Override
    public String toString() {
        StringBuilder tagValueStr = new StringBuilder();
        getTagValue()
                .entrySet()
                .stream()
                .forEach(elem -> tagValueStr.append(" " + elem.getKey()  + "=" + "\"" + elem.getValue() + "\""));
        return "<" + getTagName()
                + tagValueStr
                + ">";
    }
}
// END
