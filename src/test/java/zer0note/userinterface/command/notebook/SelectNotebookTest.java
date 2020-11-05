package zer0note.userinterface.command.notebook;

import org.junit.jupiter.api.Test;
import zer0note.exceptions.DuplicateFoundException;
import zer0note.exceptions.IncorrectAppModeException;
import zer0note.exceptions.ZeroNoteException;
import zer0note.notebooks.Notebook;
import zer0note.notebooks.NotebookShelf;
import zer0note.notebooks.Page;
import zer0note.notebooks.Section;
import zer0note.userinterface.AppMode;
import zer0note.userinterface.AppState;
import zer0note.userinterface.InputParser;

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
