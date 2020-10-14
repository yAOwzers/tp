package seedu.duke.exceptions;

public abstract class ZeroNoteException extends Exception{
    public String problematicInput;
    public ZeroNoteException() {

    }
    public ZeroNoteException(String enteredCommand) {
        this.problematicInput = enteredCommand;
    }
    public abstract void printErrorMessage();
}
