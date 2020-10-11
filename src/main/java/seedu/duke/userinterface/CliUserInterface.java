package seedu.duke.userinterface;

import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.command.Add;
import seedu.duke.userinterface.command.Remove;

import java.lang.String;

import java.util.Scanner;

public class CliUserInterface {
    private static TaskList taskList;
    private static NotebookShelf notebookShelf;

    public CliUserInterface(TaskList taskList, NotebookShelf notebookShelf) {
        this.taskList = taskList;
        this.notebookShelf = notebookShelf;
    }
    
    public void executeCommand(String userInput) throws InvalidCommandException {
        String[] input = userInput.trim().split(" ", 2); // split input into command and arguments
        final String commandWord = input[0];

        switch (commandWord) {
        case Add.COMMAND_WORD:
            String argument = input[1].trim();
            Add add = new Add(taskList, argument);
            add.execute();
            break;
        case Remove.COMMAND_WORD:
            argument = input[1].trim();
            Remove removeCommand = new Remove(taskList, notebookShelf, argument);
            removeCommand.execute();
            break;
        default:
            throw new InvalidCommandException();
        }
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
}
