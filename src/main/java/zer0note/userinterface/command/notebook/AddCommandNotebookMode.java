package zer0note.userinterface.command.notebook;

import zer0note.exceptions.AddCommandNotebookException;
import zer0note.exceptions.EmptyPageException;
import zer0note.exceptions.ZeroNoteException;
import zer0note.notebooks.Notebook;
import zer0note.notebooks.NotebookShelf;
import zer0note.notebooks.Section;
import zer0note.userinterface.AppState;
import zer0note.userinterface.command.CliCommand;

public class AddCommandNotebookMode extends CliCommand {
    public static final String COMMAND_WORD = "add";
    public static final String NOTEBOOK_DELIMITER = "/n";
    public static final String SECTION_DELIMITER = "/s";
    public static final String PAGE_DELIMITER = "/p";
    public static final String CONTENT_DELIMITER = ";";
    private final String title;
    private String content;
    private final NotebookShelf currentBookshelf;
    private final Notebook currentNotebook;
    private final Section currentSection;

    private static final boolean isAutoSave = true;

    public AddCommandNotebookMode(String title, AppState appState) {
        PRINTS_PERSONAL_MESSAGE = true;
        this.appState = appState;
        this.title = title;
        assert title != null;
        currentBookshelf = appState.getCurrentBookShelf();
        currentNotebook = appState.getCurrentNotebook();
        currentSection = appState.getCurrentSection();
    }

    public AddCommandNotebookMode(String title, String content, AppState appState) {
        this(title, appState);
        this.content = content;
    }

    public void execute() {
        try {
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
                if (content == "") {
                    throw new EmptyPageException();
                }
                currentSection.addPage(title, content);
                System.out.println("Added page with title: " + title);
                break;
            default:
                throw new AddCommandNotebookException(title);
            }
        } catch (ZeroNoteException e) {
            e.printErrorMessage();
        }
    }

    @Override
    public boolean isTriggerAutoSave() {
        return isAutoSave;
    }
}
