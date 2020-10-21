package seedu.duke.userinterface;

import seedu.duke.exceptions.IncorrectDeadlineFormatException;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidNotebookException;
import seedu.duke.exceptions.InvalidPageException;
import seedu.duke.exceptions.InvalidSectionException;
import seedu.duke.exceptions.TaskTitleException;
import seedu.duke.exceptions.TaskWrongFormatException;

import seedu.duke.storage.Storage;
import seedu.duke.userinterface.command.CliCommand;
import seedu.duke.userinterface.command.Done;
import seedu.duke.userinterface.command.Exit;
import seedu.duke.userinterface.command.Help;
import seedu.duke.userinterface.command.ModeSwitch;
import seedu.duke.userinterface.command.ModeSwitch;
import seedu.duke.userinterface.command.notebook.AddCommandNotebookMode;
import seedu.duke.userinterface.command.notebook.ListCommandNotebookMode;
import seedu.duke.userinterface.command.notebook.RemoveCommandNotebookMode;
import seedu.duke.userinterface.command.notebook.SelectCommandNotebookMode;
import seedu.duke.userinterface.command.timetable.AddCommandTimetableMode;
import seedu.duke.userinterface.command.timetable.DoneCommandTimetableMode;
import seedu.duke.userinterface.command.timetable.ListCommandTimetableMode;
import seedu.duke.userinterface.command.timetable.RemoveCommandTimetableMode;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static seedu.duke.userinterface.command.notebook.SelectCommandNotebookMode.NOTEBOOK_DELIMITER;
import static seedu.duke.userinterface.command.notebook.SelectCommandNotebookMode.PAGE_DELIMITER;
import static seedu.duke.userinterface.command.notebook.SelectCommandNotebookMode.SECTION_DELIMITER;
import static seedu.duke.userinterface.command.timetable.AddCommandTimetableMode.DEADLINE_DELIMITER;
import static seedu.duke.userinterface.command.timetable.AddCommandTimetableMode.TASK_DELIMITER;

public class InputParser {

    private Storage storage;
    private AppState appState;

    public InputParser(Storage storage, AppState appState) {
        this.storage = storage;
        this.appState = appState;
    }

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
     * @param userInput input from user which contains the deadline.
     *
     * @return deadline
     *
     * @throws IncorrectDeadlineFormatException when the deadline input is in the wrong format.
     * @throws TaskWrongFormatException         when the deadline input is blank.
     */
    public static String parseDeadline(String userInput) throws TaskWrongFormatException, IncorrectDeadlineFormatException {
        int dividerPos = userInput.indexOf(DEADLINE_DELIMITER);
        String input = userInput.substring(dividerPos);
        if (input.startsWith(DEADLINE_DELIMITER)) {
            String deadline = input.replace(DEADLINE_DELIMITER, "").trim();
            System.out.println(deadline);
            if (deadline.isBlank()) {
                throw new TaskWrongFormatException();
            }
//            if (!correctTimeFormat(deadline)) {
//                throw new IncorrectDeadlineFormatException();
//            }
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
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("d MMMM yyyy HHmm");
        try {
            LocalDate date = LocalDate.parse(by, dateTime);
            return true;
        } catch (DateTimeParseException d) {
            return false;
        }
    }

    public static String parseNotebookTitle(String input) throws InvalidNotebookException {
        if (input.startsWith(NOTEBOOK_DELIMITER)) {
            String notebookTitle = input.replace(NOTEBOOK_DELIMITER, "").trim();
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


    public CliCommand getCommandFromInput(String userInput, AppState appState, Storage storage) throws Exception {
        String trimmedInput = userInput.trim();
        String[] input = trimmedInput.split(" ", 2); // split input into command and arguments
        String commandWord = input[0];
        String argument = "";
        if (input.length > 1) {
            argument = input[1].trim();
        }
        switch (commandWord) {
        case AddCommandNotebookMode.COMMAND_WORD:
            if (appState.getAppMode() == AppMode.TIMETABLE) {
                return new AddCommandTimetableMode(argument, appState, storage);
            } else {
                String titleToAdd = "";
                String contentToAdd = "";
                if (appState.getAppMode() == AppMode.NOTEBOOK_SHELF) {
                    titleToAdd = parseNotebookTitle(argument);
                    return new AddCommandNotebookMode(titleToAdd, appState);
                }
                if (appState.getAppMode() == AppMode.NOTEBOOK_BOOK) {
                    titleToAdd = parseSectionTitle(argument);
                    return new AddCommandNotebookMode(titleToAdd, appState);
                }
                // TODO: implement adding pages
                return new AddCommandNotebookMode(titleToAdd, contentToAdd, appState);
            }
        case RemoveCommandTimetableMode.COMMAND_WORD:
            if (appState.getAppMode() == AppMode.TIMETABLE) {
                return new RemoveCommandTimetableMode(parseTaskIndex(argument), appState, storage);
            } else {
                return new RemoveCommandNotebookMode(argument, appState);
            }
        case ListCommandNotebookMode.COMMAND_WORD:
            if (appState.getAppMode() == AppMode.TIMETABLE) {
                return new ListCommandTimetableMode(argument, appState);
            } else {
                return new ListCommandNotebookMode(argument, appState);
            }
        case Exit.COMMAND_WORD:
            return new Exit(argument, appState);
        case Help.COMMAND_WORD:
            return new Help(argument);
        case DoneCommandTimetableMode.COMMAND_WORD:
            return new DoneCommandTimetableMode(argument, appState, storage);
        case ModeSwitch.COMMAND_WORD:
            return new ModeSwitch(argument, appState);
        case SelectCommandNotebookMode.COMMAND_WORD:
            if (appState.getAppMode() != AppMode.TIMETABLE) {
                return new SelectCommandNotebookMode(argument, appState);
            } else {
                throw new InvalidCommandException();
            }
        default:
            throw new InvalidCommandException();
        }
    }
}
