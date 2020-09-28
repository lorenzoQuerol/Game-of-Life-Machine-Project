package Model;

import java.util.Collections;

public class BlueDeck extends Deck<BlueCard> {

    public BlueDeck() {
        super();
    }

    @Override
    public void generateDeck(int amount) throws InterruptedException {
        temp.clear();
        for (int i = 0; i < 7; i++)
            temp.add(new BlueCard(BlueCard.BLUE[i], CareerCard.CAREER[i]));
        Collections.shuffle(temp);
        Collections.shuffle(temp);

    }
}

