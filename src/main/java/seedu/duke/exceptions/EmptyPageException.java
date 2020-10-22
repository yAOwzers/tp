package seedu.duke.exceptions;

public class EmptyPageException extends ZeroNoteException {
    @Override
    public void printErrorMessage() {
        System.out.println("Empty page!");
        System.out.println("Format for adding a page: add /pPAGE TITLE; PAGE CONTENT");
    }
}
