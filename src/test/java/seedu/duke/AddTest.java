package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.IncorrectDeadlineFormatException;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.CliUserInterface;

import static org.junit.jupiter.api.Assertions.*;
/*
public class AddTest {
    @Test
    void addTask_dateFormat_expectException() throws IncorrectDeadlineFormatException {
        TaskList list = new TaskList();
        CliUserInterface ui = new CliUserInterface();
        String inputString = "add /tplay game /by18 Oct";
        try {
            ui.executeCommand(inputString);
        } catch (InvalidCommandException i) {
            System.out.println("invalid command");
        }
        assertEquals(list.getNumberOfTasks(), 0);
    }

    @Test
    void addTask_correctFormat() {
        TaskList list = new TaskList();
        CliUserInterface ui = new CliUserInterface();
        String inputString = "add /tplay game /by18-10-2020 1900";
        try {
            ui.executeCommand(inputString);
        } catch (InvalidCommandException i) {
            System.out.println("invalid command");
        }
        assertEquals(list.getNumberOfTasks(), 1);
    }
}
*/
