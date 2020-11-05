package teetwelvedashthree.zeronote.userinterface.command.notebook;

import org.junit.jupiter.api.Test;
import teetwelvedashthree.zeronote.exceptions.DuplicateFoundException;
import teetwelvedashthree.zeronote.exceptions.IncorrectAppModeException;
import teetwelvedashthree.zeronote.exceptions.ZeroNoteException;
import teetwelvedashthree.zeronote.notebooks.Notebook;
import teetwelvedashthree.zeronote.notebooks.NotebookShelf;
import teetwelvedashthree.zeronote.notebooks.Page;
import teetwelvedashthree.zeronote.notebooks.Section;
import teetwelvedashthree.zeronote.userinterface.AppMode;
import teetwelvedashthree.zeronote.userinterface.AppState;
import teetwelvedashthree.zeronote.userinterface.InputParser;

import static org.junit.jupiter.api.Assertions.assertThrows;

//@@chuckiex3

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

    @Test
    void selectInvalid_pageTitle_expectException() {
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_SHELF);
        NotebookShelf ns = new NotebookShelf();
        Notebook notebook = new Notebook("test_notebook");
        Section section = new Section("section");
        Page page = new Page("page", "content");

        ns.addNotebook(notebook);
        notebook.addSection(section);
        section.addPage(page);

        InputParser parser = new InputParser();
        String argument = "/ntest_notebook /ssection /ppage2";
        assertThrows(ZeroNoteException.class, () -> {
            parser.extractParams(argument, appState);
        });
    }

    @Test
    void selectInvalid_page_expectException() {
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_SHELF);
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

        InputParser parser = new InputParser();
        String inputString = "select /ntest_notebook /ssection /ppage ; content";
        assertThrows(ZeroNoteException.class, () -> {
            parser.getCommandFromInput(inputString, appState);
        });
    }
}
