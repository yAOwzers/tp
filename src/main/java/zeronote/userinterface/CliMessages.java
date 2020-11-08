package zeronote.userinterface;

import zeronote.exceptions.ZeroNoteException;
import zeronote.notebooks.Notebook;
import zeronote.notebooks.Page;
import zeronote.notebooks.Section;
import zeronote.tasks.Task;
import zeronote.tasks.TaskList;

import java.util.ArrayList;

/**
 * A class containing all the messages displayed to the user during operation.
 *
 * @author neilbaner
 * @version 0.1
 */

public class CliMessages {
    private static final String REMOVE_TASK_SUCCESS_MESSAGE = "Noted. I've removed this task:";
    private static PersonalMessageGenerator msgGenerator;

    public static void printRemoveNotebookMessage(Notebook notebook) {
        //        String personalMessage = msgGenerator.generatePersonalisedMessage();
        //        System.out.println(personalMessage);
        System.out.println("Noted. I've removed this notebook: ");
        System.out.println("\t" + notebook.getTitle());
    }

    public static void printRemoveSectionMessage(Section section) {
        //        String personalMessage = msgGenerator.generatePersonalisedMessage();
        //        System.out.println(personalMessage);
        System.out.println("Noted. I've removed this section: ");
        System.out.println("\t" + section.getTitle());
    }

    public static void printRemovePageMessage(Page page) {
        //        String personalMessage = msgGenerator.generatePersonalisedMessage();
        //        System.out.println(personalMessage);
        System.out.println("Noted. I've removed this page: " + page.getTitle());
        page.printPage();
    }

    public static void printCorruptTaskFile() {
        System.out.println("There was some error reading the Tasks file; something has likely been corrupted");
        System.out.println("You may continue, and ZeroNote will start from scratch with no Task data. ");
        System.out.println("Unless otherwise mentioned, your notebooks should be fine. ");
        System.out.println("Note that continuing will overwrite the corrupted file, so you won't be able to "
                + "recover it at all. ");
        System.out.println(
                "You may also quit ZeroNote now by pressing Ctrl-C (PC keyboards) or control-C (Mac " + "keyboards) NOW"
                        + "and attempt to recover the " + "file manually. ");
        System.out.println("If you contact the developers for help, please provide the corrupt files, "
                + "and the following error message " + " ");
    }

    public static void printNoNotebookFile() {
        System.out.println("Notebook save file was not found. A new save file will be created upon exit. ");
    }

    public static void printCorruptNotebookFile() {
        System.out.println("There was some error reading the Notebooks file; something has likely been corrupted");
        System.out.println("You may continue, and ZeroNote will start from scratch with no Task data. ");
        System.out.println("Unless otherwise mentioned, your tasks should be fine. ");
        System.out.println("Note that continuing will overwrite the corrupted file, so you won't be able to "
                + "recover it at all. ");
        System.out.println(
                "You may also quit ZeroNote now by pressing Ctrl-C (PC keyboards) or control-C (Mac " + "keyboards) NOW"
                        + "and attempt to recover the " + "file manually. ");
        System.out.println("If you contact the developers for help, please provide the corrupt files, "
                + "and the following error message " + " ");
    }

    public static void printNoTaskFile() {
        System.out.println("Task save file was not found. A new save file will be created upon exit. ");
    }


    public static void printRemoveTaskMessage(Task deletedTask, int numberOfTasks) {
        //        String personalMessage = msgGenerator.generatePersonalisedMessage();
        //        System.out.println(personalMessage);
        System.out.println(REMOVE_TASK_SUCCESS_MESSAGE);
        System.out.println(deletedTask.toString());
        if (numberOfTasks == 1) {
            System.out.println("\tNow you have " + numberOfTasks + " task in the list.");
        } else {
            System.out.println("\tNow you have " + numberOfTasks + " tasks in the list.");
        }
    }

    public void printAddedTaskMessage(TaskList tasksList, String title) throws ZeroNoteException {
        //        String personalMessage = msgGenerator.generatePersonalisedMessage();
        //        System.out.println(personalMessage);
        System.out.println("Added: " + title);
        System.out.println(tasksList.getNumberOfTasks() + ":" + tasksList.getTask(tasksList.getNumberOfTasks() - 1));
    }

    public void printAddTaskHelp() {
        System.out.println("To add a task with a deadline to the task list: ");
        System.out.println("add /t[TASK] /by[dd-MM-yyyy] [hhmm]");
        System.out.println("Example of usage: ");
        System.out.println("add /tcoding /by19-10-2020 1900");
        System.out.println();
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
        System.out.println();
    }

    private void printAddSectionHelp() {
        System.out.println("To add a section into the selected notebook: ");
        System.out.println("add /s[SECTION]");
        System.out.println("Example of usage: ");
        System.out.println("add /sW1: Java");
        System.out.println();
    }

    private void printAddNotebookHelp() {
        System.out.println("To add a notebook into the notebook shelf: ");
        System.out.println("add /n[NOTEBOOK]");
        System.out.println("Example of usage: ");
        System.out.println("add /nCS2101");
        System.out.println();
    }

    public void printDoneTaskHelp() {
        System.out.println("To mark a task as done:");
        System.out.println("done [INDEX]");
        System.out.println("Example of usage: ");
        System.out.println("done 1");
        System.out.println();
    }

