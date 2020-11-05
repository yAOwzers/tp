package seedu.duke.exceptions;

public class CorruptFileException extends ZeroNoteException {
    public CorruptFileException(String enteredCommand) {
        super(enteredCommand);
    }

    @Override
    public void printErrorMessage() {
        System.out.println("Sorry, there was some error reading the file. It may be corrupt. ");
        System.out.println("The following error message may help to debug the issue: ");
        System.out.println(problematicInput);
    }
}
