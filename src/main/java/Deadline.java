public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        taskType = possibleTaskTypes.DEADLINE;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String toSaveString(){
        return ( "D" + super.toSaveString() + " | " + this.by  );
    }
}