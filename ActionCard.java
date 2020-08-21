public class ActionCard {
    private String name;
    private int payAmount;
    
    
    public ActionCard (String n, int amount) {
        name = n;
        payAmount = amount;
    }

    public void checkActionCard () {
        
    }

    @Override
    public String toString () {
        return "Action Card: " + name + "\n" + "Amount: " + payAmount;
    }
}

