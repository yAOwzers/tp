package seedu.duke.userinterface.command.notebook;

import seedu.duke.exceptions.AddCommandNotebookException;
import seedu.duke.exceptions.ZeroNoteException;
import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.storage.Storage;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.InputParser;
import seedu.duke.userinterface.command.CliCommand;

public class AddCommandNotebookMode extends CliCommand {
    public static final String COMMAND_WORD = "add";
    public static final String NOTEBOOK_DELIMITER = "/n";
    public static final String SECTION_DELIMITER = "/s";
    public static final String PAGE_DELIMITER = "/p";
    public static final String CONTENT_DELIMITER = ";";
    private final String title;
    private String content;
    private CliMessages messages = new CliMessages();
    private Storage storage;

    public AddCommandNotebookMode(String titleToAdd, AppState appState, Storage storage) {
        this.appState = appState;
        this.title = titleToAdd;
        this.storage = storage;
    }

    public AddCommandNotebookMode(String titleToAdd, String contentToAdd, AppState appState, Storage storage) {
        this.appState = appState;
        this.title = titleToAdd;
        this.storage = storage;
        this.content = contentToAdd;
    }

    public void execute() {
        try {
            switch (appState.getAppMode()) {
                case NOTEBOOK_SHELF:
                    NotebookShelf currentNotebookShelf = appState.getCurrentNotebookShelf();
                    Notebook newNotebook = new Notebook(this.title);
                    addNotebook(newNotebook, currentNotebookShelf);
                    break;
                case NOTEBOOK_BOOK:
                    Notebook currentNotebook = appState.getCurrentNotebook();
                    Section newSection = new Section(this.title);
                    addSection(newSection, currentNotebook);
                    break;
                case NOTEBOOK_SECTION:
                    Section currentSection = appState.getCurrentSection();
                    Page newPage = new Page(this.title, this.content);
                    addPage(newPage, currentSection);
                    break;
                default:
                    throw new AddCommandNotebookException(title);
            }
        } catch(ZeroNoteException e){
            e.printErrorMessage();
        }
    }


    public void addNotebook(Notebook newNotebook, NotebookShelf currentNotebookShelf) {
        currentNotebookShelf.addNotebook(newNotebook);
        this.storage.saveNotebook(newNotebook);
        System.out.println(this.messages.printAddNotebookMessage(newNotebook) + "\n"
                + this.messages.getNumberOfNotebookMessage(currentNotebookShelf.getNumberOfNotebooks()));
    }

    public void addSection(Section newSection, Notebook currentNotebook) {
        currentNotebook.addSection(newSection);
        this.storage.saveSection(newSection);
        System.out.println(this.messages.printAddSectionMessage(newSection) + "\n"
                + this.messages.getNumberOfSectionMessage(currentNotebook.getNumberOfSections()));
    }

    public void addPage(Page newPage, Section currentSection) {
        currentSection.addPage(newPage);
        this.storage.savePage(newPage);
        System.out.println(this.messages.printAddPageMessage(newPage) + "\n"
                + this.messages.getNumberOfPageMessage(currentSection.getNumberOfPages()));
    }

}
