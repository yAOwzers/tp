package seedu.duke.notebooks;

import seedu.duke.storage.Storage;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.exceptions.NotebookOutOfBoundsException;


import java.util.ArrayList;

/**
 * Represents a list of Notebooks.
 *
 */
public class NotebookShelf {
    private final ArrayList<Notebook> notebookArrayList;
    private CliMessages messages = new CliMessages();

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
    public Notebook getNotebookAtIndex(int index) throws NotebookOutOfBoundsException {
        if (index < 0 | index > notebookArrayList.size()) {
            throw new NotebookOutOfBoundsException(index);
        }
        return notebookArrayList.get(index);
    }

    /**
     * Add a notebook with a given title to the notebookShelf.
     *
     * @param newNotebook the notebook to be added
     */
    public void addNotebook(Notebook newNotebook) {
        notebookArrayList.add(newNotebook);
    }

    public int getNumberOfNotebooks() {
        return notebookArrayList.size();
    }

    public void load(Notebook notebook) {
        notebookArrayList.add(notebook);
    }

    public Notebook removeNotebook(int indexToRemove) {
        return notebookArrayList.remove(indexToRemove);
    }
}
