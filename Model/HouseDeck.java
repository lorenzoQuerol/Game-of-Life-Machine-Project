package Model;

import java.util.Collections;

public class HouseDeck extends Deck<HouseCard> {

    @Override
    public void generateDeck(int amount) throws InterruptedException {
        temp.clear();
        for (int i = 0; i < 5; i++)
            temp.add(new HouseCard(HouseCard.HOUSE[i], HouseCard.HOUSE_ODD[i], HouseCard.HOUSE_EVEN[i]));

    }
}
