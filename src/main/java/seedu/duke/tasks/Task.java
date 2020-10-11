package seedu.duke.tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Task {
    private final String title;
    private final String by;
    private LocalDate dueDate;
    private LocalTime dueTime;

    protected DateFormat dateTime = new SimpleDateFormat("dd-MM-yyyy HHmm"); // in 24h format
    protected DateFormat outputFormat = new SimpleDateFormat("MMM dd yyyy hh.mm aa");
    protected boolean isDone;

    public Task(String title, String by) {
        this.title = title;
        this.by = by;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "o" : "x");
    }

    public String reformatDate() throws ParseException {
        Date date = dateTime.parse(by);
        return outputFormat.format(date);
    }

    @Override
    public String toString() {
        try {
            return "[" + this.getStatusIcon() + "] " + this.title + " (by: " + reformatDate() + ")";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
