package seedu.duke.userinterface;

import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Section;
import seedu.duke.tasks.TaskList;

public class AppState {
    private AppMode appMode;
    private TaskList taskList;
    private NotebookShelf currentBookShelf;

    public Notebook getCurrentNotebook() {
        return currentNotebook;
    }

    public Section getCurrentSection() {
        return currentSection;
    }

    private Notebook currentNotebook;
    private Section currentSection;
    private int indexOfCurrentNotebook;

    public AppMode getAppMode() {
        return appMode;
    }

    public void setAppMode(AppMode appMode) {
        this.appMode = appMode;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public NotebookShelf getCurrentBookShelf() {
        return currentBookShelf;
    }

    public void setCurrentBookShelf(NotebookShelf currentBookShelf) {
        this.currentBookShelf = currentBookShelf;
    }

    public int getIndexOfCurrentNotebook() {
        return indexOfCurrentNotebook;
    }

    public void setIndexOfCurrentNotebook(int indexOfCurrentNotebook) {
        this.indexOfCurrentNotebook = indexOfCurrentNotebook;
    }
}
