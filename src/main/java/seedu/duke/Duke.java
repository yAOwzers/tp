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
        notebookShelf = new notebookShelf();
    }
    
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) throws Exception {
        new Duke().run();
    }
    
    /**
     * Runs the program until termination
     *
     * @param args arguments supplied by the user at program launch
     */
    public static void run(String[] args) {
        CliUserInterface ui = new CliUserInterface(taskList,notebookShelf);
        Scanner in = new Scanner(System.in);
        ui.startUI();
        while (notQuit) {
            String userInput = in.nextLine();
            try {
                ui.executeCommand(userInput);
            } catch (InvalidCommandException i) {
                System.out.println("\tSorry, I did not get that. ");
            }
        }
    }
}
