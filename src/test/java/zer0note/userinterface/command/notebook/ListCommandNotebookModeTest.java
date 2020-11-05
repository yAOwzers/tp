package zer0note.userinterface.command.notebook;

import org.junit.jupiter.api.Test;
import zer0note.exceptions.IncorrectAppModeException;
import zer0note.exceptions.InvalidCommandException;
import zer0note.userinterface.AppMode;
import zer0note.userinterface.AppState;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//@@longngng
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