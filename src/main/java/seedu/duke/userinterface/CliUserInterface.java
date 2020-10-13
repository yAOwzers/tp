package seedu.duke.userinterface;

import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.command.Add;
import seedu.duke.storage.Storage;
import seedu.duke.userinterface.command.CliCommand;
import seedu.duke.userinterface.command.Exit;

import java.util.Scanner;

public class CliUserInterface {
    private AppState appState;

    private boolean toQuit = false;

    public CliUserInterface() {

    }

    private void loadState() {
        Storage storage = new Storage();
        appState = storage.readFromFile();
    }

    private void saveState() {
        Storage storage = new Storage();
        storage.saveToFile(appState);
    }


    public void run() {
        startUI();
        loadState();
        String userInput;
        Scanner keyboard = new Scanner(System.in);
        while (!toQuit) {
            userInput = keyboard.nextLine();
            if (userInput.equals(Exit.COMMAND_WORD)) {
                saveState();
                toQuit = true;
            }
            try {
                executeCommand(userInput);
            } catch (Exception e) {
                // TODO: actually make exceptions that make sense
                e.printStackTrace();
            }
        }
    }

    private void executeCommand(String userInput) throws Exception {
        InputParser parser = new InputParser();
        CliCommand command = parser.getCommandFromInput(userInput, appState);
        command.execute();
    }

    private void startUI() {
        System.out.println("Welcome to Zer0Note!");
        // TODO: Make this prettier
    }



    public String printExit() {
        return "GOODBYE HOPE TO SEE YOU AGAIN";
    }

}
