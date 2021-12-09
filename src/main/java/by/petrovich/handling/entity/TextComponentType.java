package by.petrovich.handling.entity;

public enum TextComponentType {
    TEXT("\t", "\n"),
    PARAGRAPH("\t", "\b\n\r"),
    SENTENCE("", " "),
    LEXEME("", " "),
    WORD("", ""),
    SYMBOL("", "");

    private String prefix = "";
    private String postfix = "";

    TextComponentType() {
    }

    TextComponentType(String postfix) {
        this.postfix = postfix;
    }

    TextComponentType(String prefix, String postfix) {
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
