package seedu.duke.userinterface.command.timetable;

import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.command.CliCommand;

public class DoneCommandTimetableMode extends CliCommand {

    public static final String COMMAND_WORD = "done";
    public static final boolean isAutoSave = true;

    private AppState appState;
    private String argument;
    private CliMessages messages = new CliMessages();
    private TaskList taskList;

    public DoneCommandTimetableMode(String argument, AppState appState) {
        this.argument = argument;
        this.appState = appState;
        PRINTS_PERSONAL_MESSAGE = true;
    }

    @Override
    public void execute() {
        taskList = appState.getTaskList();
        int numberOfTasks = 0;
        numberOfTasks = taskList.getNumberOfTasks();
        try {
            int indexOfNumberAfterDone = Integer.parseInt(this.argument);
            Task taskDone = this.appState.markTaskAsDone(indexOfNumberAfterDone);
            messages.printMarkDone(taskDone);
        } catch (IndexOutOfBoundsException e) {
            if (numberOfTasks > 0) {
                System.out.println("Please enter a valid index between 1 and " + numberOfTasks + ".");
            } else {
                System.out.println("There are no tasks in the list.");
            }
        } catch (NumberFormatException e) {
            System.out.println("I'm sorry, please enter a valid number!");
        }
    }

    @Override
    public boolean isTriggerAutoSave() {
        return isAutoSave;
    }
}
