package seedu.duke.notebooks;

import java.util.ArrayList;

public class Notebook {
    private String title;
    private String tag = "";
    private final ArrayList<Section> sectionArrayList;

    public Notebook(String title) {
        this.title = title;
        sectionArrayList = new ArrayList<>();
    }

    /**
     * Get the title of this notebook.
     *
     * @return the title of the notebook
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of this notebook.
     *
     * @param title the desired new title of the notebook
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setTag(String description) {
        tag = description;
    }

    public String getTag() {
        return tag;
    }

    /**
     * Add a new section with a given title to this notebook.
     *
     * @param title the title of the section to be added
     */
    public void addSection(String title) {
        sectionArrayList.add(new Section(title));
    }

    /**
     * Remove a section from the notebook.
     *
     * @param indexToRemove the index of the section to remove
     */
    public Section removeSection(int indexToRemove) {
        return sectionArrayList.remove(indexToRemove);
    }

    /**
     * Find a section with a given title in this notebook.
     *
     * @param searchKey the title of the section to search for in the notebook
     *
     * @return the index of the section with the given title, -1 if not found
     */
    public int findSection(String searchKey) {
        int index = 0;
        for (Section s : sectionArrayList) {
            if (s.getTitle().equals(searchKey)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public Section getSectionAtIndex(int index) {
        return sectionArrayList.get(index);
    }

    public ArrayList<Section> getSectionArrayList() {
        return sectionArrayList;
    }
}
