package seedu.duke.userinterface.command;

import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidNotebookException;
import seedu.duke.exceptions.InvalidPageException;
import seedu.duke.exceptions.InvalidSectionException;
import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.userinterface.AppMode;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.InputParser;

import java.util.ArrayList;

public class Select extends CliCommand {
    public static final String COMMAND_WORD = "select";
    public static final String NOTEBOOK_DELIMITER = "/n";
    public static final String SECTION_DELIMITER = "/s";
    public static final String PAGE_DELIMITER = "/p";
    private String argument;
    private String notebookTitle = null;
    private String sectionTitle = null;
    private int pageNum;
    private Notebook notebook;
    private Section section;

    public Select(String argument, AppState uiMode) {
        this.setAppState(uiMode);
        this.argument = argument;
    }

    private void extractParams(String argument) {
        InputParser parser = new InputParser();
        try {
            if (argument.startsWith(NOTEBOOK_DELIMITER) && appState.getAppMode()==AppMode.NOTEBOOK_SHELF) {
                extractNotebookParams(argument, parser);
            } else if (argument.startsWith(SECTION_DELIMITER) && appState.getAppMode()==AppMode.NOTEBOOK_BOOK) {
                extractSectionParams(argument, parser);
            } else if (argument.startsWith(PAGE_DELIMITER) && appState.getAppMode()==AppMode.NOTEBOOK_SECTION) {
                pageNum = parser.parsePageNumber(argument);
                findPage(appState.getCurrentSection(), pageNum);
            } else {
                throw new InvalidCommandException();
            }
        } catch (InvalidNotebookException e) {
            System.out.println("invalid notebook input");
        } catch (InvalidSectionException e) {
            System.out.println("invalid section input");
        } catch (InvalidPageException e) {
            System.out.println("invalid page input");
        } catch (NullPointerException | InvalidCommandException e) {
            System.out.println("wrong format");
        }
    }

    private void extractSectionParams(String argument, InputParser parser) throws InvalidSectionException, InvalidPageException {
        sectionTitle = InputParser.parseSectionTitle(argument);
        section = findSection(notebook, sectionTitle);
        if (argument.contains(PAGE_DELIMITER)) {
            pageNum = parser.parsePageNumber(argument);
            findPage(appState.getCurrentSection(), pageNum);
        }
    }

    private void extractNotebookParams(String argument, InputParser parser) throws InvalidNotebookException, InvalidSectionException, InvalidPageException {
        notebookTitle = InputParser.parseNotebookTitle(argument);
        notebook = findNotebook(appState.getCurrentBookShelf(), notebookTitle);
        if (argument.contains(SECTION_DELIMITER)) {
            sectionTitle = InputParser.parseSectionTitle(argument);
            section = findSection(notebook, sectionTitle);
        }
        if (argument.contains(PAGE_DELIMITER) && section != null) {
            pageNum = parser.parsePageNumber(argument);
            findPage(appState.getCurrentSection(), pageNum);
        }
    }

    @Override
    public void execute() {
        switch (appState.getAppMode()) {
        case NOTEBOOK_SHELF:
            extractParams(argument);
            break;
        case NOTEBOOK_BOOK:
            extractParams(argument);
            System.out.println("now in " + appState.getAppMode() + ": "+ appState.getCurrentSection().getTitle());
            break;
        case NOTEBOOK_SECTION:
            extractParams(argument);
            System.out.println("now in " + appState.getAppMode() + ": "+ appState.getCurrentNotebook().getTitle());
            break;
        default:
            System.out.println("\tError occurred when selecting");
            break;
        }
    }

    // problem because currentBookshelf is null
    private Notebook findNotebook(NotebookShelf currentBookshelf, String notebookTitle) {
        ArrayList<Notebook> notebookArrayList = currentBookshelf.getNotebooksArrayList();
        int i = 0;
        for (Notebook notebook: notebookArrayList) {
            if (notebook.getTitle().equals(notebookTitle)) {
                notebook = notebookArrayList.get(i);
                appState.setCurrentNotebook(notebook);
                appState.setAppMode(AppMode.NOTEBOOK_BOOK);
                System.out.println("now in " + appState.getAppMode() + ": "+ notebook.getTitle());
                return notebook;
            }
            i++;
        }
        System.out.print("no matching notebook found for " + notebookTitle);
        return null;
    }

    private Section findSection(Notebook notebook, String sectionTitle) {
        ArrayList<Section> sectionArrayList = notebook.getSectionArrayList();
        for (Section section: sectionArrayList) {
            if (section.getTitle().equals(sectionTitle)){
                appState.setCurrentSection(section);
                appState.setAppMode(AppMode.NOTEBOOK_SECTION);
                return section;
            }
        }
        System.out.println("no matching section found for " + sectionTitle);
        return null;
    }

    private void findPage(Section section, int pageNum) {
        try {
            ArrayList<Page> pageArrayList = section.getPageArrayList();
            Page page = pageArrayList.get(pageNum);
            page.printPage();
            appState.setAppMode(AppMode.NOTEBOOK_PAGE);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("\tpage doesn't exist");
        }
    }
}
