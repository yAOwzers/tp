package seedu.duke.tasks;

import seedu.duke.exceptions.InvalidUserInputException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Task {
    private final String title;
    private String by;
//    protected DateFormat dateTime = new SimpleDateFormat("dd-MM-yyyy HHmm"); // in 24h format
//    protected DateFormat outputFormat = new SimpleDateFormat("MMM dd yyyy hh.mm aa"); // in 12h format
    protected boolean isDone;

    private LocalDate dueDate;
    private LocalTime dueTime;

    public Task(String title, String dateTime) throws InvalidUserInputException {
        this.title = title;
        convertDateTime(dateTime);
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

    public void markAsDone() {
        this.isDone = true;
    }

    public String getTask() {
        return this.title;
    }

//    public String reformatDate() throws ParseException {
//        Date date = dateTime.parse(by);
//        return outputFormat.format(date);
//    }

    public String getStatusIcon() {
        return (isDone ? "o" : "x");
    }

    public boolean isDone() {
        return isDone;
    }

    public String getTaskInMessagesFormat() {
        return "[" + this.getStatusIcon() + "] " + this.title + " (by: " + this.by + " )";
    }

    public String toTxtFormat() {
        return (isDone ? "1" : "0") + " | " + this.title + " | " + this.by;
    }

    public static Task parse(String txtFormat) throws InvalidUserInputException {
        String[] txtArray = txtFormat.split("\\|");
        String isDoneInteger = txtArray[0].trim();
        String description = txtArray[1].trim();
        String[] unFormattedDateTime = txtArray[2].trim().split(" ");
        String[] formattedDateTime = formatDateTime(unFormattedDateTime);
        String finalDateTime = formattedDateTime[0] + " " + formattedDateTime[1];
        Task newTask = new Task(description, finalDateTime);
        if(isDoneInteger.equals("1")) {
            newTask.markAsDone();
        }
        return newTask;
    }

    /**
     * Converts the given string into a LocalDateTime to be stored in the given Deadline.
     * @param dateAndTime to be converted into LocalDateTime.
     * @throws InvalidUserInputException when an invalid a date time format is used as input.
     */
    private void convertDateTime(String dateAndTime) throws InvalidUserInputException {
        try {
            String[] dateTimeArray = dateAndTime.split(" ");
            this.dueDate = LocalDate.parse(dateTimeArray[0]);
            this.dueTime =
                    LocalTime.parse(dateTimeArray[1].substring(0, 2) + ":" + dateTimeArray[1].substring(2, 4));
            this.by = this.dueDate.format(DateTimeFormatter.ofPattern("d MMMM yyyy")) + " "
                    + this.dueTime.format(DateTimeFormatter.ofPattern("hh:mm a"));
        } catch (DateTimeParseException e) {
            throw new InvalidUserInputException();
        }
    }

    private static String[] formatDateTime(String[] unformattedDateAndTime) {
        String[] formattedDateAndTime = new String[2];

        String unformattedDate =
                unformattedDateAndTime[0] + " " + unformattedDateAndTime[1] + " " + unformattedDateAndTime[2];
        String unformattedTime =
                unformattedDateAndTime[3] + " " + unformattedDateAndTime[4];

        String formattedDate =
                LocalDate.parse(unformattedDate, DateTimeFormatter.ofPattern("d MMMM yyyy")).toString();
        String time =
                LocalTime.parse(unformattedTime, DateTimeFormatter.ofPattern("hh:mm a")).toString();

        String formattedTime = time.substring(0, time.indexOf(':'))
                + time.substring(time.indexOf(':') + 1);

        formattedDateAndTime[0] = formattedDate;
        formattedDateAndTime[1] = formattedTime;
        return formattedDateAndTime;
    }

    @Override
    public String toString() {

        return getStatusIcon() + " | " + this.title + " | "
                + this.by + System.lineSeparator();
//        try {
//                return "[" + this.getStatusIcon() + "] " + this.title + " (by: " + this.by + ")";
//        } catch (ParseException e) {
//            System.out.println("\tAn error occurred while reading the given deadline.");
//        }
//        return null;
    }
}
