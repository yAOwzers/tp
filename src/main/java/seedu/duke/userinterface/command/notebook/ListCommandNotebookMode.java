package seedu.duke.userinterface.command.notebook;

import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.command.CliCommand;

public class ListCommandNotebookMode extends CliCommand {
    public static final String COMMAND_WORD = "list";

    public ListCommandNotebookMode(String argument, AppState appState) {
        this.setAppState(appState);
        this.setCommandParams(argument);
    }

    // TODO: Break into functions and avoid repeated code, arrowhead code

    public static void listBookshelf_nsp(NotebookShelf notebookShelf) {
        for (Notebook notebook : notebookShelf.getNotebookArrayList()) {
            System.out.println("* " + notebook.getTitle());
            for (Section section : notebook.getSectionArrayList()) {
                System.out.println("  |-- " + section.getTitle());
                for (Page page : section.getPageArrayList()) {
                    System.out.println("        |-- " + page.getTitle());
                    System.out.println("            " + page.getContent());
                }
            }
        }
    }

    // TODO: Break into functions and avoid repeated code, arrowhead code
    public static void listBookshelf_ns(NotebookShelf notebookShelf) {
        for (Notebook notebook : notebookShelf.getNotebookArrayList()) {
            System.out.println("* " + notebook.getTitle());
            for (Section section : notebook.getSectionArrayList()) {
                System.out.println("  |-- " + section.getTitle());
            }
        }
    }

    // TODO: Break into functions and avoid repeated code, arrowhead code
    public static void listBookshelf_n(NotebookShelf notebookShelf) {
        for (Notebook notebook : notebookShelf.getNotebookArrayList()) {
            System.out.println("* " + notebook.getTitle());
        }
    }

    // TODO: Break into functions and avoid repeated code, arrowhead code
    public static void listNotebook_sp(Notebook notebook) {
        for (Section section : notebook.getSectionArrayList()) {
            System.out.println("* " + section.getTitle());
            for (Page page : section.getPageArrayList()) {
                System.out.println("  |-- " + page);
                System.out.println("        " + page.getContent());
            }
        }
    }

    // TODO: Break into functions and avoid repeated code, arrowhead code
    public static void listNotebook_s(Notebook notebook) {
        for (Section section : notebook.getSectionArrayList()) {
            System.out.println("* " + section.getTitle());
        }
    }

    // TODO: Break into functions and avoid repeated code, arrowhead code
    public static void listSection(Section section) {
        for (Page page : section.getPageArrayList()) {
            System.out.println("* " + page.getTitle());
            System.out.println("    " + page.getContent());
        }
    }

    @Override
    public void execute() {
        switch (appState.getAppMode()) {
        case NOTEBOOK_SHELF:
            switch (commandParams) {
            case ("/s"):
                listBookshelf_ns(appState.getCurrentNotebookShelf());
                break;
            case ("/a"):
                listBookshelf_nsp(appState.getCurrentNotebookShelf());
                break;
            default:
                listBookshelf_n(appState.getCurrentNotebookShelf());
                break;
            }
            break;
        case NOTEBOOK_BOOK:
            switch (commandParams) {
            case ("/a"):
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
            // TODO: Replace with an exception
            System.out.println("Error in list class");
            break;
        }
    }
}
