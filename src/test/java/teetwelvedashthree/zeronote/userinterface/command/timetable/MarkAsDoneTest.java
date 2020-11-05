package teetwelvedashthree.zeronote.userinterface.command.timetable;

import org.junit.jupiter.api.Test;
import teetwelvedashthree.zeronote.tasks.TaskList;
import teetwelvedashthree.zeronote.userinterface.AppState;
import teetwelvedashthree.zeronote.userinterface.command.timetable.AddCommandTimetableMode;
import teetwelvedashthree.zeronote.userinterface.command.timetable.DoneCommandTimetableMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@@yAOwzers
public class MarkAsDoneTest {
    @Test
    void execute_MarkAsDoneTwo_IndexOutOfBound() {
        AppState appState = new AppState();

        String input = "add /tTask1 /by12-10-2020 2252";
        AddCommandTimetableMode addTimetableMode = new AddCommandTimetableMode(input, appState);
        addTimetableMode.execute();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            appState.getTaskList().markAsDone(2);
        });
    }
}
