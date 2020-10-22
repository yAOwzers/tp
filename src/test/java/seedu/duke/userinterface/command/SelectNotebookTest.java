package seedu.duke.userinterface.command;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.IncorrectAppModeException;
import seedu.duke.userinterface.AppMode;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.InputParser;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SelectNotebookTest {
    @Test
    void selectNotebook_in_wrongMode() {
        InputParser parser = new InputParser();
        AppState appState = new AppState();
        appState.setAppMode(AppMode.TIMETABLE);
        String inputString = "select /nNOTEBOOK";
        assertThrows(IncorrectAppModeException.class, () -> {
            parser.getCommandFromInput(inputString, appState);
        });
    }
}
