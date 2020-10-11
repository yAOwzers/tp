package seedu.duke.userinterface.command;

import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;

public class List extends CliCommand {

    @Override
    public void execute() {

    }

    public static void listBookshelf_nsp(NotebookShelf notebookShelf) {
        for (Notebook notebook: notebookShelf.getNotebooksArrayList()) {
            System.out.println(notebook.getTitle());
            for (Section section: notebook.getSectionArrayList()) {
                System.out.println("  |-- " + section.getTitle());
                for (Page page: section.getPageArrayList()) {
                    System.out.println("        |-- " + page);
                }
            }
        }
    }

    public static void listBookshelf_ns(NotebookShelf notebookShelf) {
        for (Notebook notebook: notebookShelf.getNotebooksArrayList()) {
            System.out.println(notebook.getTitle());
            for (Section section: notebook.getSectionArrayList()) {
                System.out.println("  |-- " + section.getTitle());
            }
        }
    }

    public static void listBookshelf_n(NotebookShelf notebookShelf) {
        for (Notebook notebook: notebookShelf.getNotebooksArrayList()) {
            System.out.println(notebook.getTitle());
        }
    }

    public void listNotebook_sp(Notebook notebook) {
        for (Section section: notebook.getSectionArrayList()) {
            System.out.println(section.getTitle());
            for (Page page: section.getPageArrayList()) {
                System.out.println("  |-- " + page);
            }
        }
    }

    public void listNotebook_s(Notebook notebook) {
        for (Section section: notebook.getSectionArrayList()) {
            System.out.println(section.getTitle());
        }
    }

    public void listSection(Section section) {
        for (Page page: section.getPageArrayList()) {
            System.out.println(page);
        }
    }

}
