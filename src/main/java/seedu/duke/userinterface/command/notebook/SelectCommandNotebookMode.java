package seedu.duke.userinterface.command.notebook;

import seedu.duke.exceptions.ZeroNoteException;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.InputParser;
import seedu.duke.userinterface.command.CliCommand;

public class SelectCommandNotebookMode extends CliCommand {
    public static final String COMMAND_WORD = "select";
    private final String argument;

    public SelectCommandNotebookMode(String argument, AppState uiMode) {
        this.setAppState(uiMode);
        this.argument = argument;
    }

    @Override
    public void execute() {
        InputParser parser = new InputParser();
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
