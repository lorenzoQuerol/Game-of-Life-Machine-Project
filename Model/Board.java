package Model;

import javafx.event.ActionEvent;

import java.util.ArrayList;

public class Board {

    private Space[] mainPath;
    private Space[] careerPath;
    private Space[] changeCareerPath;

    private ArrayList<Player> players;
    private ArrayList<Player> winners;
    private ActionDeck actionDeck;
    private CareerDeck careerDeck;
    private BlueDeck blueDeck;
    private SalaryDeck salaryDeck;
    private HouseDeck houseDeck;
    private int counter;

    /**
     * This constructs the board and instantiates all its dependencies
     */
    public Board() {
        players = new ArrayList<Player>();
        winners = new ArrayList<Player>();
        actionDeck = new ActionDeck();
        careerDeck = new CareerDeck();
        blueDeck = new BlueDeck();
        salaryDeck = new SalaryDeck();
        houseDeck = new HouseDeck();
        mainPath = new Space[42];
        careerPath = new Space[9];
        changeCareerPath = new Space[11]; // changed
    }

    /**
     * This initializes all data needed for a proper game flow
     * @param numAction amount of action cards to be generated
     * @param numCareer amount of career cards to be generated
     * @param numSalary amount of salary cards to be generated
     * @param fill1 filler value for blue cards
     * @param fill2 filler value for house cards
     */
    public void initializeData(int numAction, int numCareer, int numSalary, int fill1, int fill2) {

        actionDeck.generateDeck(numAction);
        careerDeck.generateDeck(numCareer);
        salaryDeck.generateDeck(numSalary);
        blueDeck.generateDeck(fill1);
        houseDeck.generateDeck(fill2);

        System.out.println("Action Deck generated amount: " + actionDeck.getTemp().size());
        System.out.println("Career Deck generated amount: " + careerDeck.getTemp().size());
        System.out.println("Salary Deck generated amount: " + salaryDeck.getTemp().size());
        System.out.println("Blue Deck generated amount: " + blueDeck.getTemp().size());
        System.out.println("House Deck generated amount: " + houseDeck.getTemp().size());

        mainPath[8] = new MagentaSpace(8, MagentaSpace.MAGENTA[0]);
        mainPath[15] = new MagentaSpace(15, MagentaSpace.MAGENTA[1]);
        mainPath[19] = new MagentaSpace(19, MagentaSpace.MAGENTA[5]);
        mainPath[21] = new MagentaSpace(21, MagentaSpace.MAGENTA[3]);
        mainPath[30] = new MagentaSpace(30, MagentaSpace.MAGENTA[4]);
        mainPath[33] = new MagentaSpace(33, MagentaSpace.MAGENTA[2]);

        mainPath[17] = new GreenSpace(17, GreenSpace.GREEN[0]);
        mainPath[29] = new GreenSpace(29, GreenSpace.GREEN[1]);
        mainPath[35] = new GreenSpace(35, GreenSpace.GREEN[0]);

        mainPath[24] = new BlueSpace(24);
        mainPath[38] = new BlueSpace(38);

        careerPath[3] = new GreenSpace(3, GreenSpace.GREEN[1]);
        careerPath[8] = new GreenSpace(8, GreenSpace.GREEN[0]);
        careerPath[6] = new BlueSpace(6);

        changeCareerPath[1] = new BlueSpace(1);
        changeCareerPath[3] = new GreenSpace(3, GreenSpace.GREEN[0]);

        for (int i = 0; i < mainPath.length; i++) {
            if (mainPath[i] == null && i != 41) {
                mainPath[i] = new OrangeSpace(i); // Change back to OrangeSpace once testing is done <3
            }
        }

        for (int i = 0; i < changeCareerPath.length; i++) {
            if (changeCareerPath[i] == null) {
                changeCareerPath[i] = new OrangeSpace(i);
            }
        }

        for (int i = 0; i < changeCareerPath.length; i++) {
            if (changeCareerPath[i] == null) {
                changeCareerPath[i] = new OrangeSpace(i);
            }
        }
    }

