package Model;

public class Model {

    private static Model model = null;
    private Board b;
    private int starterCash;
    private int numAction;
    private int numSalary;
    private int numCareer;
    private int numPlayers;

    private Model () {
        this.b = new Board();
        this.starterCash = 200000;
        this.numAction = 50;
        this.numCareer = 7;
        this.numSalary = 10;
    }

    public static Model getInstance()
    {
        if (model == null)
            model = new Model();

        return model;
    }

    public int getStarterCash() {
        return starterCash;
    }

    public int getNumAction() {
        return numAction;
    }

    public int getNumCareer() {
        return numCareer;
    }

    public int getNumSalary() {
        return numSalary;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void setStarterCash(int starterCash) {
        this.starterCash = starterCash;
    }

    public void setNumAction(int numAction) {
        this.numAction = numAction;
    }

    public void setNumCareer(int numCareer) {
        this.numCareer = numCareer;
    }

    public void setNumSalary(int numSalary) {
        this.numSalary = numSalary;
    }

    public Board getB() {
        return b;
    }
}
