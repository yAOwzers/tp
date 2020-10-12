package seedu.duke;

import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.CliUserInterface;

import java.util.Scanner;

public class Duke {
    private static boolean notQuit = true;
    protected TaskList taskList;
    protected NotebookShelf notebookShelf;
    
    public Duke() {
        taskList = new TaskList();
        notebookShelf = new NotebookShelf();
    }
    
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) throws Exception {
        CliUserInterface ui = new CliUserInterface();
        ui.run();
    }
}
