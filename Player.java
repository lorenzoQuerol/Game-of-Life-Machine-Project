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

    public void setPlayerCash(int playerCash) {
        this.playerCash = playerCash;
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
        int currentCash;
        String choice;
        ActionCard chosenActionCard = a.drawCard();
        System.out.println(chosenActionCard);
        
        switch (chosenActionCard.getActionType()) {
            case "Lawsuit":
                System.out.println("You have been filed for a Lawsuit!");
                currentCash = getPlayerCash();
                currentCash += chosenActionCard.getPayAmount();
                setPlayerCash(currentCash);
                
                System.out.println("Choose a Player to Pay: ");

                for (Player x : players)
                    System.out.println(x.getPlayerName());

                choice = in.nextLine();

                for (Player x : players) {
                    if (x.getPlayerName().contains(choice)) {
                        x.playerCash += (chosenActionCard.getPayAmount() * -1);
                    }
                }

                System.out.println("Cash now: " + playerCash);
                break;

            case "Christmas Bonus":
                System.out.println("You paid everyone " + (chosenActionCard.getPayAmount() * -1 + "!"));
                currentCash = getPlayerCash();

                for (Player x : players) {
                    if (x.getPlayerName() == getPlayerName()) {
                        continue;
                    }
                    currentCash += chosenActionCard.getPayAmount();
                    x.playerCash += (chosenActionCard.getPayAmount() * -1);
                }

                setPlayerCash(currentCash);
                System.out.println("Cash now: " + playerCash);
                break;

            case "File a Lawsuit":
                System.out.println("You Filed a Lawsuit Against Someone!");
                currentCash = getPlayerCash();
                currentCash += chosenActionCard.getPayAmount();
                setPlayerCash(currentCash);
                
                System.out.println("Choose a Player to File a Lawsuit Against: ");

                for (Player x : players)
                    System.out.println(x.getPlayerName());
                choice = in.nextLine();

                for (Player x : players) {
                    if (x.getPlayerName().contains(choice)) 
                        x.playerCash += (chosenActionCard.getPayAmount() * -1);
                }

                System.out.println("Cash now: " + playerCash);
                break;

            case "It's your Birthday!":
                System.out.println("It's your birthday! Everyone gifts you " + (chosenActionCard.getPayAmount() + "!"));
                currentCash = getPlayerCash();

                for (Player x : players) {
                    if (x.getPlayerName() == getPlayerName()) 
                        continue;
                    currentCash += chosenActionCard.getPayAmount();
                    x.playerCash += (chosenActionCard.getPayAmount() * -1);
                }

                setPlayerCash(currentCash);
                System.out.println("Cash now: " + playerCash);
                
                break;
            
            default:
                playerCash += chosenActionCard.getPayAmount();
                System.out.println("Cash now: " + getPlayerCash());
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