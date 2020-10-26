package seedu.duke.userinterface.command.notebook;

import seedu.duke.exceptions.IncorrectAppModeException;
import seedu.duke.exceptions.ZeroNoteException;
import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.command.CliCommand;

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
    }

    public void execute() {
        try {
            switch (appState.getAppMode()) {
            case NOTEBOOK_BOOK:
                currentNotebook.setTag(commandParams);
                cliMessages.printTagNotebookMessage(currentNotebook.getTitle(),currentNotebook.getTag());
                break;
            case NOTEBOOK_SECTION:
                currentSection.setTag(commandParams);
                cliMessages.printTagNotebookMessage(currentSection.getTitle(),currentSection.getTag());
                break;
            case NOTEBOOK_PAGE:
                currentPage.setTag(commandParams);
                cliMessages.printTagNotebookMessage(currentPage.getTitle(),currentPage.getTag());
                break;
            default:
                throw new IncorrectAppModeException();
            }
        } catch (ZeroNoteException zne) {
            zne.printErrorMessage();
            return;
        }

    }

    @Override
    public boolean isTriggerAutoSave() {
        return isAutoSave;
    }
}
