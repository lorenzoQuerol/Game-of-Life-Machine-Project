package Model;

import java.util.Collections;

public class BlueDeck extends Deck<BlueCard> {

    /**
     * The constructor for a blue deck. It extends from the abstract
     * class Deck.
     */
    public BlueDeck() {
        super();
    }

    /**
     * This generates a blue card deck.
     * @param amount The amount to be generated in a deck
     */
    @Override
    public void generateDeck(int amount) {
        temp.clear();
        for (int i = 0; i < 7; i++)
            temp.add(new BlueCard(BlueCard.BLUE[i], CareerCard.CAREER[i]));
        Collections.shuffle(temp);
        Collections.shuffle(temp);

    }
}

