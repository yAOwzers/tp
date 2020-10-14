package seedu.duke.exceptions;

/**
 * Signals that the user has input the date/time wrongly.
 */
public class IncorrectDeadlineFormatException extends ZeroNoteException {
    @Override
    public void printErrorMessage() {
        System.out.println("You have entered the date and time wrongly. ");
    }
}
