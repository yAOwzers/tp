package zer0note.userinterface.command.notebook;

import zer0note.exceptions.IncorrectAppModeException;
import zer0note.exceptions.InvalidNotebookException;
import zer0note.exceptions.InvalidPageException;
import zer0note.exceptions.InvalidSectionException;
import zer0note.exceptions.ZeroNoteException;
import zer0note.notebooks.Notebook;
import zer0note.notebooks.NotebookShelf;
import zer0note.notebooks.Page;
import zer0note.notebooks.Section;
import zer0note.userinterface.AppState;
import zer0note.userinterface.CliMessages;
import zer0note.userinterface.command.CliCommand;

public class RemoveCommandNotebookMode extends CliCommand {
    public static final String COMMAND_WORD = "delete";

    private CliMessages cliMessages = new CliMessages();
    private NotebookShelf currentBookshelf;
    private Notebook currentNotebook;
    private String notebookTitleToRemove;
    private Section currentSection;
    private String sectionTitleToRemove;
    private String pageTitleToRemove;

    private static final boolean isAutoSave = true;

    public RemoveCommandNotebookMode(String notebookTitle, String sectionTitle,
                                     String pageTitle, AppState appState) {
        this.appState = appState;
        notebookTitleToRemove = notebookTitle;
        sectionTitleToRemove = sectionTitle;
        pageTitleToRemove = pageTitle;

        currentBookshelf = appState.getCurrentBookShelf();
        currentNotebook = appState.getCurrentNotebook();
        currentSection = appState.getCurrentSection();

        PRINTS_PERSONAL_MESSAGE = true;
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
                removeFromNotebook(currentNotebook);
                break;
            case NOTEBOOK_SECTION:
                if (!notebookTitleToRemove.equals("") || !sectionTitleToRemove.equals("")) {
                    throw new IncorrectAppModeException();
                }
                removeFromSection(currentSection);
                break;
            default:
                throw new IncorrectAppModeException();
            }
        } catch (ZeroNoteException zne) {
            zne.printErrorMessage();
        }
    }

    private void removeFromSection(Section section) throws InvalidPageException {
        int indexOfPage = section.findPage(pageTitleToRemove);
        Page pageRemoved = section.removePage(indexOfPage);
        cliMessages.printRemovePageMessage(pageRemoved);
    }

    private void removeFromNotebook(Notebook notebook) throws InvalidPageException, InvalidSectionException {
        if (!sectionTitleToRemove.equals("") && !pageTitleToRemove.equals("")) {
            int indexOfSectionToRemove = notebook.findSection(sectionTitleToRemove);
            Section section;
            try {
                section = notebook.getSectionAtIndex(indexOfSectionToRemove);
            } catch (IndexOutOfBoundsException ioe) {
                throw new InvalidSectionException(sectionTitleToRemove);
            }
            removeFromSection(section);
        } else if (!sectionTitleToRemove.equals("") && pageTitleToRemove.equals("")) {
            int indexOfSectionToRemove = notebook.findSection(sectionTitleToRemove);
            try {
                Section sectionRemoved = notebook.removeSection(indexOfSectionToRemove);
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
            removeFromNotebook(notebook);
            return;
        } else if (!notebookTitleToRemove.equals("") && sectionTitleToRemove.equals("")
                && pageTitleToRemove.equals("")) {
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
        if (!pageTitleToRemove.equals("")) {
            throw new InvalidPageException(pageTitleToRemove);
        }
    }

    @Override
    public boolean isTriggerAutoSave() {
        return isAutoSave;
    }
}
