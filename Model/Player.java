package Model;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    // Instance variables for a player object
    private int cash;
    private String name;
    private String currentPath;

    private boolean isMarried;
    private boolean isGraduate;
    private boolean isRetired;

    private CareerCard career;
    private SalaryCard salary;
    private HouseCard house;
    private int numChildren;
    private int bankLoan;

    private int space;
    private Space spaceType;
    private int place;

    /**
     * Constructor for a Player object. It assigns the starter cash amount for
     * the player.
     */
    public Player (int cash) {
        this.cash = cash;
    } 

    /**
     * Sets the player's name
     * @param name The player's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the players cash.
     * @param cash The player's cash
     */
    public void setCash(int cash) {
        this.cash = cash;
    }

    /**
     * Sets the player's starting point in the game (i.e. player starts on the college path or career path).
     * @param currentPath The player's path choice when the game starts
     */
    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }
    
    /**
     * Sets the player's marriage status (i.e. married or not married).
     * @param isMarried The player's marriage status
     */
    public void setMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    /**
     * Sets the player's graduate status (i.e. if the player has completed the college path).
     * @param isGraduate The player's college status
     */
    public void setGraduate(boolean isGraduate) {
        this.isGraduate = isGraduate;
    }

    /**
     * Sets the player's career card.
     * @param career The player's current career
     */
    public void setCareer(CareerCard career) {
        this.career = career;
    }

    /**
     * Sets the player's salary card.
     * @param salary The player's current salary
     */
    public void setSalary(SalaryCard salary) {
        this.salary = salary;
    }

    /**
     * Sets the player's house card.
     * @param house The player's current house
     */
    public void setHouse(HouseCard house) {
        this.house = house;
    }

    /**
     * Sets the player's current bank loan (this accumulates if the player runs low on cash).
     * @param bankLoan The player's current bank loan
     */
    public void setBankLoan(int bankLoan) {
        this.bankLoan = bankLoan;
    }

    /**
     * Sets the player's current space on the board.
     * @param space The space the player lands on
     */
    public void setSpace(int space) {
        this.space = space;
    }

    public void setSpaceType(Space spaceType) {
        this.spaceType = spaceType;
    }

    /**
     * Gets the player's name.
     * @return The name of the player
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the player's cash
     * @return The player's current cash
     */
    public int getCash() {
        return cash;
    }
    
    public boolean getIsMarried() {
        return isMarried;
    }

    public boolean getIsGraduate() {
        return isGraduate;
    }

    public boolean getIsRetired() {
        return isRetired;
    }

    /**
     * Gets the player's space.
     * @return The player's current position on the board
     */
    public int getSpace () {
        return space;
    }

    public Space getSpaceType() {
        return spaceType;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public SalaryCard getSalaryCard() {
        return salary;
    }

    public CareerCard getCareerCard() {
        return career;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getPlace() {
        return place;
    }

    public void setRetired(boolean retired) {
        isRetired = retired;
    }

    /**
     * Spins for a random number between 1 to 10.
     * @return The number of spaces the player traverses
     */
    public int spin () {
        return (int)(Math.random() * ((10-1)+1) + 1);
    }
    
    /**
     * This method allows the player to receive an action card and manipulate the player's statistics
     * based on the description of the chosen card.
     * @param a The action card deck

     * @param players The list of current players
     */
    public void receiveActionCard (Player p, ActionCard a, ArrayList<Player> players) {
        String choice;

        /*
        Certain action cards require the interaction of the current player with other players in the game.
        e.g. the player's cash is increased by the amount that was deducted from another player, and vice versa.
        */ 
        switch (a.getActionType()) { 
            case "Lawsuit":
                System.out.println("File a Lawsuit card was drawn");
                if (!bankLoanNeeded(this, a.getPayAmount())) 
                    this.cash += (a.getPayAmount());
                else {
                    while (bankLoanNeeded(this, a.getPayAmount()))
                        makeBankLoan(this);
                    this.cash += (a.getPayAmount());
                }

                p.setCash(p.getCash() + (a.getPayAmount() * -1));
                break;

            case "Christmas Bonus":
                System.out.println("Christmas Bonus card was drawn");

                for (Player x : players) {
                    if (x.getName() == this.name) { // If it reads the name of the current player, skip
                        continue;
                    }

                    if (!bankLoanNeeded(this, a.getPayAmount())) {
                        this.cash += (a.getPayAmount());
                        x.cash += (a.getPayAmount() * -1);
                    } else {
                        while (bankLoanNeeded(this, a.getPayAmount()))
                            makeBankLoan(this);
                        this.cash += (a.getPayAmount());
                        x.cash += (a.getPayAmount() * -1);
                    }             
                }
                break;

            case "File a Lawsuit":
                System.out.println("You Filed a Lawsuit Against Someone card was drawn");
                this.cash += a.getPayAmount();
                p.setCash(p.getCash() + (a.getPayAmount() * -1));
                break;

            case "It's your Birthday!":
                System.out.println("It's your birthday! card was drawn");

                for (Player x : players) {
                    if (x.getName() == this.name) 
                        continue;
                    if (!bankLoanNeeded(x, a.getPayAmount())){
                        this.cash += a.getPayAmount();
                        x.cash += (a.getPayAmount() * -1);
                    } else {
                        while (bankLoanNeeded(x, a.getPayAmount()))
                            makeBankLoan(x);
                        this.cash += a.getPayAmount();
                        x.cash += (a.getPayAmount() * -1);
                    }                    
                }
                break;
            
            default:
                if (!bankLoanNeeded(this, a.getPayAmount()))
                        this.cash += (a.getPayAmount());
                else {
                    while (bankLoanNeeded(this, a.getPayAmount()))
                        makeBankLoan(this);
                    this.cash += (a.getPayAmount());
                }
        }
    }

    public void receiveCareerCard (CareerCard c, CareerCard notChosen, CareerDeck cd) {
        this.career = c;
        cd.deck.addFirst(notChosen);
    }

    public void jobSearch (CareerCard c, SalaryCard s, CareerDeck cd, SalaryDeck sd) {
        System.out.println("Career and Salary Changed via Job Search");
        cd.getDeck().addFirst(this.career);
        sd.getDeck().addFirst(this.salary);
        this.career = c;
        this.salary = s;
    }

    public void receiveBlueCard (BlueCard b, ArrayList<Player> players){
        boolean hasBlueCard = false;

        // case 1: player's career matches blue card
        if (b.getCareerLink() == this.career.getName()) 
            this.cash += 15000;

        // case 2: blue card matches another player's career
        for (Player x : players) {
            if (x.career.getName() == b.getCareerLink()){
                x.cash += 15000;
                this.cash -= 15000;
                hasBlueCard = true;
                break;
            }
        }
        
        // case 3: nobody's career in the game matches the blue card
        if (hasBlueCard == false)
            this.cash -= 15000;
    }


    public void receiveSalaryCard (SalaryCard s, SalaryCard notChosen, SalaryDeck sd) {
        this.salary = s;
        sd.deck.addFirst(notChosen);
    }

    public void receiveHouseCard (int diceRoll, String houseName, HouseDeck hd) {
        HouseCard house = null;

        for (HouseCard h : hd.temp) {
            if (h.getName() == houseName)
                house = h;
        }

        int key = hd.temp.indexOf(house);
        this.house = hd.temp.get(key);
        hd.temp.remove(key);

        if (diceRoll % 2 == 0)
            this.house.finalPayAmount = this.house.payAmountEven;
        else
            this.house.finalPayAmount = this.house.payAmountOdd;

        while (bankLoanNeeded(this, house.finalPayAmount))
            makeBankLoan(this);

        this.cash -= house.finalPayAmount;
    }

    public void receiveSalary () {
        this.setCash(this.getCash() + this.getSalaryCard().computeSalary());
    }

    public void receivePayRaise () {
        this.getSalaryCard().setSalary((int)(this.getSalaryCard().getSalary() * 1.1));
        this.getSalaryCard().setTax(this.getSalaryCard().getTax() + 2000);
    }

    public void makeBankLoan (Player p) {
        p.cash += 20000;
        p.bankLoan += 25000;
    }

    public void settleBankLoan () {
        if (this.cash - 25000 >= 0 && this.bankLoan - 25000 >= 0) {
            this.cash -= 25000; 
            this.bankLoan -= 25000;
        } else {
            this.cash -= this.bankLoan;
            this.bankLoan = 0;
        }
    }

    public void haveBabies (int diceRoll, ArrayList<Player> players) {
        if (this.isMarried) {
            if (diceRoll % 2 == 0) {
                this.numChildren = 2;
                this.setCash(this.getCash() + 10000 * players.size());
                for (Player p : players) {
                    if (p == this)
                        continue;
                    p.setCash(p.getCash() - 10000);
                }
            } else {
                this.numChildren = 1;
                this.setCash(this.getCash() + 5000 * players.size());
                for (Player p : players) {
                    if (p == this)
                        continue;
                    p.setCash(p.getCash() - 5000);
                }
            }
        }
    }

    public void marry (int diceRoll, ArrayList<Player> players) {
        if (diceRoll % 2 == 0) {
            this.setCash(this.getCash() + (10000 * players.size()));
            for (Player p : players) {
                if (p == this)
                    continue;
                p.setCash(p.getCash() - 10000);
            }
        } else {
            this.setCash(this.getCash() + (5000 * players.size()));
            for (Player p : players) {
                if (p == this)
                    continue;
                p.setCash(p.getCash() - 5000);
            }
        }
    }

    public void retire (ArrayList<Player> players) {
        int place = 0;

        // 1. Collect retirement pay from the bank.
        for (Player p : players) {
            if (p == this)
                continue;
            if (p.isRetired == true)
                place++;
        }
        
        switch (place) {
            case 0: // first case: player is first to retire
                this.cash += 100000;
                break;
                
            case 1: // second case: player is second to retire
                this.cash += 50000;
                break;

            case 2: // third case: player is last to retire
                this.cash += 20000;
                break;
        } 
        
        // 2. Collect $10000 for each child he has from the bank.
        this.cash += (this.numChildren * 10000);

        // 3. Sell your house to the Bank for the amount listed on the card
        this.cash += this.house.finalPayAmount;
        this.house = null;

        // 4. Repay to the Bank, all outstanding loans with interest.
        while (this.bankLoan != 0)
            settleBankLoan();

        this.setRetired(true);
    }

    /**
     * Checks the player's current cash if it is less than the payment due.
     * @param payment A value that is due to be paid
     * @return A boolean value if the player's cash is less than what he/she is paying for
     */
    private boolean bankLoanNeeded (Player p, int payment) {
        return p.cash < (payment * -1) ? true : false;
    }
 
    /**
     * Formats the output details for the player.
     */
    @Override
    public String toString() {
        return this.name;
    }
}