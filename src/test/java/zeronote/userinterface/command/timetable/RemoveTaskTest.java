package zer0note.userinterface.command.timetable;

import org.junit.jupiter.api.Test;
import zer0note.tasks.TaskList;
import zer0note.userinterface.AppState;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@@Lusi711
class RemoveTaskTest {
    @Test
    void execute_DeleteTaskOne_NoTasksInTaskList() {
        TaskList taskslist = new TaskList();
        AppState appState = new AppState();

        String input = "add /tTask1 /by12-10-2020 2252";
        AddCommandTimetableMode addTimetableMode = new AddCommandTimetableMode(input,appState);
        addTimetableMode.execute();

        RemoveCommandTimetableMode removeTimetableMode = new RemoveCommandTimetableMode(1,appState);
        removeTimetableMode.execute();

        assertEquals(taskslist.getNumberOfTasks(), 0);
    }
}