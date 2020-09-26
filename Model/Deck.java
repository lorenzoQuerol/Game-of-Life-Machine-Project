package Model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

abstract class Deck<C> {

    protected Deque<C> deck;
    protected ArrayList<C> temp;
    
    public Deck () {
        deck = new ArrayDeque<>();
        temp = new ArrayList<>();  
    }


    public abstract void generateDeck(int amount) throws InterruptedException;
//    public abstract void generateDeck(int amount);

    public int getDeckSize() {
        return deck.size(); 
    }

    public C drawCard() {
        return deck.pop();
    }

    public void displayDeck() {
        System.out.println(deck);
    }

    protected boolean deckEmpty() {
        return deck.isEmpty();
    }

    @Override
    public String toString() {
        return "Deck: " + deck;
    }
}
