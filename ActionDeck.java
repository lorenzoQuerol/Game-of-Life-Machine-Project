import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class ActionDeck {

    // Instance variables for an action card deck
    private Deque<ActionCard> actionCardDeck;
    private ArrayList<ActionCard> temp;

    /**
     * Constructor for an action card deck object. It creates a temporary
     * array list, as well as a deque for pushing action card objects into.
     */
    public ActionDeck() {
        actionCardDeck = new ArrayDeque<>();
        temp = new ArrayList<ActionCard>();
    }
    
    /**
     * Gets the action card deck's size.
     * @return The current size of the action card deck
     */
    public int getActionDeckSize () {
        return actionCardDeck.size();
    }

    /**
     * Generates and shuffles a new action card deck.
     */
    public void generateActionDeck () {
        System.out.println("Generating and Shuffling New Action Card Deck!");

        /*
        The temporary array list is used to generate the action deck values into
        its respective proportions per type of action card.
        ~~~
        "Collect from bank" and "Pay the bank" action cards each comprise 40% (20 cards each) of the deck
        "Collect from player" and "Pay the player" action cards each comprise 10% (5 cards each) of the deck
        */
        for(int j = 0; j < 20; j++) {
            temp.add(new ActionCard(ActionCard.NAMEPOOL_STRINGS[0]));
            temp.add(new ActionCard(ActionCard.NAMEPOOL_STRINGS[1]));
        }
        for(int j = 0; j < 5; j++) {
            temp.add(new ActionCard(ActionCard.NAMEPOOL_STRINGS[2]));
            temp.add(new ActionCard(ActionCard.NAMEPOOL_STRINGS[3]));
        }
        
        /*
        The newly instantiated action card objects are then assigned randomly generated action types that depends on 
        the name of the card. It then assigns the pay value that the programmers specified for the card.
        */
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

        /*
        The temporary array list uses the Collections API to shuffle the deck twice before
        being pushed into the deque for use by the players.
        */
        Collections.shuffle(temp);
        Collections.shuffle(temp);

        for (ActionCard card: temp)
            actionCardDeck.push(card);

        /*
        This is necessary to reset the temporary array list before generating a new
        deck of action cards in the future.
        */
        temp.clear(); 
    }

    /**
     * Let's the player draw a card from the action card deck. If the 
     * action card deck is empty, it calls the generationActionDeck method.
     * @return An action card
     */
    public ActionCard drawActionCard() {
        if (deckEmpty())
            generateActionDeck();
        return actionCardDeck.pop();
    }

    /** 
     * Checks the action card deck if it is empty.
     * @return A boolean value if the deck is empty or not
     */
    private boolean deckEmpty() {
        return actionCardDeck.isEmpty();
    }

    /**
     * Formats the output for the action card deck.
     */
    @Override   
    public String toString() {
        return "Current Stack: " + actionCardDeck;
    }
}