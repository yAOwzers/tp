package seedu.duke.userinterface;

import seedu.duke.exceptions.IncorrectDeadlineFormatException;
import seedu.duke.exceptions.TaskTitleException;
import seedu.duke.exceptions.TaskWrongFormatException;

import static seedu.duke.userinterface.command.Add.TASK_DELIMITER;

public class InputParser {
    public static String parseTaskTitle(String input) throws TaskWrongFormatException, TaskTitleException {
        if (input.startsWith(TASK_DELIMITER)) {
            String taskTitle = input.replace(TASK_DELIMITER, "");
            if (taskTitle.isBlank()) {
                throw new TaskTitleException();
            }
            return taskTitle;
        } else {
            throw new TaskWrongFormatException();
        }
    }

    public static String parseDeadline(String input) throws IncorrectDeadlineFormatException {
        String deadline = " ";
        return deadline;
    }
}
