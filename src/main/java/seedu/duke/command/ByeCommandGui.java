package seedu.duke.command;

import seedu.duke.statistic.Statistic;
import seedu.duke.storage.Storage;
import seedu.duke.tasklist.TaskList;
import seedu.duke.ui.Ui;

/**
 * Represents the "bye" Command for Duke's GUI.
 */
public class ByeCommandGui extends Command {

    /**
     * Default constructor.
     */
    public ByeCommandGui() {

    }

    /**
     * Executes the command.
     *
     * @param fullCommand Full String command entered by the User.
     * @param ui User Interface object.
     * @param tasks TaskList object.
     * @param taskStorage Storage object for tasks.
     * @param stats Statistic object.
     * @param statStorage Storage object for stats.
     * @return String sequence to be printed to the User.
     */
    public String execute(String fullCommand, Ui ui, TaskList tasks, Storage taskStorage, Statistic stats,
                          Storage statStorage) {

        stats.incrementTotalCommandsExecuted();

        return (ui.getByeSequence());

    }

}
