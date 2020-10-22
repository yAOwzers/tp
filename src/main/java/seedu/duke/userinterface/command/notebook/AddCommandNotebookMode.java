package seedu.duke.userinterface.command.notebook;

import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Section;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.command.CliCommand;

public class AddCommandNotebookMode extends CliCommand {
    public static final String COMMAND_WORD = "add";
    private String title;
    private String content;
    private NotebookShelf currentBookshelf;
    private Notebook currentNotebook;
    private Section currentSection;

    public AddCommandNotebookMode(String title, AppState appState) {
        this.appState = appState;
        this.title = title;
        this.currentBookshelf = appState.getCurrentNotebookShelf();
        this.currentNotebook = appState.getCurrentNotebook();
        this.currentSection = appState.getCurrentSection();
    }

    public AddCommandNotebookMode(String title, String content, AppState appState) {
        this.title = title;
        this.appState = appState;
        this.content = content;
    }

    public void execute() {
        switch (appState.getAppMode()) {
        case NOTEBOOK_SHELF:
            currentBookshelf.addNotebook(title);
            System.out.println("Added notebook with title: " + title);
            break;
        case NOTEBOOK_BOOK:
            currentNotebook.addSection(title);
            System.out.println("Added section with title : " + title);
            break;
        case NOTEBOOK_SECTION:
            currentSection.addPage(title, content);
            System.out.println("Added page with title: " + title);
            break;
        default:
            // TODO: Replace with ZeroNoteException of some form
            System.out.println("\tunable to add notebook/section/page");
            break;
        }
    }
}
