//@@author Kiri
package seedu.duke.commands;

import seedu.duke.data.child.Child;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FindCommand extends Command {
    private static final Logger logger = Logger.getLogger(FindCommand.class.getName());
    
    private final String targetName;
    
    public FindCommand(String targetName) {
        this.targetName = targetName.trim().toLowerCase();
        logger.log(Level.FINE, "FindCommand initialized with target: " + targetName);
    }
    
    @Override
    public String execute() {
        logger.log(Level.INFO, "Starting search for name: " + targetName);
        
        if (childList == null || childList.isEmpty()) {
            logger.log(Level.WARNING, "Search aborted: childList is empty.");
            return "The child list is empty!";
        }
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for (int i = 0; i < childList.size(); i++) {
            Child child = childList.get(i);
            String currentName = child.getName().toString().toLowerCase();
            
            if (currentName.equals(targetName)) {
                sb.append((i + 1)).append(" ").append(child.getName()).append("\n");
                count++;
            }
        }
        
        if (count == 0) {
            logger.log(Level.INFO, "Search completed: No matches found for '" + targetName + "'.");
            return "No match found.";
        } else {
            logger.log(Level.INFO, "Search completed: Found " + count + " match(es).");
            return "Found " + count + " matches:\n" + sb.toString().trim();
        }
    }
}
//@@author Kiri
