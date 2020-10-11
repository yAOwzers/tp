package seedu.duke.userinterface.command;

import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.InputParser;
import seedu.duke.userinterface.Mode;

public class Remove extends CliCommand {

    public static final String COMMAND_WORD = "delete";

    private TaskList taskList;
    private NotebookShelf notebookShelf;

    public Remove(TaskList taskList, NotebookShelf notebookShelf, String input) {
        this.taskList = taskList;
        this.notebookShelf = notebookShelf;
        this.commandParams = input;
    }

    @Override
    public void execute() {
        InputParser parser = new InputParser();
        if (this.uiMode == Mode.TIMETABLE) {
            try {
                int index = parser.parseTaskIndex(commandParams);
                removeTaskFromTaskList(index);
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a valid number.");
            }
        } else {
            removeFromNotebook();
        }
    }

    private void removeFromNotebook() {
    }

    private void removeTaskFromTaskList(int index) {
        try {
            Task deletedTask = taskList.removeTask(index);
            int numberOfTasks = taskList.getNumberOfTasks();
            CliMessages.printRemoveTaskMessage(deletedTask, numberOfTasks);
        } catch (IndexOutOfBoundsException ioe) {
            int numberOfTasks = taskList.getNumberOfTasks();
            if (numberOfTasks > 0) {
                System.out.println("Please enter a valid index between 1 and " + numberOfTasks + ".");
            } else {
                System.out.println("There are no tasks in the list.");
            }
        }
    }
}
