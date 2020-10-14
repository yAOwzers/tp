package seedu.duke.userinterface;

import seedu.duke.exceptions.IncorrectDeadlineFormatException;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidNotebookException;
import seedu.duke.exceptions.InvalidPageException;
import seedu.duke.exceptions.InvalidSectionException;
import seedu.duke.exceptions.TaskTitleException;
import seedu.duke.exceptions.TaskWrongFormatException;
import seedu.duke.userinterface.command.CliCommand;
import seedu.duke.userinterface.command.Exit;
import seedu.duke.userinterface.command.Help;
import seedu.duke.userinterface.command.ModeSwitch;
import seedu.duke.userinterface.command.notebook.Select;
import seedu.duke.userinterface.command.timetable.Add;
import seedu.duke.userinterface.command.timetable.List;
import seedu.duke.userinterface.command.timetable.Remove;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static seedu.duke.userinterface.command.notebook.Select.*;
import static seedu.duke.userinterface.command.timetable.Add.DEADLINE_DELIMITER;
import static seedu.duke.userinterface.command.timetable.Add.TASK_DELIMITER;

public class InputParser {
    public static String parseTaskTitle(String input) throws TaskWrongFormatException, TaskTitleException {
        if (input.startsWith(TASK_DELIMITER)) {
            String taskTitle = input.replace(TASK_DELIMITER, "");
            if (taskTitle.isBlank()) {
                throw new TaskTitleException();
            }
            int indexPos = taskTitle.indexOf("/by");
            taskTitle = taskTitle.substring(0, indexPos).trim();
            return taskTitle;
        } else {
            throw new TaskWrongFormatException();
        }
    }

    /**
     * Parses user's input to extract deadline.
     *
     * @param input input from user which contains the deadline.
     *
     * @return deadline
     *
     * @throws IncorrectDeadlineFormatException when the deadline input is in the wrong format.
     * @throws TaskWrongFormatException         when the deadline input is blank.
     */
    public static String parseDeadline(String input) throws TaskWrongFormatException, IncorrectDeadlineFormatException {
        int dividerPos = input.indexOf(DEADLINE_DELIMITER);
        input = input.substring(dividerPos);
        if (input.startsWith(DEADLINE_DELIMITER)) {
            String deadline = input.replace(DEADLINE_DELIMITER, "").trim();
            if (deadline.isBlank()) {
                throw new TaskWrongFormatException();
            }
            if (!correctTimeFormat(deadline)) {
                throw new IncorrectDeadlineFormatException();
            }
            return deadline;
        } else {
            throw new IncorrectDeadlineFormatException();
        }
    }

    /**
     * Checks if [deadline] input by the user is in the correct format.
     *
     * @param by is the string containing the deadline's due date and time.
     *
     * @return true when the input is in the correct format, otherwise false.
     */
    private static boolean correctTimeFormat(String by) {
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm");
        LocalDate date = null;
        try {
            System.out.println(by);
            date = LocalDate.parse(by, dateTime);
            return true;
        } catch (DateTimeParseException d) {
            return false;
        }
    }

    public static String parseNotebookTitle(String input) throws InvalidNotebookException {
        if (input.startsWith(NOTEBOOK_DELIMITER)) {
            String notebookTitle = input.replace(NOTEBOOK_DELIMITER, "");
            if (notebookTitle.isBlank()) {
                throw new InvalidNotebookException();
            }
            if (notebookTitle.contains(SECTION_DELIMITER)) {
                int indexPos = notebookTitle.indexOf(SECTION_DELIMITER);
                notebookTitle = notebookTitle.substring(0, indexPos).trim();
            }
            return notebookTitle;
        } else {
            throw new InvalidNotebookException();
        }
    }

    public static String parseSectionTitle(String input) throws InvalidSectionException {
        int dividerPos = input.indexOf(SECTION_DELIMITER);
        input = input.substring(dividerPos);
        if (input.startsWith(SECTION_DELIMITER)) {
            String sectionTitle = input.replace(SECTION_DELIMITER, "");
            if (sectionTitle.isBlank()) {
                throw new InvalidSectionException();
            }
            if (sectionTitle.contains(PAGE_DELIMITER)) {
                int indexPos = sectionTitle.indexOf(PAGE_DELIMITER);
                sectionTitle = sectionTitle.substring(0, indexPos).trim();
            }
            return sectionTitle;
        } else {
            throw new InvalidSectionException();
        }
    }

    public int parseTaskIndex(String args) throws NumberFormatException {
        return Integer.parseInt(args) - 1;
    }

    public int parsePageNumber(String input) throws InvalidPageException {
        int dividerPos = input.indexOf(PAGE_DELIMITER);
        input = input.substring(dividerPos);
        if (input.startsWith(PAGE_DELIMITER)) {
            String page = input.replace(PAGE_DELIMITER, "");
            if (page.isBlank()) {
                throw new InvalidPageException();
            }
            int pageNum = Integer.parseInt(page);
            return pageNum;
        } else {
            throw new InvalidPageException();
        }
    }

    public CliCommand getCommandFromInput(String userInput, AppState appState) throws Exception {
        String trimmedInput = userInput.trim();
        String[] input = trimmedInput.split(" ", 2); // split input into command and arguments
        String commandWord = input[0];
        String argument = "";
        if (input.length > 1) {
            argument = input[1].trim();
        }

        switch (commandWord) {
        case seedu.duke.userinterface.command.notebook.Add.COMMAND_WORD:
            if (appState.getAppMode() == AppMode.TIMETABLE) {
                return new Add(argument, appState);
            } else {
                String titleToAdd;
                String contentToAdd;
                if (appState.getAppMode() == AppMode.NOTEBOOK_SHELF) {
                    titleToAdd = parseNotebookTitle(argument);
                } else if (appState.getAppMode() == AppMode.NOTEBOOK_BOOK) {
                    titleToAdd = parseSectionTitle(argument);
                } else {
                    // TODO: implement adding pages
                    titleToAdd = "";
                    contentToAdd = "";
                }
                return new seedu.duke.userinterface.command.notebook.Add(titleToAdd, appState);
            }
        case Remove.COMMAND_WORD:
            if (appState.getAppMode() == AppMode.TIMETABLE) {
                return new Remove(parseTaskIndex(argument), appState);
            } else {
                return new seedu.duke.userinterface.command.notebook.Remove(argument, appState);
            }
        case seedu.duke.userinterface.command.notebook.List.COMMAND_WORD:
            if (appState.getAppMode() == AppMode.TIMETABLE) {
                return new List(argument, appState);
            } else {
                return new seedu.duke.userinterface.command.notebook.List(argument, appState);
            }
        case Exit.COMMAND_WORD:
            return new Exit(argument, appState);
        case Help.COMMAND_WORD:
            return new Help(argument);
        case ModeSwitch.COMMAND_WORD:
            return new ModeSwitch(argument, appState);
        case Select.COMMAND_WORD:
            if (appState.getAppMode() != AppMode.TIMETABLE) {
                return new Select(argument, appState);
            } else {
                throw new InvalidCommandException();
            }
        default:
            throw new InvalidCommandException();
        }
    }
}
