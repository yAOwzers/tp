package zeronote.exceptions;

public class InvalidModeException extends ZeroNoteException {

    @Override
    public void printErrorMessage() {
        System.out.println("You are in the wrong mode! Kindly switch back to Timetable Mode "
                + "by entering '/t'.");
    }
}
