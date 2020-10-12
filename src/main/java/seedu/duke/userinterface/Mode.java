package seedu.duke.userinterface;

import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.tasks.TaskList;

public class Mode {
    private int state; //0 for
    private TaskList taskList;
    private NotebookShelf currentBookShelf;
    private int indexOfCurrentNotebook;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
