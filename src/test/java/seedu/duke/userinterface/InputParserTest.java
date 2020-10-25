package seedu.duke.userinterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.IncorrectDeadlineFormatException;
import seedu.duke.exceptions.TaskWrongFormatException;
import seedu.duke.exceptions.ZeroNoteException;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class InputParserTest {
    @Test
    void parseTaskIndex_validNumber_success() {
        InputParser parser = new InputParser();
        String num = "2";
        assertEquals(1,parser.parseTaskIndex(num));
    }

    @Test
    void parseTaskIndex_InvalidString_numberFormatExceptionThrown() {
        InputParser parser = new InputParser();
        String num = "num";
        Assertions.assertThrows(NumberFormatException.class, () -> {
            parser.parseTaskIndex(num);
        });
    }

    @Test
    void parseTaskTitle_correctFormat() {
        InputParser parser = new InputParser();
        String input = "/tBlowing Bubbles /by2020-10-10";
        try {
            assertEquals("Blowing Bubbles", parser.parseTaskTitle(input));
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    void parseTaskTitle_withSpaces() {
        InputParser parser = new InputParser();
        String input = "/t Blowing Bubbles /by 2020-10-10";
        try {
            assertEquals("Blowing Bubbles", parser.parseTaskTitle(input));
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    void parseTaskTitle_noDate() {
        InputParser parser = new InputParser();
        String input = "/t Blowing Bubbles";
        assertThrows(ZeroNoteException.class, () -> {
            String output = parser.parseTaskTitle(input);
        });
    }

    @Test
    void parseDeadline_validFormat() {
        InputParser parser = new InputParser();
        String input = "/tBlowing Bubbles /by10-10-2020 1000";
        try {
            assertEquals("10-10-2020 1000", parser.parseDeadline(input));
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    void parseDeadline_validFormatWithSpaces() {
        InputParser parser = new InputParser();
        String input = "/t Blowing Bubbles /by 10-10-2020 1000";
        try {
            assertEquals("10-10-2020 1000", parser.parseDeadline(input));
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    void parseDeadline_invalidFormat() {
        InputParser parser = new InputParser();
        String input = "/tBlowing Bubbles /by 2020-10-10 12";
        assertThrows(IncorrectDeadlineFormatException.class, () -> parser.parseDeadline(input));
    }

    @Test
    void parseDeadline_noDate() {
        InputParser parser = new InputParser();
        String input = "/tBlowing Bubbles";
        assertThrows(IncorrectDeadlineFormatException.class, () -> parser.parseDeadline(input));
    }

    @Test
    void parseDeadline_blankDate() {
        InputParser parser = new InputParser();
        String input = "/tBlowing Bubbles /by";
        assertThrows(IncorrectDeadlineFormatException.class, () -> parser.parseDeadline(input));
    }
}