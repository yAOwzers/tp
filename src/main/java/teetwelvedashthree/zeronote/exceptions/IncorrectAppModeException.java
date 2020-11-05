package seedu.duke.exceptions;

//@@Lusi711
public class IncorrectAppModeException extends ZeroNoteException {
    @Override
    public void printErrorMessage() {
        System.out.println("Please check that you are in the correct mode.");
    }
}
