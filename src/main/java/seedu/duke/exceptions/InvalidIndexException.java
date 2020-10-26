package seedu.duke.exceptions;

public class InvalidIndexException extends ZeroNoteException {
    public InvalidIndexException(String problematicInput) {
        super(problematicInput);
    }
    public void printErrorMessage() {
        System.out.println("Please enter a valid index number: " + problematicInput);
    }
}
