package exercise;

// BEGIN
class LabelTag implements TagInterface {
    private String tag;
    private TagInterface inputTag;

    public LabelTag(String tag, TagInterface subTag) {
        this.tag = tag;
        this.inputTag = subTag;
    }

    @Override
    public String render() {
        return "<label>" + tag + inputTag.render() + "</label>";
    }
}
// END
