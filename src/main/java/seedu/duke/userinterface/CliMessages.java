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

    public void printAddedTaskMessage(TaskList tasksList, String title) {
        System.out.println("Added: " + title);
        System.out.println(tasksList.getNumberOfTasks() + ":" + tasksList.getTask(tasksList.getNumberOfTasks() - 1));
    }

    public static void printRemoveNotebookMessage(Notebook notebook) {
        System.out.println("Noted. I've removed this notebook: ");
        System.out.println("\t" + notebook.getTitle());
    }

    public static void printRemoveSectionMessage(Section section) {
        System.out.println("Noted. I've removed this section: ");
        System.out.println("\t" + section.getTitle());
    }

    public static void printRemovePageMessage(Page page) {
        System.out.println("Noted. I've removed this page: " + page.getTitle());
        page.printPage();
    }

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

    public void printAddTaskHelp() {
        System.out.println("To add a task with a deadline to the task list: ");
        System.out.println("add /t[TASK] /by[dd/MM/yyyy] [hhmm]");
        System.out.println("Example of usage: ");
        System.out.println("add /tcoding /by19-10-2020 1900");
        System.out.println("");
    }

    public void printAddNotebookSectionPageHelp() {
        printAddNotebookHelp();
        printAddSectionHelp();
        printAddPageHelp();
    }

    private void printAddPageHelp() {
        System.out.println("To add a page into the selected section:");
        System.out.println("add /p[PAGE]; [PAGE CONTENT]");
        System.out.println("Example of usage: ");
        System.out.println("add /pHELLO WORLD; System.out.println(\"Hello World!\");");
        System.out.println("");
    }

    private void printAddSectionHelp() {
        System.out.println("To add a section into the selected notebook: ");
        System.out.println("add /s[SECTION]");
        System.out.println("Example of usage: ");
        System.out.println("add /sW1: Java");
        System.out.println("");
    }

    private void printAddNotebookHelp() {
        System.out.println("To add a notebook into the notebook shelf: ");
        System.out.println("add /n[NOTEBOOK]");
        System.out.println("Example of usage: ");
        System.out.println("add /nCS2101");
        System.out.println("");
    }

    public void printDoneTaskHelp() {

    }

    public void printExitHelp() {
        System.out.println("To quit Zer0Note:");
        System.out.println("exit");
    }

    public void printListTaskHelp() {

    }

    public void printListNotebookSectionPageHelp() {

    }

    public void printModeSwitchHelp() {
        System.out.println("To switch to timetable mode: ");
        System.out.println("mode /t");
        System.out.println("To switch to notebook mode: ");
        System.out.println("mode /n");
        System.out.println("");
    }

    public void printRemoveTaskHelp() {
        System.out.println("To delete an existing task from the task list: ");
        System.out.println("delete [INDEX]");
        System.out.println("Example of usage: ");
        System.out.println("delete 1");
        System.out.println("");
    }

    public void printRemoveNotebookSectionPageHelp() {
        System.out.println("To delete and existing notebook, section or page: ");
        System.out.println("delete /n[NOTEBOOK] /s[SECTION] /p[NUMBER]");
        System.out.println("Examples of usage: ");
        System.out.println("delete /nCS2113T /sW10 /p1");
        System.out.println("delete /nCS2113T /sW10");
        System.out.println("delete /nCS2113T");
        System.out.println("");
    }

    public void printSelectHelp() {
        System.out.println("To select a notebook, section, page, or a combination of the three: ");
        System.out.println("select /n[NOTEBOOK] /s[SECTION] /p[NUMBER]");
        System.out.println("Examples of usage: ");
        System.out.println("In any context: ");
        System.out.println("select /nCS2101 /sW2 /p1");
        System.out.println("select /nCS2101 /sW2");
        System.out.println("select /nCS2101");
        System.out.println("select /all");
        System.out.println("");
        System.out.println("In a selected notebook");
        System.out.println("select /s1: What is OOP? /p1");
        System.out.println("select /s1: What is OOP?");
        System.out.println("");
        System.out.println("In a selected section");
        System.out.println("select /p1");
        System.out.println("");
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

    public void printOnlineGuideLink() {
        System.out.println("Access the full user guide for Zer0Note online, at: ");
        System.out.println("https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html");
        System.out.println("");
    }

    public void printAllHelp() {
        System.out.println("Here are all the commands you need to know to operate Zer0Note: ");
        printGeneralHelp();
        printNotebookModeHelp();
        printTimetableModeHelp();
        printOnlineGuideLink();
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
