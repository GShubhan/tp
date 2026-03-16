package seedu.duke.commands;

import seedu.duke.data.child.Child;
import seedu.duke.data.exception.IllegalValueException;

/**
 * Adds an action with severity to a child.
 */

public class ActionCommand extends Command {
    public String SUCCESS = "Action added for %s: \"%s\" (severity: %d)";
    public String INVALID_INDEX = "Enter a valid child index";

    private int childIndex;
    private String action;
    private int severity;

    public ActionCommand(int childIndex, String action, int severity) {
        this.childIndex = childIndex;
        this.action = action;
        this.severity = severity;
    }

    @Override
    public String execute() {
        if (childIndex < 1 || childIndex > childList.size()) {
            return INVALID_INDEX;
        }
        Child child = childList.get(childIndex - 1);
        child.addAction(action, severity);
        return String.format(SUCCESS, child.getName(), action, severity);
    }
}
