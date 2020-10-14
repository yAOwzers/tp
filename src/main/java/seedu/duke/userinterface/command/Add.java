package seedu.duke.userinterface.command;

import seedu.duke.notebooks.Notebook;
import seedu.duke.notebooks.NotebookShelf;
import seedu.duke.notebooks.Page;
import seedu.duke.notebooks.Section;
import seedu.duke.userinterface.AppMode;
import seedu.duke.userinterface.AppState;

import static seedu.duke.userinterface.command.List.listBookshelf_n;
import static seedu.duke.userinterface.command.List.listBookshelf_ns;
import static seedu.duke.userinterface.command.List.listBookshelf_nsp;

public class Add extends CliCommand {
    public static final String COMMAND_WORD = "add";
    private AppState uiMode;
    private String name;
    private String content;
    private NotebookShelf currentBookshelf = new NotebookShelf();
    private Notebook currentNotebook;
    private Section currentSection;

    public Add() {
        currentBookshelf = uiMode.getCurrentBookShelf();
        currentNotebook = uiMode.getCurrentNotebook();
        currentSection = uiMode.getCurrentSection();
    }

    public Add(String argument, AppState uiMode) {
        this.uiMode = uiMode;
        this.setAppState(uiMode);
        this.splitParams(argument);
    }

    private void splitParams(String argument) {
        name = argument;
        if (appState.getAppMode().equals(AppMode.NOTEBOOK_PAGE)) {
            String[] input = argument.split(";", 2);
            name = input[0];
            content = input[1];
            System.out.println("added page titled: " + name);
            System.out.println("content added: " + content);
        }
    }

    private String getName() {
        return name;
    }

    private String getContent() {
        return content;
    }

    public void execute() {
        switch (appState.getAppMode()) {
        case NOTEBOOK_SHELF:
            System.out.println("now in " + appState.getAppMode());
            currentBookshelf = appState.getCurrentBookShelf();
            addNotebook(currentBookshelf);
            listBookshelf_n(currentBookshelf);
            break;
        case NOTEBOOK_BOOK:
            System.out.println("now in " + appState.getAppMode());
            currentNotebook = getAppState().getCurrentNotebook();
            addNotebookSection(currentNotebook);
            appState.setCurrentNotebook(currentNotebook);
            currentSection = appState.getCurrentSection();
            appState.setCurrentSection(currentSection);
            listBookshelf_ns(currentBookshelf);
            break;
        case NOTEBOOK_SECTION:
            System.out.println("now in " + appState.getAppMode());
            addNotebookPage(currentSection, content);
            listBookshelf_nsp(currentBookshelf);
            break;
        default:
            System.out.println("\tunable to add notebook/section/page");
            break;
        }
    }

    private void addNotebook(NotebookShelf currentBookShelf) {
        currentNotebook = new Notebook(name);
        currentBookShelf.getNotebooksArrayList().add(currentNotebook);
        appState.setCurrentBookShelf(currentBookshelf);
        appState.setCurrentNotebook(currentNotebook);
        appState.setIndexOfCurrentNotebook(currentBookShelf.getNotebooksArrayList().size() - 1);
        System.out.println("now there are " + currentBookShelf.getNotebooksArrayList().size() + " notebooks");
    }

    private void addNotebookSection(Notebook currentNotebook) {
        currentSection = new Section(name);
        currentNotebook.getSectionArrayList().add(currentSection);
        appState.setCurrentNotebook(currentNotebook);
        appState.setIndexOfCurrentSection(currentNotebook.getSectionArrayList().size() - 1);
        appState.setCurrentSection(currentSection);
    }

    private void addNotebookPage(Section currentSection, String content) {
        currentSection.getPageArrayList().add(new Page(name, content));
    }
}
