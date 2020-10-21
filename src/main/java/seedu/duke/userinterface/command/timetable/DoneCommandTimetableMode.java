package seedu.duke.userinterface.command.timetable;

import seedu.duke.storage.Storage;
import seedu.duke.tasks.Task;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.command.CliCommand;

public class DoneCommandTimetableMode extends CliCommand {
    public static final String COMMAND_WORD = "done";

    private AppState appState;
    private String argument;
    private CliMessages messages = new CliMessages();
    private Storage storage;

    public DoneCommandTimetableMode(String argument, AppState appState, Storage storage) {
        this.argument = argument;
        this.appState = appState;
        this.storage = storage;
    }

    @Override
    public void execute() {
        try {
            int indexOfNumberAfterDone = Integer.parseInt(this.argument);
            Task taskDone = this.appState.markTaskAsDone(indexOfNumberAfterDone);
            this.storage.saveTaskList(this.appState.getTaskList()); // saves the file by overwriting the data.txt file
            messages.printMarkDone(taskDone);
        } catch (NumberFormatException e) {
            System.out.println("I'm sorry, please enter a valid number!");
        }
    }
}
