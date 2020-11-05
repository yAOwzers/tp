package teetwelvedashthree.zeronote.userinterface.command.notebook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import zer0note.exceptions.DuplicateFoundException;
import zer0note.exceptions.InvalidTagException;
import zer0note.notebooks.Notebook;
import zer0note.notebooks.NotebookShelf;
import zer0note.notebooks.Page;
import zer0note.notebooks.Section;
import zer0note.userinterface.AppMode;
import zer0note.userinterface.AppState;
import zer0note.userinterface.command.notebook.FindCommandNotebookMode;

class FindCommandNotebookModeTest {
    @Test
    void execute_keywordInput_noResults() {
        Section s = new Section("Section 1");
        try {
            s.addPage("Page 1", "test");
        } catch (DuplicateFoundException e) {
            e.printErrorMessage();
        }
        Notebook n = new Notebook("Notebook 1 ");
        n.addSection(s);
        NotebookShelf ns = new NotebookShelf();
        ns.addNotebook(n);
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_SHELF);
        appState.setCurrentBookShelf(ns);

        FindCommandNotebookMode f = new FindCommandNotebookMode("test", "", appState);
        f.execute();
        assertEquals(f.getNotebookMessages().size(),0);
        assertEquals(f.getSectionMessages().size(),0);
        assertEquals(f.getPageMessages().size(),0);
    }

    @Test
    void execute_keywordInput_onlyNotebookFound() {
        Section s = new Section("Section 1");
        try {
            s.addPage("Page 1", "test");
        } catch (DuplicateFoundException e) {
            e.printErrorMessage();
        }
        Notebook n = new Notebook("Notebook 1");
        n.addSection(s);
        NotebookShelf ns = new NotebookShelf();
        ns.addNotebook(n);
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_SHELF);
        appState.setCurrentBookShelf(ns);

        FindCommandNotebookMode f = new FindCommandNotebookMode("notebook", "", appState);
        f.execute();
        assertEquals(f.getNotebookMessages().size(),1);
        assertEquals(f.getSectionMessages().size(),0);
        assertEquals(f.getPageMessages().size(),0);
    }

    @Test
    void execute_keywordInput_allFound() {
        Section s = new Section("Section 1");
        try {
            s.addPage("Page 1", "test");
        } catch (DuplicateFoundException e) {
            e.printErrorMessage();
        }
        Notebook n = new Notebook("Notebook 1");
        n.addSection(s);
        NotebookShelf ns = new NotebookShelf();
        ns.addNotebook(n);
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_SHELF);
        appState.setCurrentBookShelf(ns);

        FindCommandNotebookMode f = new FindCommandNotebookMode("1", "", appState);
        f.execute();
        assertEquals(f.getNotebookMessages().size(),1);
        assertEquals(f.getSectionMessages().size(),1);
        assertEquals(f.getPageMessages().size(),1);
    }

    @Test
    void execute_tagInput_noResults() {
        Section s = new Section("Section 1");
        try {
            s.addPage("Page 1", "test");
        } catch (DuplicateFoundException e) {
            e.printErrorMessage();
        }
        Notebook n = new Notebook("Notebook 1 ");
        n.addSection(s);
        NotebookShelf ns = new NotebookShelf();
        ns.addNotebook(n);
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_SHELF);
        appState.setCurrentBookShelf(ns);

        FindCommandNotebookMode f = new FindCommandNotebookMode("", "test", appState);
        f.execute();
        assertEquals(f.getNotebookMessages().size(),0);
        assertEquals(f.getSectionMessages().size(),0);
        assertEquals(f.getPageMessages().size(),0);
    }

    @Test
    void execute_tagInput_onlyNotebookFound() {
        Section s = new Section("Section 1");
        try {
            s.addPage("Page 1", "test");
        } catch (DuplicateFoundException e) {
            e.printErrorMessage();
        }
        Notebook n = new Notebook("Notebook 1");
        n.addSection(s);
        try {
            n.setTag("test");
        } catch (InvalidTagException e) {
            return;
        }
        NotebookShelf ns = new NotebookShelf();
        ns.addNotebook(n);
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_SHELF);
        appState.setCurrentBookShelf(ns);

        FindCommandNotebookMode f = new FindCommandNotebookMode("", "test", appState);
        f.execute();
        assertEquals(f.getNotebookMessages().size(),1);
        assertEquals(f.getSectionMessages().size(),0);
        assertEquals(f.getPageMessages().size(),0);
    }

    @Test
    void execute_tagInput_allFound() {
        Notebook n = new Notebook("Notebook 1");
        try {
            Page p = new Page("Page 1", "test");
            p.setTag("test");
            Section s = new Section("Section 1");
            s.addPage(p);
            s.setTag("test");
            n.addSection(s);
            n.setTag("test");
        } catch (InvalidTagException e) {
            return;
        }
        NotebookShelf ns = new NotebookShelf();
        ns.addNotebook(n);
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_SHELF);
        appState.setCurrentBookShelf(ns);

        FindCommandNotebookMode f = new FindCommandNotebookMode("", "test", appState);
        f.execute();
        assertEquals(f.getNotebookMessages().size(),1);
        assertEquals(f.getSectionMessages().size(),1);
        assertEquals(f.getPageMessages().size(),1);
    }

    @Test
    void isPersonalised_noInput_ReturnsTrue() {
        AppState appState = new AppState();
        FindCommandNotebookMode f = new FindCommandNotebookMode("", "", appState);
        assertTrue(f.isPersonalised());
    }
}