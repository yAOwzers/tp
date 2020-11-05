package teetwelvedashthree.zeronote.userinterface.command;

import teetwelvedashthree.zeronote.exceptions.IncorrectAppModeException;
import teetwelvedashthree.zeronote.exceptions.InvalidCommandException;
import teetwelvedashthree.zeronote.userinterface.AppState;

public abstract class CliCommand {
    public static final String COMMAND_WORD = "mode";
    protected AppState appState;
    protected String commandParams;
    protected static boolean isAutoSave = false;
    protected static boolean PRINTS_PERSONAL_MESSAGE = true;

    public static String getCommandWord() {
        return COMMAND_WORD;
    }

    public abstract void execute() throws InvalidCommandException, IncorrectAppModeException;

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

    public boolean isTriggerAutoSave() {
        return isAutoSave;
    }

    public boolean printsPersonalMessage() {
        return PRINTS_PERSONAL_MESSAGE;
    }
}
