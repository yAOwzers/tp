package seedu.duke.userinterface;


import seedu.duke.exceptions.ZeroNoteException;

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
        System.out.println(" _ _ _                  _ _ _   _    _            _");
        System.out.println("|_ _  |   _ _    _  _  |  _  | |  \\ | |   _ _   _| |_    _ _");
        System.out.println("  /  /  /  _  \\ | |/_\\ | | | | |   \\| |  /   \\ |_   _| /   _ \\");
        System.out.println(" /  /_  |  _ _/ | |    | |_| | |  |\\  | |  [] |  | |_  |  _ _/");
        System.out.println("|_ _ _|  \\ _ _| |_|    |_ _ _| | _| \\_|  \\ _ /   |_ _|  \\ _ _|");
        System.out.println("You are now in timetable mode");
    }

    public String printExit() {
        return "GOODBYE HOPE TO SEE YOU AGAIN";
    }

}
