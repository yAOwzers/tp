package seedu.duke.tasks;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskArrayList;
    private static int numberOfTasks = 0;

    public TaskList(){
        taskArrayList = new ArrayList<>();
    }

    public void addTask(Task t) {
        taskArrayList.add(t);
        numberOfTasks++;
    }

    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    @Override
    public String toString() {
        return "[" + numberOfTasks + "]" + super.toString();
    }
}
