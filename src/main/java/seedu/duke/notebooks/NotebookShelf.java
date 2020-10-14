package seedu.duke.notebooks;

import java.util.ArrayList;

public class NotebookShelf {
    private final ArrayList<Notebook> notebooksArrayList;

    public NotebookShelf() {
        notebooksArrayList = new ArrayList<>();
    }

    public NotebookShelf(ArrayList<Notebook> notebooksArrayList) {
        this.notebooksArrayList = notebooksArrayList;
    }

    public ArrayList<Notebook> getNotebooksArrayList() {
        return notebooksArrayList;
    }
}
