package zeronote.userinterface.command.timetable;

import org.junit.jupiter.api.Test;
import zeronote.tasks.TaskList;
import zeronote.userinterface.AppState;

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