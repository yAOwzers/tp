package seedu.duke.exceptions;

/**
 * Signals that the user's input does not follow the correct format expected.
 */
public class TaskWrongFormatException extends ZeroNoteException {
    public TaskWrongFormatException() {
        super("Your Task is formatted wrongly!");
    }
}