    public void printExitHelp() {
        System.out.println("To quit ZeroNote:");
        System.out.println("exit");
        System.out.println();
    }

    public void printListTaskHelp() {
        System.out.println("To list all tasks: ");
        System.out.println("list");
        System.out.println("To list done tasks: ");
        System.out.println("list /d");
        System.out.println("To list undone tasks: ");
        System.out.println("list /u");
        System.out.println("To list urgent tasks: ");
        System.out.println("list /urgent");
        System.out.println();
    }

    public void printListNotebookSectionPageHelp() {
        printListShelfHelp();
        printListNotebookHelp();
        printListSectionHelp();
        System.out.println();
    }

    public void printListShelfHelp() {
        System.out.println("When no notebook is selected: ");
        System.out.println("To list all notebooks:");
        System.out.println("list");
        System.out.println("To list all notebooks with their sections: ");
        System.out.println("list /s");
        System.out.println("To list all notebooks with their sections and pages: ");
        System.out.println("list /a");
    }

    public void printListNotebookHelp() {
        System.out.println("When a notebook is selected: ");
        System.out.println("To list all sections in the notebook: ");
        System.out.println("list");
        System.out.println("To list all sections in the notebook with their pages: ");
        System.out.println("list /a");
    }

    public void printListSectionHelp() {
        System.out.println("When a section is selected: ");
        System.out.println("To list all pages in the notebook: ");
        System.out.println("list");
    }

    public void printModeSwitchHelp() {
        System.out.println("To switch to timetable mode: ");
        System.out.println("mode /t");
        System.out.println("To switch to notebook mode: ");
        System.out.println("mode /n");
        System.out.println();
    }

    public void printRemoveTaskHelp() {
        System.out.println("To delete an existing task from the task list: ");
        System.out.println("delete [INDEX]");
        System.out.println("Example of usage: ");
        System.out.println("delete 1");
        System.out.println();
    }

    public void printRemoveNotebookSectionPageHelp() {
        System.out.println("To delete and existing notebook, section or page: ");
        System.out.println("delete /n[NOTEBOOK] /s[SECTION] /p[PAGE]");
        System.out.println("Examples of usage: ");
        System.out.println("delete /nCS2113T /sW10 /pJUnit Tests");
        System.out.println("delete /nCS2113T /sW10");
        System.out.println("delete /nCS2113T");
        System.out.println();
    }

    public void printSelectHelp() {
        System.out.println("To select a notebook, section, page, or a combination of the three: ");
        System.out.println("select /n[NOTEBOOK] /s[SECTION] /p[PAGE]");
        System.out.println("Examples of usage: ");
        System.out.println("In any context: ");
        System.out.println("select /nCS2101 /sW2 /pBasics of Streams");
        System.out.println("select /nCS2101 /sW2");
        System.out.println("select /nCS2101");
        System.out.println("select /all");
        System.out.println();
        System.out.println("In a selected notebook");
        System.out.println("select /s1: What is OOP? /pBasics of OOP");
        System.out.println("select /s1: What is OOP?");
        System.out.println();
        System.out.println("In a selected section");
        System.out.println("select /p1");
        System.out.println();
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
        System.out.println("Here are some general commands that will work throughout ZeroNote: ");
        printModeSwitchHelp();
        printExitHelp();
    }

    public void printOnlineGuideLink() {
        System.out.println("Access the full user guide for ZeroNote online, at: ");
        System.out.println("https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html");
        System.out.println();
    }

    public void printAllHelp() {
        System.out.println("Here are all the commands you need to know to operate ZeroNote: ");
        printGeneralHelp();
        printNotebookModeHelp();
        printTimetableModeHelp();
        printOnlineGuideLink();
    }

    public void printGoodBye() {
        System.out.println("Bye!");
    }

    public void printMarkDone(Task task) {
        String markDoneMessage = "Yay! I've marked this task as done:";
        System.out.println(markDoneMessage + "\n " + task);
    }

    public void printTagNotebookMessage(String description, String tag) {
        //        String personalMessage = msgGenerator.generatePersonalisedMessage();
        //        System.out.println(personalMessage);
        String createTagMessage = "Got it! I've tagged this as:\n";
        System.out.println(createTagMessage + description + " (tag: " + tag + ")");
    }

    public void printTagTaskMessage(Task task) {
        //        String personalMessage = msgGenerator.generatePersonalisedMessage();
        //        System.out.println(personalMessage);
        String createTagMessage = "Got it! I've tagged this as:\n";
        System.out.println(createTagMessage + task);
    }

    public void printFoundNotebooksMessages(ArrayList<String> messages) {
        int index = 1;
        for (String message : messages) {
            System.out.println(index + ". " + message + "\n");
            index++;
        }
    }

    public void printLineSeparator() {
        System.out.println("-------------------------------------------------------------");
    }

    @Deprecated
    public void printFoundPagesMessage(ArrayList<Page> pagesFound) {
        int index = 1;
        System.out.println("Pages:");
        for (Page page : pagesFound) {
            System.out.println(index + ". " + page.getTitle());
            index += 1;
        }
    }

    public void printFillInNameOfUserMessage() {
        System.out.println("Hi there! Sorry I don't think we have met, how may I address you?");
    }

}
