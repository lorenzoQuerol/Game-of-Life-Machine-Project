public class CareerCard {

	private String name;
	private int payRaise;
	
	public void checkCareerCard (CareerDeck c) {
		switch (c.getCareerCard ()) {
			case 1:
				name = "Lawyer";
				break;

			case 2:
				name = "Accountant";
				break;

			case 3:
				name = "Computer Consultant";
				break;

			case 4:
				name = "Doctor";
				break;

			case 5:
				name = "Server";
				break;

			case 6:
				name = "Racecar Driver";
				break;

			case 7:
				name = "Athlete";
				break;
		}
	}
	
	public void setName (String n) {
        name = n;
    } 

	public void setPayRaise (int p) {
        payRaise = p;
    }

	public String getName () {
		return name;
	}

	public int getPayRaise () {
		return payRaise;
	}

	public void displayCareerCard () {
		System.out.println (getName ());
		System.out.println (getPayRaise ());
	}
}