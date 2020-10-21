package seedu.duke.userinterface.command;

import org.junit.jupiter.api.Test;
import seedu.duke.storage.Storage;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.command.timetable.AddCommandTimetableMode;
import seedu.duke.userinterface.command.timetable.RemoveCommandTimetableMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveTaskTest {
    @Test
    void execute_DeleteTaskOne_NoTasksInTaskList() {
        TaskList taskslist = new TaskList();
        AppState appState = new AppState();
        Storage storage = new Storage();

        String input = "add /tTask1 /by12-10-2020 2252";
        AddCommandTimetableMode addTimetableMode = new AddCommandTimetableMode(input, appState, storage);
        addTimetableMode.execute();

        RemoveCommandTimetableMode removeTimetableMode = new RemoveCommandTimetableMode(1, appState, storage);
        removeTimetableMode.execute();

        assertEquals(taskslist.getNumberOfTasks(), 0);
    }
}