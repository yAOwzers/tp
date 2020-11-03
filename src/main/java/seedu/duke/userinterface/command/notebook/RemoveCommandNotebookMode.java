package seedu.duke.userinterface.command.notebook;

import seedu.duke.exceptions.IncorrectAppModeException;
import seedu.duke.exceptions.InvalidNotebookException;
import seedu.duke.exceptions.InvalidPageException;
import seedu.duke.exceptions.InvalidSectionException;
import seedu.duke.exceptions.ZeroNoteException;
import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.command.CliCommand;

public class RemoveCommandNotebookMode extends CliCommand {
    public static final String COMMAND_WORD = "delete";

    private CliMessages cliMessages = new CliMessages();
    private NotebookShelf currentBookshelf;
    private Notebook currentNotebook;
    private String notebookTitleToRemove;
    private Section currentSection;
    private String sectionTitleToRemove;
    private int pageNumberToRemove;

    private static final boolean isAutoSave = true;

    public RemoveCommandNotebookMode(String notebookTitle, String sectionTitle,
                                     int pageNumber, AppState appState) {
        this.appState = appState;
        notebookTitleToRemove = notebookTitle;
        sectionTitleToRemove = sectionTitle;
        pageNumberToRemove = pageNumber;

        currentBookshelf = appState.getCurrentBookShelf();
        currentNotebook = appState.getCurrentNotebook();
        currentSection = appState.getCurrentSection();
    }

    public void execute() {
        try {
            switch (appState.getAppMode()) {
            case NOTEBOOK_SHELF:
                if (notebookTitleToRemove.equals("")) {
                    throw new InvalidNotebookException(notebookTitleToRemove);
                }
                removeFromNotebookShelf();
                break;
            case NOTEBOOK_BOOK:
                if (!notebookTitleToRemove.equals("")) {
                    throw new IncorrectAppModeException();
                }
                removeFromNotebook();
                break;
            case NOTEBOOK_SECTION:
                if (!notebookTitleToRemove.equals("") || !sectionTitleToRemove.equals("")) {
                    throw new IncorrectAppModeException();
                }
                removeFromSection();
                break;
            default:
                throw new IncorrectAppModeException();
            }
        } catch (ZeroNoteException zne) {
            zne.printErrorMessage();
        }
    }

    private void removeFromSection() throws InvalidPageException {
        Page pageRemoved = currentSection.removePage(pageNumberToRemove);
        cliMessages.printRemovePageMessage(pageRemoved);
    }

    private void removeFromNotebook() throws InvalidPageException, InvalidSectionException {
        if (!sectionTitleToRemove.equals("") && pageNumberToRemove > -1) {
            int indexOfSectionToRemove = currentNotebook.findSection(sectionTitleToRemove);
            Section section;
            try {
                section = currentNotebook.getSectionAtIndex(indexOfSectionToRemove);
            } catch (IndexOutOfBoundsException ioe) {
                throw new InvalidSectionException(sectionTitleToRemove);
            }
            Page pageRemoved = section.removePage(pageNumberToRemove);
            cliMessages.printRemovePageMessage(pageRemoved);
        } else if (!sectionTitleToRemove.equals("") && pageNumberToRemove == -1) {
            int indexOfSectionToRemove = currentNotebook.findSection(sectionTitleToRemove);
            try {
                Section sectionRemoved = currentNotebook.removeSection(indexOfSectionToRemove);
                cliMessages.printRemoveSectionMessage(sectionRemoved);
            } catch (IndexOutOfBoundsException ioe) {
                throw new InvalidSectionException(sectionTitleToRemove);
            }
        } else {
            throw new InvalidSectionException(sectionTitleToRemove);
        }
    }

    private void removeFromNotebookShelf() throws InvalidNotebookException, InvalidSectionException,
            InvalidPageException {
        int indexOfNotebookToRemove = currentBookshelf.findNotebook(notebookTitleToRemove);

        if (!notebookTitleToRemove.equals("") && !sectionTitleToRemove.equals("")) {
            Notebook notebook;
            try {
                notebook = currentBookshelf.getNotebookAtIndex(indexOfNotebookToRemove);
            } catch (IndexOutOfBoundsException ioe) {
                throw new InvalidNotebookException(notebookTitleToRemove);
            }
            int indexOfSectionToRemove = notebook.findSection(sectionTitleToRemove);
            if (pageNumberToRemove > -1) {
                Section section;
                try {
                    section = notebook.getSectionAtIndex(indexOfSectionToRemove);
                } catch (IndexOutOfBoundsException ioe) {
                    throw new InvalidSectionException(sectionTitleToRemove);
                }
                Page pageRemoved = section.removePage(pageNumberToRemove);
                cliMessages.printRemovePageMessage(pageRemoved);
            } else if (pageNumberToRemove == -1) {
                Section sectionRemoved = notebook.removeSection(indexOfSectionToRemove);
                cliMessages.printRemoveSectionMessage(sectionRemoved);
            } else {
                throw new InvalidPageException(Integer.toString(pageNumberToRemove + 1));
            }
            return;
        } else if (!notebookTitleToRemove.equals("") && sectionTitleToRemove.equals("")
                && pageNumberToRemove == -1) {
            try {
                Notebook notebookRemoved = currentBookshelf.removeNotebook(indexOfNotebookToRemove);
                cliMessages.printRemoveNotebookMessage(notebookRemoved);
            } catch (IndexOutOfBoundsException ioe) {
                throw new InvalidNotebookException(notebookTitleToRemove);
            }
            return;
        }

        if (sectionTitleToRemove.equals("")) {
            throw new InvalidSectionException(sectionTitleToRemove);
        }
        if (pageNumberToRemove == -1) {
            throw new InvalidPageException(Integer.toString(pageNumberToRemove + 1));
        }
    }

    @Override
    public boolean isTriggerAutoSave() {
        return isAutoSave;
    }
}
