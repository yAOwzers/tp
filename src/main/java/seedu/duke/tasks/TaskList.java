package seedu.duke.tasks;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskArrayList;

    public TaskList() {
        taskArrayList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskArrayList.add(task);
    }

    public Task removeTask(int indexToRemove) throws IndexOutOfBoundsException {
        Task removedTask = taskArrayList.get(indexToRemove);
        taskArrayList.remove(indexToRemove);
        return removedTask;
    }

    public int getNumberOfTasks() {
        return taskArrayList.size();
    }

    public Task getTask(int index) throws IndexOutOfBoundsException{
        return taskArrayList.get(index);
    }

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }
}
