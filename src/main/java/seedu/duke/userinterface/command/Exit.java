package seedu.duke.userinterface.command;

import seedu.duke.userinterface.Mode;

public class Exit extends CliCommand {

    public Exit(String argument, Mode uiMode) {
        this.setUiMode(uiMode);
        this.setCommandParams(argument);
    }

    public void execute() {
    }
}
