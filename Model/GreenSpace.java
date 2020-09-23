package Model;

public class GreenSpace extends Space {
    private String greenDescription;

    public static final String[] GREEN = {
        "Pay Day! Collect your salary from the bank!",
        "Pay Raise!"};

    public GreenSpace(int index, String description) {
        super(index, "green");
        this.greenDescription = description;
    }

    public String getGreenDescription() {
        return greenDescription;
    }
    
    @Override
    public String toString() {
        return this.greenDescription;
    }
}
