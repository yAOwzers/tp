package seedu.duke.userinterface.command;

import seedu.duke.userinterface.AppState;

public class Exit extends CliCommand {

    public Exit(String argument, AppState appState) {
        this.setAppState(appState);
        this.setCommandParams(argument);
    }

    public void execute() {
    }
}
