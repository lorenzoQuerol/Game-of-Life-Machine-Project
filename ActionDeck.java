import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class ActionDeck {
    
    private Stack<ActionCard> actionCardDeck;
    private ArrayList<ActionCard> temp;

    public ActionDeck() {
        actionCardDeck = new Stack<ActionCard>();
        temp = new ArrayList<ActionCard>();
    }

    public void generateActionDeck () {
        System.out.println("Generating and Shuffling New Deck!");
        String[] namePool = {"Collect From Bank", "Pay the Bank", "Pay the Player", "Collect from Player"};
        String[] collectBankPool = {"Tax Refund", "Sell an Item", "Bonus Payday", "Setup School", "Write a Book"};
        String[] payBankPool = {"Buy an Item", "Visit a Place", "Hiking", "Watch a Show", "Win a Competition", "Traffic Violation"};
        String[] payPlayerPool = {"Lawsuit", "Christmas Bonus"};
        String[] collectPlayerPool = {"File a Lawsuit", "It's your Birthday!"};

        for(int j = 0; j < 20; j++) {
            temp.add(new ActionCard(namePool[0]));
            temp.add(new ActionCard(namePool[1]));
        }
        for(int j = 0; j < 5; j++) {
            temp.add(new ActionCard(namePool[2]));
            temp.add(new ActionCard(namePool[3]));
        }
            
        for(ActionCard card : temp) {
            switch(card.getName()) {
                case "Collect From Bank":
                    card.setActionType(collectBankPool[(int)(Math.random() * (5))]);
                    switch(card.getActionType()) {
                        case "Tax Refund":
                            card.setPayAmount(15000);
                            break;
                        case "Sell an Item":
                            card.setPayAmount(7500);
                            break;
                        case "Bonus Payday":
                            card.setPayAmount(20000);
                            break;
                        case "Setup School":
                            card.setPayAmount(50000);
                            break;
                        case "Write a Book":
                            card.setPayAmount(10000);   
                            break;
                    }
                    break;

                case "Pay the Bank":
                    card.setActionType(payBankPool[(int)(Math.random() * (5))]);
                    switch(card.getActionType()) {
                        case "Buy an Item":
                            card.setPayAmount(-10000);
                            break;
                        case "Visit a Place":
                            card.setPayAmount(-25000);
                            break;
                        case "Hiking":
                            card.setPayAmount(-20000);
                            break;
                        case "Watch a Show":
                            card.setPayAmount(-2500);
                            break;
                        case "Win a Competition":
                            card.setPayAmount(-15000);
                            break;
                        case "Traffic Violation":
                            card.setPayAmount(-1000);
                            break;
                    }
                    break;

                case "Pay the Player": 
                    card.setActionType(payPlayerPool[(int)(Math.random() * (2))]);
                    switch(card.getActionType()) {
                        case "Lawsuit":
                            card.setPayAmount(-50000);
                            break;
                        case "Christmas Bonus":
                            card.setPayAmount(-25000);
                            break;
                    }
                    break;

                case "Collect from Player": 
                    card.setActionType(collectPlayerPool[(int)(Math.random() * (2))]);
                    switch(card.getActionType()) {
                        case "File a Lawsuit":
                            card.setPayAmount(30000);
                            break;
                        case "It's your Birthday!":
                            card.setPayAmount(15000);
                            break;
                    }
                    break;
            }
        }
        Collections.shuffle(temp);
        Collections.shuffle(temp);

        for (ActionCard card: temp)
            actionCardDeck.push(card);
    }

    public ActionCard drawCard () {
        return actionCardDeck.pop();
    }

    public boolean deckEmpty () {
        return actionCardDeck.empty();
    }

    @Override
    public String toString() {
        return "Current Stack: " + actionCardDeck;
    }
}