package seedu.duke.tasks;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;
    private static int numberOfTasks = 0;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public Task removeTask(int index) {
        Task removedTask = taskList.get(index);
        taskList.remove(removedTask);
        return removedTask;
    }

    public static int getNumberOfTasks() {
        return numberOfTasks;
    }
}
