package zeronote.userinterface.command.timetable;

import zeronote.tasks.Task;
import zeronote.tasks.TaskList;
import zeronote.userinterface.AppState;
import zeronote.userinterface.CliMessages;
import zeronote.userinterface.command.CliCommand;

//@@author Lusi711

/**
 * Class to delete an existing task with the index specified by the user.
 */
public class RemoveCommandTimetableMode extends CliCommand {

    public static final String COMMAND_WORD = "delete";

    private final int indexToRemove;

    private static final boolean isAutoSave = true;


    public RemoveCommandTimetableMode(int indexToRemove, AppState uiMode) {
        this.setAppState(uiMode);
        this.indexToRemove = indexToRemove;
        PRINTS_PERSONAL_MESSAGE = true;
    }

    /**
     * Executes the command to delete an existing task.
     */
    @Override
    public void execute() {
        CliMessages cliMessages = new CliMessages();
        TaskList taskList = appState.getTaskList();
        int numberOfTasks = taskList.getNumberOfTasks();
        try {
            Task deletedTask = taskList.removeTask(indexToRemove);
            numberOfTasks--;
            cliMessages.printRemoveTaskMessage(deletedTask, numberOfTasks);
        } catch (IndexOutOfBoundsException ioe) {
            if (numberOfTasks > 1) {
                System.out.println("Please enter a valid index between 1 and " + numberOfTasks + ".");
            } else if (numberOfTasks == 1) {
                System.out.println("Index can only be 1.");
            } else {
                System.out.println("There are no tasks in the list.");
            }
        }
    }

    @Override
    public boolean isTriggerAutoSave() {
        return isAutoSave;
    }
}
