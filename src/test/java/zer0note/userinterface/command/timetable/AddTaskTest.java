package zer0note.userinterface.command.timetable;

import org.junit.jupiter.api.Test;
import zer0note.exceptions.IncorrectDeadlineFormatException;
import zer0note.exceptions.ZeroNoteException;
import zer0note.userinterface.InputParser;

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
    void addTask_correctFormat() throws IncorrectDeadlineFormatException {
        InputParser parser = new InputParser();
        String inputString = "/by18-10-2020 1900";
        String expectedString = "18-10-2020 1900";
        assertEquals(expectedString, parser.parseDeadline(inputString));
    }

    @Test
    void addTask_emptyTask_expectException() {
        InputParser parser = new InputParser();
        String inputString = "add /t /by18-10-2020 1900";
        assertThrows(ZeroNoteException.class, () -> {
            parser.parseTaskTitle(inputString);
        });
    }

    @Test
    void addTask_emptyEverything_expectException() {
        InputParser parser = new InputParser();
        String inputString = "add /t /by";
        assertThrows(ZeroNoteException.class, () -> {
            parser.parseTaskTitle(inputString);
        });
    }
}

