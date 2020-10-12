package seedu.duke.userinterface.command;

import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.userinterface.AppState;

public class List extends CliCommand {
    public static final String COMMAND_WORD = "list";

    public List(String argument, AppState uiMode) {
        this.setAppState(uiMode);
        this.setCommandParams(argument);
    }

    @Override
    public void execute() {
        switch (appState.getAppMode()) {
        case NOTEBOOK_SHELF:
            switch (commandParams) {
            case ("/s"):
                listBookshelf_ns(appState.getCurrentBookShelf());
                break;
            case ("/a"):
                listBookshelf_nsp(appState.getCurrentBookShelf());
                break;
            default:
                listBookshelf_n(appState.getCurrentBookShelf());
                break;
            }
            break;
        case NOTEBOOK_BOOK:
            switch (commandParams) {
            case("/a"):
                listNotebook_s(appState.getCurrentNotebook());
                break;
            default:
                listNotebook_sp(appState.getCurrentNotebook());
                break;
            }
            break;
        case NOTEBOOK_SECTION:
            listSection(appState.getCurrentSection());
            break;
        default:
            System.out.println("Error in list class");
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
