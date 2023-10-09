package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> subTag;

    public PairedTag(String tagName, Map<String, String> tagValue, String tagBody, List<Tag> subTag) {
        super(tagName, tagValue);
        this.tagBody = tagBody;
        this.subTag = subTag;
    }

    public PairedTag(String tagName, Map<String, String> tagValue) {
        super(tagName, tagValue);
    }

    public String getTagBody() {
        return tagBody;
    }

    public void setTagBody(String tagBody) {
        this.tagBody = tagBody;
    }

    @Override
    public String toString() {
        StringBuilder tagValueStr = new StringBuilder();
        getTagValue()
                .entrySet()
                .stream()
                .forEach(elem -> tagValueStr.append(" " + elem.getKey()  + "=" + "\"" + elem.getValue() + "\""));

        return "<" + getTagName() + tagValueStr + ">"
                + tagBody + subTag.toString().replace("[", "").replace("]", "").replace(", ", "")
                + "</" + getTagName() + ">";
    }

    public List<Tag> getSubTag() {
        return subTag;
    }

    public void setSubTag(List<Tag> subTag) {
        this.subTag = subTag;
    }
}
// END
