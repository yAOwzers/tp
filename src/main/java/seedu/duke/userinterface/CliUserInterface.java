package seedu.duke.userinterface;

import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.command.Remove;

import java.util.Scanner;

public class CliUserInterface {
    private final TaskList taskList;
    private final NotebookShelf notebookShelf;

    public CliUserInterface(TaskList taskList, NotebookShelf notebookShelf) {
        this.taskList = taskList;
        this.notebookShelf = notebookShelf;
    }

    public void startUI() {
        String logo = " ____        _        \n"
                    + "|  _ \\ _   _| | _____ \n"
                    + "| | | | | | | |/ / _ \\\n"
                    + "| |_| | |_| |   <  __/\n"
                    + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
    }

    public void executeCommand(String userInput) throws InvalidCommandException {
        String[] input = userInput.trim().split(" ", 2);
        final String commandWord = input[0];
        final String argument = userInput.replace(commandWord, "").trim();

        switch (commandWord) {
        case Remove.COMMAND_WORD:
            Remove removeCommand = new Remove(taskList, notebookShelf, argument);
            removeCommand.execute();
            break;
        default:
            throw new InvalidCommandException();
        }
    }
}
