package seedu.duke.userinterface.command.notebook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.duke.exceptions.ZeroNoteException;
import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.userinterface.AppMode;
import seedu.duke.userinterface.AppState;

class TagNotebookTest {

    @Test
    void execute_tagNotebook_tagSet() throws ZeroNoteException {
        Notebook n = new Notebook("Notebook 1");
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_BOOK);
        appState.setCurrentNotebook(n);

        TagCommandNotebookMode t = new TagCommandNotebookMode("test",appState);
        t.execute();
        assertEquals("test",appState.getCurrentNotebook().getTag());
    }

    @Test
    void execute_tagSection_tagSet() throws ZeroNoteException {
        Section s = new Section("Section 1");
        AppState appState = new AppState();
        appState.setCurrentSection(s);
        appState.setAppMode(AppMode.NOTEBOOK_SECTION);

        TagCommandNotebookMode t = new TagCommandNotebookMode("test",appState);
        t.execute();
        assertEquals("test",appState.getCurrentSection().getTag());
    }

    @Test
    void execute_tagPage_tagSet() throws ZeroNoteException {
        Page p = new Page("Page 1", "test");
        AppState appState = new AppState();
        appState.setCurrentPage(p);
        appState.setAppMode(AppMode.NOTEBOOK_PAGE);

        TagCommandNotebookMode t = new TagCommandNotebookMode("test",appState);
        t.execute();
        assertEquals("test",appState.getCurrentPage().getTag());
    }

    @Test
    void execute_wrongMode_noTagSet() throws ZeroNoteException {
        Notebook n = new Notebook("Notebook 1");
        AppState appState = new AppState();
        appState.setAppMode(AppMode.NOTEBOOK_SHELF);
        appState.setCurrentNotebook(n);

        TagCommandNotebookMode t = new TagCommandNotebookMode("test",appState);
        t.execute();
        assertEquals("",appState.getCurrentNotebook().getTag());
    }

    @Test
    void isTriggerAutoSave() {
        AppState appState = new AppState();
        TagCommandNotebookMode t = new TagCommandNotebookMode("", appState);
        assertTrue(t.isTriggerAutoSave());
    }
}