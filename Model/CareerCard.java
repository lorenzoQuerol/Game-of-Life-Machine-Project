package Model;

public class CareerCard {

	// Possible names for the action card
	public static final String[] CAREER = {"Lawyer", "Accountant", "Computer Consultant", "Doctor", "Server", "Racecar Driver", "Athlete"};

	private String name;
	private int payRaise;
	
	public CareerCard (String n) {
		this.name = n;
	}

	public void setPayRaise (int p) {
        this.payRaise = p;
    }

	public String getName () {
		return this.name;
	}

	public int getPayRaise () {
		return this.payRaise;
	}

	@Override
    public String toString() {
        return name + " [" + payRaise + "]";

    }
} 
