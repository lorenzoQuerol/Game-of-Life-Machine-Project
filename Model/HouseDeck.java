package Model;

import java.util.Collections;

public class HouseDeck extends Deck<HouseCard> {

    /**
     * Generates the house card deck
     * @param amount amount of house cards to be generated in a deck
     */
    @Override
    public void generateDeck(int amount) {
        temp.clear();
        for (int i = 0; i < 5; i++)
            temp.add(new HouseCard(HouseCard.HOUSE[i], HouseCard.HOUSE_ODD[i], HouseCard.HOUSE_EVEN[i]));

    }
}
