package zer0note.userinterface.command.notebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import zer0note.exceptions.InvalidKeywordTagException;
import zer0note.exceptions.ZeroNoteException;
import zer0note.notebooks.Notebook;
import zer0note.notebooks.NotebookShelf;
import zer0note.notebooks.Page;
import zer0note.notebooks.Section;
import zer0note.userinterface.AppState;
import zer0note.userinterface.CliMessages;
import zer0note.userinterface.command.CliCommand;

public class FindCommandNotebookMode extends CliCommand {
    public static final String COMMAND_WORD = "find";
    private String keyword;
    private String tag;

    private ArrayList<String> notebookMessages = new ArrayList<>();
    private ArrayList<String> sectionMessages = new ArrayList<>();
    private ArrayList<String> pageMessages = new ArrayList<>();

    public FindCommandNotebookMode(String keyword, String tag, AppState appState) {
        this.keyword = keyword.toLowerCase();
        this.tag = tag;
        this.appState = appState;
        PRINTS_PERSONAL_MESSAGE = true;
    }

    public void execute() {
        try {
            if (tag.equals("") && !keyword.equals("")) {
                getAllWithTitleContainingKeyword();
                System.out.println("I've found these for keyword: " + keyword);
            } else if (!tag.equals("") && keyword.equals("")) {
                getAllWithTag();
                System.out.println("I've found these for tag: " + tag);
            } else {
                throw new InvalidKeywordTagException(keyword + "\t" + tag);
            }
        } catch (ZeroNoteException zne) {
            zne.printErrorMessage();
            return;
        }

        print();
    }

    private void print() {
        CliMessages cliMessages = new CliMessages();
        if (notebookMessages.isEmpty() && sectionMessages.isEmpty() && pageMessages.isEmpty()) {
            System.out.println("Nothing is found!");
        }
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

    private void getAllWithTag() {
        NotebookShelf currentNotebookShelf = appState.getCurrentBookShelf();
        for (Notebook notebook : currentNotebookShelf.getNotebooksArrayList()) {
            String notebookTag = notebook.getTag();
            if (!notebookTag.equals("") && notebookTag.equals(tag)) {
                notebookMessages.add(notebook.getTitle());
            }
            getSectionsWithTag(notebook);
        }
    }

    private void getSectionsWithTag(Notebook notebook) {
        for (Section section : notebook.getSectionArrayList()) {
            String sectionTag = section.getTag();
            if (!sectionTag.equals("") && sectionTag.equals(tag)) {
                sectionMessages.add(notebook.getTitle() + " |-- " + section.getTitle());
            }
            getPagesWithTag(notebook, section);
        }
    }

    private void getPagesWithTag(Notebook notebook, Section section) {
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

    public ArrayList<String> getNotebookMessages() {
        return notebookMessages;
    }

    public ArrayList<String> getSectionMessages() {
        return sectionMessages;
    }

    public ArrayList<String> getPageMessages() {
        return pageMessages;
    }

    private List<String> getWordsInTitle(String title) {
        return Arrays.asList(title.toLowerCase().split(" "));
    }

    public boolean isPersonalised() {
        return PRINTS_PERSONAL_MESSAGE;
    }
}
