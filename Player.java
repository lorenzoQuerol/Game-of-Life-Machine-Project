public class Player {

    private int playerCash;
    private String playerName;

    private String playerChoice;

    private boolean playerMarried;
    private boolean playerDegreee;

    // private CareerCard playerCareer;
    // private SalaryCard playerSalary;

    private int space;

    public Player () {
        playerCash = 200000;
    }   

    public void setName (String n) {
        playerName = n;
    }

    public void setSpace (int s) {
        space = s;
    }

    public int getSpace () {
        return space;
    }

    public void chooseActionCard (ActionDeck a, ActionCard c) {
        a.getActionCard();
        c.checkActionCard(a);
        System.out.println(c);
    }

    public void displayPlayerInfo () {

    }
}