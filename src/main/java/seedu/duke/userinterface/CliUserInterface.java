package seedu.duke.userinterface;

import seedu.duke.exceptions.InvalidUserInputException;
import seedu.duke.exceptions.ZeroNoteException;
import seedu.duke.storage.Storage;
import seedu.duke.userinterface.command.CliCommand;
import seedu.duke.userinterface.command.Exit;

import java.util.Scanner;

public class CliUserInterface {
    private AppState appState;
    private Storage storage;
    private CliMessages messages;
    private InputParser parser;

    private boolean toQuit = false;

    public CliUserInterface() {
        this.messages = new CliMessages();
        this.storage = new Storage();
        this.appState = new AppState(this.storage);
        this.parser = new InputParser(this.storage, this.appState);
    }

    /**
     * Initialises Zer0Note.
     *
     * @return welcome message.
     */
    private void startUI() {
        try {
            this.appState.loadState();
        } catch (InvalidUserInputException e) {
            System.out.println(this.messages.printZer0NoteError(e));
        }
            System.out.println("Welcome to");
            System.out.println(" _ _ _                  _ _ _   _    _            _");
            System.out.println("|_ _  |   _ _    _  _  |  _  | |  \\ | |   _ _   _| |_    _ _");
            System.out.println("  /  /  /  _  \\ | |/_\\ | | | | |   \\| |  /   \\ |_   _| /   _ \\");
            System.out.println(" /  /_  |  _ _/ | |    | |_| | |  |\\  | |  [] |  | |_  |  _ _/");
            System.out.println("|_ _ _|  \\ _ _| |_|    |_ _ _| | _| \\_|  \\ _ /   |_ _|  \\ _ _|");
            System.out.println("You are now in timetable mode");
        }


    public void run() {
        startUI();
        String userInput;
        Scanner keyboard = new Scanner(System.in);
        while (!toQuit) {
            userInput = keyboard.nextLine();
            if (userInput.equals(Exit.COMMAND_WORD)) {
                System.out.println(printExit());
                toQuit = true;
            }
            try {
                executeCommand(userInput);
            } catch (ZeroNoteException e) {
                e.printErrorMessage();
            }
        }
    }

    private void executeCommand(String userInput) throws ZeroNoteException {
        CliCommand command = this.parser.getCommandFromInput(userInput, this.appState, this.storage);
        command.execute();
    }

    public String printExit() {
        return "GOODBYE HOPE TO SEE YOU AGAIN";
    }

}
