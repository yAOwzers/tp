package seedu.duke.userinterface.command.timetable;

import seedu.duke.exceptions.IncorrectDeadlineFormatException;
import seedu.duke.exceptions.TaskTitleException;
import seedu.duke.exceptions.TaskWrongFormatException;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.InputParser;
import seedu.duke.userinterface.command.CliCommand;

public class AddCommandTimetableMode extends CliCommand {
    //TODO have subclasses of CliCommand for commands with and without arguments, and the subclass with arguments could
    // contain these fields to be overridden.
    public static final String COMMAND_WORD = "add";
    public static final String TASK_DELIMITER = "/t";
    public static final String DEADLINE_DELIMITER = "/by";
    private static InputParser parser;
    private final String argument;
    private final CliMessages messages = new CliMessages();

    public AddCommandTimetableMode(String argument, AppState appState) {
        this.appState = appState;
        this.argument = argument;
    }

    @Override
    public void execute() {
        parser = new InputParser();
        TaskList currentTaskList = appState.getTaskList();
        try {
            if (argument.contains("/by")) {
                String title = InputParser.parseTaskTitle(argument);
                String deadline = InputParser.parseDeadline(argument);
                currentTaskList.addTask(new Task(title, deadline));
                messages.printAddedTaskMessage(currentTaskList, title);
            } else {
                throw new TaskWrongFormatException();
            }
            // TODO AddTimetable more OOP: catch exceptions in CliUserInterface,
            //  and use an inherited printErrorMessage() method
        } catch (TaskTitleException t) {
            System.out.println("\tYour task is missing a title!");
            System.out.println("\tPlease type in the format: add /tTITLE /byDEADLINE");
        } catch (ArrayIndexOutOfBoundsException | TaskWrongFormatException w) {
            System.out.println("\tPlease type in the format: add /tTITLE /byDEADLINE");
        } catch (IncorrectDeadlineFormatException d) {
            System.out.println("\tOops! Your deadline should be in this format");
            System.out.println("\tdd-MM-yyyy HHmm where time is in 24h");
        }
    }
}
