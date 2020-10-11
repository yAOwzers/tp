package seedu.duke.tasks;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskArrayList;
    private static int numberOfTasks = 0;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public Task removeTask(int index) {
        Task removedTask = taskArrayList.get(index);
        taskArrayList.remove(removedTask);
        return removedTask;
    }

    public static int getNumberOfTasks() {
        return numberOfTasks;
    }
}
