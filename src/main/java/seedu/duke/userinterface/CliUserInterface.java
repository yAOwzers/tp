package seedu.duke.userinterface;

import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.command.Add;
import seedu.duke.userinterface.command.CliCommand;

import java.lang.String;
import java.util.Scanner;

public class CliUserInterface {
    private static int numberOfTasks;
    private static TaskList list;
    private static AppState appState;
    public Add add;

    public CliUserInterface(TaskList list, int numberOfTasks) {
        this.list = list;
        this.numberOfTasks = numberOfTasks;
    }

    public void executeCommand(String userInput) throws Exception {

        InputParser parser = new InputParser();
        CliCommand command = parser.getCommandFromInput(userInput, appState);
        command.execute();

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
