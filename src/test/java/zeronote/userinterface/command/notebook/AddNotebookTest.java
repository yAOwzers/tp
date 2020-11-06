package zeronote.userinterface.command.notebook;

import org.junit.jupiter.api.Test;
import zeronote.exceptions.InvalidCommandException;
import zeronote.exceptions.ZeroNoteException;
import zeronote.userinterface.AppMode;
import zeronote.userinterface.AppState;
import zeronote.userinterface.InputParser;

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

    @Test
    void addNotebook_sectionPage_expectException() {
        InputParser parser = new InputParser();
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_SHELF);
        String userInput = "add /nNotebook /sSection /pPage";
        assertThrows(ZeroNoteException.class, () -> {
           parser.getCommandFromInput(userInput, appState);
        });

    }
}
