package zeronote.userinterface.command.timetable;

import zeronote.tasks.Task;

import java.util.Comparator;

public class SortByDate implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        if (o1.getDueDateTime() == null || o2.getDueDateTime() == null) {
            return 0;
        }
        return o1.getDueDateTime().compareTo(o2.getDueDateTime());
    }
}
