package seedu.duke.userinterface.command.timetable;

import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.command.CliCommand;

import java.util.ArrayList;

public class RemoveTimetableMode extends CliCommand {

    public static final String COMMAND_WORD = "delete";

    private final int indexToRemove;

    public RemoveTimetableMode(int indexToRemove, AppState uiMode) {
        this.setAppState(uiMode);
        this.indexToRemove = indexToRemove;
    }

    @Override
    public void execute() {
        int numberOfTasks = 0;
        try {
            TaskList taskList = appState.getTaskList();
            Task deletedTask = taskList.removeTask(indexToRemove);
            numberOfTasks = taskList.getNumberOfTasks();
            CliMessages.printRemoveTaskMessage(deletedTask, numberOfTasks);
        } catch (IndexOutOfBoundsException ioe) {
            if (numberOfTasks > 0) {
                System.out.println("Please enter a valid index between 1 and " + numberOfTasks + ".");
            } else {
                System.out.println("There are no tasks in the list.");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter a valid number.");
        }
    }
}
