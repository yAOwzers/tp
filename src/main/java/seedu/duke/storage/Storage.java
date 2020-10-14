package seedu.duke.storage;

import seedu.duke.tasks.Task;
import seedu.duke.userinterface.AppState;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents the storage of where Zer0Note is loading from and saving information to
 */
public class Storage {

    private String filepath;

    // To include String filepath
    public Storage() {

    }

    // Saves the given task to txt format
    public void saveTask(Task task) {
        File file = new File(this.filepath);
        try {
            file.getParentFile().mkdir(); // create a directory
            file.createNewFile(); // create a .txt file

            // checks whether the file exist
            if (file.length() > 0) {
                FileWriter saveFile = new FileWriter(file, true);
                saveFile.write(System.lineSeparator() + task.toTxtFormat());
                saveFile.close();
            } else {
                FileWriter saveFile = new FileWriter(this.filepath);
                saveFile.write(task.toTxtFormat());
                saveFile.close();
            }
        } catch (IOException e) {
            System.out.println("Error in IO!");
        }
    }

    public void saveToFile(AppState currentAppState) {
        // TODO: Implement
    }

    public AppState readFromFile() {
        // TODO: Implement
        return new AppState();
    }
}
