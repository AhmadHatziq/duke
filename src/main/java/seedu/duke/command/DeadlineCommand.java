package seedu.duke.command;

import seedu.duke.core.DukeException;
import seedu.duke.parser.Parser;
import seedu.duke.statistic.Statistic;
import seedu.duke.storage.Storage;
import seedu.duke.task.Deadline;
import seedu.duke.tasklist.TaskList;
import seedu.duke.ui.Ui;

/**
 * Represents the "deadline" command.
 */
public class DeadlineCommand extends Command {

    /**
     * Default constructor.
     */
    public DeadlineCommand() {

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
     * @throws DukeException
     */
    public String execute (String fullCommand, Ui ui, TaskList tasks, Storage taskStorage,
                           Statistic stats, Storage statStorage) throws DukeException {

        stats.incrementTotalCommandsExecuted();

        checkForInvalidInput(fullCommand);

        Deadline newDeadline = newDeadline(fullCommand);

        tasks.addTask(newDeadline);

        return ui.getDeadlineSequence(tasks, newDeadline);
    }

    /**
     * Creates new Deadline object from User string.
     *
     * @param fullCommand Full String command entered by the User.
     */
    public Deadline newDeadline(String fullCommand) {
        String description = Parser.getDeadlineDescription(fullCommand);
        String extraDescription = Parser.getDeadlineDateTime(fullCommand);

        assert description != null : "Description should not be null";
        assert extraDescription != null : "Extra Description should not be null";

        Deadline newDeadline = new Deadline(description, extraDescription);

        return newDeadline;
    }

    /**
     * Checks for invalid inputs from User input.
     *
     * @param fullCommand String from User.
     * @throws DukeException Custom exception.
     */
    public void checkForInvalidInput(String fullCommand) throws DukeException {

        if ((fullCommand.length() < 9)) {

            // fullCommand contains only the string "deadline".
            throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");

        } else if ((fullCommand.lastIndexOf('/') < 1)
                || (4 + fullCommand.lastIndexOf('/') > fullCommand.length()))  {

            // fullCommand does not contain '/' chars or there are no char after "/by".
            throw new DukeException("☹ OOPS!!! The time period of an event cannot be empty.");

        }

    }

}