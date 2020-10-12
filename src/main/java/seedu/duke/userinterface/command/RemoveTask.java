package seedu.duke.userinterface.command;

import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;

public class RemoveTask extends CliCommand {

    public static final String COMMAND_WORD = "delete";

    private static int index;

    public RemoveTask(int argument, AppState uiMode) {
        this.setAppState(uiMode);
        index = argument;
    }

    @Override
    public void execute() {
        try {
            TaskList tasksList = appState.getTaskList();
            removeTaskFromTaskList(tasksList, index);
        } catch (NumberFormatException nfe) {
            System.out.println("Please enter a valid number.");
        }
    }

    private void removeTaskFromTaskList(TaskList tasksList, int index) {
        try {
            Task deletedTask = tasksList.removeTask(index);
            int numberOfTasks = tasksList.getNumberOfTasks();
            CliMessages.printRemoveTaskMessage(deletedTask, numberOfTasks);
        } catch (IndexOutOfBoundsException ioe) {
            int numberOfTasks = tasksList.getNumberOfTasks();
            if (numberOfTasks > 0) {
                System.out.println("Please enter a valid index between 1 and " + numberOfTasks + ".");
            } else {
                System.out.println("There are no tasks in the list.");
            }
        }
    }
}
