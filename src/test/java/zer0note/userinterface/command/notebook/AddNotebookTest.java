package zer0note.userinterface.command.notebook;

import org.junit.jupiter.api.Test;
import zer0note.exceptions.InvalidCommandException;
import zer0note.userinterface.AppMode;
import zer0note.userinterface.AppState;
import zer0note.userinterface.InputParser;

import static org.junit.jupiter.api.Assertions.assertThrows;

//@@chuckiex3
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
