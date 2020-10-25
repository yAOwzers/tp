package seedu.duke.exceptions;

//@@chuckiex3
/**
 * Signals that the user has input an invalid page name.
 */
public class InvalidPageException extends ZeroNoteException {
    @Override
    public void printErrorMessage() {
        System.out.println("Entered invalid page");
        System.out.println("Format for adding page: add /pPAGE; CONTENT");
        System.out.println("Format for selecting page: select /pNUMBER");
    }
}
