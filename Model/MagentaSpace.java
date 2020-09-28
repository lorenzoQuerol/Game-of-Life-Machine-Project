package Model;

public class MagentaSpace extends Space {
    private String magentaDescription;

    public static final String[] MAGENTA = {
            "College Career Choice! Pick a Career and Salary Card!",
            "Job Search! Choose a new Career or keep your current one!",
            "Buy a House! Choose a house of your choice!",
            "Get Married! Spin a number for your wedding gift!",
            "Have a Baby or Twins! Spin a number for your gift!",
            "Which Path? Change your career or go start a family!"
    };

    /**
     * Constructs the magenta space
     * @param index index/position of the space on the board
     * @param description description of the magenta space
     */
    public MagentaSpace(int index, String description) {
        super(index, "magenta");
        this.magentaDescription = description;
    }

    /**
     * Formats the string
     * @return formatted string
     */
    @Override
    public String toString() {
        return this.magentaDescription;
    }
}
