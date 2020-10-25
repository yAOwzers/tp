package seedu.duke.userinterface;

import seedu.duke.exceptions.InvalidUserInputException;
import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Section;
import seedu.duke.storage.Storage;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;

public class AppState {
    private AppMode appMode;
    private TaskList currentTaskList;
    private NotebookShelf currentNotebookShelf;
    private Notebook currentNotebook;
    private Section currentSection;
    private Storage storage;

    private int indexOfCurrentNotebook;
    private int indexOfCurrentSection;
    private String sectionTitle;
    private String notebookTitle;

    public AppState(Storage storage) {
        this.currentTaskList = new TaskList();
        this.storage = storage;
        this.currentNotebookShelf = new NotebookShelf();
        this.appMode = AppMode.TIMETABLE;


    }

    public AppMode getAppMode() {
        return this.appMode;
    }

    public void setAppMode(AppMode appMode) {
        this.appMode = appMode;
    }

    public NotebookShelf getCurrentNotebookShelf() {
        return this.currentNotebookShelf;
    }

    public void setCurrentNotebookShelf(NotebookShelf currentNotebookShelf) {
        this.currentNotebookShelf = currentNotebookShelf;
    }

    public Notebook getCurrentNotebook() {
        return this.currentNotebook;
    }

    public void setCurrentNotebook(Notebook currentNotebook) {
        this.currentNotebook = currentNotebook;
    }

    public int getIndexOfCurrentNotebook() {
        return this.indexOfCurrentNotebook;
    }

    public void setIndexOfCurrentNotebook(int indexOfCurrentNotebook) {
        this.indexOfCurrentNotebook = indexOfCurrentNotebook;
    }

    public Section getCurrentSection() {
        return this.currentSection;
    }

    public void setCurrentSection(Section currentSection) {
        this.currentSection = currentSection;
    }

    public int getIndexOfCurrentSection() {
        return this.indexOfCurrentSection;
    }

    public void setIndexOfCurrentSection(int indexOfCurrentSection) {
        this.indexOfCurrentSection = indexOfCurrentSection;
    }

    public TaskList getTaskList() {
        return this.currentTaskList;
    }

    public void setTaskList(TaskList taskList) {
        this.currentTaskList = taskList;
    }

    public Task markTaskAsDone(int index) {
        Task task = this.currentTaskList.markAsDone(index);
        return task;
    }

    public void loadState() throws InvalidUserInputException {
        this.storage.loadTaskList(this.currentTaskList);
         this.storage.loadSection(this.currentSection);
         this.storage.loadNotebook(this.currentNotebook);
         this.storage.loadNotebookShelf(this.currentNotebookShelf);
    }
}
