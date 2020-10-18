package seedu.duke.userinterface;

import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Section;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;

public class AppState {
    private AppMode appMode;
    private TaskList currentTaskList;
    private NotebookShelf currentBookShelf;
    private Notebook currentNotebook;
    private Section currentSection;
    private int indexOfCurrentNotebook;
    private int indexOfCurrentSection;


    public AppState() {
        currentTaskList = new TaskList();
        appMode = AppMode.TIMETABLE;
        currentBookShelf = new NotebookShelf();
    }

    public AppMode getAppMode() {
        return appMode;
    }

    public void setAppMode(AppMode appMode) {
        this.appMode = appMode;
    }

    public NotebookShelf getCurrentBookShelf() {
        return currentBookShelf;
    }

    public void setCurrentBookShelf(NotebookShelf currentBookShelf) {
        this.currentBookShelf = currentBookShelf;
    }

    public Notebook getCurrentNotebook() {
        return currentNotebook;
    }

    public void setCurrentNotebook(Notebook currentNotebook) {
        this.currentNotebook = currentNotebook;
    }

    public int getIndexOfCurrentNotebook() {
        return indexOfCurrentNotebook;
    }

    public void setIndexOfCurrentNotebook(int indexOfCurrentNotebook) {
        this.indexOfCurrentNotebook = indexOfCurrentNotebook;
    }

    public Section getCurrentSection() {
        return currentSection;
    }

    public void setCurrentSection(Section currentSection) {
        this.currentSection = currentSection;
    }

    public int getIndexOfCurrentSection() {
        return indexOfCurrentSection;
    }

    public void setIndexOfCurrentSection(int indexOfCurrentSection) {
        this.indexOfCurrentSection = indexOfCurrentSection;
    }

    public TaskList getTaskList() {
        return currentTaskList;
    }

    public void setTaskList(TaskList taskList) {
        this.currentTaskList = taskList;
    }

    public Task markTaskAsDone(int index) {
        Task task = this.currentTaskList.markAsDone(index);
        return task;
    }




}
