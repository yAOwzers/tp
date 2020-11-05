package teetwelvedashthree.zeronote.userinterface.command.notebook;

import teetwelvedashthree.zeronote.exceptions.InvalidSelectCommandException;
import teetwelvedashthree.zeronote.exceptions.ZeroNoteException;
import teetwelvedashthree.zeronote.userinterface.AppState;
import teetwelvedashthree.zeronote.userinterface.InputParser;
import teetwelvedashthree.zeronote.userinterface.command.CliCommand;

public class SelectCommandNotebookMode extends CliCommand {
    public static final String COMMAND_WORD = "select";
    public static final String SHOW_ALL = "/all";
    private final String argument;

    public SelectCommandNotebookMode(String argument, AppState uiMode) {
        this.setAppState(uiMode);
        this.argument = argument;
        PRINTS_PERSONAL_MESSAGE = false;
    }

    @Override
    public void execute() {
        InputParser parser = new InputParser();
        try {
            switch (appState.getAppMode()) {
            case NOTEBOOK_SHELF:
            case NOTEBOOK_BOOK:
            case NOTEBOOK_SECTION:
            case NOTEBOOK_PAGE:
                parser.extractParams(argument, appState);
                break;
            default:
                throw new InvalidSelectCommandException(argument);
            }
        } catch (ZeroNoteException e) {
            e.printErrorMessage();
        }
    }
}
