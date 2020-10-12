package seedu.duke.userinterface.command;

import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.userinterface.Mode;

public class List extends CliCommand {

    public List(String argument, Mode uiMode) {
        this.setUiMode(uiMode);
        this.setCommandParams(argument);
    }

    @Override
    public void execute() {
        switch(applicationState.getAppMode()) {
        case NOTEBOOK_SHELF:
            switch (commandParams) {
            case ("/s"):
                listBookshelf_ns(applicationState.getCurrentBookShelf());
                break;
            case ("/a"):
                listBookshelf_nsp(applicationState.getCurrentBookShelf());
                break;
            default:
                listBookshelf_n(applicationState.getCurrentBookShelf());
                break;
            }
            break;
        case NOTEBOOK_BOOK:
            switch (commandParams) {
            case("/a"):
                listNotebook_s(applicationState.getCurrentNotebook());
            default:
                listNotebook_s(applicationState.getCurrentNotebook());
                break;
            }
            break;
        case NOTEBOOK_SECTION:
            listSection(applicationState.getCurrentSection());
            break;
        }

    }

    public static void listBookshelf_nsp(NotebookShelf notebookShelf) {
        for (Notebook notebook: notebookShelf.getNotebooksArrayList()) {
            System.out.println("* " + notebook.getTitle());
            for (Section section: notebook.getSectionArrayList()) {
                System.out.println("  |-- " + section.getTitle());
                for (Page page: section.getPageArrayList()) {
                    System.out.println("        |-- " + page.getTitle());
                    System.out.println("            " + page.getContent());
                }
            }
        }
    }

    public static void listBookshelf_ns(NotebookShelf notebookShelf) {
        for (Notebook notebook: notebookShelf.getNotebooksArrayList()) {
            System.out.println("* " + notebook.getTitle());
            for (Section section: notebook.getSectionArrayList()) {
                System.out.println("  |-- " + section.getTitle());
            }
        }
    }

    public static void listBookshelf_n(NotebookShelf notebookShelf) {
        for (Notebook notebook: notebookShelf.getNotebooksArrayList()) {
            System.out.println("* " + notebook.getTitle());
        }
    }

    public static void listNotebook_sp(Notebook notebook) {
        for (Section section: notebook.getSectionArrayList()) {
            System.out.println("* " + section.getTitle());
            for (Page page: section.getPageArrayList()) {
                System.out.println("  |-- " + page);
                System.out.println("        " + page.getContent());
            }
        }
    }

    public static void listNotebook_s(Notebook notebook) {
        for (Section section: notebook.getSectionArrayList()) {
            System.out.println("* " + section.getTitle());
        }
    }

    public static void listSection(Section section) {
        for (Page page: section.getPageArrayList()) {
            System.out.println("* " + page.getTitle());
            System.out.println("    " + page.getContent());
        }
    }

}
