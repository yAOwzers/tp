package seedu.duke.userinterface.command.notebook;

import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidNotebookException;
import seedu.duke.exceptions.InvalidPageException;
import seedu.duke.exceptions.InvalidSectionException;
import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.storage.Storage;
import seedu.duke.userinterface.AppMode;
import seedu.duke.exceptions.ZeroNoteException;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.InputParser;
import seedu.duke.userinterface.command.CliCommand;

public class SelectCommandNotebookMode extends CliCommand {
    public static final String COMMAND_WORD = "select";
    public static final String SHOW_ALL = "/all";
    private final String argument;
    private String notebookTitle = null;
    private String sectionTitle = null;
    private int pageNum;
    private Notebook notebook;
    private Section section;
    private Storage storage;


    public SelectCommandNotebookMode(String argument, AppState uiMode) {
        this.setAppState(uiMode);
        this.argument = argument;
    }

    //TODO change this method updated by Joel 9:51pm, Tuesday, 22 October 2020
    @Override
    public void execute() {
        InputParser parser = new InputParser(this.storage, this.appState);
        try {
            switch (appState.getAppMode()) {
            case NOTEBOOK_SHELF:
            case NOTEBOOK_BOOK:
            case NOTEBOOK_SECTION:
                parser.extractParams(argument, appState);
                break;
            default:
                System.out.println("\tError occurred when selecting");
                break;
            }
        } catch (ZeroNoteException e) {
            e.printErrorMessage();
        }
    }
}
