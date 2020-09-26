package Model;

import javafx.event.ActionEvent;

import java.util.ArrayList;

public class Board {

    private Space[] mainPath;
    private Space[] careerPath;
    private Space[] changeCareerPath;

    private ArrayList<Player> players;

    private ActionDeck actionDeck;
    private CareerDeck careerDeck;
    private BlueDeck blueDeck;
    private SalaryDeck salaryDeck;
    private HouseDeck houseDeck;
    private int counter;

    public Board () {
        players = new ArrayList<Player>();
        actionDeck = new ActionDeck();
        careerDeck = new CareerDeck();
        blueDeck = new BlueDeck();
        salaryDeck = new SalaryDeck();
        houseDeck = new HouseDeck();
        mainPath = new Space[42];
        careerPath = new Space[9];
        changeCareerPath = new Space[8];
    }
    
    public void initializeData (int numAction, int numCareer, int numSalary, int fill1, int fill2) throws InterruptedException {

        actionDeck.generateDeck(numAction);
        careerDeck.generateDeck(numCareer);
        salaryDeck.generateDeck(numSalary);
        blueDeck.generateDeck(fill1);
        houseDeck.generateDeck(fill2);

        System.out.println("Action Deck generated amount: " + actionDeck.getDeckSize());
        System.out.println("Career Deck generated amount: " + careerDeck.getDeckSize());
        System.out.println("Salary Deck generated amount: " + salaryDeck.getDeckSize());
        System.out.println("Blue Deck generated amount: " + blueDeck.getDeckSize());
        System.out.println("House Deck generated amount: " + houseDeck.getDeckSize());

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
            if (mainPath[i] == null) {
                mainPath[i] = new OrangeSpace(i);
            }
        }

        for (int i = 0; i < changeCareerPath.length; i++) {
            if (changeCareerPath[i] == null)  {
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
     * @param p The current player
     * @param ad The action card deck
     */
    public Space takeTurn (Player p, int diceRoll, ActionEvent event, ActionDeck ad,
    CareerDeck cd, BlueDeck bd, SalaryDeck sd, HouseDeck hd) {

        Space s = null;
        int i = 0;
        
        switch (p.getCurrentPath()) {
            case "mainPath":
                while (i < diceRoll && p.getSpace() < mainPath.length) {
                    p.setSpace(p.getSpace()+1);

                    if (mainPath[p.getSpace()] instanceof MagentaSpace)
                        break;
                    i++;     
                }
                s = mainPath[p.getSpace()];
                break;

            case "careerPath":
                while (i <= diceRoll && p.getSpace() < careerPath.length) {
                    p.setSpace(p.getSpace()+i);
                    i++;     
                }
                if (i <= diceRoll && p.getSpace() == careerPath.length-1) {
                    p.setCurrentPath("mainPath");
                    p.setSpace(9);

                    while (i <= diceRoll && p.getSpace() < mainPath.length) {
                        p.setSpace(p.getSpace()+i);
    
                        if (mainPath[p.getSpace()] instanceof MagentaSpace)
                            break;
                        i++;
                    }
                    s = mainPath[p.getSpace()];
                } else
                    s = careerPath[p.getSpace()];
                break;

            case "changeCareerPath":
                while (i <= diceRoll && p.getSpace() < changeCareerPath.length) {
                    p.setSpace(p.getSpace()+i);
                    i++;     
                }
                if (i <= diceRoll && p.getSpace() == changeCareerPath.length-1) {
                    p.setCurrentPath("mainPath");
                    p.setSpace(28);
                    
                    while (i <= diceRoll && p.getSpace() < mainPath.length) {
                        p.setSpace(p.getSpace()+i);
    
                        if (mainPath[p.getSpace()] instanceof MagentaSpace)
                            break;
                        i++;
                    }
                }
                s = changeCareerPath[p.getSpace()];
                break;
        }  

        System.out.println(p + " landed on space " + p.getSpace());
        return s;
    }

    public void checkSpace (Space s, Player p, ActionEvent event, ActionDeck ad,
                            CareerDeck cd, BlueDeck bd, SalaryDeck sd, HouseDeck hd) {

        if (s instanceof OrangeSpace) 

            p.receiveActionCard(ad.drawCard(), event, players);

        else if (s instanceof BlueSpace)

            p.receiveBlueCard(bd.drawCard(), players);

        else if (s instanceof GreenSpace) {

            if (((GreenSpace) s).getGreenDescription() == GreenSpace.GREEN[0])
                p.setCash(p.getCash() + p.getSalaryCard().computeSalary());
            else {
                p.getSalaryCard().setSalary((int)(p.getSalaryCard().getSalary() * 1.1));
                p.getSalaryCard().setTax(p.getSalaryCard().getTax() + 2000);
            }

        } else if (s instanceof MagentaSpace) {
            CareerCard c1 = cd.drawCard();
            CareerCard c2 = cd.drawCard();
            SalaryCard s1 = sd.drawCard();
            SalaryCard s2 = sd.drawCard();
            HouseCard h1 = hd.drawCard();
            HouseCard h2 = hd.drawCard();
            switch (((MagentaSpace) s).getMagentaDescription()) {
                case "College Career Choice! Pick a Career and Salary Card!":

                    p.receiveCareerCard(c1, c2, cd, event);
                    p.receiveSalaryCard(s1, s2, sd, event);
                    break;

                case "Job Search! Choose a new Career or keep your current one!":
                    p.jobSearch(c1, s1, cd, sd, event);
                    break;

                case "Buy a House! Choose a house of your choice!":
                    p.receiveHouseCard(h1, h2, hd);
                    break;

                case "Get Married! Spin a number for your wedding gift!":
                    int num = p.spin();
                    if (p.getIsMarried() == false) {

                        p.setMarried(true);

                        if (num % 2 == 0)
                            p.setCash(p.getCash() + (10000 * players.size()));
                        else 
                            p.setCash(p.getCash() + (5000 * players.size())); 
                        
                    } else 
                        System.out.println("Current Player is already married");
                    break;

                case "Have a Baby or Twins! Spin a number for your gift!":
                    if (p.getIsMarried() == true) {
                        int numBabies = ((int)Math.random() * ((2-1)+1)+1);

                        switch (numBabies) {
                            case 1:
                                p.setCash(p.getCash() + 5000 * players.size());
                                break;

                            case 2:
                                p.setCash(p.getCash() + 10000 * players.size());
                                break;
                        }
                    } else
                        System.out.println("Current player is not married");
                    break;

                case "Which Path? Change your career or go start a family!":


                    break;
            }
        }      
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
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

    public Space[] getMainPath() {
        return mainPath;
    }

    public Space[] getCareerPath() {
        return careerPath;
    }

    public Space[] getChangeCareerPath() {
        return changeCareerPath;
    }
}