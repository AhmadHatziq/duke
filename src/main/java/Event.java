public class Event extends Task {

    protected String at;

    public Event (String description, String at){
        super(description);
        this.at = at;
        taskType = possibleTaskTypes.EVENT;
    }

    @Override
    public String toString(){
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    @Override
    public String toSaveString(){
        return ( "E" + super.toSaveString() + " | " + this.at );
    }

}
