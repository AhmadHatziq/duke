package seedu.duke.ui;

import seedu.duke.task.Deadline;
import seedu.duke.task.Event;
import seedu.duke.task.Task;
import seedu.duke.task.Todo;
import seedu.duke.tasklist.TaskList;

/**
 * Graphical Ui class, that handles returning formatted and parsed strings for DUKE GUI's implementation
 * Main difference is that ticks and crosses are swapped with V and X.
 * Unnecessary underscores and spaces have been removed from the CLI's implementation.
 */
public class GraphicalUi extends Ui {
    /**
     * Default constructor.
     */
    public GraphicalUi(){
    }

    /**
     * Returns welcome string.
     *
     * @return String.
     */
    public static String getWelcomeString() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String intro =
                "Hello! I'm Duke " + "\n"
                + "What can I do for you?" + "\n";
        return (logo + intro);
    }

    /**
     * Prints the Done Sequence, when the user command "done" is entered.
     *
     * @param tasks TaskList class, which contains a list of Task objects.
     * @param taskNum Integer index of the task which has been selected as "done".
     * @return
     */
    public String getDoneSequence(TaskList tasks, int taskNum) {
        String output = "Nice! I've marked this task as done:\n"
                + "[" + tasks.getTask(taskNum).getStatusIcon() + "] " + tasks.getTask(taskNum).getTaskName()
                + "\n";
        output = output.replace("✓", "V");
        output = output.replace("✘", "X");
        return output;
    }

    /**
     * Returns the Todo Sequence, when the user command "Todo" is entered.
     *
     * @param tasks TaskList class, which contains a list of Task objects.
     * @param newTodo Todo class, which has been newly created.
     * @return
     */
    public String getTodoSequence(TaskList tasks, Todo newTodo) {
        String output = "Got it. I've added this task:\n"
                + newTodo.toString() + getTasksRemainingSequence(tasks.getSize());
        output = output.replace("✓", "V");
        output = output.replace("✘", "X");
        return output;
    }

    /**
     * Returns the Deadline sequence, when the user command "deadline" is entered.
     *
     * @param tasks TaskList class, which contains a list of Task objects.
     * @param newDeadline Deadline class, which has been newly created.
     * @return String
     */
    public String getDeadlineSequence(TaskList tasks, Deadline newDeadline) {
        String output = "Got it. I've added this task:\n"
                + newDeadline.toString() + getTasksRemainingSequence(tasks.getSize());
        output = output.replace("✓", "V");
        output = output.replace("✘", "X");
        return output;
    }

    /**
     * Returns the Event sequence, when the user command "event" is entered.
     *
     * @param tasks TaskList class, which contains a list of Task objects.
     * @param newEvent Event class, which has been newly created.
     * @return String.
     */
    public String getEventSequence(TaskList tasks, Event newEvent) {
        String output = "Got it. I've added this task:\n"
                + newEvent.toString() + getTasksRemainingSequence(tasks.getSize());
        output = output.replace("✓", "V");
        output = output.replace("✘", "X");
        return output;
    }

    /**
     * Returns the Delete sequence, when the user command "delete" is entered.
     *
     * @param tasks TaskList class, which contains a list of Task objects.
     * @param taskToDelete Task class, which will be deleted from the list.
     * @return String
     */
    public String getDeleteSequence(TaskList tasks, Task taskToDelete) {
        String output = "Noted. I've removed this task.\n"
                + taskToDelete.toString() + getTasksRemainingSequence(tasks.getSize());
        output = output.replace("✓", "V");
        output = output.replace("✘", "X");
        return output;
    }

    /**
     * Returns the Bye sequence, when the user command "bye" is entered.
     *
     * @return String.
     */
    public String getByeSequence() {
        String output = "\n" + "Bye. Hope to see you again soon!" + "\n";
        return (output);
    }

    /**
     * Returns the string containing tasks in a pre-formatted form.
     * Eg. "1.[E][X] Run (at: ERC)
     *      2.[D][V] IPPT (by: 21st of December 2004, 8.15am)
     *      3.[E][V] Lecture (at: LT7A)".
     *
     * @param tasks TaskList object
     * @return String of tasks
     */
    public String getListSequence(TaskList tasks) {
        String output = "";
        for (int i = 0; i < tasks.getSize(); i++) {
            output += (i + 1) + "." + tasks.getTask(i).toString() + "\n";
        }
        output = output.replace("✓", "V");
        output = output.replace("✘", "X");
        return output;
    }

    /**
     * Returns the tasks which are similar for the "find" command.
     *
     * @param tasks TaskList object.
     * @return String.
     */
    public String getFoundTasks(TaskList tasks) {
        String output = "Here are the matching tasks in your list:\n";
        output += getListSequence(tasks);
        return (output);
    }

    /**
     * Returns the tasks remaining in the list.
     *
     * @param numOfTaskRemaining TaskList object.
     * @return String
     */
    public String getTasksRemainingSequence(int numOfTaskRemaining) {
        String output = "\nNow you have "
                + numOfTaskRemaining + " tasks in the list.\n";
        return output;
    }
}