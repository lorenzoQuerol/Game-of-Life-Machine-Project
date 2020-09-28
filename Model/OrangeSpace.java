package Model;

public class OrangeSpace extends Space {
    private String orangeDescription = "You landed on an orange space! Draw an Action Card!";

    /**
     * Constructs the orange space
     * @param index index/position of the space on the board
     */
    public OrangeSpace (int index){
        super(index, "orange");
    }

    /**
     * Formats the string
     * @return formatted string
     */
    @Override
    public String toString() {
        return this.orangeDescription;
    }
}
