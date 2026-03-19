//@@author Kiri
package seedu.duke.commands;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ElfListCommand extends Command {
    private static final Logger logger = Logger.getLogger(ElfListCommand.class.getName());
    
    @Override
    public String execute() {
        
        assert elfList != null : "The elfList must be initialized before execution!";
        
        logger.log(Level.INFO, "Executing ElfListCommand...");
        
        if (elfList.isEmpty()) {
            logger.log(Level.WARNING, "Elf list is empty. Returning empty message.");
            return "The elf list is empty!";
        }
        
        logger.log(Level.INFO, "Found " + elfList.size() + " elves in the list.");
        
        StringBuilder sb = new StringBuilder("Here are all elf:\n");
        for (int i = 0; i < elfList.size(); i++) {
            assert elfList.get(i) != null : "Elf at index " + i + " should not be null";
            sb.append((i + 1)).append(". ").append(elfList.get(i).toString()).append("\n");
        }
        
        return sb.toString().trim();
    }
}
//@@author
