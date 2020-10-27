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
    private Date dueDateTime;
    private String tag = "";

    public Task(String title, String by) {
        this.title = title;
        this.by = by;
        this.isDone = false;
    }

    public Date getDueDateTime() {
        return dueDateTime;
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

    public void markAsDone() {
        this.isDone = true;
    }

    public String getTitle() {
        return this.title;
    }

    public String reformatDate() throws ParseException {
        Date date = dateTime.parse(by);
        this.dueDateTime = date;
        return outputFormat.format(date);
    }

    public String getStatusIcon() {
        return (isDone ? "o" : "x");
    }

    public void setTag(String description) {
        tag = description;
    }

    public String getTag() {
        return (tag.equals("") ? tag : "(tag: " + tag + ")");
    }

    public boolean isDone() {
        return isDone;
    }

    @Override
    public String toString() {
        try {
            return "[" + getStatusIcon() + "] " + getTitle() + " (by: " + reformatDate() + ")" + getTag();
        } catch (ParseException e) {
            System.out.println("\tAn error occurred while reading the given deadline.");
        }
        return null;
    }

    public String getTaskInMessagesFormat() {
        return "[" + this.getStatusIcon() + "] " + this.title;
    }

    public String toTxtFormat() {
        // ...
        return null;
    }

    public String serialize() {
        StringBuilder serialized = new StringBuilder();
        String lineSeparator = System.lineSeparator();
        serialized.append(title);
        serialized.append(lineSeparator);
        serialized.append(by);
        serialized.append(lineSeparator);
        serialized.append(isDone);
        serialized.append(lineSeparator);
        return serialized.toString();
    }
}
