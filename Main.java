import java.util.ArrayList;

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
        Player player1 = new Player ();
        System.out.println("ENZO IS HERE");
        player1.chooseActionCard(actionDeck);
    }

}