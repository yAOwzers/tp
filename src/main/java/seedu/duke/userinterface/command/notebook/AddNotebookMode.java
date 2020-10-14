package seedu.duke.userinterface.command.notebook;

import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Section;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.command.CliCommand;

public class AddNotebookMode extends CliCommand {
    public static final String COMMAND_WORD = "add";
    private String title;
    private String content;
    private NotebookShelf currentBookshelf;
    private Notebook currentNotebook;
    private Section currentSection;

    public AddNotebookMode() {
        currentBookshelf = appState.getCurrentBookShelf();
        currentNotebook = appState.getCurrentNotebook();
        currentSection = appState.getCurrentSection();
    }

    public AddNotebookMode(String title, AppState appState) {
        this.appState = appState;
        this.title = title;
    }

    public AddNotebookMode(String title, String content, AppState appState) {
        this.appState = appState;
        this.title = title;
        this.content = content;
    }

    private String getTitle() {
        return title;
    }

    private String getContent() {
        return content;
    }

    public void execute() {
        switch (appState.getAppMode()) {
        case NOTEBOOK_SHELF:
            currentBookshelf.addNotebook(title);
            break;
        case NOTEBOOK_BOOK:
            currentNotebook.addSection(title);
            break;
        case NOTEBOOK_SECTION:
            currentSection.addPage(title, content);
            break;
        default:
            System.out.println("\tunable to add notebook/section/page");
            break;
        }
    }
}
