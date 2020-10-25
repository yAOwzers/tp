package seedu.duke.storage;

import seedu.duke.exceptions.FileSavingException;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents the storage of where Zer0Note is loading from and saving information to.
 */
public class Storage {

    private final String tasksFilePath = "tasks.txt";
    private final String notebooksFilePath = "notebooks.txt";

    // To include String filepath
    public Storage() {

    }

    public void saveToFile(AppState currentAppState) throws FileSavingException {
        File tasksFile = new File(tasksFilePath);
        File notebooksFile = new File(notebooksFilePath);

        TaskList currentTaskList = currentAppState.getTaskList();
        NotebookShelf currentNotebookShelf = currentAppState.getCurrentBookShelf();

        String tasksToSave = currentTaskList.serialize();
        String notebooksToSave = currentNotebookShelf.serialize();

        try {
            FileWriter tasksFileWriter = new FileWriter(tasksFile);
            FileWriter notebooksFileWriter = new FileWriter(notebooksFile);
            tasksFileWriter.write(tasksToSave);
            notebooksFileWriter.write(notebooksToSave);
            tasksFileWriter.close();
            notebooksFileWriter.close();
        } catch (IOException e) {
            throw new FileSavingException(e.getMessage());
        }
    }

    public AppState readFromFile() {
        // TODO: Implement
        return new AppState();
    }
}
