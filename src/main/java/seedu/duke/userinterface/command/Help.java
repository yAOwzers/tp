package seedu.duke.userinterface.command;

import seedu.duke.userinterface.AppState;

public class Help extends CliCommand {

    public Help(String argument, AppState appState) {
        this.setAppState(appState);
        this.commandParams = argument;
    }

    @Override
    public void execute() {

    }
}