    /**
     * Allows the player to take a turn (e.g. spin a number and get a card).
     *  @param p  The current player
     * @return
     */
    public Space takeTurn(Player p, int diceRoll) {

        Space s = null;
        int i = 0;

        switch (p.getCurrentPath()) {
            case "mainPath":
                while (i < diceRoll && p.getSpace() < mainPath.length) {
                    p.setSpace(p.getSpace() + 1);

                    if (mainPath[p.getSpace()] instanceof MagentaSpace) {
                        break;
                    }
                    i++;
                }
                s = mainPath[p.getSpace()];
                break;

            case "careerPath":
                while (i < diceRoll && p.getSpace() < careerPath.length) {
                    p.setSpace(p.getSpace() + 1);
                    i++;
                }

                if (i < diceRoll && p.getSpace() >= careerPath.length) {
                    p.setCurrentPath("mainPath");
                    p.setSpace(9);

                    while (i < diceRoll && p.getSpace() < mainPath.length) {
                        p.setSpace(p.getSpace() + 1);

                        if (mainPath[p.getSpace()] instanceof MagentaSpace)
                            break;
                        i++;
                    }
                    s = mainPath[p.getSpace()];
                } else
                    s = careerPath[p.getSpace()];
                break;

            case "changeCareerPath":
                while (i < diceRoll && p.getSpace() < changeCareerPath.length) {
                    p.setSpace(p.getSpace() + 1);
                    i++;
                }
                if (i < diceRoll && p.getSpace() >= changeCareerPath.length) {
                    p.setCurrentPath("mainPath");
                    p.setSpace(28);

                    while (i < diceRoll && p.getSpace() < mainPath.length) {
                        p.setSpace(p.getSpace() + 1);

                        if (mainPath[p.getSpace()] instanceof MagentaSpace)
                            break;
                        i++;
                    }
                    s = mainPath[p.getSpace()];
                } else
                    s = changeCareerPath[p.getSpace()];
                break;
        }

        System.out.println(p + " landed on space " + p.getSpace());
        return s;
    }

    /**
     * Checks the current space the player is on
     * @param p current player
     * @return string value of the type of space
     */
    public String checkSpace(Player p) {
        if (p.getSpaceType() instanceof GreenSpace)
            return "green";
        else if (p.getSpaceType() instanceof OrangeSpace)
            return "orange";
        else if (p.getSpaceType() instanceof BlueSpace)
            return "blue";
        else if (p.getSpaceType() == null)
            return "null";

        return "magenta";
    }

    /**
     * Gets the winners of the game
     * @return arraylist of players who reached the end of the board
     */
    public ArrayList<Player> getWinners() {
        return winners;
    }

    /**
     * Gets the counter (active player)
     * @return integer value or count of who is playing
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Sets the value of counter when the next player spins
     * @param counter integer value or count of who is playing
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * Gets the current players of the game
     * @return arraylist of players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Gets the action card deck
     * @return deck of action cards
     */
    public ActionDeck getActionDeck() {
        return actionDeck;
    }

    /**
     * Gets the blue card deck
     * @return deck of blue cards
     */
    public BlueDeck getBlueDeck() {
        return blueDeck;
    }

    /**
     * Gets the career card deck
     * @return deck of career cards
     */
    public CareerDeck getCareerDeck() {
        return careerDeck;
    }

    /**
     * Gets the salary card deck
     * @return deck of salary cards
     */
    public SalaryDeck getSalaryDeck() {
        return salaryDeck;
    }

    /**
     * Gets the house card deck
     * @return deck of house cards
     */
    public HouseDeck getHouseDeck() {
        return houseDeck;
    }

    /**
     * Gets the main path
     * @return array of Spaces denoted as main path
     */
    public Space[] getMainPath() {
        return mainPath;
    }

    /**
     * Gets the career path
     * @return array of Spaces denoted as career path
     */
    public Space[] getCareerPath() {
        return careerPath;
    }

    /**
     * Gets the change career path
     * @return array of Spaces denoted as change career  path
     */
    public Space[] getChangeCareerPath() {
        return changeCareerPath;
    }
}