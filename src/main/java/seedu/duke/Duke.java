package seedu.duke;

import seedu.duke.userinterface.CliUserInterface;

public class Duke {

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) throws Exception {
        CliUserInterface ui = new CliUserInterface();
        ui.run();
    }
}
