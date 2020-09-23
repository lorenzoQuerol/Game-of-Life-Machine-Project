package Model;

public class BlueSpace extends Space {
    private String blueDescription = "You landed on an blue space! Draw a Blue Card!";

    public BlueSpace(int index) {
        super(index, "Blue");
    }

    @Override
    public String toString() {
        return this.blueDescription;
    }
}
