package seedu.duke.userinterface;

import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.TaskTitleException;
import seedu.duke.exceptions.TaskWrongFormatException;
import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.command.Add;

import java.lang.String;
import java.util.Scanner;

public class CliUserInterface {
    private static int numberOfTasks;
    private static TaskList list;
    public Add add;

    public CliUserInterface(TaskList list, int numberOfTasks) {
        this.list = list;
        this.numberOfTasks = numberOfTasks;
    }

    public void executeCommand(String userInput) throws Exception {
        String[] input = userInput.trim().split(" ", 2); // split input into command and arguments
        final String commandWord = input[0];
        final String argument = userInput.replace(commandWord, "").trim();

        add = new Add(list, argument);

        switch(commandWord) {
        case Add.COMMAND_WORD:
            add.execute();
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
