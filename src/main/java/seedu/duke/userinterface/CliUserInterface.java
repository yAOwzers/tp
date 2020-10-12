package seedu.duke.userinterface;

import seedu.duke.exceptions.InvalidCommandException;
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
        final String argument = input[1].trim();

        switch (commandWord) {
        case Add.COMMAND_WORD:
            add = new Add(list, argument);
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

    public void showMarkDone(Task task) {
        String markDoneMessage = "Yay! I've marked these task as done:";
        String taskDetails = task.getTask();
        System.out.println(markDoneMessage + "\n " + taskDetails + "\n");
    }

    public String printExit() {
        return "GOODBYE HOPE TO SEE YOU AGAIN";
    }

}
