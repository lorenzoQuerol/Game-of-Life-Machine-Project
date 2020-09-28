package Model;

import java.util.Collections;

public class ActionDeck extends Deck<ActionCard> {

    /**
     * Constructor for an action card deck object. It creates a temporary
     * array list, as well as a deque for pushing action card objects into.
     * It extends from abstract class Deck.
     */

    public ActionDeck() {
        super();
    }

    /**
     * Generates and shuffles a new action card deck.
     */
    @Override
    public void generateDeck(int amount) {
        temp.clear();
        /*
        The temporary array list is used to generate the action deck values into
        its respective proportions per type of action card.
        ~~~
        "Collect from bank" and "Pay the bank" action cards each comprise 40% (20 cards each) of the deck
        "Collect from player" and "Pay the player" action cards each comprise 10% (5 cards each) of the deck
        */

        int fortyPercent = (int) (amount * 0.4);
        int tenPercent = (int) (amount * 0.1);

        for(int i = 0; i < fortyPercent; i++) {
            temp.add(new ActionCard(ActionCard.ACTIONCARD[2]));
            temp.add(new ActionCard(ActionCard.ACTIONCARD[3]));
        }

        for(int j = 0; j < tenPercent; j++) {
            temp.add(new ActionCard(ActionCard.ACTIONCARD[2]));
            temp.add(new ActionCard(ActionCard.ACTIONCARD[3]));
        }

        int k = 0;
        // This fills up the card stack to the specified AMOUNT if the stack comes short of cards from previous loops
        while (temp.size() < amount) {
            temp.add(new ActionCard(ActionCard.ACTIONCARD[k]));
            if (k == 3)
                k = 0;
            else
                k++;
        }

        /*
        The newly instantiated action card objects are then assigned randomly generated action types that depends on 
        the name of the card. It then assigns the pay value that the programmers specified for the card.
        */
        for(ActionCard card : temp) {
            switch(card.getName()) {
                case "Collect From Bank":
                    card.setActionType(ActionCard.COLLECTBANK[(int)(Math.random() * (5))]);
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
                    card.setActionType(ActionCard.PAYBANK[(int)(Math.random() * (6))]);
                    switch(card.getActionType()) {
                        case "Buy an Item":
                            card.setPayAmount(10000);
                            break;

                        case "Visit a Place":
                            card.setPayAmount(25000);
                            break;

                        case "Hiking":
                            card.setPayAmount(20000);
                            break;

                        case "Watch a Show":
                            card.setPayAmount(2500);
                            break;

                        case "Win a Competition":
                            card.setPayAmount(15000);
                            break;

                        case "Traffic Violation":
                            card.setPayAmount(1000);
                            break;
                    }
                    break;

                case "Pay the Player": 
                    card.setActionType(ActionCard.PAYPLAYER[(int)(Math.random() * (2))]);
                    switch(card.getActionType()) {
                        case "Lawsuit":
                            card.setPayAmount(50000);
                            break;

                        case "Christmas Bonus":
                            card.setPayAmount(25000);
                            break;
                    }
                    break;

                case "Collect from Player": 
                    card.setActionType(ActionCard.COLLECTPLAYER[(int)(Math.random() * (2))]);
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

        /*
        The temporary array list uses the Collections API to shuffle the deck twice before
        being pushed into the deque for use by the players.
        */
        Collections.shuffle(temp);
        Collections.shuffle(temp);
    }
}