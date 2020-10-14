package seedu.duke.userinterface.command;

import seedu.duke.tasks.Task;
import seedu.duke.userinterface.AppState;

public class ListTimetable extends CliCommand {

    public ListTimetable(String argument, AppState appState) {
        this.setAppState(appState);
        this.commandParams = argument;
    }

    @Override
    public void execute() {
        try {
            if (appState.getTaskList().getTaskArrayList().size() == 0) {
                System.out.println("The list of tasks is empty");
                return;
            }
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
        } catch (NullPointerException e) {
            System.out.println("The list of tasks is empty");
        }

    }

    private void printAllTasks() {
        for (Task task : appState.getTaskList().getTaskArrayList()) {
            System.out.println(task);
        }
    }

    private void printDoneTasks() {
        for (Task task : appState.getTaskList().getTaskArrayList()) {
            if (task.isDone()) {
                System.out.println(task);
            }
        }
    }

    private void printUndoneTasks() {
        for (Task task : appState.getTaskList().getTaskArrayList()) {
            if (!task.isDone()) {
                System.out.println(task);
            }
        }
    }

}
