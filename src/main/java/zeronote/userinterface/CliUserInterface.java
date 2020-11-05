package zeronote.userinterface;

import zeronote.exceptions.CorruptFileException;
import zeronote.exceptions.ZeroNoteException;
import zeronote.storage.Storage;
import zeronote.userinterface.command.CliCommand;
import zeronote.userinterface.command.Exit;

import java.util.Scanner;

public class CliUserInterface {
    private AppState appState;

    private boolean toQuit = false;
    private PersonalMessageGenerator msgGenerator;
    private CliMessages messages;
    private Scanner keyboardScanner;

    public CliUserInterface() {
        messages = new CliMessages();
        keyboardScanner = new Scanner(System.in);
    }

    private void loadState() throws CorruptFileException {
        Storage storage = new Storage();
        appState = storage.readFromFile();
    }

    private void saveState() throws ZeroNoteException {
        Storage storage = new Storage();
        storage.saveToFile(appState);
    }

    private void printPrompt() {

    }

    private void checkNameOfUser() {
        if (appState.getUserName().equals("")) {
            messages.printFillInNameOfUserMessage();
            String userName = keyboardScanner.nextLine();
            appState.setUserName(userName);
            msgGenerator = new PersonalMessageGenerator(userName);
            msgGenerator.greetUser();
        }
    }


    public void run() {
        try {
            loadState();
        } catch (CorruptFileException e) {
            e.printErrorMessage();
        }
        startUI();
        String userInput;
        checkNameOfUser();
        msgGenerator = new PersonalMessageGenerator(appState.getUserName());
        while (!toQuit) {
            printPrompt();
            userInput = keyboardScanner.nextLine();
            try {
                if (userInput.equals(Exit.COMMAND_WORD)) {
                    toQuit = true;
                }
                messages.printLineSeparator();
                executeCommand(userInput);
                messages.printLineSeparator();
            } catch (ZeroNoteException e) {
                e.printErrorMessage();
                messages.printLineSeparator();
            }
        }
    }

    private void executeCommand(String userInput) throws ZeroNoteException {
        InputParser parser = new InputParser();
        CliCommand command = parser.getCommandFromInput(userInput, appState);
        command.execute();
        messages.printLineSeparator();
        if (command.printsPersonalMessage()) {
            String message = msgGenerator.generatePersonalisedMessage();
            System.out.println(message);
        }
        if (command.isTriggerAutoSave()) {
            saveState();
        }
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
