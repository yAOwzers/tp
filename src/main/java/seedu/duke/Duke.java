package seedu.duke;

import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.CliUserInterface;

import java.util.Scanner;

public class Duke {
    public static boolean notQuit = true;
    private static final TaskList list = new TaskList();
    private static int numberOfTasks = 0;

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) throws Exception {
        CliUserInterface ui = new CliUserInterface();
        ui.run();
    }
}
