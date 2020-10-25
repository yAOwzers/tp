package seedu.duke.userinterface;

import seedu.duke.exceptions.EmptyPageException;
import seedu.duke.exceptions.IncorrectAppModeException;
import seedu.duke.exceptions.IncorrectDeadlineFormatException;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidNotebookException;
import seedu.duke.exceptions.InvalidPageException;
import seedu.duke.exceptions.InvalidSectionException;
import seedu.duke.exceptions.NotebookOutOfBoundsException;
import seedu.duke.exceptions.TaskTitleException;
import seedu.duke.exceptions.TaskWrongFormatException;
import seedu.duke.exceptions.ZeroNoteException;

import seedu.duke.storage.Storage;

import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Section;

import seedu.duke.userinterface.command.CliCommand;
import seedu.duke.userinterface.command.timetable.DoneCommandTimetableMode;
import seedu.duke.userinterface.command.Exit;
import seedu.duke.userinterface.command.Help;
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

import static seedu.duke.userinterface.command.notebook.AddCommandNotebookMode.CONTENT_DELIMITER;
import static seedu.duke.userinterface.command.notebook.AddCommandNotebookMode.NOTEBOOK_DELIMITER;
import static seedu.duke.userinterface.command.notebook.AddCommandNotebookMode.PAGE_DELIMITER;
import static seedu.duke.userinterface.command.notebook.AddCommandNotebookMode.SECTION_DELIMITER;
import static seedu.duke.userinterface.command.notebook.SelectCommandNotebookMode.SHOW_ALL;
import static seedu.duke.userinterface.command.timetable.AddCommandTimetableMode.DEADLINE_DELIMITER;
import static seedu.duke.userinterface.command.timetable.AddCommandTimetableMode.TASK_DELIMITER;

public class InputParser {

    private Storage storage;
    private AppState appState;

    public InputParser(Storage storage, AppState appState) {
        this.storage = storage;
        this.appState = appState;
    }

