package seedu.duke.userinterface.command;

import seedu.duke.exceptions.InvalidUserInputException;
import seedu.duke.userinterface.Mode;

public abstract class CliCommand {
    private Mode uiMode;
    private String commandParams;
    public static final String COMMAND_WORD = "";


    public abstract void execute() throws InvalidUserInputException;

    public void setUiMode(Mode currentUiMode) {
        uiMode = currentUiMode;
    }

    public void setCommandParams(String params) {
        commandParams = params;
    }
}
