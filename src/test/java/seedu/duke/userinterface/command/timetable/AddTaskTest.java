package seedu.duke.userinterface.command.timetable;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.IncorrectDeadlineFormatException;
import seedu.duke.exceptions.TaskWrongFormatException;
import seedu.duke.userinterface.InputParser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void addTask_correctFormat() throws TaskWrongFormatException, IncorrectDeadlineFormatException {
        InputParser parser = new InputParser();
        String inputString = "/by18-10-2020 1900";
        String expectedString = "18-10-2020 1900";
        assertEquals(expectedString, parser.parseDeadline(inputString));
    }
}

