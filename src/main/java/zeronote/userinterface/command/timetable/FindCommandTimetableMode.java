package zeronote.userinterface.command.timetable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import zeronote.exceptions.InvalidKeywordTagException;
import zeronote.exceptions.ZeroNoteException;
import zeronote.tasks.Task;
import zeronote.tasks.TaskList;
import zeronote.userinterface.AppState;
import zeronote.userinterface.command.CliCommand;

public class FindCommandTimetableMode extends CliCommand {
    public static final String COMMAND_WORD = "find";
    private String keyword;
    private String tag;
    private ArrayList<Task> tasksFound = new ArrayList<>();
    private boolean isPersonalised = true;

    public FindCommandTimetableMode(String keyword, String tag, AppState appState) {
        this.keyword = keyword.toLowerCase();
        this.tag = tag;
        this.appState = appState;
        PRINTS_PERSONAL_MESSAGE = false;
    }

    public void execute() {
        TaskList tasks = appState.getTaskList();
        try {
            if (tag.equals("") && !keyword.equals("")) {
                getTasksWithTitleContainingKeyword(tasks);
            } else if (!tag.equals("") && keyword.equals("")) {
                getTasksWithTagsContainingKeyword(tasks);
            } else {
                throw new InvalidKeywordTagException(keyword + "/t" + tag);
            }
        } catch (ZeroNoteException zne) {
            zne.printErrorMessage();
        }
        System.out.println("Here are the tasks I found:");
        for (Task task : tasksFound) {
            System.out.println(task);
        }
    }

    private void getTasksWithTitleContainingKeyword(TaskList tasks) {
        ArrayList<Task> matchedTasks = new ArrayList<>();
        for (Task task : tasks.getTaskArrayList()) {
            Set<String> wordsInTitle = new HashSet<>(getWordsInTitle(task.getTitle()));
            for (String word : wordsInTitle) {
                if (word.contains(keyword)) {
                    tasksFound.add(task);
                }
            }
        }
    }

    private void getTasksWithTagsContainingKeyword(TaskList tasks) {
        ArrayList<Task> matchedTasks = new ArrayList<>();
        for (Task task : tasks.getTaskArrayList()) {
            String taskTag = task.getTag();
            if (!taskTag.equals("") && taskTag.contains(tag)) {
                tasksFound.add(task);
            }
        }
    }

    public ArrayList<Task> getTasksFound() {
        return tasksFound;
    }

    private List<String> getWordsInTitle(String title) {
        return Arrays.asList(title.toLowerCase().split(" "));
    }

    public boolean isPersonalised() {
        return isPersonalised;
    }

}
