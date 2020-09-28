package Model;

public class GreenSpace extends Space {
    private String greenDescription;

    public static final String[] GREEN = {
        "Pay Day! Collect your salary from the bank!",
        "Pay Raise!"};

    /**
     * Constructs the green space
     * @param index index/position of the space on the board
     * @param description description of the green space
     */
    public GreenSpace(int index, String description) {
        super(index, "green");
        this.greenDescription = description;
    }

    /**
     * Formats the string
     * @return formatted string
     */
    @Override
    public String toString() {
        return this.greenDescription;
    }
}
