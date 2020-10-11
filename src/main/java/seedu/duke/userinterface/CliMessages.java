package seedu.duke.userinterface;

import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;

public class CliMessages {
    private static final String REMOVE_TASK_SUCCESS_MESSAGE = "Noted. I've removed this task:";

    public static void printRemoveTaskMessage(Task deletedTask, int numberOfTasks) {
        System.out.println(REMOVE_TASK_SUCCESS_MESSAGE);
        System.out.println(deletedTask.toString());
        if (numberOfTasks == 1) {
            System.out.println("\tNow you have " + (numberOfTasks - 1) + " task in the list.");
        } else {
            System.out.println("\tNow you have " + (numberOfTasks - 1) + " tasks in the list.");
        }
    }
    
    public static void printAddedTaskMessage(TaskList taskList, String title) {
        System.out.println("Added: " + title);
        System.out.println(taskList.getNumberOfTasks() + ":" + taskList.getTask(taskList.getNumberOfTasks() - 1));
    }
}
