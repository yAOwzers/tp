package seedu.duke.userinterface.command;

import seedu.duke.userinterface.AppMode;
import seedu.duke.userinterface.AppState;
import seedu.duke.userinterface.InputParser;

public class Select extends CliCommand {
    public static final String COMMAND_WORD = "select";
    public static final String NOTEBOOK_DELIMITER = "/n";
    public static final String SECTION_DELIMITER = "/s";
    public static final String PAGE_DELIMITER = "/p";
    private String notebookTitle = null;
    private String sectionTitle = null;
    private String pageTitle = null;


    public Select(String argument, AppState uiMode) {
        this.setAppState(uiMode);
        this.extractParams(argument);
    }

    private void extractParams(String argument) {
        String[] params = argument.split("/", 3);
        notebookTitle = params[0].replace(NOTEBOOK_DELIMITER, "").trim();
        if (argument.startsWith(NOTEBOOK_DELIMITER)) {
            notebookTitle = params[0].replace(NOTEBOOK_DELIMITER, "").trim();
            sectionTitle = params[1].replace(SECTION_DELIMITER, "").trim();
            pageTitle = params[2].replace(PAGE_DELIMITER, "").trim();
        } else if (argument.startsWith(SECTION_DELIMITER)) {
            sectionTitle = params[0].replace(SECTION_DELIMITER, "").trim();
            pageTitle = params[1].replace(PAGE_DELIMITER, "").trim();
        } else if (argument.startsWith(PAGE_DELIMITER)) {
            pageTitle = params[0].replace(PAGE_DELIMITER, "").trim();
        }
    }

    @Override
    public void execute() {
        InputParser parser = new InputParser();
        switch (appState.getAppMode()) {
        case NOTEBOOK_SHELF:
            appState.setAppMode(AppMode.NOTEBOOK_BOOK);
            findNotebook(notebookTitle);
            findSection(sectionTitle);
            findPage(pageTitle);
            break;
        case NOTEBOOK_BOOK:
            appState.setAppMode(AppMode.NOTEBOOK_SECTION);
            findSection(sectionTitle);
            findPage(pageTitle);
            break;
        case NOTEBOOK_SECTION:
            appState.setAppMode(AppMode.NOTEBOOK_PAGE);
            findPage(pageTitle);
            break;
        default:
            System.out.println("\tError occurred when selecting");
            break;
        }
    }

    private void findNotebook(String notebookTitle) {

    }

    private void findSection(String sectionTitle) {
    }

    private void findPage(String pageTitle) {

    }
}
