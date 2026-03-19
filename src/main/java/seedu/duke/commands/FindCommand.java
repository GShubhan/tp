//@@author Kiri
package seedu.duke.commands;

import seedu.duke.data.child.Child;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FindCommand extends Command {
    private static final Logger logger = Logger.getLogger(FindCommand.class.getName());
    
    private final String targetName;
    
    public FindCommand(String targetName) {
        assert targetName != null : "Search target name should not be null";
        this.targetName = targetName.trim().toLowerCase();
        assert !this.targetName.isEmpty() : "Search target name should not be empty after trimming";
        logger.log(Level.FINE, "FindCommand initialized with target: " + targetName);
    }
    
    @Override
    public String execute() {
        assert childList != null : "childList must be initialized before execution";
        
        logger.log(Level.INFO, "Starting search for name: " + targetName);
        
        if (childList.isEmpty()) {
            logger.log(Level.WARNING, "Search aborted: childList is empty.");
            return "The child list is empty!";
        }
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for (int i = 0; i < childList.size(); i++) {
            Child child = childList.get(i);
            
            assert child != null : "Child object in list should not be null";
            assert child.getName() != null : "Child name should not be null";
            
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
