import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private int playerCash;
    private String playerName;

    private String playerChoice;

    private boolean playerMarried;
    private boolean playerDegreee;

    private CareerCard playerCareer;
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

    public void setPlayerCash(int c) {
        playerCash = c;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerCash() {
        return playerCash;
    }

    public int getSpace () {
        return space;
    }

    public void chooseActionCard (ActionDeck a, Scanner in, ArrayList<Player> players) {
        String choice;
        ActionCard chosenActionCard = a.drawActionCard();
        System.out.println(chosenActionCard);
        
        switch (chosenActionCard.getActionType()) {
            case "Lawsuit":
                System.out.println("You have been filed for a Lawsuit!");  
                this.playerCash += chosenActionCard.getPayAmount();
                
                System.out.println("Choose a Player to Pay: ");

                for (Player x : players) {
                    if (x.getPlayerName() == this.playerName)
                        continue;
                    System.out.println(x.getPlayerName());
                }

                choice = in.nextLine();

                for (Player x : players) {
                    if (x.getPlayerName().contains(choice))
                        x.playerCash += (chosenActionCard.getPayAmount() * -1);
                }

                System.out.println("Cash now: " + this.playerCash);
                break;

            case "Christmas Bonus":
                System.out.println("You paid everyone " + (chosenActionCard.getPayAmount() * -1 + "!"));

                for (Player x : players) {
                    if (x.getPlayerName() == getPlayerName()) {
                        continue;
                    }
                    this.playerCash += chosenActionCard.getPayAmount();
                    x.playerCash += (chosenActionCard.getPayAmount() * -1);
                }

                System.out.println("Cash now: " + this.playerCash);
                break;

            case "File a Lawsuit":
                System.out.println("You Filed a Lawsuit Against Someone!");
                this.playerCash += chosenActionCard.getPayAmount();
                
                System.out.println("Choose a Player to File a Lawsuit Against: ");

                for (Player x : players) {
                    if (x.getPlayerName() == this.playerName)
                        continue;
                    System.out.println(x.getPlayerName());
                }

                choice = in.nextLine();

                for (Player x : players) {
                    if (x.getPlayerName().contains(choice)) 
                        x.playerCash += (chosenActionCard.getPayAmount() * -1);
                }

                System.out.println("Cash now: " + playerCash);
                break;

            case "It's your Birthday!":
                System.out.println("It's your birthday! Everyone gifts you " + (chosenActionCard.getPayAmount() + "!"));

                for (Player x : players) {
                    if (x.getPlayerName() == getPlayerName()) 
                        continue;
                    this.playerCash += chosenActionCard.getPayAmount();
                    x.playerCash += (chosenActionCard.getPayAmount() * -1);
                }

                System.out.println("Cash now: " + this.playerCash);
                break;
            
            default:
                this.playerCash += chosenActionCard.getPayAmount();
                System.out.println("Cash now: " + this.playerCash);
        }
    }

    public void chooseCareerCard (){

    }

    public void chooseBlueCard (){

    }

    public void chooseSalaryCard (){

    }

    public void borrowMoney (){
        
    }

    public void displayPlayerInfo () {
        
    }
}