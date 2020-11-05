package zeronote.userinterface.command.timetable;

import zeronote.exceptions.TaskWrongFormatException;
import zeronote.exceptions.ZeroNoteException;
import zeronote.tasks.Task;
import zeronote.tasks.TaskList;
import zeronote.userinterface.AppState;
import zeronote.userinterface.CliMessages;
import zeronote.userinterface.InputParser;
import zeronote.userinterface.command.CliCommand;

public class AddCommandTimetableMode extends CliCommand {
    public static final String COMMAND_WORD = "add";
    public static final String TASK_DELIMITER = "/t";
    public static final String DEADLINE_DELIMITER = "/by";
    private final String argument;
    private final CliMessages messages = new CliMessages();
    private static final boolean isAutoSave = true;


    public AddCommandTimetableMode(String argument, AppState appState) {
        this.appState = appState;
        this.argument = argument;
        PRINTS_PERSONAL_MESSAGE = true;
    }

    @Override
    public void execute() {
        InputParser parser = new InputParser();
        TaskList currentTaskList = appState.getTaskList();
        try {
            if (argument.contains(DEADLINE_DELIMITER)) {
                String title = parser.parseTaskTitle(argument);
                String deadline = parser.parseDeadline(argument);
                currentTaskList.addTask(new Task(title, deadline));
                messages.printAddedTaskMessage(currentTaskList, title);
            } else {
                throw new TaskWrongFormatException();
            }
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("\tPlease type in the format: add /tTITLE /byDEADLINE");
        } catch (ZeroNoteException z) {
            z.printErrorMessage();
        }
    }

    @Override
    public boolean isTriggerAutoSave() {
        return isAutoSave;
    }
}
