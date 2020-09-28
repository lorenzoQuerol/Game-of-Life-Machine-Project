package Model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

abstract class Deck<C> {

    protected Deque<C> deck;
    protected ArrayList<C> temp;

    /**
     * This is a generic constructor for the Deck abstract class
     */
    public Deck () {
        deck = new ArrayDeque<>();
        temp = new ArrayList<>();  
    }

    /**
     * Generates the card deck
     * @param amount amount specified by player
     */
    public abstract void generateDeck(int amount);

    /**
     * Gets card deck
     * @return card deck
     */
    public Deque<C> getDeck() {
        return deck;
    }

    /**
     * Draws a card from the card deck
     * @return card
     */
    public C drawCard() {
        return deck.pop();
    }

    /**
     * Gets the temporary arraylist of the card deck
     * @return arraylist of cards
     */
    public ArrayList<C> getTemp() {
        return temp;
    }

    /**
     * Formats the string
     * @return formatted string
     */
    @Override
    public String toString() {
        return "Deck: " + deck;
    }
}
