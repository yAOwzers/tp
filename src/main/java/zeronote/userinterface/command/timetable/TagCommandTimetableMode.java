package zeronote.userinterface.command.timetable;

import zeronote.exceptions.InvalidTagException;
import zeronote.tasks.Task;
import zeronote.userinterface.AppState;
import zeronote.userinterface.CliMessages;
import zeronote.userinterface.command.CliCommand;

public class TagCommandTimetableMode extends CliCommand {
    public static final String COMMAND_WORD = "tag";
    private int index;
    private String tag;
    private boolean isPersonalised = true;
    private static final boolean isAutoSave = true;

    public TagCommandTimetableMode(int index, String tag, AppState appState) {
        this.index = index;
        this.tag = tag;
        assert this.tag != null;
        this.appState = appState;
        PRINTS_PERSONAL_MESSAGE = true;
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
            ite.setProblematicInput("tag " + index + " /t" + tag);
            ite.printErrorMessage();
        }
    }

    @Override
    public boolean isTriggerAutoSave() {
        return isAutoSave;
    }

}
