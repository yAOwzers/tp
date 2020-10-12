package seedu.duke.userinterface.command;

import seedu.duke.userinterface.Mode;

public class Help extends CliCommand {

    public Help(String argument, Mode uiMode) {
        this.setUiMode(uiMode);
        this.commandParams = argument;
    }

    @Override
    public void execute() {

    }
}
