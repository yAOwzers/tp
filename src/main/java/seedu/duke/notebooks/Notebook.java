package seedu.duke.notebooks;

import java.util.ArrayList;

public class Notebook {
    private String title;
    private ArrayList<Section> sectionArrayList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Section> getSectionArrayList() {
        return sectionArrayList;
    }

    public void setSectionArrayList(ArrayList<Section> sectionArrayList) {
        this.sectionArrayList = sectionArrayList;
    }

    public Notebook(String title) {
        this.title = title;
    }

    public Notebook(String title, ArrayList<Section> sectionArrayList) {
        this.title = title;
        this.sectionArrayList = sectionArrayList;
    }
}
