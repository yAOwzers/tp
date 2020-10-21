package seedu.duke.userinterface.command.notebook;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.IncorrectAppModeException;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.userinterface.AppMode;
import seedu.duke.userinterface.AppState;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ListCommandNotebookModeTest {

    @Test
    void execute_invalidInput_exceptionThrown() {
        AppState appState = new AppState();
        String input = "list /d";

        ListCommandNotebookMode listCommandNotebookMode = new ListCommandNotebookMode(input, appState);
        appState.setAppMode(AppMode.NOTEBOOK_SHELF);
        try {
            listCommandNotebookMode.execute();
            fail();
        } catch (InvalidCommandException e) {
            assertEquals("There not exists such options", e.problematicInput);
        } catch (IncorrectAppModeException e) {
            e.printStackTrace();
        }
    }
}