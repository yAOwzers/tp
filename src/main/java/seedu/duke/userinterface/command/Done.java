package seedu.duke.userinterface.command;

import seedu.duke.exceptions.InvalidUserInputException;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.CliUserInterface;

public class Done extends CliCommand {

    public static final String COMMAND_WORD = "done";

    private AppState appState;
    private String argument;
    private CliMessages messages = new CliMessages();

    public Done(String argument, AppState appState) {
       this.argument = argument;
       this.appState = appState;
    }

    @Override
    public void execute() {
        try {
            int indexOfNumberAfterDone = Integer.parseInt(this.argument);
            Task taskDone = this.appState.markTaskAsDone(indexOfNumberAfterDone);
            messages.printMarkDone(taskDone);
        } catch (NumberFormatException e) {
            System.out.println("I'm sorry, please enter a valid number!");
        }
    }


}
