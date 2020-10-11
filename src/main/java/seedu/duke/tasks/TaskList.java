package seedu.duke.tasks;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskArrayList;

    public TaskList() {
        taskArrayList = new ArrayList<>();
    }

    public void addTask(Task t) {
        taskArrayList.add(t);
        numberOfTasks++;
    }
    
    public Task removeTask(int index) {
        Task removedTask = getTask(index);
        taskArrayList.remove(removedTask);
        return removedTask;
    }

    public int getNumberOfTasks() {
        return taskArrayList.size();
    }

    public Task getTask(int index) {
        try {
            return taskArrayList.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\ttask does not exist");
        }
        return null;
    }
}
