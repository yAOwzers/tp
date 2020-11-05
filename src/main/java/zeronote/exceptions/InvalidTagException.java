package zeronote.exceptions;

public class InvalidTagException extends ZeroNoteException {
    public InvalidTagException(String problematicInput) {
        super(problematicInput);
    }

    public void setProblematicInput(String problematicInput) {
        this.problematicInput = problematicInput;
    }

    public void printErrorMessage() {
        System.out.println("Missing tag/Invalid tag: tag /t" + problematicInput);
        System.out.println("Format: tag [index] /t[tag] for timetable mode");
        System.out.println("Format: tag /t[tag] for notebook mode");
    }
}
