package seedu.duke.storage;

import seedu.duke.exceptions.FileSavingException;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;

import java.io.File;
import java.io.FileNotFoundException;
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

//    // Saves the given task to txt format
//    public void saveTask(Task task) {
//        File file = new File(this.filepath);
//        try {
//            file.getParentFile().mkdir(); // create a directory
//            file.createNewFile(); // create a .txt file
//
//            // checks whether the file exist
//            if (file.length() > 0) {
//                FileWriter saveFile = new FileWriter(file, true);
//                saveFile.write(System.lineSeparator() + task.toTxtFormat());
//                saveFile.close();
//            } else {
//                FileWriter saveFile = new FileWriter(this.filepath);
//                saveFile.write(task.toTxtFormat());
//                saveFile.close();
//            }
//        } catch (IOException e) {
//            System.out.println("Error in IO!");
//        }
//    }

    public void saveToFile(AppState currentAppState) throws FileSavingException {
        File tasksFile = new File(tasksFilePath);
        File notebooksFile = new File(notebooksFilePath);

        TaskList currentTaskList = currentAppState.getTaskList();
        NotebookShelf currentNotebookShelf = currentAppState.getCurrentBookShelf();

        String tasksToSave = currentTaskList.serialize();
        // String notebooksToSave = currentNotebookShelf.serialize();

        try {
            FileWriter tasksFileWriter = new FileWriter(tasksFile);
            FileWriter notebooksFileWriter = new FileWriter(notebooksFile);
            tasksFileWriter.write(tasksToSave);
            // notebooksFileWriter.write(notebooksToSave);
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
