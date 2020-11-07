package zeronote.exceptions;

public class TaskIndexIncorrectFormatException extends ZeroNoteException {
    @Override
    public void printErrorMessage() {
        System.out.println("I'm sorry, please enter a valid number!");
    }
}
