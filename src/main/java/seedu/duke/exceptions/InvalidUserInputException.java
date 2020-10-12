package seedu.duke.exceptions;

public class InvalidUserInputException extends ZeroNoteException {
    public InvalidUserInputException(String userInput) {
        super("Sorry but " + userInput + " is invalid!");
    }
}
