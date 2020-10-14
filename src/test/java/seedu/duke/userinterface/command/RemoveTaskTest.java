package seedu.duke.userinterface.command;

import org.junit.jupiter.api.Test;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.command.timetable.AddTimetableMode;
import seedu.duke.userinterface.command.timetable.RemoveTimetableMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveTaskTest {
    @Test
    void execute_DeleteTaskOne_NoTasksInTaskList() {
        TaskList taskslist = new TaskList();
        AppState appState = new AppState();

        String input = "add /tTask1 /by12-10-2020 2252";
        AddTimetableMode addTimetableMode = new AddTimetableMode(input,appState);
        addTimetableMode.execute();

        RemoveTimetableMode removeTimetableMode = new RemoveTimetableMode(1,appState);
        removeTimetableMode.execute();

        assertEquals(taskslist.getNumberOfTasks(), 0);
    }
}