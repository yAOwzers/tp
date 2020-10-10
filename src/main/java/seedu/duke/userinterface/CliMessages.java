package seedu.duke.userinterface;

import seedu.duke.tasks.TaskList;

public class CliMessages {
    public static void printAddedTaskMessage(TaskList taskList, String title) {
        System.out.println("Added:" + title);
        System.out.println(taskList.getNumberOfTasks() + ":" + taskList.getTask(taskList.getNumberOfTasks()- 1));
    }
}
