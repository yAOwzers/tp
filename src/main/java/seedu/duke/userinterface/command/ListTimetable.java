package seedu.duke.userinterface.command;

import seedu.duke.userinterface.Mode;

public class ListTimetable extends CliCommand{

    public ListTimetable(String argument, Mode uiMode) {
        this.setUiMode(uiMode);
        this.setCommandParams(argument);
    }

    @Override
    public void execute() {

    }

}
