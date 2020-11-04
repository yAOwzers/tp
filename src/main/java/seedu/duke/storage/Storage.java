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
    private final String nameFilepath = "src/main/resources/txt/nameOfUser.txt";

    public void saveTasks(AppState currentAppState) throws FileSavingException {
        File tasksFile = new File(tasksFilePath);
        TaskList currentTaskList = currentAppState.getTaskList();
        String tasksToSave = currentTaskList.serialize();
        try {
            FileWriter tasksFileWriter = new FileWriter(tasksFile);
            tasksFileWriter.write(tasksToSave);
            tasksFileWriter.close();
        } catch (IOException e) {
            throw new FileSavingException(e.getMessage());
        }
    }

    public void saveNotebooks(AppState currentAppState) throws FileSavingException {
        File notebooksFile = new File(notebooksFilePath);
        NotebookShelf currentNotebookShelf = currentAppState.getCurrentBookShelf();
        String notebooksToSave = currentNotebookShelf.serialize();
        try {
            FileWriter notebooksFileWriter = new FileWriter(notebooksFile);
            notebooksFileWriter.write(notebooksToSave);
            notebooksFileWriter.close();
        } catch (IOException e) {
            throw new FileSavingException(e.getMessage());
        }
    }

    public void saveUserName(AppState currentAppState) throws FileSavingException {
        File userNameFile = new File(nameFilepath);
        try {
            FileWriter userNameFileWriter = new FileWriter(userNameFile);
            userNameFileWriter.write(currentAppState.getUserName());
        } catch (IOException e) {
            throw new FileSavingException(e.getMessage());
        }
    }

    public void saveToFile(AppState currentAppState) throws FileSavingException {
        saveTasks(currentAppState);
        saveNotebooks(currentAppState);
        saveUserName(currentAppState);
    }

    public void readTasks(AppState loadedAppState) {
        TaskList loadedTaskList = new TaskList();
        File tasksFile = new File(tasksFilePath);
        try {
            Scanner tasksFileScanner = new Scanner(tasksFile);
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
            loadedAppState.setTaskList(loadedTaskList);
        } catch (FileNotFoundException e) {
            CliMessages.printNoTaskFile();
        } catch (Exception e) {
            CliMessages.printCorruptTaskFile();
            PrintStream syserr = System.err;
            System.setErr(System.out);
            e.printStackTrace();
            System.setErr(syserr);
        }
    }

    public void readNotebooks(AppState loadedAppState) {
        NotebookShelf loadedNotebookShelf = new NotebookShelf();
        File notebooksFile = new File(notebooksFilePath);
        try {
            Scanner notebooksFileScanner = new Scanner(notebooksFile);
            int numNotebooks = Integer.parseInt(notebooksFileScanner.nextLine());
            for (int i = 0; i < numNotebooks; i++) {
                String notebookTitle = notebooksFileScanner.nextLine();
                int numSections = Integer.parseInt(notebooksFileScanner.nextLine());
                Notebook currentNotebook = new Notebook(notebookTitle);
                readSections(numSections, currentNotebook, notebooksFileScanner);
                loadedNotebookShelf.addNotebook(currentNotebook);
            }
            loadedAppState.setCurrentBookShelf(loadedNotebookShelf);
        } catch (FileNotFoundException e) {
            CliMessages.printNoNotebookFile();
        } catch (Exception e) {
            CliMessages.printCorruptNotebookFile();
            PrintStream syserr = System.err;
            System.setErr(System.out);
            e.printStackTrace();
            System.setErr(syserr);
        }
    }

    public void readSections(int numSections, Notebook currentNotebook, Scanner notebooksFileScanner) {
        for (int j = 0; j < numSections; j++) {
            String sectionTitle = notebooksFileScanner.nextLine();
            int numPages = Integer.parseInt(notebooksFileScanner.nextLine());
            Section currentSection = new Section(sectionTitle);
            readPages(numPages, currentSection, notebooksFileScanner);
            currentNotebook.addSection(currentSection);
        }
    }

    public void readPages(int numPages, Section currentSection, Scanner notebooksFileScanner) {
        for (int k = 0; k < numPages; k++) {
            String pageTitle = notebooksFileScanner.nextLine();
            String pageContent = notebooksFileScanner.nextLine();
            pageContent = pageContent.replaceAll("~~~", System.lineSeparator());
            Page currentPage = new Page(pageTitle, pageContent);
            currentSection.addPage(currentPage);
        }
    }

    public void readUserName(AppState loadedAppState) {
        File userNameFile = new File(nameFilepath);
        try{
            Scanner userNameFileScanner = new Scanner(userNameFile);
            String userName = userNameFileScanner.nextLine();
            loadedAppState.setUserName(userName);
        } catch (Exception e) {

        }
    }

    public AppState readFromFile() throws CorruptFileException {
        AppState loadedAppState = new AppState();
        readTasks(loadedAppState);
        readNotebooks(loadedAppState);
        readUserName(loadedAppState);
        return loadedAppState;
    }

    @Deprecated
    public boolean isNameOfUserFilled() {
        File nameOfUserFile = new File(this.nameFilepath);
        if (nameOfUserFile.length() == 0 || !nameOfUserFile.exists()) {
            return false;
        }
        return true;
    }
    
    @Deprecated
    public void saveNameOfUser() {
        File file = new File(this.nameFilepath);
        try {
            file.getParentFile().mkdir(); // create a directory
            file.createNewFile(); // create .txt file
            Scanner keyboard = new Scanner(System.in);
            String userInput = keyboard.nextLine();
            FileWriter nameOfUserFileToSave = new FileWriter(this.nameFilepath);
            nameOfUserFileToSave.write(userInput);
            msgGenerator.setChosenName(userInput);
            msgGenerator.greetFirstTimeUser();
            nameOfUserFileToSave.close();
        } catch (IOException e) {
            System.out.println("Error in FileSaving");
        }

    }
}
