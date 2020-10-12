package seedu.duke.userinterface.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveTaskTest {
    @Test
    void execute_DeleteTaskOne_NoTasksInTaskList() {
        TaskList taskslist = new TaskList();
        AppState appState = new AppState();

        String input = "add /tTask1 /by12-10-2020 2252";
        Add add = new Add(input,appState);
        add.execute();

        RemoveTask remove = new RemoveTask(1,appState);
        remove.execute();

        assertEquals(taskslist.getNumberOfTasks(), 0);
    }
}