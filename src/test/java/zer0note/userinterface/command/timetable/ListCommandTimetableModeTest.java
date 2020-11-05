package teetwelvedashthree.zeronote.userinterface.command.timetable;

import org.junit.jupiter.api.Test;
import teetwelvedashthree.zeronote.exceptions.InvalidCommandException;
import teetwelvedashthree.zeronote.userinterface.AppState;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//@@longngng
class ListCommandTimetableModeTest {

    @Test
    void execute_invalidInput_exceptionThrown() {
        AppState appState = new AppState();
        String input = "list /d";

        ListCommandTimetableMode listCommandTimetableMode = new ListCommandTimetableMode(input, appState);
        try {
            listCommandTimetableMode.execute();
            fail();
        } catch (InvalidCommandException e) {
            assertEquals("There not exists such options", e.problematicInput);
        }
    }
}