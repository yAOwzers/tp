package seedu.duke.userinterface;

/**
 * A class containing all the messages displayed to the user during operation.
 *
 * @author neilbaner
 * @version 0.1
 */

import seedu.duke.tasks.TaskList;

public class CliMessages {

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

    public void printAddedTaskMessage(TaskList taskList, String title) {
        System.out.println("Added: " + title);
        System.out.println(taskList.getNumberOfTasks() + ":" + taskList.getTask(taskList.getNumberOfTasks() - 1));
    }

    public void printGoodBye() {
        System.out.println("Bye!");
    }
}
