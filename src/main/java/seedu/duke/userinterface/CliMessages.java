package seedu.duke.userinterface;

import seedu.duke.tasks.TaskList;

public class CliMessages {
    public static void printAddedTaskMessage(String title) {
        System.out.println("Added task:" + title);
        System.out.println(TaskList.getNumberOfTasks() + ": " + title);
    }
}
