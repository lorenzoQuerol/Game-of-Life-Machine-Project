import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Stack;

public class ActionDeck {
    
    private Deque<ActionCard> actionCardDeck;
    private ArrayList<ActionCard> temp;

    public ActionDeck() {
        actionCardDeck = new ArrayDeque<>();
        temp = new ArrayList<ActionCard>();
    }

    public void generateActionDeck () {
        System.out.println("Generating and Shuffling New Deck!");

        for(int j = 0; j < 20; j++) {
            temp.add(new ActionCard(ActionCard.NAMEPOOL_STRINGS[0]));
            temp.add(new ActionCard(ActionCard.NAMEPOOL_STRINGS[1]));
        }
        for(int j = 0; j < 5; j++) {
            temp.add(new ActionCard(ActionCard.NAMEPOOL_STRINGS[2]));
            temp.add(new ActionCard(ActionCard.NAMEPOOL_STRINGS[3]));
        }
            
        for(ActionCard card : temp) {
            switch(card.getName()) {
                case "Collect From Bank":
                    card.setActionType(ActionCard.COLLECTBANK_STRINGS[(int)(Math.random() * (5))]);
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
                    card.setActionType(ActionCard.PAYBANK_STRINGS[(int)(Math.random() * (6))]);
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
                    card.setActionType(ActionCard.PAYPLAYER_STRINGS[(int)(Math.random() * (2))]);
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
                    card.setActionType(ActionCard.COLLECTPLAYER_STRINGS[(int)(Math.random() * (2))]);
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
    
        temp.clear(); 
    }

    public ActionCard drawActionCard() {
        return actionCardDeck.pop();
    }

    private boolean deckEmpty() {
        return actionCardDeck.isEmpty();
    }

    @Override   
    public String toString() {
        return "Current Stack: " + actionCardDeck;
    }
}