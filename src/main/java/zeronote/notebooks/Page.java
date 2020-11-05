package zer0note.notebooks;

import zer0note.exceptions.InvalidTagException;

public class Page {
    private String title;
    private String content;
    private String tag = "";

    public Page(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTag(String tag) throws InvalidTagException {
        if (!tag.equals("")) {
            this.tag = tag;
        } else {
            throw new InvalidTagException("tag /t" + tag);
        }
    }

    public String getTag() {
        return tag;
    }

    public void printPage() {
        System.out.println(content);
    }

    public String serialize() {
        StringBuilder serialized = new StringBuilder();
        String lineSeparator = System.lineSeparator();
        serialized.append(title);
        serialized.append(lineSeparator);
        serialized.append(content.replaceAll(System.lineSeparator(), "~~~"));
        serialized.append(lineSeparator);
        return serialized.toString();
    }
}
