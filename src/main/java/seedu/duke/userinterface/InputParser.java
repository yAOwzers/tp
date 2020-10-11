package seedu.duke.userinterface;

public class InputParser {
    public int parseTaskIndex(String args) throws NumberFormatException {
        return Integer.parseInt(args) - 1;
    }
}
