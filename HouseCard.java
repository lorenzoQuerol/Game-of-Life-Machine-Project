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

    public HouseCard (String n, int o, int e) {
        this.name = n;
        this.payAmountOdd = o;
        this.payAmountEven = e;
    }

    public String getName() {
        return name;
    }

    public int getPayAmountOdd() {
        return payAmountOdd;
    }

    public int getPayAmountEven() {
        return payAmountEven;
    }

    public int getFinalPayAmount() {
        return finalPayAmount;
    }

    public void setFinalPayAmount(int finalPayAmount) {
        this.finalPayAmount = finalPayAmount;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "Pay Amount: " + payAmountOdd;

    }
}