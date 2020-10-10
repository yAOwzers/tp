package seedu.duke.userinterface.command;

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

    public Add(TaskList taskArrayList, String input) {
        this.taskArrayList = taskArrayList;
        this.input = input;
    }

    @Override
    public void execute() {
        try {
            String title = InputParser.parseTaskTitle(input);
            taskArrayList.addTask(new Task(title));
            CliMessages.printAddedTaskMessage(title);
        } catch (TaskTitleException t) {
            System.out.println("\tYour task is missing a title!");
            System.out.println("\tPlease type in the format: add /tTITLE");
        } catch (TaskWrongFormatException w) {
            System.out.println("\tPlease type in the format: add /tTITLE");
        }
    }
}
