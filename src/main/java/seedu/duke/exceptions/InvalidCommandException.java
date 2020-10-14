package seedu.duke.exceptions;

/**
 * Signals that the user has input an invalid command.
 */
public class InvalidCommandException extends ZeroNoteException {
    @Override
    public void printErrorMessage() {
        System.out.println("You have entered an invalid command" + problematicInput);
    }
}
