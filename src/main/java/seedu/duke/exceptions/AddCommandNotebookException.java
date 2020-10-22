package seedu.duke.exceptions;

public class AddCommandNotebookException extends ZeroNoteException {
    public AddCommandNotebookException(String problematicInput) {
        super(problematicInput);
    }

    @Override
    public void printErrorMessage() {
        System.out.println("Unable to add notebook/section/page" + problematicInput);
    }
}
