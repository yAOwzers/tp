package seedu.duke.userinterface.command.notebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.CliMessages;
import seedu.duke.userinterface.command.CliCommand;

public class FindCommandNotebookMode extends CliCommand {
    public static final String COMMAND_WORD = "find";
    private String keyword;
    private String tag;

<<<<<<< HEAD
    private ArrayList<Notebook> notebooksFound = new ArrayList<>();
    private ArrayList<Section> sectionsFound = new ArrayList<>();
    private ArrayList<Page> pagesFound = new ArrayList<>();
=======
    private ArrayList<String> notebookMessages = new ArrayList<>();
    private ArrayList<String> sectionMessages = new ArrayList<>();
    private ArrayList<String> pageMessages = new ArrayList<>();
>>>>>>> master

    public FindCommandNotebookMode(String keyword, String tag, AppState appState) {
        this.keyword = keyword.toLowerCase();
        this.tag = tag.toLowerCase();
        this.appState = appState;
    }

    public void execute() {
        CliMessages cliMessages = new CliMessages();
        if (tag.equals("") && !keyword.equals("")) {
            getAllWithTitleContainingKeyword();
            System.out.println("I've found these for keyword: " + keyword);
        } else if (!tag.equals("") && keyword.equals("")) {
            getAllWithTagsContainingKeyword();
            System.out.println("I've found these for tag: " + tag);
        } else {
            System.out.println("Missing keyword/tag");
            System.out.println("Format: find [KEYWORD] or find /t[TAG]");
            return;
        }

<<<<<<< HEAD
    private void printFoundListsMessage() {
        CliMessages cliMessages = new CliMessages();
        System.out.println("Here are what I found:");
        cliMessages.printFoundNotebooksMessage(notebooksFound);
        cliMessages.printFoundSectionsMessage(sectionsFound);
        cliMessages.printFoundPagesMessage(pagesFound);
=======
        if (!notebookMessages.isEmpty()) {
            System.out.println("Notebooks:");
            cliMessages.printFoundNotebooksMessages(notebookMessages);
        }
        if (!sectionMessages.isEmpty()) {
            System.out.println("Sections:");
            cliMessages.printFoundNotebooksMessages(sectionMessages);
        }
        if (!pageMessages.isEmpty()) {
            System.out.println("Pages:");
            cliMessages.printFoundNotebooksMessages(pageMessages);
        }
>>>>>>> master
    }

    private void getAllWithTitleContainingKeyword() {
        NotebookShelf currentNotebookShelf = appState.getCurrentBookShelf();
        for (Notebook notebook : currentNotebookShelf.getNotebooksArrayList()) {
            String notebookTitle = notebook.getTitle();
            if (isMatching(notebookTitle, keyword)) {
                notebookMessages.add(notebookTitle);
            }
            getSectionsWithTitleContainingKeyword(notebook);
        }
    }

    private void getSectionsWithTitleContainingKeyword(Notebook notebook) {
        for (Section section : notebook.getSectionArrayList()) {
            String sectionTitle = section.getTitle();
            if (isMatching(sectionTitle, keyword)) {
                sectionMessages.add(notebook.getTitle() + " |-- " + sectionTitle);
            }
            getPagesWithTitleContainingKeyword(notebook, section);
        }
    }

    private void getPagesWithTitleContainingKeyword(Notebook notebook, Section section) {
        for (Page page : section.getPageArrayList()) {
            String pageTitle = page.getTitle();
            if (isMatching(pageTitle, keyword)) {
                pageMessages.add(notebook.getTitle() +  " |-- " + section.getTitle() + " |-- " + page.getTitle());
            }
        }
    }

    private void getAllWithTagsContainingKeyword() {
        NotebookShelf currentNotebookShelf = appState.getCurrentBookShelf();
        for (Notebook notebook : currentNotebookShelf.getNotebooksArrayList()) {
            String notebookTag = notebook.getTag();
            if (!notebookTag.equals("") && notebookTag.equals(tag)) {
                notebookMessages.add(notebook.getTitle());
            }
            getSectionsWithTagContainingKeyword(notebook);
        }
    }

    private void getSectionsWithTagContainingKeyword(Notebook notebook) {
        for (Section section : notebook.getSectionArrayList()) {
            String sectionTag = section.getTag();
            if (!sectionTag.equals("") && sectionTag.equals(tag)) {
                sectionMessages.add(notebook.getTitle() + " |-- " + section.getTitle());
            }
            getPagesWithTagContainingKeyword(notebook, section);
        }
    }

    private void getPagesWithTagContainingKeyword(Notebook notebook, Section section) {
        for (Page page : section.getPageArrayList()) {
            String pageTag = page.getTag();
            if (!pageTag.equals("") && pageTag.equals(tag)) {
                pageMessages.add(notebook.getTitle() +  " |-- " + section.getTitle() + " |-- " + page.getTitle());
            }
        }
    }

    private boolean isMatching(String title, String keyword) {
        Set<String> wordsInTitle = new HashSet<>(getWordsInTitle(title));
        for (String word : wordsInTitle) {
            if (word.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    private List<String> getWordsInTitle(String title) {
        return Arrays.asList(title.toLowerCase().split(" "));
    }
}
