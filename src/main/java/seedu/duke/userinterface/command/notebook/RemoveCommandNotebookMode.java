package seedu.duke.userinterface.command.notebook;

import seedu.duke.exceptions.IncorrectAppModeException;
import seedu.duke.exceptions.InvalidCommandException;
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

    private NotebookShelf currentBookshelf;
    private Notebook currentNotebook;
    private String notebookTitleToRemove;
    private Section currentSection;
    private String sectionTitleToRemove;
    private int pageNumberToRemove;

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
                removeFromNotebookShelf();
                break;
            case NOTEBOOK_BOOK:
                removeFromNotebook();
                break;
            case NOTEBOOK_SECTION:
                removeFromSection();
                break;
            default:
                throw new IncorrectAppModeException();
            }
        } catch (ZeroNoteException zne) {
            zne.printErrorMessage();
        }
    }

    private void removeFromSection() throws InvalidCommandException {
        if (pageNumberToRemove > -1) {
            Page pageRemoved = currentSection.removePage(pageNumberToRemove);
            CliMessages.printRemovePageMessage(pageRemoved, pageNumberToRemove);
        } else {
            throw new InvalidCommandException("Please enter in the format:/n" +
                    "delete /pPAGE_NUMBER");
        }
    }

    private void removeFromNotebook() throws InvalidCommandException {
        if (!sectionTitleToRemove.equals("") && pageNumberToRemove > -1) {
            int indexOfSectionToRemove = currentNotebook.findSection(sectionTitleToRemove);
            Section section = currentNotebook.getSectionAtIndex(indexOfSectionToRemove);
            Page pageRemoved = section.removePage(pageNumberToRemove);
            CliMessages.printRemovePageMessage(pageRemoved, pageNumberToRemove);
        } else if (!sectionTitleToRemove.equals("") && pageNumberToRemove == -1) {
            int indexOfSectionToRemove = currentNotebook.findSection(sectionTitleToRemove);
            Section sectionRemoved = currentNotebook.removeSection(indexOfSectionToRemove);
            CliMessages.printRemoveSectionMessage(sectionRemoved);
        } else {
            throw new InvalidCommandException("Please enter in the format:/n" +
                    "delete /sSECTION /pPAGE_NUMBER");
        }
    }

    private void removeFromNotebookShelf() throws InvalidCommandException {
        CliMessages cliMessages = new CliMessages();
        int indexOfNotebookToRemove = currentBookshelf.findNotebook(notebookTitleToRemove);

        if (!notebookTitleToRemove.equals("") && !sectionTitleToRemove.equals("")
                && pageNumberToRemove > -1) {
            Notebook notebook = currentBookshelf.getNotebookAtIndex(indexOfNotebookToRemove);
            int indexOfSectionToRemove = notebook.findSection(sectionTitleToRemove);
            Section section = notebook.getSectionAtIndex(indexOfSectionToRemove);
            Page pageRemoved = section.removePage(pageNumberToRemove);
            CliMessages.printRemovePageMessage(pageRemoved, pageNumberToRemove);
        } else if (!notebookTitleToRemove.equals("") && !sectionTitleToRemove.equals("")
                && pageNumberToRemove == -1) {
            Notebook notebook = currentBookshelf.getNotebookAtIndex(indexOfNotebookToRemove);
            int indexOfSectionToRemove = notebook.findSection(sectionTitleToRemove);
            Section sectionRemoved = notebook.removeSection(indexOfSectionToRemove);
            CliMessages.printRemoveSectionMessage(sectionRemoved);
        } else if (!notebookTitleToRemove.equals("") && sectionTitleToRemove.equals("")
                && pageNumberToRemove == -1) {
            Notebook notebookRemoved = currentBookshelf.removeNotebook(indexOfNotebookToRemove);
            CliMessages.printRemoveNotebookMessage(notebookRemoved);
        } else {
            throw new InvalidCommandException("Please enter in the format:/n" +
                    "delete /nNOTEBOOK /sSECTION /pPAGE_NUMBER");
        }
    }
}
