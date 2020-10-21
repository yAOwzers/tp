package seedu.duke.userinterface.command.timetable;

import seedu.duke.storage.Storage;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.command.CliCommand;

public class RemoveCommandTimetableMode extends CliCommand {

    public static final String COMMAND_WORD = "delete";

    private final int indexToRemove;
    private Storage storage;

    public RemoveCommandTimetableMode(int indexToRemove, AppState uiMode, Storage storage) {
        this.setAppState(uiMode);
        this.indexToRemove = indexToRemove;
        this.storage = storage;
    }

    @Override
    public void execute() {
        TaskList currentTaskList = appState.getTaskList();
        int numberOfTasks = currentTaskList.getNumberOfTasks();

        try {
            Task deletedTask = currentTaskList.removeTask(indexToRemove);
            CliMessages.printRemoveTaskMessage(deletedTask, numberOfTasks);
            this.storage.saveTaskList(currentTaskList);
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
