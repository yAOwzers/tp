package seedu.duke.userinterface;

import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.command.CliCommand;

import java.lang.String;

import java.util.Scanner;

public class CliUserInterface {
    private static TaskList taskList;
    private static AppState appState;

    public CliUserInterface(TaskList taskList, NotebookShelf notebookShelf) {
        this.taskList = taskList;
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
