package seedu.duke.userinterface;

import seedu.duke.exceptions.TaskTitleException;
import seedu.duke.exceptions.TaskWrongFormatException;

public class InputParser {
    public static String getTaskTitle(String input) throws TaskWrongFormatException, TaskTitleException {
        if (input.startsWith("/t")) {
            int dividerPosition = input.indexOf("/t");
            String taskTitle = input.substring((dividerPosition+1)).trim();
            if (taskTitle.isBlank()) {
                throw new TaskTitleException();
            }
            return taskTitle;
        } else {
            throw new TaskWrongFormatException();
        }
    }
}
