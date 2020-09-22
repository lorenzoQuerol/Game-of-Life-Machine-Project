package Model;

import java.util.Collections;

public class CareerDeck extends Deck<CareerCard> {

	public CareerDeck () {
		super();
	}

	@Override
	public void generateDeck() {
		for (int i = 0; i < CareerCard.CAREER.length; i++)
			temp.add(new CareerCard(CareerCard.CAREER[i]));
		
		for (CareerCard card : temp) {
			switch (card.getName()) {
				case "Lawyer":
					card.setPayRaise((int)Math.random() * ((8-5)+1) + 5);
					break;

				case "Accountant":
					card.setPayRaise((int)Math.random() * ((7-4)+1) + 4);
					break;

				case "Computer Consultant":
					card.setPayRaise((int)Math.random() * ((7-3)+1) + 3);	
					break;

				case "Doctor":
					card.setPayRaise((int)Math.random() * ((8-5)+1) + 5);
					break;

				case "Server":
					card.setPayRaise((int)Math.random() * ((4-1)+1) + 1);
					break;

				case "Racecar Driver":
					card.setPayRaise((int)Math.random() * ((8-2)+1) + 2);
					break;
					
				case "Athlete":
					card.setPayRaise((int)Math.random() * ((6-1)+1) + 1);
					break;
			}
		}

		Collections.shuffle(temp);
		Collections.shuffle(temp);

		for (CareerCard card: temp)
			deck.push(card);
			
		temp.clear();
	}
} 

	
	
	
