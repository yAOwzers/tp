package seedu.duke.exceptions;

public class InvalidUserInputException extends ZeroNoteException {

    @Override
    public void printErrorMessage() {
        System.out.println("The input \"" + problematicInput + "\" doesn't follow the format expected. ");
    }
}
