package seedu.duke.storage;

import seedu.duke.exceptions.InvalidUserInputException;
import seedu.duke.exceptions.NotebookOutOfBoundsException;
import seedu.duke.notebooks.*;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.CliUserInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents the storage of where Zer0Note is loading from and saving information to.
 *
 * @author yAOwzers
 *
 * @version 0.1
 */
public class Storage {

    private static final String taskFilepath = "data/taskData.txt";
    private static final String notebookShelfFilepath = "data/notebookShelfData.txt";

    public Storage() {

    }

    // Saves the given task to txt format
    public void saveTask(Task task) {
        File file = new File(this.taskFilepath);
        try {
            file.getParentFile().mkdir(); // create a directory
            file.createNewFile(); // create a .txt file

            // checks whether the file exist
            if (file.length() > 0) {
                FileWriter saveFile = new FileWriter(file, true);
                saveFile.write(System.lineSeparator() + task.toTxtFormat());
                saveFile.close();
            } else {
                FileWriter saveFile = new FileWriter(this.taskFilepath);
                saveFile.write(task.toTxtFormat());
                saveFile.close();
            }
        } catch (IOException e) {
            System.out.println("Error in IO!");
        }
    }

    /**
     * Loads the data in the text file from the file path to an assigned tasks.TaskList.
     * @param taskList to load data to.
     * @throws InvalidUserInputException if there are any invalid inputs in the file
     * that are unable to be parsed into a Task.
     */
    public void loadTaskList(TaskList taskList) throws InvalidUserInputException {
        File file = new File(this.taskFilepath); // create a File for the given file path
        try {
            Scanner s = new Scanner(file); // create a Scanner using the File as the source
            while (s.hasNext()) {
                Task loadTaskList = Task.parse(s.nextLine());
                taskList.load(loadTaskList);
            }
        } catch (FileNotFoundException e) {
            // If file is not found, a new file will be created
        }
    }

    /**
     * Overwrites and saves an entire tasklist into the txt file from the file path.
     * @param taskList to be saved into the txt file.
     */
    public void saveTaskList(TaskList taskList) {
        try {
            FileWriter overwriteFile = new FileWriter(this.taskFilepath);
            if (taskList.getNumberOfTasks() > 0) {
                overwriteFile.write(taskList.getTask(0).toTxtFormat());
                overwriteFile.close();
                for (int i = 1; i < taskList.getTaskArrayList().size(); i++) {
                    saveTask(taskList.getTask(i));
                }
            } else {
                overwriteFile.write("");
                overwriteFile.close();
            }
        } catch (IOException e) {
            System.out.println(CliMessages.printUnknownError());
        }
    }


    // TODO condense all methods into a single one, and do a switch
    public void savePage(Page page) {
        File file = new File(this.notebookShelfFilepath);
        try {
            file.getParentFile().mkdir(); // create a directory
            file.createNewFile(); // create .txt file

            // checks whether the file exists
            if (file.length() > 0) {
                FileWriter writeToFile = new FileWriter(file, true);
                writeToFile.write(System.lineSeparator() + page.toTxtFormat());
                writeToFile.close();
            } else {
                FileWriter writeToFile = new FileWriter(this.notebookShelfFilepath);
                writeToFile.write(page.toTxtFormat());
                writeToFile.close();
            }
        } catch (IOException e) {
            System.out.println("Error in IO");
        }
    }

    public void saveSection(Section section) {
        File file = new File(this.notebookShelfFilepath);
        try {
            file.getParentFile().mkdir(); // create a directory
            file.createNewFile(); // create a .txt file

            // checks whether the file exist
            if (file.length() > 0) {
                FileWriter saveFile = new FileWriter(file, true);
                saveFile.write(System.lineSeparator() + section.toTxtFormat());
                saveFile.close();
            } else {
                FileWriter saveFile = new FileWriter(this.notebookShelfFilepath);
                saveFile.write(section.toTxtFormat());
                saveFile.close();
            }
        } catch (IOException e) {
            System.out.println("Error in IO!");
        }
    }

    // TODO change all load methods
    public void loadSection(Section section) throws InvalidUserInputException {
        File file = new File(this.notebookShelfFilepath); // create a File for the given file path
        try {
            Scanner s = new Scanner(file); // create a Scanner using the File as the source
            while (s.hasNext()) {
                Page loadPageList = (Page) Page.parse(s.nextLine());
                section.load(loadPageList);
            }
        } catch (FileNotFoundException e) {
            // If file is not found, a new file will be created
        }
    }

    public void loadNotebook(Notebook notebook) throws InvalidUserInputException {
        File file = new File(this.notebookShelfFilepath); // create a File for the given file path
        try {
            Scanner s = new Scanner(file); // create a Scanner using the File as the source
            while (s.hasNext()) {
                Section loadSectionList = (Section) Section.parse(s.nextLine());
                notebook.load(loadSectionList);
            }
        } catch (FileNotFoundException e) {
            // If file is not found, a new file will be created
        }
    }

    public void saveNotebook(Notebook notebook) {
        File file = new File(this.notebookShelfFilepath);
        try {
            file.getParentFile().mkdir(); // create a directory
            file.createNewFile(); // create a .txt file

            // checks whether the file exist
            if (file.length() > 0) {
                FileWriter saveFile = new FileWriter(file, true);
                saveFile.write(System.lineSeparator() + notebook.toTxtFormat());
                saveFile.close();
            } else {
                FileWriter saveFile = new FileWriter(this.notebookShelfFilepath);
                saveFile.write(notebook.toTxtFormat());
                saveFile.close();
            }
        } catch (IOException e) {
            System.out.println("Error in IO!");
        }
    }


    /**
     * Overwrites and saves an entire notebookShelf into the txt file from the file path.
     * @param notebookShelf to be saved into the txt file.
     */
    public void saveNotebookShelf(NotebookShelf notebookShelf) {
        try {
            FileWriter overwriteFile = new FileWriter(this.notebookShelfFilepath);
            if (notebookShelf.getNumberOfNotebooks() > 0) {
                overwriteFile.write(notebookShelf.getNotebookAtIndex(0).toTxtFormat());
                overwriteFile.close();
                for (int i = 1; i < notebookShelf.getNotebookArrayList().size(); i++) {
                    saveNotebook(notebookShelf.getNotebookAtIndex(i));
                }
            } else {
                overwriteFile.write("");
                overwriteFile.close();
            }
        } catch (IOException | NotebookOutOfBoundsException e) {
            System.out.println(CliMessages.printUnknownError());
        }
    }

    public void loadNotebookShelf(NotebookShelf notebookShelf) throws InvalidUserInputException {
        File file = new File(this.notebookShelfFilepath); // create a File for the given file path
        try {
            Scanner s = new Scanner(file); // create a Scanner using the File as the source
            while (s.hasNext()) {
                Notebook loadNotebookList = (Notebook) Notebook.parse(s.nextLine());
                notebookShelf.load(loadNotebookList);
            }
        } catch (FileNotFoundException e) {
            // If file is not found, a new file will be created
        }
    }
}
