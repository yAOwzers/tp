package seedu.duke.userinterface.command;

import seedu.duke.userinterface.CliMessages;

public class Help extends CliCommand {
    String commandArgs;
    public Help(String commandArgs) {
        this.commandArgs = commandArgs;
    }
    @Override
    public void execute() {
        CliMessages messages = new CliMessages();
        messages.printGeneralHelp();
        switch(commandArgs) {
        case "notebook":
            messages.printNotebookModeHelp();
            break;
        case "timetable":
            messages.printTimetableModeHelp();
            break;
        }
    }
}
