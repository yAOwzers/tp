package zeronote.exceptions;

// @@author neilbaner

public class TaskIndexIncorrectFormatException extends ZeroNoteException {
    @Override
    public void printErrorMessage() {
        System.out.println("I'm sorry, please enter a valid number!");
    }
}
