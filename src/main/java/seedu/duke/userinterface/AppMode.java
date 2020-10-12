package seedu.duke.userinterface;

public enum AppMode {
    TIMETABLE,
    NOTEBOOK_SHELF,
    NOTEBOOK_BOOK,
    NOTEBOOK_SECTION;

    @Override
    public String toString() {
        switch(this) {
        case TIMETABLE:
            return "timetable";
        case NOTEBOOK_SHELF:
        default:
            return "notebook";
        }
    }
}