    /**
     * Parses the user's input to extract the task title in TIMETABLE mode.
     *
     * @param input is the user's input.
     * @return the task title.
     * @throws TaskWrongFormatException when the user's input does not include the TASK_DELIMITER.
     * @throws TaskTitleException       when the user's input does not include a task title.
     */
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
     *
     * @param userInput is the user's input.
     * @return deadline in the format dd-MM-yyyy hhMM, where time is in 24h format.
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
            // TODO fix the formatting issue
//            if (!correctTimeFormat(deadline)) {
//                throw new IncorrectDeadlineFormatException();
//            }
            return deadline;
        } else {
            throw new IncorrectDeadlineFormatException();
        }
    }

    // TODO fix this method
    /**
     * Checks if [deadline] input by the user is in the correct format.
     *
     * @param by is the string containing the deadline's due date and time.
     * @return true when the input is in the correct format, otherwise false.
     */
    private static boolean correctTimeFormat(String by) {
//<<<<<<< HEAD
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("d MMMM yyyy HHmm");
//=======
//        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm");
//>>>>>>> 8ee1100b93925d06ca6c03f253d64f4ce65bb453
        try {
            LocalDate date = LocalDate.parse(by, dateTime);
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
     */
    public void extractParams(String argument, AppState appState)
            throws InvalidNotebookException, InvalidSectionException, InvalidPageException, InvalidCommandException,
            NotebookOutOfBoundsException {
        if (argument.startsWith(NOTEBOOK_DELIMITER)) {
            extractNotebookParams(argument, appState);
        } else if (argument.startsWith(SECTION_DELIMITER)) {
            extractSectionParams(argument, appState);
        } else if (argument.startsWith(PAGE_DELIMITER)) {
            Section section = appState.getCurrentSection();
            int pageNum = parsePageNumber(argument);
            section.getPage(pageNum);
        } else if (argument.startsWith(SHOW_ALL)) {
            appState.setAppMode(AppMode.NOTEBOOK_SHELF);
        } else {
            throw new InvalidCommandException(argument);
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
            throws InvalidNotebookException, InvalidSectionException, InvalidPageException,
            NotebookOutOfBoundsException {
        Notebook notebook;
        Section section = null;
        String notebookTitle = parseNotebookTitle(argument);
        NotebookShelf notebookShelf = appState.getCurrentNotebookShelf();
        int notebookIndex = notebookShelf.findNotebook(notebookTitle);
        if (notebookIndex == -1) {
            throw new InvalidNotebookException(notebookTitle);
        }
        notebook = notebookShelf.getNotebookAtIndex(notebookIndex);
        appState.setAppMode(AppMode.NOTEBOOK_BOOK);
        appState.setCurrentNotebook(notebook);
        System.out.println("now in " + appState.getAppMode() + ": " + appState.getCurrentNotebook().getTitle());
        if (argument.contains(SECTION_DELIMITER)) {
            String sectionTitle = InputParser.parseSectionTitle(argument);
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
                throw new InvalidPageException();
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
    public static String parseNotebookTitle(String input) throws InvalidNotebookException {
        if (input.startsWith(NOTEBOOK_DELIMITER)) {
            String notebookTitle = input.replace(NOTEBOOK_DELIMITER, "").trim();
            if (notebookTitle.isBlank()) {
                throw new InvalidNotebookException(null);
            }
            if (notebookTitle.contains(SECTION_DELIMITER)) {
                int indexPos = notebookTitle.indexOf(SECTION_DELIMITER);
                notebookTitle = notebookTitle.substring(0, indexPos).trim();
            }
            return notebookTitle;
        } else {
            throw new InvalidNotebookException(input);
        }
    }

    /**
     * Parses section title from the user's input.
     *
     * @param input is the user's input.
     * @return the section title input by the user.
     * @throws InvalidSectionException when the user's input does not contain the section delimiter, or when the
     *                                 section title is blank.
     */
    public static String parseSectionTitle(String input) throws InvalidSectionException {
        try {
            int dividerPos = input.indexOf(SECTION_DELIMITER);
            input = input.substring(dividerPos);
        } catch (StringIndexOutOfBoundsException e) {
            throw new InvalidSectionException(input);
        }

        if (input.startsWith(SECTION_DELIMITER)) {
            String sectionTitle = input.replace(SECTION_DELIMITER, "");
            if (sectionTitle.isBlank()) {
                throw new InvalidSectionException(null);
            }
            if (sectionTitle.contains(PAGE_DELIMITER)) {
                int indexPos = sectionTitle.indexOf(PAGE_DELIMITER);
                sectionTitle = sectionTitle.substring(0, indexPos).trim();
            }
            return sectionTitle;
        } else {
            throw new InvalidSectionException(input);
        }
    }

    public int parseTaskIndex(String args) throws NumberFormatException {
        return Integer.parseInt(args) - 1;
    }

    /**
     * Parses the page number input by the user.
     *
     * @param input is the user's input.
     * @return the page number input by the user.
     * @throws InvalidPageException when the page input by the user is blank, or when the user's input is in the
     *                              wrong format.
     */
    public int parsePageNumber(String input) throws InvalidPageException {
        try {
            int dividerPos = input.indexOf(PAGE_DELIMITER);
            input = input.substring(dividerPos);
        } catch (StringIndexOutOfBoundsException e) {
            throw new InvalidPageException();
        }

        if (input.startsWith(PAGE_DELIMITER)) {
            try {
                String page = input.replace(PAGE_DELIMITER, "");
                if (page.isBlank()) {
                    throw new InvalidPageException();
                }
                return Integer.parseInt(page) - 1;
            } catch (NumberFormatException e) {
                throw new InvalidPageException();
            }
        } else {
            throw new InvalidPageException();
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
                throw new InvalidPageException();
            }
            if (!pageTitle.contains(CONTENT_DELIMITER)) {
                throw new EmptyPageException();
            }
            int indexPos = pageTitle.indexOf(CONTENT_DELIMITER);
            pageTitle = pageTitle.substring(0, indexPos).trim();
            return pageTitle;
        } else {
            throw new InvalidPageException();
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
            throw new InvalidPageException();
        }
    }

    public CliCommand getCommandFromInput(String userInput, AppState appState, Storage storage) throws ZeroNoteException {
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
                return new AddCommandTimetableMode(argument, appState, storage);
            } else {
                String titleToAdd;
                String contentToAdd;
                if (appState.getAppMode() == AppMode.NOTEBOOK_SHELF) {
                    titleToAdd = parseNotebookTitle(argument);
                    return new AddCommandNotebookMode(titleToAdd, appState, storage);
                } else if (appState.getAppMode() == AppMode.NOTEBOOK_BOOK) {
                    titleToAdd = parseSectionTitle(argument);
                    return new AddCommandNotebookMode(titleToAdd, appState, storage);
                } else if (appState.getAppMode() == AppMode.NOTEBOOK_SECTION) {
                    titleToAdd = parsePageTitle(argument);
                    contentToAdd = parsePageContent(argument);
                    return new AddCommandNotebookMode(titleToAdd, contentToAdd, appState, storage);
                } else {
                    throw new InvalidCommandException(userInput);
                }
            }
        case ListCommandTimetableMode.COMMAND_WORD:
            if (appState.getAppMode() == AppMode.TIMETABLE) {
                return new ListCommandTimetableMode(argument, appState);
            } else {
                return new ListCommandNotebookMode(argument, appState);
            }
        case RemoveCommandTimetableMode.COMMAND_WORD:
            if (appState.getAppMode() == AppMode.TIMETABLE) {
                return new RemoveCommandTimetableMode(parseTaskIndex(argument), appState, storage);
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
                }
                return new RemoveCommandNotebookMode(notebookTitleToRemove,
                        sectionTitleToRemove, pageNumberToRemove, appState);
            }
        case SelectCommandNotebookMode.COMMAND_WORD:
            if (appState.getAppMode() != AppMode.TIMETABLE) {
                return new SelectCommandNotebookMode(argument, appState);
            } else {
                throw new IncorrectAppModeException();
            }
        case Exit.COMMAND_WORD:
            return new Exit(argument, appState);
        case Help.COMMAND_WORD:
            return new Help(argument);
        case DoneCommandTimetableMode.COMMAND_WORD:
            return new DoneCommandTimetableMode(argument, appState, storage);
        case ModeSwitch.COMMAND_WORD:
            return new ModeSwitch(argument, appState);
        default:
            throw new InvalidCommandException(userInput);
        }
    }
}
