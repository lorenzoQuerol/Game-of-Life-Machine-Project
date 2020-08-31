public class ActionCard {
    
    // Possible names for the action card
    public static final String[] NAMEPOOL_STRINGS = {"Collect From Bank", "Pay the Bank", "Pay the Player", "Collect from Player"};

    // Possible action types for the action card
    public static final String[] COLLECTBANK_STRINGS = {"Tax Refund", "Sell an Item", "Bonus Payday", "Setup School", "Write a Book"};
    public static final String[] PAYBANK_STRINGS = {"Buy an Item", "Visit a Place", "Hiking", "Watch a Show", "Win a Competition", "Traffic Violation"};
    public static final String[] PAYPLAYER_STRINGS = {"Lawsuit", "Christmas Bonus"};
    public static final String[] COLLECTPLAYER_STRINGS = {"File a Lawsuit", "It's your Birthday!"};

    // Instance variables for an action card
    private String name;
    private String actionType;
    private int payAmount;

    /**
     * Constructor for an ActionCard object. It assigns the name of the card.
     * @param n The name randomly assigned to the new card object instantiated
     */
    public ActionCard (String n) {
        name = n;
    }

    /**
     * Gets the name of the action card.
     * @return The name of the action card
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the action type of the action card.
     * @return The action type of the action card
     */
    public String getActionType() {
        return actionType;
    }

    /**
     * Gets the pay value of the action card.
     * @return The pay value of the action card.
     */
    public int getPayAmount() {
        return payAmount;
    }

    /**
     * Sets the action type for the action card.
     * @param actionType The action type randomly assigned to the action card
     */
    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    /**
     * Sets the pay value that corresponds to the action type of the action card.
     * @param payAmount The pay value assigned to its respective action type
     */
    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * Formats the output for an action card.
     */
    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "Action: " + actionType + "\n" +
               "Pay Amount: " + payAmount + "\n";
    }
} 