package seedu.duke.exceptions;

/**
 * Signals that the user has input an invalid command.
 */
public class InvalidCommandException extends ZeroNoteException {
    public InvalidCommandException(String command) {
        super("UHHH your " + command + " is not valid...");
    }
}
