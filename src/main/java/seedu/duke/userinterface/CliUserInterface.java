package seedu.duke.userinterface;

import seedu.duke.exceptions.CorruptFileException;
import seedu.duke.exceptions.ZeroNoteException;
import seedu.duke.storage.Storage;
import seedu.duke.userinterface.command.CliCommand;
import seedu.duke.userinterface.command.Exit;

import java.util.Scanner;

public class CliUserInterface {
    private AppState appState;

    private boolean toQuit = false;
    private PersonalMesssageGenerator msgGenerator;

    public CliUserInterface() {
        msgGenerator = new PersonalMesssageGenerator();
    }

    private void loadState() throws CorruptFileException {
        Storage storage = new Storage();
        appState = storage.readFromFile();
    }

    private void saveState() throws ZeroNoteException {
        Storage storage = new Storage();
        storage.saveToFile(appState);
    }


    public void run() {
        try {
            loadState();
        } catch (CorruptFileException e) {
            e.printErrorMessage();
        }
        startUI();
        String userInput;
        Scanner keyboard = new Scanner(System.in);
        while (!toQuit) {
            userInput = keyboard.nextLine();
            try {
                if (userInput.equals(Exit.COMMAND_WORD)) {
                    saveState();
                    toQuit = true;
                }
                executeCommand(userInput);
            } catch (ZeroNoteException e) {
                e.printErrorMessage();
            }
        }
    }

    private void executeCommand(String userInput) throws ZeroNoteException {
        InputParser parser = new InputParser();
        CliCommand command = parser.getCommandFromInput(userInput, appState);
        command.execute();
    }

    private void startUI() {
        System.out.println("Welcome to");
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
