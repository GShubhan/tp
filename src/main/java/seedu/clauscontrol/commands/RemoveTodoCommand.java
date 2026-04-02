//@@author GShubhan
package seedu.clauscontrol.commands;

import seedu.clauscontrol.data.todo.Todo;
import java.util.ArrayList;

/**
 * Removes a todo item from the todo list.
 */
public class RemoveTodoCommand extends Command {
    private final int index;
    private final ArrayList<Todo> todoList;

    public RemoveTodoCommand(int index, ArrayList<Todo> todoList) {
        this.index = index;
        this.todoList = todoList;
    }

    @Override
    public String execute() {
        try {
            if (index < 1 || index > todoList.size()) {
                return "Enter a valid todo index!";
            }
            assert index >= 1 && index <= todoList.size() : "Index should be valid at this point";
            Todo removed = todoList.get(index - 1);
            todoList.remove(index - 1);
            return "Todo removed: " + removed.getDescription();
        } catch (Exception e) {
            return "Something went wrong removing the todo!";
        }
    }
}
//@@author
