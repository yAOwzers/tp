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

    /**
     * Deletes a task with the specified index from this TaskList.
     *
     * @param index the index of the task to be deleted.
     * @return the task that is deleted.
     * @throws IndexOutOfBoundsException when the index is out of the bounds of the TaskList
     */
    public Task removeTask(int index) throws IndexOutOfBoundsException {
        return taskArrayList.remove(index);
    }

    public int getNumberOfTasks() {
        return taskArrayList.size();
    }

    public Task getTask(int index) throws TaskIndexOutOfBoundsException {
        if (index > taskArrayList.size()) {
            throw new TaskIndexOutOfBoundsException(String.valueOf(index));
        }
        return taskArrayList.get(index);
    }

    public Task markAsDone(int i) throws ZeroNoteException {
        if (i > taskArrayList.size()) {
            throw new TaskIndexOutOfBoundsException(String.valueOf(taskArrayList.size()));
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
