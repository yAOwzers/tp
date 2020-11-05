package teetwelvedashthree.zeronote.userinterface.command;

import teetwelvedashthree.zeronote.userinterface.AppState;
import teetwelvedashthree.zeronote.userinterface.CliMessages;

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
