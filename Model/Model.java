package Model;

public class Model {

    private static Model model = null;
    private Board b;
    private int starterCash;
    private int numAction;
    private int numSalary;
    private int numCareer;
    private int numPlayers;

    /**
     * Constructs a singleton class of the model
     */
    private Model() {
        this.b = new Board();
        this.starterCash = 200000;
        this.numAction = 50;
        this.numCareer = 7;
        this.numSalary = 10;
    }

    /**
     * Gets the instance of the singleton class
     * @return the instance of model
     */
    public static Model getInstance() {
        if (model == null)
            model = new Model();

        return model;
    }

    /**
     * Gets the starter cash specified by player
     * @return starter cash
     */
    public int getStarterCash() {
        return starterCash;
    }

    /**
     * Gets the starter amount of action cards for the game
     * @return starter amount of action cards
     */
    public int getNumAction() {
        return numAction;
    }

    /**
     * Gets the starter amount of career cards for the game
     * @return starter amount of career cards
     */
    public int getNumCareer() {
        return numCareer;
    }

    /**
     * Gets the starter amount of salary cards for the game
     * @return starter amount of salary cards
     */
    public int getNumSalary() {
        return numSalary;
    }

    /**
     * Gets the current number of players
     * @return current number of players
     */
    public int getNumPlayers() {
        return numPlayers;
    }

    /**
     * Sets the number of players
     * @param numPlayers the number of players
     */
    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    /**
     * Sets the starter cash
     * @param starterCash the value specified by player
     */
    public void setStarterCash(int starterCash) {
        this.starterCash = starterCash;
    }

    /**
     * Sets the value of the amount of action cards to be generated
     * @param numAction the value specified by player
     */
    public void setNumAction(int numAction) {
        this.numAction = numAction;
    }

    /**
     * Sets the value of the amount of career cards to be generated
     * @param numCareer the value specified by player
     */
    public void setNumCareer(int numCareer) {
        this.numCareer = numCareer;
    }

    /**
     * Sets the value of the amount of salary cards to be generated
     * @param numSalary the value specified by player
     */
    public void setNumSalary(int numSalary) {
        this.numSalary = numSalary;
    }

    /**
     * Gets the board
     * @return the board object
     */
    public Board getB() {
        return b;
    }
}
