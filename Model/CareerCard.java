package Model;

public class CareerCard {

	// Possible names for the action card
	public static final String[] CAREER = {"Lawyer", "Accountant", "Computer\nConsultant", "Doctor", "Server", "Racecar Driver", "Athlete"};

	private String name;
	private int payRaise;

	/**
	 * Constructs the career card
	 * @param n name of the career card
	 */
	public CareerCard (String n) {
		this.name = n;
	}

	/**
	 * Sets the pay raise of the career card
	 * @param p the pay raise
	 */
	public void setPayRaise (int p) {
        this.payRaise = p;
    }

	/**
	 * Gets the name of the career card
	 * @return name of the career card
	 */
	public String getName () {
		return this.name;
	}

	/**
	 * Formats the string
	 * @return formatted string
	 */
	@Override
    public String toString() {
        return name + " [" + payRaise + "]";

    }
} 
