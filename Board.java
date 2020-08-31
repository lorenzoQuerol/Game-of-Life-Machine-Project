import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    private int[] careerPath;
    private int[] collegePath;
    private int[] pathOne;
    private int[] changeCareerPath;
    private int[] familyPath;
    private int[] pathTwo;

    private ArrayList<Player> players;
    private ActionDeck actionDeck;

    private CareerDeck careerDeck;
    private BlueDeck blueDeck;
    private SalaryDeck salaryDeck;
    private HouseDeck houseDeck;

    public Board () { 
        players = new ArrayList<Player>();
        actionDeck = new ActionDeck ();
        actionDeck.generateActionDeck ();
    }
    
    /**
     * Allows the player to take a turn (e.g. spin a number and get a card).
     * @param p The current player
     * @param in Input Scanner
     * @param actionDeck The action card deck
     * @param gameOver The status of the game
     * @return A boolean value if the game is over
     */
    public boolean takeTurn (Player p, Scanner in, ActionDeck actionDeck, boolean gameOver) {
        System.out.println("Card #" + actionDeck.getActionDeckSize());
        System.out.println(p.getName() + "'s turn!");
        p.receiveActionCard(actionDeck, in, players);
        // if (actionDeck.getActionDeckSize() == 0) Continuous Action Card Generation after it runs out
        //     actionDeck.generateActionDeck();
        if (actionDeck.getActionDeckSize() == 0)
            gameOver = true;
        return gameOver;        
    }

   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board game = new Board();

        boolean gameOver = false; 
        int counter = 0;
        
        /*
        This asks for how many players will play the game, while 
        also asking for the name of the player.
        */
        System.out.print("How many players will play: ");
        int playerCount = Integer.parseInt(in.nextLine());

        for (int i = 0; i < playerCount; i++) {
            game.players.add(new Player());
            System.out.print("Set a name for your player: ");
            String name = in.nextLine();
            game.players.get(i).setName(name);
        }
        
        do {
            System.out.println(" ");
            for (int j = 0; j < playerCount; j++) {
                System.out.println(game.players.get(j).getName() + "'s Cash: " + game.players.get(j).getCash());
            }
            System.out.println(" ");
            System.out.println("Would you like to continue drawing action cards? ");
            System.out.println("\t(1) Draw Action Card");
            System.out.println("\t(2) Quit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(in.nextLine());

            if (choice == 1) {
                gameOver = game.takeTurn (game.players.get(counter), in, game.actionDeck, gameOver);
                counter++;
            }
            else if (choice == 2) {
                break;
            }
            else {
                System.out.println("Invalid input! Please try again.\n\n");
            }
            if (counter > game.players.size() - 1)
                counter = 0;
        } while (!gameOver);
        System.out.println("====End Demo====");
    } 
}