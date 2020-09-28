package Model;

import javax.print.Doc;
import java.util.ArrayList;

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
    private int retirementPay;
    private int childCash;
    private int houseCost;
    private int totalBankLoan;

    /**
     * Constructor for a Player object. It assigns the starter cash amount for
     * the player.
     */
    public Player (int cash) {
        this.cash = cash;
    } 

    /**
     * Sets the player's name.
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
     * This gets the cost of the house card
     * @return the house card value.
     */
    public int getHouseCost() {
        return houseCost;
    }

    /**
     * This gets the number of children the player has
     * @return the number of children.
     */
    public int getNumChildren() {
        return numChildren;
    }

    /**
     * This gets the bank loan of the player
     * @return the bank loan.
     */
    public int getBankLoan() {
        return bankLoan;
    }

    /**
     * This gets the retirement pay the player received
     * @return the retirement pay.
     */
    public int getRetirementPay() {
        return retirementPay;
    }

    /**
     * This gets the total cash received from the amount
     * of children the player has.
     * @return
     */
    public int getChildCash() {
        return childCash;
    }

    /**
     * Gets the total bank loan the player paid.
     * @return total bank loan the player paid
     */
    public int getTotalBankLoan() {
        return totalBankLoan;
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
     * Gets the house card of the player
     * @return house card of the player
     */
    public HouseCard getHouse() {
        return house;
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

    /**
     * Sets the type of space the player is currently on.
     * @param spaceType color/type of space player is on
     */
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
     * Gets the player's cash.
     * @return The player's current cash
     */
    public int getCash() {
        return cash;
    }

    /**
     * Gets marriage status of player.
     * @return marriage status of player
     */
    public boolean getIsMarried() {
        return isMarried;
    }

    /**
     * Gets graduate status of player.
     * @return graduate status of player
     */
    public boolean getIsGraduate() {
        return isGraduate;
    }

    /**
     * Gets retirement status of player.
     * @return retirement status of player
     */
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

    /**
     * Gets the space type of the player is currently on.
     * @return the type of space the player is currently on
     */
    public Space getSpaceType() {
        return spaceType;
    }

    /**
     * Gets current path of player.
     * @return current path of player
     */
    public String getCurrentPath() {
        return currentPath;
    }

    /**
     * Gets salary card of player.
     * @return salary card
     */
    public SalaryCard getSalaryCard() {
        return salary;
    }

    /**
     * Gets career card of player.
     * @return career card
     */
    public CareerCard getCareerCard() {
        return career;
    }

    /**
     * Sets place/ranking of player (1,2,3)
     * @@param place of player
     */
    public void setPlace(int place) {
        this.place = place;
    }

    /**
     * Gets place/ranking of player.
     * @return place of player
     */
    public int getPlace() {
        return place;
    }

    /**
     * Sets the retirement status of player.
     * @param retired retirement status of player
     */
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
     * @param p the player the current player interacts with
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
                    this.cash -= (a.getPayAmount());
                else {
                    while (bankLoanNeeded(this, a.getPayAmount()))
                        makeBankLoan(this);
                    this.cash -= (a.getPayAmount());
                }

                p.setCash(p.getCash() + a.getPayAmount());
                System.out.println(this.cash);
                System.out.println(p.getCash());
                break;

            case "Christmas Bonus":
                System.out.println("Christmas Bonus card was drawn");

                for (Player x : players) {
                    if (x.getName() == this.name) { // If it reads the name of the current player, skip
                        continue;
                    }

                    if (!bankLoanNeeded(this, a.getPayAmount())) {
                        this.cash -= a.getPayAmount();
                        x.cash += a.getPayAmount();
                    } else {
                        while (bankLoanNeeded(this, a.getPayAmount()))
                            makeBankLoan(this);
                        this.cash -= a.getPayAmount();
                        x.cash += a.getPayAmount();
                    }             
                }
                break;

            case "File a Lawsuit":
                System.out.println("You Filed a Lawsuit Against Someone card was drawn");
                this.cash += a.getPayAmount();
                p.setCash(p.getCash() - a.getPayAmount());
                break;

            case "It's your Birthday!":
                System.out.println("It's your birthday! card was drawn");

                for (Player x : players) {
                    if (x.getName() == this.name) 
                        continue;
                    if (!bankLoanNeeded(x, a.getPayAmount())){
                        this.cash += a.getPayAmount();
                        x.cash -= a.getPayAmount();
                    } else {
                        while (bankLoanNeeded(x, a.getPayAmount()))
                            makeBankLoan(x);
                        this.cash += a.getPayAmount();
                        x.cash -= a.getPayAmount();
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

    /**
     * Lets player receive the career card and set it
     * @param c career card chosen by the player
     * @param notChosen career card to be discarded
     * @param cd career deck
     */
    public void receiveCareerCard (CareerCard c, CareerCard notChosen, CareerDeck cd) {
        System.out.println("Chosen Career: " + c);
        this.career = c;
        cd.getTemp().add(notChosen);
    }

    /**
     * Lets player receive the salary card and set it.
     * @param s salary card chosen by the player
     * @param notChosen salary card to be discarded
     * @param sd salary deck
     */
    public void receiveSalaryCard (SalaryCard s, SalaryCard notChosen, SalaryDeck sd) {
        System.out.println("Chosen salary: " + s);
        this.salary = s;
        sd.getTemp().add(notChosen);
    }

    /**
     * Called when player lands on a Job Search magenta space
     * @param c career chosen by player
     * @param s salary chosen by player
     * @param cd career deck
     * @param sd salary deck
     */
    public void jobSearch (CareerCard c, SalaryCard s, ArrayList<CareerCard> cd, ArrayList<SalaryCard> sd) {
        System.out.println("Career and Salary Changed via Job Search");
        cd.add(this.career);
        sd.add(this.salary);
        this.career = c;
        this.salary = s;
    }

    /**
     * Lets player receive the blue card and set it.
     * @param b blue card
     * @param players players in the current game
     */
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

    /**
     * Lets player receive the house card and set it.
     * @param str string value which contains "even" or "odd"
     * @param houseName name of the house the player chose
     * @param hd house deck
     */
    public void receiveHouseCard (String str, String houseName, HouseDeck hd) {
        HouseCard house = null;

        for (HouseCard h : hd.temp) {
            if (h.getName().equals(houseName))
                house = h;
        }

        int key = hd.temp.indexOf(house);
        this.house = hd.temp.remove(key);

        if (str.equals("even"))
            this.house.setFinalPayAmount(this.house.getPayAmountEven());
        else
            this.house.setFinalPayAmount(this.house.getPayAmountOdd());

        while (bankLoanNeeded(this, house.finalPayAmount))
            makeBankLoan(this);

        this.cash -= house.getFinalPayAmount();
    }

    /**
     * Lets the player receive the computed salary
     */
    public void receiveSalary () {
        this.setCash(this.getCash() + this.getSalaryCard().computeSalary());
    }

    /**
     * Lets the player receive a pay raise
     */
    public void receivePayRaise () {
        this.getSalaryCard().setSalary((int)(this.getSalaryCard().getSalary() * 1.1));
        this.getSalaryCard().setTax(this.getSalaryCard().getTax() + 2000);
    }

    /**
     * Makes a bank loan of $20000 and adds to the player's bank loan balance
     * @param p player
     */
    public void makeBankLoan (Player p) {
        p.cash += 20000;
        p.bankLoan += 25000;
        p.totalBankLoan += 25000;
    }

    /**
     * Lets the player pay all of his/her bank loans
     */
    public void settleBankLoan () {
        if (this.cash - 25000 >= 0 && this.bankLoan - 25000 >= 0) {
            this.cash -= 25000; 
            this.bankLoan -= 25000;
        } else {
            this.cash -= this.bankLoan;
            this.bankLoan = 0;
        }
    }

    /**
     * Called when player lands on have baby/ies magenta space
     * @param diceRoll an integer value that may contain 1 or 2
     * @param players players of the current game
     */
    public void haveBabies (int diceRoll, ArrayList<Player> players) {
        if (this.isMarried) {
            if (diceRoll == 2) {
                this.numChildren = 2;
                this.setCash(this.getCash() + (10000 * (players.size() - 1)));
                for (Player p : players) {
                    if (p == this)
                        continue;
                    else
                        p.setCash(p.getCash() - 10000);
                }
            } else if (diceRoll == 1){
                this.numChildren = 1;
                this.setCash(this.getCash() + (5000 * (players.size() - 1)));
                for (Player p : players) {
                    if (p == this)
                        continue;
                    else
                        p.setCash(p.getCash() - 5000);
                }
            }
        }
    }

    /**
     * Lets the player be married, which sets his/her status to married
     * @param diceRoll a string value containing "even" or "odd"
     * @param players players of the current game
     */
    public void marry (String diceRoll, ArrayList<Player> players) {
        if (diceRoll.equals("even")) {
            this.setCash(this.getCash() + (10000 * (players.size() - 1)));
            for (Player p : players) {
                if (p == this)
                    continue;
                p.setCash(p.getCash() - 10000);
            }
        } else if (diceRoll.equals("odd")) {
            this.setCash(this.getCash() + (5000 * (players.size() - 1)));
            for (Player p : players) {
                if (p == this)
                    continue;
                p.setCash(p.getCash() - 5000);
            }
        }
        this.setMarried(true);
    }

    /**
     * Lets the play retire. Called when the player reaches the end of the board
     * @param players players of the current game
     * @param winners list of players who arrived at the end of the board first
     */
    public void retire (ArrayList<Player> players, ArrayList<Player> winners) {
        int place = 0;

        switch (winners.indexOf(this)) {
        // first case: player is first to retire
            case 0 -> {
                this.retirementPay = 100000;
                this.cash += 100000;
            }
        // second case: player is second to retire
            case 1 -> {
                this.retirementPay = 50000;
                this.cash += 50000;
            }
        // third case: player is last to retire
            case 2 -> {
                this.retirementPay = 20000;
                this.cash += 20000;
            }
        }
        
        // 2. Collect $10000 for each child he has from the bank.
        this.childCash += (this.numChildren * 10000);
        this.cash += this.childCash;

        // 3. Sell your house to the Bank for the amount listed on the card
        try {
            this.houseCost = this.house.finalPayAmount;
            this.cash += this.house.finalPayAmount;
        } catch (NullPointerException e) {
            System.out.println("Player has no house");
        }
        this.house = null;

        // 4. Repay to the Bank, all outstanding loans with interest.
        while (this.bankLoan != 0) {
            settleBankLoan();
        }

        this.setRetired(true);
        System.out.println(getIsRetired());
    }

    /**
     * Checks the player's current cash if it is less than the payment due.
     * @param payment A value that is due to be paid
     * @return A boolean value if the player's cash is less than what he/she is paying for
     */
    private boolean bankLoanNeeded (Player p, int payment) {
        return p.cash < (payment) ? true : false;
    }
 
    /**
     * Formats the output details for the player.
     */
    @Override
    public String toString() {
        return this.name;
    }
}