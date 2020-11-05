package zeronote.userinterface.command.timetable;

import org.junit.jupiter.api.Test;
import zeronote.userinterface.AppState;

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
