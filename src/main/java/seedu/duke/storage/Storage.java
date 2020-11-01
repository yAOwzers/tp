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
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.PersonalMesssageGenerator;

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
    private final String nameFilepath = "txt/nameOfUser.txt";
    private PersonalMesssageGenerator msgGenerator;

    public Storage() {
        msgGenerator = new PersonalMesssageGenerator();
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

    public boolean isNameOfUserFilled() throws IOException {
        File nameOfUserFile = new File(this.nameFilepath);
        System.out.println(nameOfUserFile.length());
        if (nameOfUserFile.length() == 0 || !nameOfUserFile.exists()) {
            return false;
        }
        return true;
    }

    public void saveNameOfUser() throws IOException {

        //If the folder doesn't exists, create it
        File folder = new File("data");
        boolean bool = folder.mkdirs();

        //If the file doesn't exist, create it
        File f = new File(this.nameFilepath);
        // create a Scanner using the File as the source
        try {
            Scanner s = new Scanner(f);
        } catch (FileNotFoundException e) {
//            System.out.println("File Not Found");
            try {
                f.createNewFile();
                //System.out.println("New File");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

            Scanner keyboard = new Scanner(System.in);
            String userInput = keyboard.nextLine();
            FileWriter nameOfUserFileToSave = new FileWriter(this.nameFilepath);
            nameOfUserFileToSave.write(userInput);
            msgGenerator.setChosenName(userInput);
            msgGenerator.greetFirstTimeUser();
            nameOfUserFileToSave.close();


    }
}
