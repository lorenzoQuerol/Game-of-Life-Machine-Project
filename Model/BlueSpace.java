package Model;

public class BlueSpace extends Space {
    private String blueDescription = "You landed on an blue space! Draw a Blue Card!";

    /**
     * This constructs a new blue space for the board
     * @param index the specified index/position of the blue space
     */
    public BlueSpace(int index) {
        super(index, "Blue");
    }

    /**
     * Formats the output for a blue space.
     */
    @Override
    public String toString() {
        return this.blueDescription;
    }
}
