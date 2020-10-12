package seedu.duke.userinterface.command;

import seedu.duke.userinterface.AppState;

public abstract class CliCommand {
    protected AppState appState;
    protected String commandParams;

    public static final String COMMAND_WORD = "";

    public CliCommand() {

    }

    public abstract void execute();

    public AppState getAppState() {
        return appState;
    }

    public void setAppState(AppState appState) {
        this.appState = appState;
    }

    public static String getCommandWord() {
        return COMMAND_WORD;
    }

    public void setCommandParams(String params) {
        commandParams = params;
    }

    public String getCommandParams() {
        return commandParams;
    }
}
