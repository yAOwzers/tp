package seedu.duke.userinterface;


import seedu.duke.exceptions.ZeroNoteException;

import seedu.duke.storage.Storage;
import seedu.duke.userinterface.command.CliCommand;
import seedu.duke.userinterface.command.Exit;

import java.util.Scanner;

public class CliUserInterface {
    private AppState appState;

    private boolean toQuit = false;

    // TODO change the filepath to an appropriate one
    private static final String filepath = "data/data.txt";

    public CliUserInterface() {

    }

    // TODO change
    private void loadState() {
        Storage storage = new Storage(this.filepath);
        appState = storage.readFromFile();
    }

    // TODO change
    private void saveState() {
        Storage storage = new Storage(this.filepath);
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
                saveState(); // TODO change saveState at every command
                toQuit = true;
            }
            try {
                executeCommand(userInput);
            } catch (ZeroNoteException e) {
                e.printErrorMessage();
            } catch (Exception e) {
                // TODO: Make sure all Java exceptions are handled and converted to ZeroNoteExceptions
                // TODO: Delete this block after the above is done
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
        System.out.println("You are now in timetable mode");
        // TODO: Make this prettier
    }



    public String printExit() {
        return "GOODBYE HOPE TO SEE YOU AGAIN";
    }

}
