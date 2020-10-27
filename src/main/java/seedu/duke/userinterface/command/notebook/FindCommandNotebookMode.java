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
    private boolean isPersonalised = true;

    private ArrayList<Notebook> notebooksFound = new ArrayList<>();
    private ArrayList<Section> sectionsFound = new ArrayList<>();
    private ArrayList<Page> pagesFound = new ArrayList<>();
    private CliMessages cliMessages = new CliMessages();

    public FindCommandNotebookMode(String keyword, String tag, AppState appState) {
        this.keyword = keyword;
        this.tag = tag.toLowerCase();
        this.appState = appState;
    }

    public void execute() {
        if (tag.equals("")) {
            getAllWithTitleContainingKeyword();
        } else {
            getAllWithTagsContainingKeyword();
        }
        printFoundListsMessage();
    }

    private void printFoundListsMessage() {
        System.out.println("Here are what I found:");
        cliMessages.printFoundNotebooksMessage(notebooksFound);
        cliMessages.printFoundSectionsMessage(sectionsFound);
        cliMessages.printFoundPagesMessage(pagesFound);
    }

    private void getAllWithTitleContainingKeyword() {
        NotebookShelf currentNotebookShelf = appState.getCurrentBookShelf();
        for (Notebook notebook : currentNotebookShelf.getNotebooksArrayList()) {
            String notebookTitle = notebook.getTitle();
            if (isMatching(notebookTitle, keyword)) {
                notebooksFound.add(notebook);
            }
            getSectionsWithTitleContainingKeyword(notebook);
        }
    }

    private void getSectionsWithTitleContainingKeyword(Notebook notebook) {
        for (Section section : notebook.getSectionArrayList()) {
            String sectionTitle = section.getTitle();
            if (isMatching(sectionTitle, keyword)) {
                sectionsFound.add(section);
            }
            getPagesWithTitleContainingKeyword(section);
        }
    }

    private void getPagesWithTitleContainingKeyword(Section section) {
        for (Page page : section.getPageArrayList()) {
            String pageTitle = page.getTitle();
            if (isMatching(pageTitle, keyword)) {
                pagesFound.add(page);
            }
        }
    }

    private void getAllWithTagsContainingKeyword() {
        NotebookShelf currentNotebookShelf = appState.getCurrentBookShelf();
        for (Notebook notebook : currentNotebookShelf.getNotebooksArrayList()) {
            String notebookTag = notebook.getTag();
            if (!notebookTag.equals("") && isMatching(notebookTag, tag)) {
                notebooksFound.add(notebook);
            }
            getSectionsWithTagContainingKeyword(notebook);
        }
    }

    private void getSectionsWithTagContainingKeyword(Notebook notebook) {
        for (Section section : notebook.getSectionArrayList()) {
            String sectionTag = section.getTag();
            if (!sectionTag.equals("") && isMatching(sectionTag, tag)) {
                sectionsFound.add(section);
            }
            getPagesWithTagContainingKeyword(section);
        }
    }

    private void getPagesWithTagContainingKeyword(Section section) {
        for (Page page : section.getPageArrayList()) {
            String pageTag = page.getTag();
            if (!pageTag.equals("") && isMatching(pageTag, tag)) {
                pagesFound.add(page);
            }
        }
    }

    private boolean isMatching(String title, String keyword) {
        Set<String> wordsInDescription = new HashSet<>(getWordsInTitle(title));
        return wordsInDescription.contains(keyword);
    }

    private List<String> getWordsInTitle(String title) {
        return Arrays.asList(title.toLowerCase().split(" "));
    }

    @Override
    public boolean isPersonalised() {
        return isPersonalised;
    }
}
