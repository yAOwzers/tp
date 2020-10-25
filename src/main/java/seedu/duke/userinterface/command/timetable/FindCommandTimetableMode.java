package seedu.duke.userinterface.command.timetable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.duke.tasks.Task;
import seedu.duke.tasks.TaskList;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.command.CliCommand;

public class FindCommandTimetableMode extends CliCommand {
    public static final String COMMAND_WORD = "find";
    private String keyword;
    private String tag;

    public FindCommandTimetableMode(String keyword, String tag, AppState appState) {
        this.keyword = keyword;
        this.tag = tag.toLowerCase();
        this.appState = appState;
    }

    public void execute() {
        ArrayList<Task> tasksFound = new ArrayList<Task>();
        TaskList tasks = appState.getTaskList();
        if (tag.equals("")) {
            tasksFound = getTasksWithTitleContainingKeyword(tasks);
        } else {
            tasksFound = getTasksWithTagsContainingKeyword(tasks);
        }
        System.out.println("Here are the tasks I found:");
        for (Task task : tasksFound) {
            System.out.println(task);
        }
    }

    private ArrayList<Task> getTasksWithTitleContainingKeyword(TaskList tasks) {
        ArrayList<Task> matchedTasks = new ArrayList<>();
        for (int i = 0; i < tasks.getNumberOfTasks(); i++) {
            Task task = tasks.getTask(i);
            Set<String> wordsInTitle = new HashSet<>(getWordsInTag(task.getTitle()));
            if (wordsInTitle.contains(keyword)) {
                matchedTasks.add(task);
            }
        }
        return matchedTasks;
    }

    private ArrayList<Task> getTasksWithTagsContainingKeyword(TaskList tasks) {
        ArrayList<Task> matchedTasks = new ArrayList<>();
        for (int i = 0; i < tasks.getNumberOfTasks(); i++) {
            Task task = tasks.getTask(i);
            Set<String> wordsInTag = new HashSet<>(getWordsInTag(task.getTag()));
            for (String word : wordsInTag) {
                if (!tag.equals("") && word.contains(tag)) {
                    matchedTasks.add(task);
                }
            }
        }
        return matchedTasks;
    }

    private List<String> getWordsInTag(String description) {
        return Arrays.asList(description.toLowerCase().split(" "));
    }
}
