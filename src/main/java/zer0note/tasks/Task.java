package teetwelvedashthree.zeronote.tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import teetwelvedashthree.zeronote.exceptions.InvalidTagException;

public class Task {
    private final String title;
    private final String by;
    protected DateFormat dateTime = new SimpleDateFormat("dd-MM-yyyy HHmm"); // in 24h format
    protected DateFormat outputFormat = new SimpleDateFormat("MMM dd yyyy hh.mm aa"); // in 12h format
    protected boolean isDone;
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
        return LocalDate.parse(dayTime[0].trim());
    }

    public LocalTime getTime() {
        String[] dayTime = by.split(" ", 2);
        return LocalTime.parse(dayTime[1].trim());
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

    public void setTag(String tag) throws InvalidTagException {
        if (!tag.equals("")) {
            this.tag = tag;
        } else {
            throw new InvalidTagException(tag);
        }
    }

    public String getTag() {
        return tag;
    }

    public boolean isDone() {
        return isDone;
    }

    @Override
    public String toString() {
        try {
            return ("[" + getStatusIcon() + "] " + getTitle() + " (by: " + reformatDate() + ")"
                    + (tag.equals("") ? "" : "(tag: " + getTag() + ")"));
        } catch (ParseException e) {
            System.out.println("\tAn error occurred while reading the given deadline.");
        }
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
