package seedu.duke.exceptions;

/**
 * Signals that the user has input an invalid page name.
 */
public class InvalidPageException extends ZeroNoteException {
    @Override
    public void printErrorMessage() {
        System.out.println("Entered invalid page name " + problematicInput);
    }
}
