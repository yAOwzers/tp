package zeronote.exceptions;

//@@author Lusi711

/**
 * Signals that the user has input an invalid number e.g. letters.
 */
public class InvalidIndexException extends ZeroNoteException {
    public InvalidIndexException(String problematicInput) {
        super(problematicInput);
    }

    public void printErrorMessage() {
        System.out.println("You have input an invalid index number: " + problematicInput);
    }
}
