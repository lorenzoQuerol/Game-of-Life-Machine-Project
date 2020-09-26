package Model;

import java.util.Scanner;

public class Model {

    private static Model model = null;

    private Board b;

    private int starterCash;
    private int numAction;
    private int numSalary;
    private int numCareer;
    private int numPlayers;

    private Model () {
        this.b = new Board();
        this.starterCash = 200000;
    }

    public static Model getInstance()
    {
        if (model == null)
            model = new Model();

        return model;
    }

    public int getStarterCash() {
        return starterCash;
    }

    public int getNumAction() {
        return numAction;
    }

    public int getNumCareer() {
        return numCareer;
    }

    public int getNumSalary() {
        return numSalary;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void setStarterCash(int starterCash) {
        this.starterCash = starterCash;
    }

    public void setNumAction(int numAction) {
        this.numAction = numAction;
    }

    public void setNumCareer(int numCareer) {
        this.numCareer = numCareer;
    }

    public void setNumSalary(int numSalary) {
        this.numSalary = numSalary;
    }

    public Board getB() {
        return b;
    }



//    public static void main(String[] args) {
//        int startCash;
//
//        Scanner in = new Scanner(System.in);
//        Board game = new Board();
//
//        boolean gameOver = false;
//        int counter = 0;
//        game.initializeData();
//        /*
//        This asks for how many players will play the game, while
//        also asking for the name of the player.
//        */
//        System.out.print("How many players will play: ");
//        int playerCount = Integer.parseInt(in.nextLine());
//
////        for (int i = 0; i < playerCount; i++) {
////            game.getPlayers().add(new Player());
////            System.out.print("Set a name for your player: ");
////            String name = in.nextLine();
////            game.getPlayers().get(i).setName(name);
////        }
//
//        /*
//        This is main game area, players take turns drawing an action card until the deck runs out,
//        or if the player decides to quit, it will exit the demo.
//        */
//        do {
//            System.out.println(" ");
//            for (int j = 0; j < playerCount; j++) {
//                game.getActionDeck().getDeckSize();
//                System.out.println(game.getPlayers().get(j).getName() + "'s Cash: " + game.getPlayers().get(j).getCash());
//            }
//            System.out.println(" ");
//            System.out.println("Would you like to continue drawing action cards? ");
//            System.out.println("\t(1) Draw Action Card");
//            System.out.println("\t(2) Quit");
//            System.out.print("Choice: ");
//            int choice = Integer.parseInt(in.nextLine());
//
//            if (choice == 1) {
//                gameOver = game.takeTurn (game.getPlayers().get(counter), in, game.getActionDeck(), gameOver);
//                counter++;
//            }
//            else if (choice == 2) {
//                break;
//            }
//            else {
//                System.out.println("Invalid input! Please try again.\n\n");
//            }
//
//            if (counter > game.getPlayers().size() - 1)
//                counter = 0;
//        } while (!gameOver);
//        System.out.println("====End Demo====");
//    }
}
