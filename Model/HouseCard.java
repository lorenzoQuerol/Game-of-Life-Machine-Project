package Model;

public class HouseCard {

    /*
    The house card has two different pay amounts, one for when the user spins an odd number, and one for when it is even.
    The final pay amount is set once the player has spinned for a number
    */
    public static final String[] HOUSE = { "Mobile Home", "Cabin", "Apartment", "Condominium", "Villa" };
    public static final int[] HOUSE_ODD = {10000, 20000, 30000, 40000, 50000};
    public static final int[] HOUSE_EVEN = {5000, 15000, 25000, 35000, 45000};

    String name;
    int payAmountOdd;
    int payAmountEven;
    int finalPayAmount;

    /**
     * Constructs the house card
     * @param n name of the house card
     * @param o odd pay amount of the house card
     * @param e even pay amount of the house card
     */
    public HouseCard (String n, int o, int e) {
        this.name = n;
        this.payAmountOdd = o;
        this.payAmountEven = e;
    }

    /**
     * Gets the name of the house card
     * @return name of house card
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the pay amount when player spins an odd number
     * @return pay amount for odd spun values
     */
    public int getPayAmountOdd() {
        return payAmountOdd;
    }

    /**
     * Gets the pay amount when player spins an even number
     * @return pay amount for even spun values
     */
    public int getPayAmountEven() {
        return payAmountEven;
    }

    /**
     * Gets the final pay amount when player spins an odd or even number
     * @return pay amount for odd or even spun values
     */
    public int getFinalPayAmount() {
        return finalPayAmount;
    }

    /**
     * Sets the final pay amount when player spins an odd or even number
     * @param finalPayAmount final pay amount of house card
     */
    public void setFinalPayAmount(int finalPayAmount) {
        this.finalPayAmount = finalPayAmount;
    }

    /**
     * Formats the string
     * @return formatted string
     */
    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "Pay Amount: " + payAmountOdd;

    }
}