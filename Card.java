
/*
Card Type Legend:
(1) Career
(2) Salary
(3) Blue
(4) Action
*/
public class Card {
    private int cardType;
    private String cardName;
}

public class ActionCard extends Card {

    
    private String actionText;
    private int payAmount;

    public String getActionText () {
        return this.actionText;
    }

    public int getActionText () {
        return this.payAmount;
    }
}