package seedu.duke.userinterface.command;

import seedu.duke.userinterface.Mode;

public abstract class CliCommand {
    protected Mode uiMode;
    protected String commandParams;

    public CliCommand() {
        this.uiMode = Mode.TIMETABLE;
    }

    public abstract void execute();

    public void setUiMode(Mode currentUiMode) {
        uiMode = currentUiMode;
    }

    public void setCommandParams(String params) {
        commandParams = params;
    }
}
