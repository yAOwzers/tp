package seedu.duke.userinterface.command.timetable;

import seedu.duke.exceptions.IncorrectAppModeException;
import seedu.duke.exceptions.ZeroNoteException;
import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.tasks.Task;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.command.CliCommand;

public class TagCommandTimetableMode extends CliCommand {
    public static final String COMMAND_WORD = "tag";
    private int indexOfTask;
    private String tag;
    private CliMessages cliMessages = new CliMessages();

    public TagCommandTimetableMode(int index, String tag, AppState appState) {
        indexOfTask = index;
        this.tag = tag;
        assert this.tag != null;
        this.appState = appState;
    }

    public void execute() {
        Task targetTask = appState.getTaskList().getTask(indexOfTask);
        targetTask.setTag(tag);
        cliMessages.printTagTaskMessage(targetTask);
    }
}
