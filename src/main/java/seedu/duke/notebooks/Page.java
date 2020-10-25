package seedu.duke.notebooks;

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

    public void printPage() {
        System.out.println(content);
    }

    public void setTag(String description) {
        tag = description;
    }
}
