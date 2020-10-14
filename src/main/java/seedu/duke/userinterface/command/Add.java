package seedu.duke.userinterface.command;

import seedu.duke.userinterface.AppState;


public class Add extends CliCommand {
    public static final String COMMAND_WORD = "add";
    private String argument;
    private AppState uiMode;


    public Add(String argument, AppState uiMode) {
        this.argument = argument;
        this.uiMode = uiMode;
    }

    public void execute() {

    }
}
