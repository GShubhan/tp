//@@author GShubhan
package seedu.clauscontrol.storage;

import seedu.clauscontrol.data.todo.Todo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles saving and loading of todo items.
 */
public class TodoStorage {
    private static final Logger logger = Logger.getLogger(TodoStorage.class.getName());
    private final String filePath;

    public TodoStorage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves the list of todos to file.
     */
    public void save(List<Todo> todos) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (Todo todo : todos) {
            writer.write(todo.getDescription() + "|" + todo.getDeadline());
            writer.newLine();
        }
        writer.close();
        logger.log(Level.INFO, "Saved " + todos.size() + " todos to " + filePath);
    }

    /**
     * Loads todos from file. Skips corrupt lines gracefully.
     */
    public List<Todo> load() throws IOException {
        List<Todo> todos = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length == 2) {
                try {
                    String description = parts[0];
                    LocalDate deadline = LocalDate.parse(parts[1]);
                    todos.add(new Todo(description, deadline));
                } catch (DateTimeParseException e) {
                    logger.log(Level.WARNING, "Skipping corrupt todo line: " + line);
                }
            }
        }
        reader.close();
        logger.log(Level.INFO, "Loaded " + todos.size() + " todos from " + filePath);
        return todos;
    }
}
//@@author
