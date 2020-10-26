package seedu.duke.userinterface.command.timetable;

import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.command.CliCommand;

public class RemoveCommandTimetableMode extends CliCommand {

    public static final String COMMAND_WORD = "delete";

    private final int indexToRemove;

    private boolean isPersonalised = true;

    public RemoveCommandTimetableMode(int indexToRemove, AppState uiMode) {
        this.setAppState(uiMode);
        this.indexToRemove = indexToRemove;
    }

    @Override
    public void execute() {
        CliMessages cliMessages = new CliMessages();
        int numberOfTasks = 0;
        try {
            TaskList taskList = appState.getTaskList();
            Task deletedTask = taskList.removeTask(indexToRemove);
            numberOfTasks = taskList.getNumberOfTasks();
            cliMessages.printRemoveTaskMessage(deletedTask, numberOfTasks);
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

    @Override
    public boolean isPersonalised() {
        return isPersonalised;
    }
}
