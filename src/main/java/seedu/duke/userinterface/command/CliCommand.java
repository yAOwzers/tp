package seedu.duke.userinterface.command;

import seedu.duke.userinterface.AppState;

public abstract class CliCommand {
    public static final String COMMAND_WORD = "mode";
    protected AppState appState;
    protected String commandParams;

    public static String getCommandWord() {
        return COMMAND_WORD;
    }

    public abstract void execute();

    public AppState getAppState() {
        return appState;
    }

    public void setAppState(AppState appState) {
        this.appState = appState;
    }

    public String getCommandParams() {
        return commandParams;
    }

    public void setCommandParams(String params) {
        commandParams = params;
    }
}
