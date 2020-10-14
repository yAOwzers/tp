package seedu.duke.exceptions;

/**
 * Signals that the user has input an invalid notebook name.
 */
public class InvalidNotebookException extends ZeroNoteException {
    @Override
    public void printErrorMessage() {
        System.out.println("You have entered an invalid notebook name " + problematicInput);
    }
}
