public class ActionCard {
    
    public static final String[] NAMEPOOL_STRINGS = {"Collect From Bank", "Pay the Bank", "Pay the Player", "Collect from Player"};
    public static final String[] COLLECTBANK_STRINGS = {"Tax Refund", "Sell an Item", "Bonus Payday", "Setup School", "Write a Book"};
    public static final String[] PAYBANK_STRINGS = {"Buy an Item", "Visit a Place", "Hiking", "Watch a Show", "Win a Competition", "Traffic Violation"};
    public static final String[] PAYPLAYER_STRINGS = {"Lawsuit", "Christmas Bonus"};
    public static final String[] COLLECTPLAYER_STRINGS = {"File a Lawsuit", "It's your Birthday!"};

    private String name;
    private String actionType;
    private int payAmount;

    public ActionCard (String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
    public String getActionType() {
        return actionType;
    }
    public int getPayAmount() {
        return payAmount;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "Action: " + actionType + "\n" +
               "Pay Amount: " + payAmount + "\n";
    }
}