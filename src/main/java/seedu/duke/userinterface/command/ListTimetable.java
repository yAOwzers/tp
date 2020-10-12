package seedu.duke.userinterface.command;

import seedu.duke.tasks.Task;
import seedu.duke.userinterface.Mode;

public class ListTimetable extends CliCommand {

    public ListTimetable(String argument, Mode uiMode) {
        this.setUiMode(uiMode);
        this.commandParams = argument;
    }

    @Override
    public void execute() {
        switch (commandParams) {
        case "/d":
            printDoneTasks();
            break;
        case "/u":
            printUndoneTasks();
            break;
        default:
            printAllTasks();
            break;
        }
    }

    private void printAllTasks() {
        for (Task task: applicationState.getTaskList().getTaskArrayList()) {
            System.out.println(task);
        }
    }

    private void printDoneTasks() {
        for (Task task: applicationState.getTaskList().getTaskArrayList()) {
            if (task.isDone()) {
                System.out.println(task);
            }
        }
    }

    private void printUndoneTasks() {
        for (Task task: applicationState.getTaskList().getTaskArrayList()) {
            if (!task.isDone()) {
                System.out.println(task);
            }
        }
    }

}
