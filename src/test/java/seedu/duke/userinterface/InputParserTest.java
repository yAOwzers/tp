package seedu.duke.userinterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}