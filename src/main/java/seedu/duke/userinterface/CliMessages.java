package seedu.duke.userinterface;

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

    public void printAddedTaskMessage(TaskList tasksList, String title) {
        System.out.println("Added: " + title);
        System.out.println(tasksList.getNumberOfTasks() + ":" + tasksList.getTask(tasksList.getNumberOfTasks() - 1));
    }

    public static void printRemoveNotebookMessage(Notebook notebook) {
        System.out.println("Noted. I've removed this notebook: ");
        System.out.println("\t"+notebook.getTitle());
    }

    public static void printRemoveSectionMessage(Section section) {
        System.out.println("Noted. I've removed this section: ");
        System.out.println("\t"+section.getTitle());
    }

    public static void printRemovePageMessage(Page page, int index) {
        System.out.println("Noted. I've removed this page: " + index);
        page.printPage();
    }

    public static void printRemoveTaskMessage(Task deletedTask, int numberOfTasks) {
        System.out.println(REMOVE_TASK_SUCCESS_MESSAGE);
        System.out.println(deletedTask.toString());
        if (numberOfTasks == 1) {
            System.out.println("\tNow you have " + numberOfTasks + " task in the list.");
        } else {
            System.out.println("\tNow you have " + numberOfTasks + " tasks in the list.");
        }
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

    public void printGoodBye() {
        System.out.println("Bye!");
    }
}
