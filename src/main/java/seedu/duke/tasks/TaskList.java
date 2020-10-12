package seedu.duke.tasks;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskArrayList;
    private int numberOfTasks = 0;

    public TaskList() {
        taskArrayList = new ArrayList<>();
    }

    public void addTask(Task t) {
        taskArrayList.add(t);
        numberOfTasks++;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public Task getTask(int index) {
        try {
            return taskArrayList.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\ttask does not exist");
        }
        return null;
    }

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }
}
