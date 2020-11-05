package seedu.duke.userinterface.command.timetable;

import org.junit.jupiter.api.Test;

import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.command.timetable.AddCommandTimetableMode;
import seedu.duke.userinterface.command.timetable.RemoveCommandTimetableMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@@Lusi711
class RemoveTaskTest {
    @Test
    void execute_DeleteTaskOne_NoTasksInTaskList() {
        AppState appState = new AppState();
        TaskList tasksList = appState.getTaskList();

        Task t = new Task("Task 1", "12-10-2020 2252");
        tasksList.addTask(t);

        RemoveCommandTimetableMode r = new RemoveCommandTimetableMode(1,appState);
        r.execute();
        tasksList = appState.getTaskList();

        assertEquals(tasksList.getNumberOfTasks(), 0);
    }
}