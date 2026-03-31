package seedu.clauscontrol.commands;

import seedu.clauscontrol.data.child.Child;
import seedu.clauscontrol.data.exception.IllegalValueException;

//@@author shrabasti-c
public class EditCommand extends Command {
    private final int childIndex;
    private final String newName;

    public EditCommand(int childIndex, String newName) {
        this.childIndex = childIndex;
        this.newName = newName;
    }

    @Override
    public String execute() {
        if (childIndex < 0 || childIndex >= childList.size()) {
            return "Invalid position :(";
        }

        Child child = childList.get(childIndex);

        try {
            child.setName(newName);
        } catch (IllegalValueException e) {
            throw new RuntimeException(e);
        }
        return "Name changed!";
    }
}
//@@author
