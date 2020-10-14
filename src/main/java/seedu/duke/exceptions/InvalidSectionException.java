package seedu.duke.exceptions;

/**
 * Signals that the user has input an invalid section name.
 */
public class InvalidSectionException extends ZeroNoteException {
    @Override
    public void printErrorMessage() {
        System.out.println("Invalid Section Name " + problematicInput);
    }
}
