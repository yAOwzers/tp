package seedu.duke.userinterface.command;

import seedu.duke.userinterface.Mode;

public abstract class CliCommand {
    protected static Mode applicationState;
    protected String commandParams;
    public static final String COMMAND_WORD = "";

    public abstract void execute();

    public void setUiMode(Mode currentUiMode) {
        applicationState = currentUiMode;
    }

    public void setCommandParams(String params) {
        commandParams = params;
    }

    public static Mode getApplicationState() {
        return applicationState;
    }

    public static void setApplicationState(Mode applicationState) {
        CliCommand.applicationState = applicationState;
    }

    public String getCommandParams() {
        return commandParams;
    }
}
