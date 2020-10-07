package seedu.duke.tasks;

//deadline stuff not in  v.01?
import java.time.LocalDate;
import java.time.LocalTime;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String title;
    private LocalDate dueDate;
    private LocalTime dueTime;
    protected boolean isDone;

    public Task(String title) {
        this.title = title;
        this.isDone = false;
    }
}
