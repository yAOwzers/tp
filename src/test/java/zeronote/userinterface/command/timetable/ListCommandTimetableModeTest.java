package zeronote.userinterface.command.timetable;

import org.junit.jupiter.api.Test;
import zeronote.exceptions.InvalidCommandException;
import zeronote.userinterface.AppState;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ListCommandTimetableModeTest {

    @Test
    void execute_invalidInput_exceptionThrown() {
        AppState appState = new AppState();
        String input = "/u/u";

        ListCommandTimetableMode listCommandTimetableMode = new ListCommandTimetableMode(input, appState);
        try {
            listCommandTimetableMode.execute();
            fail();
        } catch (InvalidCommandException e) {
            assertEquals("There not exists such options", e.problematicInput);
        }
    }
}