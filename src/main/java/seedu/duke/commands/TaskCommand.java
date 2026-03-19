//@@author Kiri
package seedu.duke.commands;

import seedu.duke.data.elf.Elf;
import seedu.duke.data.elf.ElfTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskCommand extends Command {
    public static final String MESSAGE_SUCCESS = "Ho ho ho! Task [%1$s] assigned to Elf: %2$s";
    public static final String MESSAGE_INVALID_INDEX = "Error: Invalid Elf index. "
            + "You have %1$d elves in your list.";
    
    private static final Logger logger = Logger.getLogger(TaskCommand.class.getName());
    
    private final int targetIndex; // 用户输入的 1-based index
    private final String taskContent;
    
    public TaskCommand(int targetIndex, String taskContent) {
        this.targetIndex = targetIndex;
        this.taskContent = taskContent;
    }
    
    @Override
    public String execute() {
        assert elfList != null : "elfList should not be null during execution";
        
        logger.log(Level.INFO, "Attempting to assign task to index: " + targetIndex);
        
        if (targetIndex < 1 || targetIndex > elfList.size()) {
            logger.log(Level.WARNING, "Index out of bounds: " + targetIndex);
            return String.format(MESSAGE_INVALID_INDEX, elfList.size());
        }

        Elf targetElf = elfList.get(targetIndex - 1);
        
        assert targetElf != null : "Elf at index should not be null";
        
        ElfTask newTask = new ElfTask(taskContent);
        targetElf.setTask(newTask);
        
        logger.log(Level.INFO, "Task assigned successfully to " + targetElf.getName());
        
        return String.format(MESSAGE_SUCCESS, taskContent, targetElf.getName());
    }
}
//@@author
