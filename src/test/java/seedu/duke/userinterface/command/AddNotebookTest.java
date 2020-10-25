package seedu.duke.userinterface.command;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.userinterface.AppMode;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.InputParser;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddNotebookTest {
    @Test
    void addNotebook_wrongFormat_expectException() {
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_PAGE);
        InputParser parser = new InputParser();
        String inputString = "add notebook";
        assertThrows(InvalidCommandException.class, () -> {
            parser.getCommandFromInput(inputString, appState);
        });
    }

    @Test
    void addNotebook_wrongMode_expectException() {
        InputParser parser = new InputParser();
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_PAGE);
        String inputString = "add /nNOTEBOOK";
        assertThrows(InvalidCommandException.class, () -> {
            parser.getCommandFromInput(inputString, appState);
        });
    }
}
