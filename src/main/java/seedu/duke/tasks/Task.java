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
    protected DateFormat dateTime = new SimpleDateFormat("dd-MM-yyyy HHmm"); // in 24h format
    protected DateFormat outputFormat = new SimpleDateFormat("MMM dd yyyy hh.mm aa"); // in 12h format
    protected boolean isDone;
    private LocalDate dueDate;
    private LocalTime dueTime;

    public Task(String title, String by) {
        this.title = title;
        this.by = by;
        this.isDone = false;
    }

    public LocalDate getDueDate() {
        String[] dayTime = by.split(" ", 2);
        dueDate = LocalDate.parse(dayTime[0].trim());
        return dueDate;
    }

    public LocalTime getTime() {
        String[] dayTime = by.split(" ", 2);
        dueTime = LocalTime.parse(dayTime[1].trim());
        return dueTime;
    }

    public String reformatDate() throws ParseException {
        Date date = dateTime.parse(by);
        return outputFormat.format(date);
    }

    public String getStatusIcon() {
        return (isDone ? "o" : "x");
    }

    public boolean isDone() {
        return isDone;
    }

    @Override
    public String toString() {
        try {
            return "[" + this.getStatusIcon() + "] " + this.title + " (by: " + reformatDate() + ")";
        } catch (ParseException e) {
            System.out.println("\tAn error occurred while reading the given deadline.");
        }
        return null;
    }
}
