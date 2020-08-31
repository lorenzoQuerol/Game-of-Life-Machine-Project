import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    // Instance variables for a player object
    private int cash;
    private String name;
    private String pathStart;

    private boolean isMarried;
    private boolean isGraduate;

    private CareerCard career;
    private SalaryCard salary;
    private HouseCard house;
    private int bankLoan;

    private int space;

    /**
     * Constructor for a Player object. It assigns the starter cash amount for
     * the player.
     */
    public Player () {
        // this.cash = 200000; // Normal starter cash
        this.cash = 20000; // For testing the bank loan methods, set player cash to a lower amount to instigate a bank loan
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
     * @param pathStart The player's path choice when the game starts
     */
    public void setPathStart(String pathStart) {
        this.pathStart = pathStart;
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

    /**
     * Gets the player's space.
     * @return The player's current position on the board
     */
    public int getSpace () {
        return space;
    }

    /**
     * Spins for a random number between 1 to 10.
     * @return The number of spaces the player traverses
     */
    public int spin () {
        return (int)(Math.random() * (10-1) + 1);
    }
    
    /**
     * This method allows the player to receive an action card and manipulate the player's statistics
     * based on the description of the chosen card.
     * @param a The action card deck
     * @param in The input scanner
     * @param players The list of current players
     */
    public void receiveActionCard (ActionDeck a, Scanner in, ArrayList<Player> players) {
        String choice;
        ActionCard chosenActionCard = a.drawActionCard();
        System.out.println(chosenActionCard);
        
        /*
        Certain action cards require the interaction of the current player with other players in the game.
        e.g. the player's cash is increased by the amount that was deducted from another player, and vice versa.
        */ 
        switch (chosenActionCard.getActionType()) { 
            case "Lawsuit":
                System.out.println("You have been filed for a Lawsuit!");  
                if (!bankLoanNeeded(this, chosenActionCard.getPayAmount())) 
                    this.cash += (chosenActionCard.getPayAmount());
                else {
                    while (bankLoanNeeded(this, chosenActionCard.getPayAmount()))
                        makeBankLoan(this);
                    this.cash += (chosenActionCard.getPayAmount());
                }

                System.out.println("Choose a Player to Pay: ");
                displayOtherPlayers(players);
                choice = in.nextLine();

                for (Player x : players) {
                    if (x.getName().contains(choice)) 
                        x.cash += (chosenActionCard.getPayAmount() * -1);                 
                }
                break;

            case "Christmas Bonus":
                System.out.println("You paid everyone " + (chosenActionCard.getPayAmount() * -1 + "!"));

                for (Player x : players) {
                    if (x.getName() == this.name) { // If it reads the name of the current player, skip
                        continue;
                    }

                    if (!bankLoanNeeded(this, chosenActionCard.getPayAmount())) {
                        this.cash += (chosenActionCard.getPayAmount());
                        x.cash += (chosenActionCard.getPayAmount() * -1);
                    } else {
                        while (bankLoanNeeded(this, chosenActionCard.getPayAmount()))
                            makeBankLoan(this);
                        this.cash += (chosenActionCard.getPayAmount());
                        x.cash += (chosenActionCard.getPayAmount() * -1);
                    }             
                }
                break;

            case "File a Lawsuit":
                System.out.println("You Filed a Lawsuit Against Someone!");
                this.cash += chosenActionCard.getPayAmount();
                
                System.out.println("Choose a Player to File a Lawsuit Against: ");
                displayOtherPlayers(players);
                choice = in.nextLine();
                
                for (Player x : players) {
                    if (x.getName().contains(choice)) {
                        if (!bankLoanNeeded(x, chosenActionCard.getPayAmount())) 
                            x.cash += (chosenActionCard.getPayAmount() * -1);
                        else {
                            while (bankLoanNeeded(x, chosenActionCard.getPayAmount()))
                                makeBankLoan(x);
                            x.cash += (chosenActionCard.getPayAmount() * -1);
                        }
                    }
                }
                break;

            case "It's your Birthday!":
                System.out.println("It's your birthday! Everyone gifts you " + (chosenActionCard.getPayAmount() + "!"));

                for (Player x : players) {
                    if (x.getName() == this.name) 
                        continue;
                    if (!bankLoanNeeded(x, chosenActionCard.getPayAmount())){
                        this.cash += chosenActionCard.getPayAmount();
                        x.cash += (chosenActionCard.getPayAmount() * -1);
                    } else {
                        while (bankLoanNeeded(x, chosenActionCard.getPayAmount()))
                            makeBankLoan(x);
                        this.cash += chosenActionCard.getPayAmount();
                        x.cash += (chosenActionCard.getPayAmount() * -1);
                    }                    
                }
                break;
            
            default:
                if (!bankLoanNeeded(this, chosenActionCard.getPayAmount()))
                        this.cash += (chosenActionCard.getPayAmount());
                else {
                    while (bankLoanNeeded(this, chosenActionCard.getPayAmount()))
                        makeBankLoan(this);
                    this.cash += (chosenActionCard.getPayAmount());
                }
        }
    }

    public void receiveCareerCard (){

    }

    public void receiveBlueCard (){

    }

    public void receiveSalaryCard (){

    }

    public void makeBankLoan (Player p) {
        System.out.println("===Bank loan made===");
        p.cash += 20000;
        p.bankLoan += 25000;
    }

    public void settleBankLoan () {

    }

    public void retire () {

    }

    /**
     * Helper Method: This displays other players in the game. It skips outputting
     * the current player.
     * @param players The current players of the game
     */
    public void displayOtherPlayers (ArrayList<Player> players) {
        for (Player x : players) {
            if (x.getName() == this.name) 
                continue;
            System.out.println(x.getName());
        }
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
        return this.name + " | " + "Cash: " + this.cash;
    }
}