package zer0note.userinterface.command.timetable;

import zer0note.exceptions.TaskWrongFormatException;
import zer0note.exceptions.ZeroNoteException;
import zer0note.tasks.Task;
import zer0note.tasks.TaskList;
import zer0note.userinterface.AppState;
import zer0note.userinterface.CliMessages;
import zer0note.userinterface.InputParser;
import zer0note.userinterface.command.CliCommand;

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
