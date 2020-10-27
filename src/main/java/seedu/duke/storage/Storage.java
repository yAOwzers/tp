package seedu.duke.storage;

import seedu.duke.exceptions.CorruptFileException;
import seedu.duke.exceptions.FileSavingException;
import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents the storage of where Zer0Note is loading from and saving information to.
 */
public class Storage {

    private final String tasksFilePath = "tasks.txt";
    private final String notebooksFilePath = "notebooks.txt";

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

    public AppState readFromFile() throws CorruptFileException {
        AppState loadedAppState = new AppState();
        TaskList loadedTaskList = loadedAppState.getTaskList();
        NotebookShelf loadedNotebookShelf = loadedAppState.getCurrentBookShelf();

        File tasksFile = new File(tasksFilePath);
        File notebooksFile = new File(notebooksFilePath);
        try {
            Scanner tasksFileScanner = new Scanner(tasksFile);
            Scanner notebooksFileScanner = new Scanner(notebooksFile);
            int numTasks = Integer.parseInt(tasksFileScanner.nextLine());
            for (int i = 0; i < numTasks; i++) {
                String taskTitle = tasksFileScanner.nextLine();
                String taskDate = tasksFileScanner.nextLine();
                String done = tasksFileScanner.nextLine();
                Task currentTask = new Task(taskTitle, taskDate);
                if (done.equals("true")) {
                    currentTask.markAsDone();
                }
                loadedTaskList.addTask(currentTask);
            }
            int numNotebooks = Integer.parseInt(notebooksFileScanner.nextLine());
            for (int i = 0; i < numNotebooks; i++) {
                String notebookTitle = notebooksFileScanner.nextLine();
                int numSections = Integer.parseInt(notebooksFileScanner.nextLine());
                Notebook currentNotebook = new Notebook(notebookTitle);
                for (int j = 0; j < numSections; j++) {
                    String sectionTitle = notebooksFileScanner.nextLine();
                    int numPages = Integer.parseInt(notebooksFileScanner.nextLine());
                    Section currentSection = new Section(sectionTitle);
                    for (int k = 0; k < numPages; k++) {
                        String pageTitle = notebooksFileScanner.nextLine();
                        String pageContent = notebooksFileScanner.nextLine();
                        pageContent = pageContent.replaceAll("~~~", System.lineSeparator());
                        Page currentPage = new Page(pageTitle, pageContent);
                        currentSection.addPage(currentPage);
                    }
                    currentNotebook.addSection(currentSection);
                }
                loadedNotebookShelf.addNotebook(currentNotebook);
            }
            return loadedAppState;
        } catch (FileNotFoundException e) {
            System.out.println("File was not found. A new save file will be created upon exit. ");
            return new AppState();
        } catch (InputMismatchException | NumberFormatException e) {
            e.printStackTrace();
            return new AppState();
        }
    }
}
