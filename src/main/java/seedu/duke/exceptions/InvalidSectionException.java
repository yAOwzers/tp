package seedu.duke.exceptions;

/**
 * Signals that the user has input an invalid section name.
 */
public class InvalidSectionException extends ZeroNoteException {
    @Override
    public void printErrorMessage() {
        System.out.println("Invalid Section Name " + problematicInput);
        System.out.println("Format for adding section: add /sSECTION");
        System.out.println("Format for selecting section: select /sSECTION");
    }
}
