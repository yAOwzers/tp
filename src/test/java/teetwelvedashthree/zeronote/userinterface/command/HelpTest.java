package seedu.duke.userinterface.command;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the "help" command.
 *
 * @author neilbaner
 */
public class HelpTest {
    String lineSeparator = System.lineSeparator();

    String expectedOutputNotebook = "Here are some commands to help you work with the Notebook mode: " + lineSeparator
            + "To add a notebook into the notebook shelf: " + lineSeparator + "add /n[NOTEBOOK]" + lineSeparator
            + "Example of usage: " + lineSeparator + "add /nCS2101" + lineSeparator + "" + lineSeparator
            + "To add a section into the selected notebook: " + lineSeparator + "add /s[SECTION]" + lineSeparator
            + "Example of usage: " + lineSeparator + "add /sW1: Java" + lineSeparator + "" + lineSeparator
            + "To add a page into the selected section:" + lineSeparator + "add /p[PAGE]; [PAGE CONTENT]"
            + lineSeparator + "Example of usage: " + lineSeparator
            + "add /pHELLO WORLD; System.out.println(\"Hello World!\");" + lineSeparator + "" + lineSeparator
            + "To select a notebook, section, page, or a combination of the three: " + lineSeparator
            + "select /n[NOTEBOOK] /s[SECTION] /p[NUMBER]" + lineSeparator + "Examples of usage: " + lineSeparator
            + "In any context: " + lineSeparator + "select /nCS2101 /sW2 /p1" + lineSeparator + "select /nCS2101 /sW2"
            + lineSeparator + "select /nCS2101" + lineSeparator + "select /all" + lineSeparator + "" + lineSeparator
            + "In a selected notebook" + lineSeparator + "select /s1: What is OOP? /p1" + lineSeparator
            + "select /s1: What is OOP?" + lineSeparator + "" + lineSeparator + "In a selected section" + lineSeparator
            + "select /p1" + lineSeparator + "" + lineSeparator + "To delete and existing notebook, section or page: "
            + lineSeparator + "delete /n[NOTEBOOK] /s[SECTION] /p[NUMBER]" + lineSeparator + "Examples of usage: "
            + lineSeparator + "delete /nCS2113T /sW10 /p1" + lineSeparator + "delete /nCS2113T /sW10" + lineSeparator
            + "delete /nCS2113T" + lineSeparator + "" + lineSeparator;

    String expectedOutputTimetable = "Here are some commands to help you work with the Timetable mode: " + lineSeparator
            + "To add a task with a deadline to the task list: " + lineSeparator + "add /t[TASK] /by[dd/MM/yyyy] [hhmm]"
            + lineSeparator + "Example of usage: " + lineSeparator + "add /tcoding /by19-10-2020 1900" + lineSeparator
            + "" + lineSeparator + "To delete an existing task from the task list: " + lineSeparator + "delete [INDEX]"
            + lineSeparator + "Example of usage: " + lineSeparator + "delete 1" + lineSeparator + "" + lineSeparator;

    String expectedOutputNoParams = "Here are all the commands you need to know to operate Zer0Note: " + lineSeparator
            + "Here are some general commands that will work throughout Zer0Note: " + lineSeparator
            + "To switch to timetable mode: " + lineSeparator + "mode /t" + lineSeparator
            + "To switch to notebook mode: " + lineSeparator + "mode /n" + lineSeparator + "" + lineSeparator
            + "To quit Zer0Note:" + lineSeparator + "exit" + lineSeparator + expectedOutputNotebook
            + expectedOutputTimetable + "Access the full user guide for Zer0Note online, at: " + lineSeparator
            + "https://ay2021s1-cs2113t-t12-3.github.io/tp/UserGuide.html" + lineSeparator + lineSeparator;

    @Test
    void help_noParams() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        Help help = new Help("");
        String output;
        assertDoesNotThrow(help::execute);
        output = os.toString();
        assertEquals(output, expectedOutputNoParams);
    }

    @Test
    void help_randomParams() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        Help help = new Help("lmao rekt");
        String output;

        assertDoesNotThrow(help::execute);

        output = os.toString();
        assertEquals(output, expectedOutputNoParams);
    }

    @Test
    void help_notebook() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        Help help = new Help("notebook");
        String output;

        assertDoesNotThrow(help::execute);

        output = os.toString();
        assertEquals(output, expectedOutputNotebook);
    }

    @Test
    void help_notebookMixedCase() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        Help help = new Help("nOtEbOoK");
        String output;

        assertDoesNotThrow(help::execute);

        output = os.toString();
        assertEquals(output, expectedOutputNotebook);
    }

    @Test
    void help_timetable() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        Help help = new Help("timetable");
        String output;

        assertDoesNotThrow(help::execute);

        output = os.toString();
        assertEquals(output, expectedOutputTimetable);
    }

    @Test
    void help_timetableMixedCase() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        Help help = new Help("TiMeTaBlE");
        String output;

        assertDoesNotThrow(help::execute);

        output = os.toString();
        assertEquals(output, expectedOutputTimetable);
    }
}
