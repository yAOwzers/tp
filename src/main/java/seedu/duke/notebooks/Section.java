package seedu.duke.notebooks;

import java.util.ArrayList;

/**
 * Represents a list of Pages.
 *
 */
public class Section extends NotebookData {
    private String title;
    private final ArrayList<Page> pageArrayList;
    private String notebookTitle;

    public Section(String title, String notebookTitle) {
        this.title = title;
        pageArrayList = new ArrayList<>();
        this.notebookTitle = notebookTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPage(String searchKey) {
        int index = 0;
        for (Page p : pageArrayList) {
            if (p.getTitle().equals(searchKey)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public void getPage(int pageIndex) {
        try {
            Page page = pageArrayList.get(pageIndex);
            page.printPage();
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            System.out.println("page <" + (pageIndex + 1) + "> doesn't exist");
        }
    }

    public Page removePage(int indexToRemove) {
        return pageArrayList.remove(indexToRemove);
    }

    public void removePage(String titleToRemove) {
        int indexToRemove = getPage(titleToRemove);
        if (indexToRemove >= 0) {
            removePage(indexToRemove);
        } else {
            System.out.println("doesn't exist");
        }
    }

    public Page getPageAtIndex(int index) {
        return pageArrayList.get(index);
    }

    public ArrayList<Page> getPageArrayList() {
        return pageArrayList;
    }

    public int getNumberOfPages() {
        return pageArrayList.size();
    }

    /**
     * Changes the string to txtFormat for the txt file.
     *
     * @return txtFormatted String for parsing when loading.
     */
    public String toTxtFormat() {
        return getType() + " | " + this.notebookTitle
                + " | " + this.title;
    }

    public void load(Page page) {
        pageArrayList.add(page);
    }

    // TODO change parsing method
    public static Section parse(String[] txtArray) {
        String notebookTitle = txtArray[1].trim();
        String sectionTitle = txtArray[2].trim();
        Section newSection = new Section(sectionTitle, notebookTitle);
        return newSection;
    }

    /**
     * Add a page with a given title to the section.
     *
     * @param newPage the page to be added
     */
    public void addPage(Page newPage) {
        this.pageArrayList.add(newPage);
    }

    public String getSectionInMessageFormat() {
        return "Section with title: " + this.title;
    }

    public String getType() {
        return "S";
    }
}

