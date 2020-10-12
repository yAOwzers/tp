package seedu.duke.exceptions;

/**
 * Signals that the user has input the date/time wrongly.
 */
public class IncorrectDeadlineFormatException extends ZeroNoteException {
    public IncorrectDeadlineFormatException() {
        super("There is an error in your formatting!");
    }
}
