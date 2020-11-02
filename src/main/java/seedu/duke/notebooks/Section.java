package seedu.duke.notebooks;

import java.util.ArrayList;

import seedu.duke.exceptions.InvalidPageException;
import seedu.duke.exceptions.InvalidTagException;

public class Section {
    private String title;
    private String tag = "";
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

    public void addPage(Page p) {
        pageArrayList.add(p);
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

    public int findPage(String searchKey) {
        int index = 0;
        for (Page p : pageArrayList) {
            if (p.getTitle().equals(searchKey)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public Page removePage(int indexToRemove) throws InvalidPageException {
        try {
            return pageArrayList.remove(indexToRemove);
        } catch (Exception e) {
            throw new InvalidPageException(Integer.toString(indexToRemove + 1));
        }
    }

    public Page getPageAtIndex(int index) {
        return pageArrayList.get(index);
    }

    public ArrayList<Page> getPageArrayList() {
        return pageArrayList;
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

    public String serialize() {
        StringBuilder serialized = new StringBuilder();
        String lineSeparator = System.lineSeparator();
        serialized.append(title);
        serialized.append(lineSeparator);
        serialized.append(pageArrayList.size());
        serialized.append(lineSeparator);
        for (Page p: pageArrayList) {
            serialized.append(p.serialize());
        }
        return serialized.toString();
    }
}
