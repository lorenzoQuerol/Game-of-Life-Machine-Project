import java.util.Collections;
import java.util.Stack;

public class CareerDeck {

	private Stack<Integer> careerCardDeck;
	
	public CareerDeck () {
		careerCardDeck  = new Stack<Integer>();
	}

	public void generateNewCareerDeck () {
		for (int i = 1; i <= 7; i++)
			careerCardDeck.push(i);

		Collections.shuffle(careerCardDeck);
		Collections.shuffle(careerCardDeck);
	}

	public int getCareerCard () {
		return careerCardDeck.pop();
	}	
}