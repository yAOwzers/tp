package seedu.duke.userinterface;

import seedu.duke.exceptions.IncorrectDeadlineFormatException;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidNotebookException;
import seedu.duke.exceptions.InvalidPageException;
import seedu.duke.exceptions.InvalidSectionException;
import seedu.duke.exceptions.TaskTitleException;
import seedu.duke.exceptions.TaskWrongFormatException;

import seedu.duke.userinterface.command.CliCommand;
import seedu.duke.userinterface.command.Done;
import seedu.duke.userinterface.command.Exit;
import seedu.duke.userinterface.command.Help;
import seedu.duke.userinterface.command.ModeSwitch;
import seedu.duke.userinterface.command.notebook.AddCommandNotebookMode;
import seedu.duke.userinterface.command.notebook.ListCommandNotebookMode;
import seedu.duke.userinterface.command.notebook.RemoveCommandNotebookMode;
import seedu.duke.userinterface.command.notebook.SelectCommandNotebookMode;
import seedu.duke.userinterface.command.timetable.AddCommandTimetableMode;
import seedu.duke.userinterface.command.timetable.ListCommandTimetableMode;
import seedu.duke.userinterface.command.timetable.RemoveCommandTimetableMode;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static seedu.duke.userinterface.command.notebook.SelectCommandNotebookMode.NOTEBOOK_DELIMITER;
import static seedu.duke.userinterface.command.notebook.SelectCommandNotebookMode.PAGE_DELIMITER;
import static seedu.duke.userinterface.command.notebook.SelectCommandNotebookMode.SECTION_DELIMITER;
import static seedu.duke.userinterface.command.timetable.AddCommandTimetableMode.DEADLINE_DELIMITER;
import static seedu.duke.userinterface.command.timetable.AddCommandTimetableMode.TASK_DELIMITER;

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
            date = LocalDate.parse(by, dateTime);
            return true;
        } catch (DateTimeParseException d) {
            return false;
        }
    }

    /**
     * Parses user's input to extract notebook title, section title or page number whenever applicable.
     *
     * @param argument contains notebook title, section title or/and page number.
     * @param appState is the state of the application.
     * @throws InvalidNotebookException      when the notebook the user wants to select does not exist.
     * @throws InvalidSectionException       when the section the user wants to select does not exist.
     * @throws InvalidPageException          when the page number the user wants to select does not exist.
     * @throws InvalidSelectCommandException when the select command types by the user is wrong.
     */
    public void extractParams(String argument, AppState appState)
            throws InvalidNotebookException, InvalidSectionException, InvalidPageException,
            InvalidSelectCommandException {
        if (argument.startsWith(NOTEBOOK_DELIMITER)) {
            extractNotebookParams(argument, appState);
        } else if ((argument.startsWith(SECTION_DELIMITER)) && (appState.getAppMode() == AppMode.NOTEBOOK_BOOK)) {
            extractSectionParams(argument, appState);
        } else if ((argument.startsWith(PAGE_DELIMITER)) && (appState.getAppMode() == AppMode.NOTEBOOK_SECTION)) {
            Section section = appState.getCurrentSection();
            int pageNum = parsePageNumber(argument);
            section.getPage(pageNum);
            appState.setCurrentPage(pageNum);
            appState.setAppMode(AppMode.NOTEBOOK_PAGE);
        } else if (argument.startsWith(SHOW_ALL)) {
            appState.setAppMode(AppMode.NOTEBOOK_SHELF);
        } else {
            throw new InvalidSelectCommandException(argument);
        }
    }

    /**
     * Extracts the notebook title, as well as the section title and page number, if provided.
     *
     * @param argument is the user's input.
     * @param appState is the current mode the user is in.
     * @throws InvalidNotebookException when the notebook title input by the user does not exist.
     * @throws InvalidSectionException  when the section title input by the user does not exist.
     * @throws InvalidPageException     when the page number input by the user does not exist.
     */
    public void extractNotebookParams(String argument, AppState appState)
            throws InvalidNotebookException, InvalidSectionException, InvalidPageException {
        Notebook notebook;
        Section section = null;
        String notebookTitle = parseNotebookTitle(argument);
        NotebookShelf notebookShelf = appState.getCurrentBookShelf();
        int notebookIndex = notebookShelf.findNotebook(notebookTitle);
        if (notebookIndex == -1) {
            throw new InvalidNotebookException(notebookTitle);
        }
        notebook = notebookShelf.getNotebookAtIndex(notebookIndex);
        appState.setAppMode(AppMode.NOTEBOOK_BOOK);
        appState.setCurrentNotebook(notebook);
        System.out.println("now in " + appState.getAppMode() + ": " + appState.getCurrentNotebook().getTitle());
        if (argument.contains(SECTION_DELIMITER)) {
            String sectionTitle = parseSectionTitle(argument);
            int sectionIndex = notebook.findSection(sectionTitle);
            if (sectionIndex == -1) {
                throw new InvalidSectionException(sectionTitle);
            }
            section = notebook.getSectionAtIndex(sectionIndex);
            appState.setAppMode(AppMode.NOTEBOOK_SECTION);
            appState.setCurrentSection(section);
            System.out.println("now in " + appState.getAppMode() + ": " + appState.getCurrentSection().getTitle());
        }
        if (argument.contains(PAGE_DELIMITER) && section != null) {
            int pageNum = parsePageNumber(argument);
            section.getPage(pageNum);
        }
    }

    /**
     * Parses the user's input to extract the section title, and the page number if provided by the user.
     *
     * @param argument is the user's input.
     * @param appState is the current mode the user is in.
     * @throws InvalidSectionException when the section title input by the user does not exist.
     * @throws InvalidPageException    when the page number input by the user does not exist.
     */
    public void extractSectionParams(String argument, AppState appState) throws InvalidSectionException,
            InvalidPageException {
        Notebook notebook = appState.getCurrentNotebook();
        String sectionTitle = parseSectionTitle(argument);
        int sectionIndex = notebook.findSection(sectionTitle);
        if (sectionIndex == -1) {
            throw new InvalidSectionException(sectionTitle);
        }
        Section section = notebook.getSectionAtIndex(sectionIndex);
        appState.setAppMode(AppMode.NOTEBOOK_SECTION);
        appState.setCurrentSection(section);
        System.out.println("now in " + appState.getAppMode() + ": " + appState.getCurrentSection().getTitle());
        if (argument.contains(PAGE_DELIMITER)) {
            int pageNum = parsePageNumber(argument);
            if (pageNum > section.getPageArrayList().size()) {
                throw new InvalidPageException(Integer.toString(pageNum + 1));
            }
            section.getPage(pageNum);
        }
    }

    /**
     * Parses notebook title from the user's input.
     *
     * @param input is the input from the user.
     * @return the notebook title input by the user.
     * @throws InvalidNotebookException when user's input is in the wrong format.
     */
    public String parseNotebookTitle(String input) throws InvalidNotebookException {
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
        try {
            int dividerPos = input.indexOf(PAGE_DELIMITER);
            input = input.substring(dividerPos);
        } catch (StringIndexOutOfBoundsException e) {
            throw new InvalidPageException(input);
        }

        if (input.startsWith(PAGE_DELIMITER)) {
            String page = input.replace(PAGE_DELIMITER, "");
            try {
                if (page.isBlank()) {
                    throw new InvalidPageException(page);
                }
                return Integer.parseInt(page) - 1;
            } catch (NumberFormatException e) {
                throw new InvalidPageException(page);
            }
        } else {
            throw new InvalidPageException(input);
        }
    }

    /**
     * Parses the page title input by the user.
     *
     * @param input is the user's input.
     * @return the page title input by the user.
     * @throws InvalidPageException when the user's input is in the wrong format, or when the page title is blank.
     * @throws EmptyPageException   when the user's page input does not contain the content delimiter.
     */
    public String parsePageTitle(String input) throws InvalidPageException, EmptyPageException {
        if (input.startsWith(PAGE_DELIMITER)) {
            String pageTitle = input.replace(PAGE_DELIMITER, "").trim();
            if (pageTitle.isBlank()) {
                throw new InvalidPageException(pageTitle);
            }
            if (!pageTitle.contains(CONTENT_DELIMITER)) {
                throw new EmptyPageException();
            }
            int indexPos = pageTitle.indexOf(CONTENT_DELIMITER);
            pageTitle = pageTitle.substring(0, indexPos).trim();
            return pageTitle;
        } else {
            throw new InvalidPageException(input);
        }
    }

    /**
     * Parses the page contents of the user's input.
     *
     * @param input is the user's input.
     * @return contents in the page input by the user.
     * @throws InvalidPageException when the user's input does not contain the page content delimiter, or when there
     *                              is no content.
     */
    public String parsePageContent(String input) throws InvalidPageException, EmptyPageException {
        int dividerPos = input.indexOf(CONTENT_DELIMITER);
        input = input.substring(dividerPos);

        if (input.startsWith(CONTENT_DELIMITER)) {
            String content = input.replace(CONTENT_DELIMITER, "").trim();
            if (content.isBlank()) {
                throw new EmptyPageException();
            }
            return content;
        } else {
            throw new InvalidPageException(input);
        }
    }

    public String[] parseTagDescription(String input) {
        return input.split(TASK_DELIMITER, 2);
    }

    public CliCommand getCommandFromInput(String userInput, AppState appState) throws ZeroNoteException {
        String trimmedInput = userInput.trim();
        String[] input = trimmedInput.split(" ", 2); // split input into command and arguments
        String commandWord = input[0];
        String argument = "";
        if (input.length > 1) {
            argument = input[1].trim();
        }
        switch (commandWord) {
        case AddCommandTimetableMode.COMMAND_WORD:
            if (appState.getAppMode() == AppMode.TIMETABLE) {
                return new AddCommandTimetableMode(argument, appState);
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
        case ListCommandTimetableMode.COMMAND_WORD:
            if (appState.getAppMode() == AppMode.TIMETABLE) {
                return new ListCommandTimetableMode(argument, appState);
            } else {
                return new ListCommandNotebookMode(argument, appState);
            }
        case RemoveCommandTimetableMode.COMMAND_WORD:
            if (appState.getAppMode() == AppMode.TIMETABLE) {
                return new RemoveCommandTimetableMode(parseTaskIndex(argument), appState);
            } else {
                String notebookTitleToRemove = "";
                String sectionTitleToRemove = "";
                int pageNumberToRemove = -1;
                if (argument.contains(NOTEBOOK_DELIMITER)) {
                    notebookTitleToRemove = parseNotebookTitle(argument);
                }
                if (argument.contains(SECTION_DELIMITER)) {
                    sectionTitleToRemove = parseSectionTitle(argument);
                }
                if (argument.contains(PAGE_DELIMITER)) {
                    pageNumberToRemove = parsePageNumber(argument);
                    if (pageNumberToRemove < 0) {
                        throw new InvalidPageException(Integer.toString(pageNumberToRemove + 1));
                    }
                }
                return new RemoveCommandNotebookMode(notebookTitleToRemove,
                        sectionTitleToRemove, pageNumberToRemove, appState);
            }
        case SelectCommandNotebookMode.COMMAND_WORD:
            if (appState.getAppMode() != AppMode.TIMETABLE) {
                return new SelectCommandNotebookMode(argument, appState);
            } else {
                throw new InvalidCommandException("Please key in the format:");
            }
        case Exit.COMMAND_WORD:
            return new Exit(argument, appState);
        case Help.COMMAND_WORD:
            return new Help(argument);
        case Done.COMMAND_WORD:
            return new Done(argument, appState);
        case ModeSwitch.COMMAND_WORD:
            return new ModeSwitch(argument, appState);
        default:
            throw new InvalidCommandException("Please key in a valid command.");
        }
    }
}
