package seedu.duke.notebooks;

import java.util.ArrayList;

public class NotebookShelf {
    private final ArrayList<Notebook> notebooksArrayList;

    public NotebookShelf() {
        notebooksArrayList = new ArrayList<>();
    }

    public ArrayList<Notebook> getNotebooksArrayList() {
        return notebooksArrayList;
    }

    public void addNotebook(String title) {
        notebooksArrayList.add(new Notebook(title));
    }
}
