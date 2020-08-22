import java.util.Arrays;
import java.util.Stack;

class Main {

    public static void main(String[] args) {
        ActionDeck actionDeck = new ActionDeck();
        ActionCard actionCard = new ActionCard();
        actionDeck.generateNewDeck();
        actionDeck.assignActions();
        actionDeck.getCard();
        actionCard.checkActionCard(actionDeck);
        System.out.println(actionCard);
    }

    
}