package seedu.duke.notebooks;

import seedu.duke.exceptions.InvalidUserInputException;

public abstract class NotebookData {

    private String title;

    public NotebookData() {

    }

    public String getTitle() {
        return this.title;
    }

    public String toTxtFormat() {
        return this.title;
    }

    /**
     * Parses a given string into a specific type of Notebookdata.
     * @param txtFormat to be parsed into a notebookData.
     * @return a specific notebookData type based on the txtFormat.
     * @throws InvalidUserInputException when txtFormat is of invalid format to be parsed into a task.
     */
    public static NotebookData parse(String txtFormat) throws InvalidUserInputException {
        char firstLetter = txtFormat.charAt(0);
        String[] txtArray = txtFormat.split("\\|");
        if (firstLetter == 'N') {
            return Notebook.parse(txtArray);
        } else if (firstLetter == 'S') {
            return Section.parse(txtArray);
        } else if (firstLetter == 'P') {
            return Page.parse(txtArray);
        } else {
            throw new InvalidUserInputException();
        }
    }
}
