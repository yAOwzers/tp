package seedu.duke.notebooks;

import java.util.ArrayList;

public class Section {
    private String title;
    private ArrayList<Page> pageArrayList;

    public Section(String title, ArrayList<Page> pageArrayList) {
        this.title = title;
        this.pageArrayList = pageArrayList;
    }

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPageArrayList(ArrayList<Page> pageArrayList) {
        this.pageArrayList = pageArrayList;
    }

    public ArrayList<Page> getPageArrayList() {
        return pageArrayList;
    }

}
