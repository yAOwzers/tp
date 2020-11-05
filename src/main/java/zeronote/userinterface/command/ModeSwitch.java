package zeronote.userinterface.command;

import zeronote.exceptions.InvalidCommandException;
import zeronote.userinterface.AppMode;
import zeronote.userinterface.AppState;

public class ModeSwitch extends CliCommand {
    public static final String COMMAND_WORD = "mode";

    public ModeSwitch(String argument, AppState appState) {
        this.setAppState(appState);
        this.setCommandParams(argument);
    }

    @Override
    public void execute() throws InvalidCommandException {
        switch (commandParams) {
        case ("/t"):
            appState.setAppMode(AppMode.TIMETABLE);
            System.out.println("You are now in " + appState.getAppMode() + " mode");
            break;
        case ("/n"):
            appState.setAppMode(AppMode.NOTEBOOK_SHELF);
            System.out.println("You are now in " + appState.getAppMode() + " mode");
            break;
        default:
            throw new InvalidCommandException("Invalid option after mode");
        }

    }
}
