import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int[] boardSpaces;
    private static ArrayList<Player> players;
    private static ActionDeck actionDeck;
    

    public static void InitializeData() { 
        boardSpaces = new int[50];
        players = new ArrayList<Player>();
        actionDeck = new ActionDeck ();
        
        actionDeck.generateActionDeck ();
    }

    public static void main(String[] args) {
        InitializeData ();
        Scanner in = new Scanner(System.in);
        Player player1 = new Player ();
        Player player2 = new Player ();
        Player player3 = new Player ();
        player1.setName("John");
        player2.setName("Josh");
        player3.setName("Jason");
        players.add(player1); // ADDED PLAYERS FOR TESTING
        players.add(player2); // ADDED PLAYERS FOR TESTING
        players.add(player3); // ADDED PLAYERS FOR TESTING
        player1.chooseActionCard(actionDeck, in, players);
    }
}