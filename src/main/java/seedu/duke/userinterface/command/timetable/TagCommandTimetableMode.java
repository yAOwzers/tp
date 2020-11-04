package seedu.duke.userinterface.command.timetable;

import seedu.duke.exceptions.InvalidTagException;
import seedu.duke.tasks.Task;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.command.CliCommand;

public class TagCommandTimetableMode extends CliCommand {
    public static final String COMMAND_WORD = "tag";
    private int index;
    private String tag;
    private static final boolean isAutoSave = true;

    public TagCommandTimetableMode(int index, String tag, AppState appState) {
        this.index = index;
        this.tag = tag;
        assert this.tag != null;
        this.appState = appState;
    }

    public void execute() {
        CliMessages cliMessages = new CliMessages();
        try {
            Task targetTask = appState.getTaskList().getTask(index);
            targetTask.setTag(tag);
            cliMessages.printTagTaskMessage(targetTask);
        } catch (IndexOutOfBoundsException ioe) {
            int numberOfTasks = appState.getTaskList().getNumberOfTasks();
            if (numberOfTasks > 1) {
                System.out.println("Please enter a valid index between 1 and " + numberOfTasks + ".");
            } else if (numberOfTasks == 1) {
                System.out.println("Index can only be 1.");
            } else {
                System.out.println("There are no tasks in the list.");
            }
        } catch (InvalidTagException ite) {
            ite.setProblematicInput("tag " + index + " /t");
            ite.printErrorMessage();
        }
    }

    @Override
    public boolean isTriggerAutoSave() {
        return isAutoSave;
    }

}
