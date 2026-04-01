//@@author GShubhan
package seedu.clauscontrol.commands;

import seedu.clauscontrol.data.todo.Todo;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Adds a todo item to the todo list.
 */
public class AddTodoCommand extends Command {
    private static final Logger logger = Logger.getLogger(AddTodoCommand.class.getName());
    private final String arguments;
    private final ArrayList<Todo> todoList;

    public AddTodoCommand(String arguments, ArrayList<Todo> todoList) {
        this.arguments = arguments;
        this.todoList = todoList;
    }

    @Override
    public String execute() {
        try {
            int dIndex = arguments.indexOf("d/");
            int byIndex = arguments.indexOf("by/");

            if (dIndex == -1 || byIndex == -1) {
                return "Format: todo d/DESCRIPTION by/YYYY-MM-DD";
            }

            String description = arguments.substring(dIndex + 2, byIndex).trim();
            String dateStr = arguments.substring(byIndex + 3).trim();
            LocalDate deadline = LocalDate.parse(dateStr);

            if (description.isEmpty()) {
                return "Description cannot be empty!";
            }
            if (deadline.isBefore(LocalDate.now())) {
                return "Deadline cannot be in the past!";
            }

            todoList.add(new Todo(description, deadline));
            logger.log(Level.INFO, "Todo added: " + description);
            return "Todo added: " + description + " (due: " + deadline + ")";
        } catch (DateTimeParseException e) {
            logger.log(Level.WARNING, "Invalid date format entered");
            return "Invalid date format! Please use YYYY-MM-DD e.g. 2026-04-05";
        }
    }
}
//@@author
