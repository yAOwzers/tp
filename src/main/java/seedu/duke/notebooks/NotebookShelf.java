package seedu.duke.notebooks;

import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;

import java.util.ArrayList;

/**
 * Represents a list of Notebooks.
 *
 */
public class NotebookShelf {
    private final ArrayList<Notebook> notebookArrayList;

    public NotebookShelf() {
        notebookArrayList = new ArrayList<>();
    }

    public ArrayList<Notebook> getNotebookArrayList() {
        return notebookArrayList;
    }

    /**
     * Find the notebook on the shelf with the given title.
     *
     * @param title the title of the notebook we want to find
     *
     * @return the index of the notebook we want to find
     */
    public int findNotebook(String title) {
        int index = 0;
        for (Notebook n : notebookArrayList) {
            if (n.getTitle().equals(title)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * Get the notebook at a particular index in the ArrayList. Use findNotebook() to get an index from a given title.
     *
     * @param index the index of the notebook to be found
     *
     * @return The notebook at that index
     */
    // TODO: Add NotebookIndexOutOfBoundsException and throw it
    public Notebook getNotebookAtIndex(int index) {
        return notebookArrayList.get(index);
    }

    /**
     * Add a notebook with a given title to the shelf.
     *
     * @param title the title of the notebook to be added
     */
    public void addNotebook(String title) {
        notebookArrayList.add(new Notebook(title));
    }

    public int getNumberOfNotebooks() {
        return notebookArrayList.size();
    }

    public void load(Notebook notebook) {
        notebookArrayList.add(notebook);
    }

    public void addTask(Task newTask, TaskList currentTaskList) {
        currentTaskList.addTask(newTask);
        this.storage.saveTask(newTask);
        System.out.println(this.messages.printAddTaskMessage(newTask) + "\n"
                + this.messages.getNumberOfTaskMessage(currentTaskList.getNumberOfTasks()));
    }
}
