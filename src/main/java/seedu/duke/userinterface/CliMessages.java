package seedu.duke.userinterface;

import seedu.duke.exceptions.InvalidUserInputException;
import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;

/**
 * A class containing all the messages displayed to the user during operation.
 *
 * @author neilbaner
 * @version 0.1
 */

public class CliMessages {
    private static final String REMOVE_TASK_SUCCESS_MESSAGE = "Noted. I've removed this task:";

    public static void printRemoveTaskMessage(Task deletedTask, int numberOfTasks) {
        System.out.println(REMOVE_TASK_SUCCESS_MESSAGE);
        System.out.println(deletedTask.getTaskInMessagesFormat());
        if (numberOfTasks == 1) {
            System.out.println("\tNow you have " + numberOfTasks + " task in the list.");
        } else {
            System.out.println("\tNow you have " + numberOfTasks + " tasks in the list.");
        }
    }

    public static String printUnknownError() {
        return "Sorry unknown error!";
    }

    public String printZer0NoteError(InvalidUserInputException e) {
        return "Error starting up Zer0Note!";
    }

    //TODO: fill these sections with the appropriate user documentation, possibly taken from the final UG
    public void printAddTaskHelp() {

    }

    public void printAddNotebookSectionPageHelp() {

    }

    public void printDoneTaskHelp() {

    }

    public void printExitHelp() {

    }

    public void printListTaskHelp() {

    }

    public void printListNotebookSectionPageHelp() {

    }

    public void printModeSwitchHelp() {

    }

    public void printRemoveTaskHelp() {

    }

    public void printRemoveNotebookSectionPageHelp() {

    }

    public void printSelectHelp() {

    }

    public void printNotebookModeHelp() {
        System.out.println("Here are some commands to help you work with the Notebook mode: ");
        printAddNotebookSectionPageHelp();
        printListNotebookSectionPageHelp();
        printSelectHelp();
        printRemoveNotebookSectionPageHelp();
    }

    public void printTimetableModeHelp() {
        System.out.println("Here are some commands to help you work with the Timetable mode: ");
        printAddTaskHelp();
        printDoneTaskHelp();
        printListTaskHelp();
        printRemoveTaskHelp();
    }

    public void printGeneralHelp() {
        System.out.println("Here are some general commands that will work throughout Zer0Note: ");
        printModeSwitchHelp();
        printExitHelp();
    }

    public void printAllHelp() {
        System.out.println("Here are all the commands you need to know to operate Zer0Note: ");
        printGeneralHelp();
        printNotebookModeHelp();
        printTimetableModeHelp();
    }

    public void printAddedTaskMessage(TaskList tasksList, String title) {
        System.out.println("Added: " + title);
        System.out.println(tasksList.getNumberOfTasks() + ":" + tasksList.getTask(tasksList.getNumberOfTasks() - 1));
    }

    public void printGoodBye() {
        System.out.println("Bye!");
    }

    public void printMarkDone(Task task) {
        String markDoneMessage = "Yay! I've marked these task as done:";
        System.out.println(markDoneMessage + "\n " + task.getTaskInMessagesFormat());
    }

    /**
     * Generates and prints the task that has been added to the list.
     * @param newTask that is added to the tasklist.
     */
    public String printAddTaskMessage(Task newTask) {
        String addMessage = "Got it. I've added this task:\n  ";
        return addMessage + newTask.getTaskInMessagesFormat();
    }

    /**
     * Prints a message which displays the total number of tasks in a tasklist.
     * @param i the total number of task in a tasklist.
     */
    public String getNumberOfTaskMessage(int i) {
        //If there is only one task, then task will be singular
        if(i == 1) {
            return "Now you have " + i + " task in the list.";
        }
        else {
            return "Now you have " + i + " tasks in the list.";
        }
    }

    /**
     * Generates and prints the notebook that has been added to the notebookShelf.
     * @param newNotebook that is added to the NotebookShelf.
     */
    public String printAddNotebookMessage(Notebook newNotebook) {
        String addMessage = "Got it. I've added this notebook:\n  ";
        return addMessage + newNotebook.getNotebookInMessageFormat();
    }

    /**
     * Prints a message which displays the total number of notebooks in a notebookShelf.
     * @param i the total number of notebooks in a notebookShelf.
     */
    public String getNumberOfNotebookMessage(int i) {
        //If there is only one notebook, then notebook will be singular
        if(i == 1) {
            return "Now you have " + i + " notebook in the notebookShelf.";
        }
        else {
            return "Now you have " + i + " notebooks in the notebookShelf.";
        }
    }

    /**
     * Generates and prints the section that has been added to the notebook.
     * @param newSection that is added to the Notebook.
     */
    public String printAddSectionMessage(Section newSection) {
        String addMessage = "Got it. I've added this section:\n  ";
        return addMessage + newSection.getSectionInMessageFormat();
    }

    /**
     * Prints a message which displays the total number of sections in a notebook.
     * @param i the total number of sections in a notebook.
     */
    public String getNumberOfSectionMessage(int i) {
        //If there is only one section, then section will be singular
        if(i == 1) {
            return "Now you have " + i + " section in the notebook.";
        }
        else {
            return "Now you have " + i + " sections in the notebook.";
        }
    }

    /**
     * Generates and prints the page that has been added to the section.
     * @param newPage that is added to the section.
     */
    public String printAddPageMessage(Page newPage) {
        String addMessage = "Got it. I've added this page:\n  ";
        return addMessage + newPage.getPageInMessageFormat();
    }

    /**
     * Prints a message which displays the total number of pages in a section.
     * @param i the total number of pages in a section.
     */
    public String getNumberOfPageMessage(int i) {
        //If there is only one page, then page will be singular
        if(i == 1) {
            return "Now you have " + i + " page in the section.";
        }
        else {
            return "Now you have " + i + " pages in the section.";
        }
    }
}
