package seedu.duke.tasks;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskArrayList;

    public TaskList() {
        taskArrayList = new ArrayList<>();
    }

    public void addTask(Task t) {
        taskArrayList.add(t);
    }

    public int getNumberOfTasks() {
        return this.taskArrayList.size();
    }

    public Task getTask(int index) {
        try {
            return taskArrayList.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\ttask does not exist");
        }
        return null;
    }

    public Task markAsDone(int i) {
        Task task = this.taskArrayList.get(i - 1);
        task.markAsDone();
        return task;
    }

    public ArrayList<Task> getTaskList() {
        return this.taskArrayList;
    }


}
