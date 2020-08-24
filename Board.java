import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Board {
    private static int[] boardSpaces;
    private static ArrayList<Player> players;
    private static ActionDeck actionDeck;
    private static ActionCard actionCard;

    public static void InitializeData() {
        boardSpaces = new int[50];
        players = new ArrayList<Player>();
        actionDeck = new ActionDeck ();
        actionCard = new ActionCard ();

        actionDeck.generateNewActionDeck ();
        actionDeck.assignActions ();
    }


    public static void main(String[] args) {
        InitializeData ();
        int playerTurn = 0;
        boolean gameOver = false;

        Player player1 = new Player();
        // System.out.println(actionDeck);
        // player1.chooseActionCard(actionDeck, actionCard);
        
        // player1.chooseActionCard(actionDeck, actionCard);
        // System.out.println(actionDeck);
        // player1.chooseActionCard(actionDeck, actionCard);
        // System.out.println(actionDeck);
    }

    
}