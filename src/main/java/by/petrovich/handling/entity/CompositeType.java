package by.petrovich.handling.entity;

public enum CompositeType {
    TEXT("\t", "\n"),
    PARAGRAPH("\t", "\b\n\r"),
    SENTENCE("", " "),
    WORD("", ""),
    SYMBOL("", "");

    private String prefix = "";
    private String postfix = "";

    CompositeType(String prefix, String postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getPostfix() {
        return postfix;
    }
}
