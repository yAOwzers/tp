package seedu.duke.notebooks;

import java.util.ArrayList;

public class NotebookShelf {
    private ArrayList<Notebook> notebooksArrayList;

    public NotebookShelf(ArrayList<Notebook> notebooksArrayList) {
        this.notebooksArrayList = notebooksArrayList;
    }

    public NotebookShelf() {
        notebooksArrayList = new ArrayList<>();
    }

    public ArrayList<Notebook> getNotebooksArrayList() {
        return notebooksArrayList;
    }
}
