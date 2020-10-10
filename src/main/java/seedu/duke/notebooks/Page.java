package seedu.duke.notebooks;

public class Page {
    private String title;
    private String content;

    public Page(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return title + ", " + content;
    }
}
