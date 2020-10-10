package seedu.duke.userinterface.command;

import seedu.duke.exceptions.IncorrectDeadlineFormatException;
import seedu.duke.exceptions.TaskTitleException;
import seedu.duke.exceptions.TaskWrongFormatException;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.InputParser;

public class Add extends CliCommand {
    public static final String COMMAND_WORD = "add";
    public static final String TASK_DELIMITER = "/t";
    public static final String DEADLINE_DELIMITER = "/by";
    private final TaskList taskArrayList;
    private String input;
    private static InputParser parser;

    public Add(TaskList taskArrayList, String input) {
        this.taskArrayList = taskArrayList;
        this.input = input;
    }

    @Override
    public void execute() {
        parser = new InputParser();
        try {
            if (input.contains("/by")) {
                String title = parser.parseTaskTitle(input);
                String deadline = parser.parseDeadline(input);
                taskArrayList.addTask(new Task(title, deadline));
                CliMessages.printAddedTaskMessage(taskArrayList, title);
            } else {
                throw new TaskWrongFormatException();
            }
        } catch (TaskTitleException t) {
            System.out.println("\tYour task is missing a title!");
            System.out.println("\tPlease type in the format: add /tTITLE /byDEADLINE");
        } catch (ArrayIndexOutOfBoundsException | TaskWrongFormatException w) {
            System.out.println("\tPlease type in the format: add /tTITLE /byDEADLINE");
        } catch (IncorrectDeadlineFormatException d) {
            System.out.println("\tOops! Your deadline should be in this format");
            System.out.println("\tdd/MM/yyyy HHmm where time is in 24h");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
