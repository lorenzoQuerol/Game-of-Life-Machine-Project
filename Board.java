import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    private int[] mainPath;
    private int[] careerPath;
    private int[] changeCareerPath;

    private ArrayList<Player> players;

    private ActionDeck actionDeck;
    private CareerDeck careerDeck;
    private BlueDeck blueDeck;
    private SalaryDeck salaryDeck;
    private HouseDeck houseDeck;

    public Board () { 
        players = new ArrayList<Player>();
        actionDeck = new ActionDeck();
        careerDeck = new CareerDeck();
        blueDeck = new BlueDeck();
        salaryDeck = new SalaryDeck();
        houseDeck = new HouseDeck();
        mainPath = new int[75];
        careerPath = new int[10];
        changeCareerPath = new int[10];
    }
    
    public void initializeData () {
        actionDeck.generateDeck();
        careerDeck.generateDeck();
        blueDeck.generateDeck();
        salaryDeck.generateDeck();
        houseDeck.generateDeck();
    }

    /**
     * Allows the player to take a turn (e.g. spin a number and get a card).
     * @param p The current player
     * @param in Input Scanner
     * @param actionDeck The action card deck
     * @param gameOver The status of the game
     * @return A boolean value if the game is over
     */
    public boolean takeTurn (Player p, Scanner in, ActionDeck actionDeck, boolean gameOver) {
        System.out.println("Card #" + actionDeck.getDeckSize());
        System.out.println(p.getName() + "'s turn!");
        p.receiveActionCard(actionDeck.drawCard(), in, players);
        if (actionDeck.getDeckSize() == 0) //Continuous Action Card Generation after it runs out
            actionDeck.generateDeck();
        
        return gameOver;        
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ActionDeck getActionDeck() {
        return actionDeck;
    }

    public BlueDeck getBlueDeck() {
        return blueDeck;
    }

    public CareerDeck getCareerDeck() {
        return careerDeck;
    }

    public SalaryDeck getSalaryDeck() {
        return salaryDeck;
    }

    public HouseDeck getHouseDeck() {
        return houseDeck;
    }

}