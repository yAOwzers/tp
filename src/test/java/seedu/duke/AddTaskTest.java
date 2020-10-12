package seedu.duke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.IncorrectDeadlineFormatException;
import seedu.duke.exceptions.TaskWrongFormatException;
import seedu.duke.userinterface.InputParser;

import static org.junit.jupiter.api.Assertions.*;

public class AddTaskTest {
    @Test
    void addTask_dateFormat_expectException() throws IncorrectDeadlineFormatException {
        InputParser parser = new InputParser();
        String inputString = "/by18 Oct";
        Assertions.assertThrows(IncorrectDeadlineFormatException.class, () -> {
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

