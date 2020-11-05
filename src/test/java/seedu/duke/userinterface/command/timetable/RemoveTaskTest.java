package seedu.duke.userinterface.command.timetable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;

//@@Lusi711
class RemoveTaskTest {
    @Test
    void execute_DeleteTaskOne_NoTasksInTaskList() {
        TaskList tasksList = new TaskList();
        Task t = new Task("Task 1", "12-10-2020 2252");
        tasksList.addTask(t);
        AppState appState = new AppState();
        appState.setTaskList(tasksList);

        RemoveCommandTimetableMode r = new RemoveCommandTimetableMode(0, appState);
        r.execute();

        assertEquals(0, appState.getTaskList().getNumberOfTasks());
    }

    @Test
    void execute_InvalidTaskNumber_NoTasksInTaskList() {
        TaskList tasksList = new TaskList();
        Task t = new Task("Task 1", "12-10-2020 2252");
        tasksList.addTask(t);
        AppState appState = new AppState();
        appState.setTaskList(tasksList);

        RemoveCommandTimetableMode r = new RemoveCommandTimetableMode(-1, appState);
        r.execute();

        assertEquals(1, appState.getTaskList().getNumberOfTasks());
    }
}