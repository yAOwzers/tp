package seedu.duke.userinterface.command.notebook;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.duke.userinterface.AppMode;
import seedu.duke.userinterface.AppState;

class RemoveCommandNotebookModeTest {
    
    @Test
    void isTriggerAutoSave_correctMode_returnsTrue() {
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_SHELF);

        RemoveCommandNotebookMode r = new RemoveCommandNotebookMode("","","",appState);
        assertTrue(r.isTriggerAutoSave());
    }
}