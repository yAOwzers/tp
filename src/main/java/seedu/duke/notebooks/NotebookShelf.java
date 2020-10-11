package seedu.duke.notebooks;

import java.util.ArrayList;

public class NotebookShelf {
    private ArrayList<Notebook> notebooksArrayList;

    public NoteBookShelf() {
        notebooksArrayList = new ArrayList<>();
      
    public NotebookShelf(ArrayList<Notebook> notebooksArrayList) {
        this.notebooksArrayList = notebooksArrayList;
    }

    public ArrayList<Notebook> getNotebooksArrayList() {
        return notebooksArrayList;
    }
}
