package zeronote.exceptions;

public class TaskListEmptyException extends ZeroNoteException {
    @Override
    public void printErrorMessage() {
        System.out.println("The Task List is empty!");
    }
}
