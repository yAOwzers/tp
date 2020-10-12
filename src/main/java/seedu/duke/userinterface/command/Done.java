package seedu.duke.userinterface.command;

import seedu.duke.exceptions.InvalidUserInputException;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.CliUserInterface;

public class Done extends CliCommand {

    public static final String COMMAND_WORD = "done";

    private TaskList taskList;
    private NotebookShelf notebookShelf;
    private String userInput;
    private CliUserInterface ui;

    public Done(TaskList taskList, NotebookShelf notebookShelf, String userInput, CliUserInterface ui) {
        this.taskList = taskList;
        this.notebookShelf = notebookShelf;
        this.userInput = userInput;
        this.ui = ui;
    }

    @Override
    public void execute() throws InvalidUserInputException {
        // Retrieves the number after the 'done' keyword
        if(this.userInput.length() == 4) {
            throw new InvalidUserInputException(userInput);
        }
            try {
                String intSubstring = this.userInput.substring(5);
                int indexOfNumberAfterDone = Integer.parseInt(intSubstring);
                Task taskDone = this.taskList.markAsDone(indexOfNumberAfterDone);
                ui.showMarkDone(taskDone);
            } catch (NumberFormatException e) {
                System.out.println("I'm sorry, please enter a valid number!");
            }
    }


}
