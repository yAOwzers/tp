package zeronote.tasks;

import zeronote.exceptions.TaskIndexOutOfBoundsException;
import zeronote.exceptions.ZeroNoteException;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> taskArrayList;

    public TaskList() {
        taskArrayList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskArrayList.add(task);
    }

    public Task removeTask(int indexToRemove) throws IndexOutOfBoundsException {
        Task removedTask = taskArrayList.remove(indexToRemove);
        return removedTask;
    }

    public int getNumberOfTasks() {
        return taskArrayList.size();
    }

    public Task getTask(int index) throws ZeroNoteException {
        if (index > taskArrayList.size()) {
            throw new TaskIndexOutOfBoundsException(String.valueOf(index));
        }
        return taskArrayList.get(index);
    }

    public Task markAsDone(int i) throws ZeroNoteException{
        if (i > taskArrayList.size()) {
            throw new TaskIndexOutOfBoundsException(String.valueOf(i));
        }
        Task task = this.taskArrayList.get(i - 1);
        task.markAsDone();
        return task;
    }

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public String serialize() {
        StringBuilder serialized = new StringBuilder();
        String lineSeparator = System.lineSeparator();
        serialized.append(getNumberOfTasks());
        serialized.append(lineSeparator);
        for (Task t : taskArrayList) {
            serialized.append(t.serialize());
        }
        return serialized.toString();
    }
}
