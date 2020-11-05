package zer0note.userinterface.command;

import zer0note.userinterface.AppState;
import zer0note.userinterface.CliMessages;

public class Exit extends CliCommand {
    public static final String COMMAND_WORD = "exit";


    public Exit(String argument, AppState appState) {
        this.setAppState(appState);
        this.setCommandParams(argument);
        isAutoSave = true;
    }

    public void execute() {
        CliMessages messages = new CliMessages();
        messages.printGoodBye();
    }
}
