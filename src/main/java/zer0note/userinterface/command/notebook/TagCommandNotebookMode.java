package zer0note.userinterface.command.notebook;

import zer0note.exceptions.IncorrectAppModeException;
import zer0note.exceptions.ZeroNoteException;
import zer0note.notebooks.Notebook;
import zer0note.notebooks.Page;
import zer0note.notebooks.Section;
import zer0note.userinterface.AppState;
import zer0note.userinterface.CliMessages;
import zer0note.userinterface.command.CliCommand;

public class TagCommandNotebookMode extends CliCommand {
    public static final String COMMAND_WORD = "tag";
    private final Notebook currentNotebook;
    private final Section currentSection;
    private final Page currentPage;
    private CliMessages cliMessages = new CliMessages();
    private static final boolean isAutoSave = true;


    public TagCommandNotebookMode(String params, AppState appState) {
        this.appState = appState;
        this.setCommandParams(params);
        assert this.commandParams != null;
        currentNotebook = appState.getCurrentNotebook();
        currentSection = appState.getCurrentSection();
        currentPage = appState.getCurrentPage();
        PRINTS_PERSONAL_MESSAGE = true;
    }

    public void execute() {
        CliMessages cliMessages = new CliMessages();
        try {
            switch (appState.getAppMode()) {
            case NOTEBOOK_BOOK:
                currentNotebook.setTag(commandParams);
                cliMessages.printTagNotebookMessage(currentNotebook.getTitle(), currentNotebook.getTag());
                break;
            case NOTEBOOK_SECTION:
                currentSection.setTag(commandParams);
                cliMessages.printTagNotebookMessage(currentSection.getTitle(), currentSection.getTag());
                break;
            case NOTEBOOK_PAGE:
                currentPage.setTag(commandParams);
                cliMessages.printTagNotebookMessage(currentPage.getTitle(), currentPage.getTag());
                break;
            default:
                throw new IncorrectAppModeException();
            }
        } catch (ZeroNoteException zne) {
            zne.printErrorMessage();
        }
    }

    @Override
    public boolean isTriggerAutoSave() {
        return isAutoSave;
    }
}
