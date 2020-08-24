import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class CareerDeck {

	private Stack<Integer> CareerCard;
	private ArrayList<Integer> temp;

	
	public CareerDeck () {
		careerCardDeck = new Stack<Integer>();
		temp = new ArrayList<Integer>();
	}

	public void generateNewCareerDeck () {
		for (int i = 1; i <= 7; i++)
			careerCardDeck.push(i);

		Collections.shuffle(careerCardDeck);
		Collections.shuffle(careerCardDeck);
	}

	public int getCareerCard () {
		careerCardDeck.pop();
	}

	
}