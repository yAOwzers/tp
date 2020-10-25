package seedu.duke.exceptions;

//@@chuckiex3

/**
 * Signals that the user has input a notebook that does not exist.
 */
public class NotebookOutOfBoundsException extends ZeroNoteException {
    public NotebookOutOfBoundsException(int input) {
        this.problematicInput = Integer.toString(input);
    }

    @Override
    public void printErrorMessage() {
        System.out.println("Notebook at index: " + problematicInput + "does not exist.");
    }
}
