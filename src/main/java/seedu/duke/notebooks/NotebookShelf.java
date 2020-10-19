package seedu.duke.notebooks;

import seedu.duke.exceptions.NotebookOutOfBoundsException;

import java.util.ArrayList;

public class NotebookShelf {
    private final ArrayList<Notebook> notebooksArrayList;

    public NotebookShelf() {
        notebooksArrayList = new ArrayList<>();
    }

    public ArrayList<Notebook> getNotebooksArrayList() {
        return notebooksArrayList;
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
        for (Notebook n : notebooksArrayList) {
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
        if (index < 0 | index > notebooksArrayList.size()) {
            throw new NotebookOutOfBoundsException(index);
        }
        return notebooksArrayList.get(index);
    }

    /**
     * Add a notebook with a given title to the shelf.
     *
     * @param title the title of the notebook to be added
     */
    public void addNotebook(String title) {
        notebooksArrayList.add(new Notebook(title));
    }

    public Notebook removeNotebook(int indexToRemove) {
        return notebooksArrayList.remove(indexToRemove);
    }
}
