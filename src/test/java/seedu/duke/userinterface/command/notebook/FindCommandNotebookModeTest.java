package seedu.duke.userinterface.command.notebook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import seedu.duke.exceptions.InvalidTagException;
import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.userinterface.AppMode;
import seedu.duke.userinterface.AppState;

class FindCommandNotebookModeTest {
    @Test
    void execute_keywordInput_noResults() {
        Section s = new Section("Section 1");
        s.addPage("Page 1", "test");
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
        s.addPage("Page 1", "test");
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
        s.addPage("Page 1", "test");
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
        s.addPage("Page 1", "test");
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
        s.addPage("Page 1", "test");
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
        assertEquals(f.isPersonalised(),true);
    }
}