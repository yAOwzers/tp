package teetwelvedashthree.zeronote.userinterface.command.notebook;

import org.junit.jupiter.api.Test;
import teetwelvedashthree.zeronote.exceptions.DuplicateFoundException;
import teetwelvedashthree.zeronote.exceptions.InvalidCommandException;
import teetwelvedashthree.zeronote.exceptions.ZeroNoteException;
import teetwelvedashthree.zeronote.notebooks.Notebook;
import teetwelvedashthree.zeronote.notebooks.NotebookShelf;
import teetwelvedashthree.zeronote.notebooks.Section;
import teetwelvedashthree.zeronote.userinterface.AppMode;
import teetwelvedashthree.zeronote.userinterface.AppState;
import teetwelvedashthree.zeronote.userinterface.InputParser;

import static org.junit.jupiter.api.Assertions.assertThrows;

//@@chuckiex3
public class AddNotebookModeTest {
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
    void addNotebook_SectionPage_expectException() {
        InputParser parser = new InputParser();
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_PAGE);
        String inputString = "add /nNOTEBOOK /sSection /p";
        assertThrows(ZeroNoteException.class, () -> {
            parser.getCommandFromInput(inputString, appState);
        });
    }

    @Test
    void addDuplicate_page_expectException() {
        NotebookShelf ns = new NotebookShelf();
        Notebook notebook = new Notebook("test_notebook");
        Section section = new Section("section");
        String page = "page";
        String content = "content";

        ns.addNotebook(notebook);
        notebook.addSection(section);

        try {
            section.addPage(page, content);
        } catch (DuplicateFoundException e) {
            e.printErrorMessage();
        }

        assertThrows(ZeroNoteException.class, () -> {
            section.addPage(page, content);
        });
    }
}
