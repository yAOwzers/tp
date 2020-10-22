package seedu.duke.exceptions;

//TODO create a ZeroNoteException class that all the regular exceptions will inherit from.

/**
 * Signals that the user's input is missing a title.
 */
public class TaskTitleException extends ZeroNoteException {
    @Override
    public void printErrorMessage() {
        System.out.println("Your task is missing a title!");
        System.out.println("Please type in the format: add /tTITLE /byDEADLINE");
    }
}
