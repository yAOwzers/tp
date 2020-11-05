package teetwelvedashthree.zeronote.userinterface.command.notebook;

import teetwelvedashthree.zeronote.exceptions.AddCommandNotebookException;
import teetwelvedashthree.zeronote.exceptions.EmptyPageException;
import teetwelvedashthree.zeronote.exceptions.ZeroNoteException;
import teetwelvedashthree.zeronote.notebooks.Notebook;
import teetwelvedashthree.zeronote.notebooks.NotebookShelf;
import teetwelvedashthree.zeronote.notebooks.Section;
import teetwelvedashthree.zeronote.userinterface.AppState;
import teetwelvedashthree.zeronote.userinterface.command.CliCommand;

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
