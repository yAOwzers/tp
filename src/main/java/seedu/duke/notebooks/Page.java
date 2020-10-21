package seedu.duke.notebooks;

import seedu.duke.tasks.Task;

/**
 * Represents a page class.
 *
 */
public class Page {
    private String title;
    private String content;

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

    public String toTxtFormat() {
        // TODO Find out how to store data in the txt file.
        return this.title + " | " + this.content;
    }

    public static Page parse(String txtFormat) {
        // TODO Find out how to store data in the txt file.
        String[] txtArray = txtFormat.split("\\|");
        String title = txtArray[0].trim();
        String content = txtArray[1].trim();
        Page newPage = new Page(title, content);
        return newPage;
    }

}
