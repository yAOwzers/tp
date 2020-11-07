package zeronote.userinterface.command.timetable;

import org.junit.jupiter.api.Test;
import zeronote.exceptions.IncorrectDeadlineFormatException;
import zeronote.exceptions.ZeroNoteException;
import zeronote.userinterface.AppMode;
import zeronote.userinterface.AppState;
import zeronote.userinterface.InputParser;
import zeronote.userinterface.command.CliCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@@chuckiex3
public class AddTaskTest {
    @Test
    void addTask_dateFormat_expectException() {
        InputParser parser = new InputParser();
        String inputString = "/by18 Oct";
        assertThrows(IncorrectDeadlineFormatException.class, () -> {
            parser.parseDeadline(inputString);
        });
    }

    @Test
    void addTask_date_correctFormat() throws IncorrectDeadlineFormatException {
        InputParser parser = new InputParser();
        String inputString = "/by18-10-2020 1900";
        String expectedString = "18-10-2020 1900";
        assertEquals(expectedString, parser.parseDeadline(inputString));
    }

    @Test
    void addTask_emptyTask_expectException() throws ZeroNoteException {
        InputParser parser = new InputParser();
        AppState appState = new AppState();
        appState.setAppMode(AppMode.TIMETABLE);
        String inputString = "add /t /by18-10-2020 1900";
        String argument = "/t /by18-10-2020 1900";
        CliCommand command  = parser.getCommandFromInput(inputString, appState);
        command.execute();
        assertThrows(ZeroNoteException.class, () -> {
            parser.parseTaskTitle(argument);
        });
    }

    @Test
    void addTask_emptyEverything_expectException() throws ZeroNoteException {
        InputParser parser = new InputParser();
        AppState appState = new AppState();
        appState.setAppMode(AppMode.TIMETABLE);
        String inputString = "add /t /by";
        String argument = "/t /by";
        CliCommand command  = parser.getCommandFromInput(inputString, appState);
        command.execute();
        assertThrows(ZeroNoteException.class, () -> {
            parser.parseTaskTitle(argument);
        });
    }
}

