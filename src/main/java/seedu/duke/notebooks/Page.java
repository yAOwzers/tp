package seedu.duke.notebooks;

/**
 * Represents a page class.
 *
 */
public class Page extends NotebookData {
    private String title;
    private String content;

    // TODO add in title of Notebook and Section
    private String notebookTitle;
    private String sectionTitle;

    public Page(String title, String content, String notebookTitle, String sectionTitle) {
        this.title = title;
        this.content = content;
        this.sectionTitle = sectionTitle;
        this.notebookTitle = notebookTitle;
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

    public String toTxtFormat() {
        return getType() + " | " + this.notebookTitle + " | " + this.sectionTitle
                + " | " + this.title + " | " + this.content;
    }

    public static Page parse(String[] txtArray) {
        String notebookTitle = txtArray[1].trim();
        String sectionTitle = txtArray[2].trim();
        String pageTitle = txtArray[3].trim();
        String pageContent = txtArray[4].trim();
        Page newPage = new Page(pageTitle, pageContent, notebookTitle, sectionTitle);
        return newPage;
    }

    public String getPageInMessageFormat() {
        return "Page with title: " + this.title + "\n"
                + "content: " + this.content;
    }

    public String getType() {
        return "P";
    }
}
