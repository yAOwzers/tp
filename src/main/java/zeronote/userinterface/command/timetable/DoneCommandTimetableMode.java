package zeronote.userinterface.command.timetable;

import zeronote.exceptions.TaskIndexIncorrectFormatException;
import zeronote.exceptions.TaskIndexOutOfBoundsException;
import zeronote.exceptions.TaskListEmptyException;
import zeronote.exceptions.ZeroNoteException;
import zeronote.tasks.Task;
import zeronote.tasks.TaskList;
import zeronote.userinterface.AppState;
import zeronote.userinterface.CliMessages;
import zeronote.userinterface.command.CliCommand;

public class DoneCommandTimetableMode extends CliCommand {

    public static final String COMMAND_WORD = "done";
    public static final boolean isAutoSave = true;

    private AppState appState;
    private String argument;
    private CliMessages messages = new CliMessages();
    private TaskList taskList;

    public DoneCommandTimetableMode(String argument, AppState appState) {
        this.argument = argument;
        this.appState = appState;
        PRINTS_PERSONAL_MESSAGE = true;
    }

    @Override
    public void execute() throws ZeroNoteException {
        taskList = appState.getTaskList();
        int numberOfTasks = taskList.getNumberOfTasks();
        if (numberOfTasks == 0) {
            throw new TaskListEmptyException();
        }
        try {
            int indexOfNumberAfterDone = Integer.parseInt(this.argument);
            Task taskDone = this.appState.markTaskAsDone(indexOfNumberAfterDone);
            messages.printMarkDone(taskDone);
        } catch (IndexOutOfBoundsException e) {
            throw new TaskIndexOutOfBoundsException(String.valueOf(numberOfTasks));
        } catch (NumberFormatException e) {
            throw new TaskIndexIncorrectFormatException();
        }
    }

    @Override
    public boolean isTriggerAutoSave() {
        return isAutoSave;
    }
}
