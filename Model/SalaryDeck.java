package Model;

import java.util.Collections;

public class SalaryDeck extends Deck<SalaryCard> {


    public SalaryDeck () {
        super();
    }

    @Override
    public void generateDeck(int amount) throws InterruptedException {
        int tempSalary = 0;
        int tempTax = 0;

        for(int i = 0; i < amount; i++) {
            tempSalary = 10000 * (int) (Math.random() * ((15-5)+1) + 5);
            tempTax = (int) (tempSalary * 0.1);
            temp.add(new SalaryCard(tempSalary, tempTax));
        }

        Collections.shuffle(temp);
        Collections.shuffle(temp);
    }
}


