package seedu.duke.notebooks;

import java.util.ArrayList;

import seedu.duke.exceptions.DuplicateFoundException;
import seedu.duke.exceptions.InvalidTagException;

public class Notebook {
    private String title;
    private String tag = "";
    private final ArrayList<Section> sectionArrayList;

    public Notebook(String title) {
        this.title = title;
        sectionArrayList = new ArrayList<>();
    }

    public void setTag(String tag) throws InvalidTagException {
        if (!tag.equals("")) {
            this.tag = tag;
        } else {
            throw new InvalidTagException("tag /t" + tag);
        }
    }

    public String getTag() {
        return tag;
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

    public ArrayList<Section> getSectionArrayList() {
        return sectionArrayList;
    }

    public Section getSectionAtIndex(int index) {
        return sectionArrayList.get(index);
    }

    /**
     * Add a new section with a given title to this notebook.
     *
     * @param title the title of the section to be added
     * @throws DuplicateFoundException when the user inputs a section title that has already been used.
     */
    public void addSection(String title) throws DuplicateFoundException {
        for (Section s : sectionArrayList) {
            if (s.getTitle().equals(title)) {
                throw new DuplicateFoundException(title);
            }
        }
        sectionArrayList.add(new Section(title));
    }

    public void addSection(Section s) {
        sectionArrayList.add(s);
    }

    /**
     * Find a section with a given title in this notebook.
     *
     * @param searchKey the title of the section to search for in the notebook
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

    /**
     * Remove a section from the notebook.
     *
     * @param indexToRemove the index of the section to remove
     */
    public Section removeSection(int indexToRemove) {
        return sectionArrayList.remove(indexToRemove);
    }

    public String serialize() {
        StringBuilder serialized = new StringBuilder();
        String lineSeparator = System.lineSeparator();
        serialized.append(title);
        serialized.append(lineSeparator);
        serialized.append(sectionArrayList.size());
        serialized.append(lineSeparator);
        for (Section s : sectionArrayList) {
            serialized.append(s.serialize());
        }
        return serialized.toString();
    }
}
