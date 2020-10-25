package seedu.duke.notebooks;

import java.util.ArrayList;

/**
 * Represents a list of Pages.
 *
 */
public class Section {
    private String title;
    private final ArrayList<Page> pageArrayList;

    public Section(String title) {
        this.title = title;
        pageArrayList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addPage(String title, String content) {
        pageArrayList.add(new Page(title, content));
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

    public String toTxtFormat() {
        return this.title;
    }

    public void load(Page page) {
        pageArrayList.add(page);
    }

    public static Section parse(String txtFormat) {
        String title = txtFormat;
        Section newSection = new Section(title);
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
}

