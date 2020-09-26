package Model;

import java.util.ArrayList;
import java.util.Scanner;

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
    
    public void initializeData (int numAction, int numCareer, int numSalary, int fill1, int fill2) {
        actionDeck.generateDeck(numAction);
        careerDeck.generateDeck(numCareer);
        salaryDeck.generateDeck(numSalary);
        blueDeck.generateDeck(fill1);
        houseDeck.generateDeck(fill2);

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
            if (mainPath[i] == null) 
                mainPath[i] = new OrangeSpace(i);
        }

        for (int i = 0; i < changeCareerPath.length; i++) {
            if (changeCareerPath[i] == null) 
            changeCareerPath[i] = new OrangeSpace(i);
        }

        for (int i = 0; i < changeCareerPath.length; i++) {
            if (changeCareerPath[i] == null) 
            changeCareerPath[i] = new OrangeSpace(i);
        }
    }

    /**
     * Allows the player to take a turn (e.g. spin a number and get a card).
     * @param p The current player
     * @param in Input Scanner
     * @param ad The action card deck
     */
    public void takeTurn (Player p, Scanner in, ActionDeck ad,
    CareerDeck cd, BlueDeck bd, SalaryDeck sd, HouseDeck hd) {

        int spin = p.spin();
        Space s = null;
        int i = 0;
        
        switch (p.getCurrentPath()) {
            case "mainPath":
                while (i <= spin && p.getSpace() < mainPath.length) {
                    p.setSpace(p.getSpace()+i);

                    if (mainPath[p.getSpace()] instanceof MagentaSpace)
                        break;
                    i++;     
                }

                s = mainPath[p.getSpace()];
                break;

            case "careerPath":
                while (i <= spin && p.getSpace() < careerPath.length) {
                    p.setSpace(p.getSpace()+i);
                    i++;     
                }
                if (i <= spin && p.getSpace() == careerPath.length-1) {
                    p.setCurrentPath("mainPath");
                    p.setSpace(9);

                    while (i <= spin && p.getSpace() < mainPath.length) {
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
                while (i <= spin && p.getSpace() < changeCareerPath.length) {
                    p.setSpace(p.getSpace()+i);
                    i++;     
                }
                if (i <= spin && p.getSpace() == changeCareerPath.length-1) {
                    p.setCurrentPath("mainPath");
                    p.setSpace(28);
                    
                    while (i <= spin && p.getSpace() < mainPath.length) {
                        p.setSpace(p.getSpace()+i);
    
                        if (mainPath[p.getSpace()] instanceof MagentaSpace)
                            break;
                        i++;
                    }
                }
                s = changeCareerPath[p.getSpace()];
                break;
        }  

        System.out.println(p.getSpace());
        if (p.getSpace() == mainPath.length - 1)
            p.retire(players);
        else   
            checkSpace(s, p, in, ad, cd, bd, sd, hd);
    }

    public void checkSpace (Space s, Player p, Scanner in, ActionDeck ad,
    CareerDeck cd, BlueDeck bd, SalaryDeck sd, HouseDeck hd) {

        if (s instanceof OrangeSpace) 

            p.receiveActionCard(ad.drawCard(), in, players);

        else if (s instanceof BlueSpace)

            p.receiveBlueCard(bd.drawCard(), players);

        else if (s instanceof GreenSpace) {

            if (((GreenSpace) s).getGreenDescription() == GreenSpace.GREEN[0])
                p.setCash(p.getCash() + p.getSalaryCard().computeSalary());
            else {
                p.getSalaryCard().setSalary((int)(p.getSalaryCard().getSalary() * 1.1));
                p.getSalaryCard().setTax((int)(p.getSalaryCard().getTax() + 2000));
            }

        } else if (s instanceof MagentaSpace) {
            switch (((MagentaSpace) s).getMagentaDescription()) {
                case "College Career Choice! Pick a Career and Salary Card!":
                    p.receiveCareerCard(cd.drawCard(), cd.drawCard(), cd, in);
                    p.receiveSalaryCard(sd.drawCard(), sd.drawCard(), sd, in);
                    break;

                case "Job Search! Choose a new Career or keep your current one!":
                    p.jobSearch(cd.drawCard(), sd.drawCard(), cd, sd, in);
                    break;

                case "Buy a House! Choose a house of your choice!":
                    p.receiveHouseCard(hd.drawCard(), hd.drawCard(), hd, in);
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
                        System.out.println("Already married!");
                    break;

                case "Have a Baby or Twins! Spin a number for your gift!":
                    if (p.getIsMarried() == true) {
                        int choice = Integer.parseInt(in.nextLine());
                        switch (choice) {
                            case 1: 
                                p.setCash(p.getCash() + 5000 * players.size());
                                break;
                            case 2:
                                p.setCash(p.getCash() + 10000 * players.size());
                                break;
                        }
                    } else
                        System.out.println("You are not married!");
                    break;

                case "Which Path? Change your career or go start a family!":
                    int choice = Integer.parseInt(in.nextLine());
                    if (choice == 1) { 
                        p.setCurrentPath("changeCareerPath");
                        p.setSpace(0);
                    } 
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

    public Space[] getcareerPath() {
        return careerPath;
    }

    public Space[] getChangeCareerPath() {
        return changeCareerPath;
    }
}