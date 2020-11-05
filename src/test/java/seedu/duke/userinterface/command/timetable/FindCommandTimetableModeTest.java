package teetwelvedashthree.zeronote.userinterface.command.timetable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import teetwelvedashthree.zeronote.exceptions.InvalidTagException;
import teetwelvedashthree.zeronote.tasks.Task;
import teetwelvedashthree.zeronote.userinterface.AppState;

class FindCommandTimetableModeTest {

    @Test
    void execute_keywordInput_noneFound() {
        AppState appState = new AppState();
        String input = "add /tTask 1 /by12-10-2020 2252";
        AddCommandTimetableMode a = new AddCommandTimetableMode(input, appState);
        a.execute();

        FindCommandTimetableMode f = new FindCommandTimetableMode("test", "", appState);
        f.execute();
        assertEquals(f.getTasksFound().size(), 0);
    }

    @Test
    void execute_keywordInput_taskFound() {
        AppState appState = new AppState();
        Task t = new Task("Task 1", "03-11-2020 1112");
        appState.getTaskList().addTask(t);

        FindCommandTimetableMode f = new FindCommandTimetableMode("task", "", appState);
        f.execute();
        assertEquals(f.getTasksFound().size(), 1);
    }

    @Test
    void execute_tagInput_noneFound() {
        AppState appState = new AppState();
        Task t = new Task("Task 1", "03-11-2020 1112");
        try {
            t.setTag("test");
        } catch (InvalidTagException ite) {
            ite.printErrorMessage();
        }
        appState.getTaskList().addTask(t);

        FindCommandTimetableMode f = new FindCommandTimetableMode("", "task", appState);
        f.execute();
        assertEquals(f.getTasksFound().size(), 0);
    }

    @Test
    void execute_tagInput_taskFound() {
        AppState appState = new AppState();
        Task t = new Task("Task 1", "03-11-2020 1112");
        try {
            t.setTag("test");
        } catch (InvalidTagException ite) {
            ite.printErrorMessage();
        }
        appState.getTaskList().addTask(t);

        FindCommandTimetableMode f = new FindCommandTimetableMode("", "test", appState);
        f.execute();
        assertEquals(f.getTasksFound().size(), 1);
    }

    @Test
    void isPersonalised_noInput_ReturnsTrue() {
        AppState appState = new AppState();
        FindCommandTimetableMode f = new FindCommandTimetableMode("", "", appState);
        assertTrue(f.isPersonalised());
    }
}