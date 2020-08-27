public class ActionCard {
    
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

    public void setName(String name) {
        this.name = name;
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